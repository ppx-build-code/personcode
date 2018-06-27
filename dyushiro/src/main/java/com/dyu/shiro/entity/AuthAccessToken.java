package com.dyu.shiro.entity;

import org.apache.shiro.authc.AuthenticationToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yudi on 2018/3/27.
 */
public class AuthAccessToken implements AuthenticationToken {

    private final static Logger logger = LoggerFactory.getLogger(AuthAccessToken.class);

    private final static long serialVersionUID = 1L;

    private String accessToken;
    private String username;
    private String userId;

    public AuthAccessToken(String accessToken, String username, String userId){
        super();
        this.accessToken = accessToken;
        this.username = username;
        this.userId = userId;
        logger.debug("createToken , token {}, host{}, agent {}.", accessToken, username, userId);
    }


    public Object getPrincipal() {
        return this.accessToken;
    }

    public Object getCredentials() {
        return this.accessToken;
    }
}
