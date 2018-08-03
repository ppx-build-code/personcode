package com.dyu.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.core.Ordered;

import javax.servlet.http.HttpServletRequest;

/**
 * @author dyu
 * @date 2018/08/03
 */
@Slf4j
public class AccessFilter extends ZuulFilter {
    private final static String AUTH = "authorization";
    private final static String X_AUTH = "x_authorization";

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        requestContext.set("tic", System.currentTimeMillis());
        HttpServletRequest request = requestContext.getRequest();
        String token = request.getHeader(AUTH);
        if (!StringUtils.isEmpty(token)) {
            requestContext.addZuulRequestHeader(X_AUTH, token);
        }
        return null;
    }
}
