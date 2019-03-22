package com.dyu.web;

import com.dyu.service.impl.UserHandler;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * @author dyu
 * @date 2018/07/23
 */
@Configuration
@RequiredArgsConstructor
public class UserRouter {
    @NonNull
    private UserHandler userHandler;

    @Bean
    public RouterFunction<ServerResponse> link() {
        return route(GET("/user.do"), serverRequest -> userHandler.lists(serverRequest));
    }

    @Bean
    public RouterFunction<ServerResponse> save() {
        return route(GET("/user"), serverRequest -> userHandler.save(serverRequest));
    }
}
