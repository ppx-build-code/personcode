package com.dyu.service.impl;

import com.dyu.domain.dao.UserDO;
import com.dyu.domain.repo.UserRepository;
import com.dyu.domain.vo.UserVO;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


import javax.persistence.EntityManager;
import java.util.ArrayList;
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
    @NonNull
    private EntityManager entityManager;

    public Mono<ServerResponse> lists(ServerRequest servletRequest) {
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(
                        Mono.just(userRepository.findAllByUserIdIsAfter(123L).stream().map(UserVO::new).collect(Collectors.toList())), List.class);
    }

    @Transactional
    public Mono<ServerResponse> save(ServerRequest servletRequest) {
        List<UserDO> us = new ArrayList<>();
        UserDO u1 = new UserDO();
        u1.setId(1L);
        u1.setUserId(123456L);
        u1.setUserName("test");
        UserDO u2 = new UserDO();
        u2.setId(2L);
        u2.setUserId(123456L);
        u2.setUserName("dyu");

        us.add(u1);
        us.add(u2);
        us.forEach(o -> entityManager.merge(o));
        entityManager.flush();
        entityManager.clear();
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(null);
    }


    public Flux<ServerResponse> get(Long id) {
        return null;
    }
}
