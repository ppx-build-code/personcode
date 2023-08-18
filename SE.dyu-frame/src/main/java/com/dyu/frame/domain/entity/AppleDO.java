package com.dyu.frame.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author dyu 2021/6/28 11:10
 */
@TableName("apple")
@Data
public class AppleDO {

    private Long id;

    private String name;

    private String color;

    private BigDecimal weight;
}
