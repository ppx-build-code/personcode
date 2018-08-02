package com.dyu.service.impl;

import com.dyu.domain.repo.UserRepository;
import com.dyu.domain.vo.UserVO;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

/**
 * @author dyu
 * @date 2018/07/23
 */
@Component
@RequiredArgsConstructor
public class UserHandler{

    @NonNull
    private UserRepository userRepository;

    public Mono<ServerResponse> lists(ServerRequest servletRequest) {
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(
                        Mono.just(userRepository.findAllByUserIdIsAfter(123L).stream().map(UserVO::new).collect(Collectors.toList())), List.class);
    }


    public Flux<ServerResponse> get(Long id) {
        return null;
    }
}
