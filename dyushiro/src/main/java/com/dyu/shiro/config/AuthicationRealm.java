package com.dyu.shiro.config;

import com.dyu.shiro.entity.AuthAccessToken;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.subject.Subject;
import org.slf4j.LoggerFactory;

/**
 * Created by yudi on 2018/3/27.
 */
public class AuthicationRealm implements Realm{


    public String getName() {
        return null;
    }

    public boolean supports(AuthenticationToken authenticationToken) {
        return false;
    }

    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        AuthAccessToken authAccessToken = (AuthAccessToken) authenticationToken;
        // Subject currentUser = SecurityUtils.getSubject();
        return null;
    }
}
