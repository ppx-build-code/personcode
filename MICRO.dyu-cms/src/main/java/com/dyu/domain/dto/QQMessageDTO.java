package com.dyu.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author dyu 2019-07-22 10:55
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QQMessageDTO {


    private Integer type;
    private String toNumber;
    private String msg;
}
