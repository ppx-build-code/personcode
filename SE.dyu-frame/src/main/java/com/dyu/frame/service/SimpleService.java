package com.dyu.frame.service;

import org.springframework.transaction.annotation.Transactional;

public interface SimpleService {

    @Transactional(transactionManager = "masterTransactionManager")
    void testTm();
}
