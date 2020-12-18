package com.dyu.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.core.Ordered;

import javax.servlet.http.HttpServletRequest;

/**
 * @author dyu
 * @date 2018/08/03
 */
@Slf4j
public class LogFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;
    }

    @Override
    public int filterOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        log.info("Request `{}` from `{}` return `{}` , total cost: {} ms.",
                request.getRequestURI(),
                request.getRemoteAddr(),
                requestContext.getResponseStatusCode(),
                System.currentTimeMillis() - (long) requestContext.get("tic"));
        return null;
    }
}
