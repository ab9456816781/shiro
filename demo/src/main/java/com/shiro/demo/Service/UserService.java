package com.shiro.demo.Service;

import com.shiro.demo.model.User;

public interface UserService {

    User findUserByUsername(String username);
}
