package com.dyu.frame.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dyu.frame.domain.entity.AppleDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author dyu 2021/6/28 11:15
 */
@Repository
@Mapper
@Transactional(transactionManager = "hwTm")
public interface AppleMapper extends BaseMapper<AppleDO> {
}
