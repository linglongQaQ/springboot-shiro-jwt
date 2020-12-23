package com.qc.online.diagnosis.common.utils;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @Description:
 * @Author: wangyilong
 * @Date: 2020/12/17 11:30
 **/
public class JWTToken implements AuthenticationToken {


        // 密钥
        private String token;

        public JWTToken(String token) {
            this.token = token;
        }

        @Override
        public Object getPrincipal() {
            return token;
        }

        @Override
        public Object getCredentials() {
            return token;
        }

}
