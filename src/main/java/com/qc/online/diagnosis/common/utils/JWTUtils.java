package com.qc.online.diagnosis.common.utils;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * @Description: jwt生成和解析工具类
 * @Author: wangyilong
 * @Date: 2020/12/14 16:03
 **/
public class JWTUtils {

    private static final Logger logger = LoggerFactory.getLogger(JWTUtils.class);
    //设置过期时间
    private  static final long EXPIRATION = 180000L;


    /**
     * 设置token
     * @param username
     * @param secret
     * @return
     */
    public static String  sign(String username, String secret) {
        //设置签名
        try {
            Algorithm signer = Algorithm.HMAC256(secret);
            //设置过期时间
            Date expire = new Date(System.currentTimeMillis()+EXPIRATION * 1000);
            String token = JWT.create()
                    .withClaim("username",username)
                    .withExpiresAt(expire)
                    .sign(signer);
            return token;
        }catch (Exception e){
            return  e.getMessage();
        }
    }


    /**
     * 校验token是否正确
     * @param token
     * @return
     */
    public static boolean parseToken(String token, String username, String secret) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withClaim("username", username)
                    .build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    /**
     * 获得token中的信息无需secret解密也能获得
     * @return token中包含的用户名
     */
    public static String getUsername(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("username").asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }


    /**
     * 判断过期
     * @param token
     * @return
     */
    public static boolean isExpire(String token){
        DecodedJWT jwt = JWT.decode(token);
        return System.currentTimeMillis()>jwt.getExpiresAt().getTime();
    }



}
