package com.dyu.web;

import com.dyu.domain.dto.QQMessageDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * @author dyu
 * @date 2018/08/03
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class CartoonController {

    @GetMapping("/lists")
    public String lists() {
        log.info("-----> enter...");
        return "hello worlds";
    }

    @PostMapping("/hello-world")
    public Map<String, Object> helloWorld(@RequestParam("qq") String desQQ) {

        System.out.println("come on ..." + desQQ);

        Map<String, Object> map = new HashMap<>();
        map.put("result", true);

        QQMessageDTO qq = QQMessageDTO.builder()
                .msg("hello-world!!!")
                .toNumber("694973189")
                .type(0)
                .build();

        List<QQMessageDTO> messages = Collections.singletonList(qq);

        map.put("others", messages);

        return map;
    }
}
