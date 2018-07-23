package com.dyu.domain.dao;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author dyu
 * @date 2018/07/23
 */
@Data
@Entity(name = "auth_user")
@NoArgsConstructor
public class UserDO {
    @Id
    private Long userId;
    private String userName;
}
