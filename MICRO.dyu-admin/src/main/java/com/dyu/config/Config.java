package com.dyu.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author dyu
 * @date 2018/08/07
 */
@Data
@ConfigurationProperties(prefix = "begin")
public class Config {
    private String one;
    private String two;
}
