package com.manage.sys.sms.dao;

import com.manage.sys.sms.api.entity.ApplyEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface IApplyMapper extends IBaseMapper<ApplyEntity> {

    ApplyEntity getByUserIdAndStallId(@Param("userId") Integer userId,@Param("stallId") Integer stallId);
}
