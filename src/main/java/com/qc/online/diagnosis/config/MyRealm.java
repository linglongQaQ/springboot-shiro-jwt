package com.qc.online.diagnosis.config;
import com.qc.online.diagnosis.bean.entity.Role;
import com.qc.online.diagnosis.bean.entity.User;
import com.qc.online.diagnosis.common.utils.JWTToken;
import com.qc.online.diagnosis.common.utils.JWTUtils;
import com.qc.online.diagnosis.service.PermissionService;
import com.qc.online.diagnosis.service.UserService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @Description:
 * @Author: wangyilong
 * @Date: 2020/12/17 13:58
 **/

@Service
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;
    @Autowired
    private PermissionService permissionService;

    public MyRealm(){

    }

    public MyRealm(UserService userService){
        this.userService = userService;
        this.setAuthenticationCachingEnabled(true);
        this.setCacheManager(new MemoryConstrainedCacheManager());
    }

    /**
     * 大坑！，必须重写此方法，不然Shiro会报错
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }

    /**
     * 只有当需要检测用户权限的时候才会调用此方法，例如checkRole,checkPermission之类的
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        //获取token
        String token = (String) principals.getPrimaryPrincipal();
        //解析token  获取用户名
        String username = JWTUtils.getUsername(token);
        System.out.println(username);
        User user = userService.findUserByName(username);
        if(user.getType()==0){
            authorizationInfo.addStringPermission("*:*");
        }else {
            //获取角色列表
            List<Role> roleList = userService.findRolesById(user.getUserid());
            //获取权限列表
            Set<String> permissions = permissionService.findPermissionByUserid(user.getUserid());
            //授权角色
            if (!CollectionUtils.isEmpty(roleList)) {
                for (Role role : roleList) {
                    authorizationInfo.addRole(role.getRole());
                }
            }
            //授权权限
            if (!CollectionUtils.isEmpty(permissions)) {
                for (String  permission : permissions) {
                    if (permission != null && !"".equals(permission)) {
                        authorizationInfo.addStringPermission(permission);
                    }
                }
            }
        }
        return authorizationInfo;
    }

    /**
     * 默认使用此方法进行用户名正确与否验证，错误抛出异常即可。
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken auth) throws AuthenticationException {
        String token = (String) auth.getCredentials();
        // 解密获得username，用于和数据库进行对比
        String username = JWTUtils.getUsername(token);

        if (username == null) {
            throw new AuthenticationException(" token错误，请重新登入！");
        }

        User userBean = userService.findUserByName(username);

        if (userBean == null) {
            throw new AccountException("账号不存在!");
        }
        if(JWTUtils.isExpire(token)){
            throw new AuthenticationException(" token过期，请重新登入！");
        }

        if (! JWTUtils.parseToken(token, username, userBean.getPassword())) {
            throw new CredentialsException("密码错误!");
        }

        if(userBean.getStatus()==0){
            throw new LockedAccountException("账号已被锁定!");
        }

        return new SimpleAuthenticationInfo(token, token, getName());
    }
}