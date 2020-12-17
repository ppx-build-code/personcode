package com.dyu.demo;

import java.io.Serializable;

/**
 * @author dyu 2020/12/17 23:38
 */
public class SecondSkillEvent implements Serializable {

    private static final long serialVersionUID = 1L;
    private long productId;
    private long userId;

    public SecondSkillEvent() {
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "SecondSkillEvent{" +
                "productId=" + productId +
                ", userId=" + userId +
                '}';
    }
}
