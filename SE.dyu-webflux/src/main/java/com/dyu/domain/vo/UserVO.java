package com.dyu.domain.vo;

import com.dyu.domain.dao.UserDO;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author dyu
 * @date 2018/07/23
 */
@Data
@NoArgsConstructor
public class UserVO {
    private Long id;
    private String name;

    public UserVO(UserDO userDO) {
        id = userDO.getUserId();
        name = userDO.getUserName();
    }
}
