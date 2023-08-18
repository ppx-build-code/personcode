package com.dyu.frame.tx;

import com.dyu.frame.ApplicationTests;
import com.dyu.frame.domain.entity.AppleDO;
import com.dyu.frame.mapper.AppleMapper;
import com.dyu.frame.service.SimpleService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author dyu 2021/6/30 10:12
 */
public class TMTest extends ApplicationTests {
    @Autowired
    private AppleMapper appleMapper;
    @Autowired
    private SimpleService simpleService;

    @Test
    public void test() {
        AppleDO apple = new AppleDO();
        apple.setId(1L);
        apple.setName("helloworld");
        appleMapper.insert(apple);
        simpleService.testTm();
    }
}
