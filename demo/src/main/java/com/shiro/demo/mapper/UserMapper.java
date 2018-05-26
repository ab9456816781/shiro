package com.shiro.demo.mapper;

import com.shiro.demo.model.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    User findUserByUsername(@Param("username") String username);
}
