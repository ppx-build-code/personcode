package com.dyu.domain.repo;

import com.dyu.domain.dao.UserDO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<UserDO, Long> {
    List<UserDO> findAllByUserIdIsAfter(Long userId);
}
