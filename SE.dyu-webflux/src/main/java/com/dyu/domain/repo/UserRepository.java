package com.dyu.domain.repo;

import com.dyu.domain.dao.UserDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserDO, Long> {
    List<UserDO> findAllByUserIdIsAfter(Long userId);
}
