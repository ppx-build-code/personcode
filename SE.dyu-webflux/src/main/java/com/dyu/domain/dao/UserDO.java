package com.dyu.domain.dao;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author dyu
 * @date 2018/07/23
 */
@Data
@Entity
@Table(name = "admin__user", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"id"})
})
@NoArgsConstructor
public class UserDO {
    @Id
    private Long id;
    private Long userId;
    private String userName;
}
