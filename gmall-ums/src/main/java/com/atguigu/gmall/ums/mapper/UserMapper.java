package com.atguigu.gmall.ums.mapper;

import com.atguigu.gmall.ums.entity.UserEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户表
 * 
 * @author langD
 * @email langD@atguigu.com
 * @date 2020-10-19 19:11:09
 */
@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {
	
}
