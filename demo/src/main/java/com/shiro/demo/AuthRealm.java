package com.shiro.demo;

import com.shiro.demo.Service.UserService;
import com.shiro.demo.model.Permission;
import com.shiro.demo.model.Role;
import com.shiro.demo.model.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class AuthRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    /**
     * 2  授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //根据类名 迭代取出 user 对象
        User user  = (User) principalCollection.fromRealm(this.getClass().getName()).iterator().next();
        //设置权限列表
        List<String> permissionList = new ArrayList<>();
        //角色
        List<String> roleNameList = new ArrayList<>();

        Set<Role> roleSet = user.getRoles();
        //role 非空
        if (CollectionUtils.isNotEmpty(roleSet)){
            for (Role role : roleSet){
                roleNameList.add(role.getRname());
                Set<Permission> permissionSet = role.getPermissions();
                // permission非空
                if (CollectionUtils.isNotEmpty(permissionSet)){
                    for (Permission permission : permissionSet){
                        permissionList.add(permission.getName());
                    }
                }
            }
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermissions(permissionList);
        info.addRoles(roleNameList);
        return info;
    }
    /**
     * 1  认证登陆
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //转换为 usernamePasswordToken
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        //取出username
        String username = usernamePasswordToken.getUsername();
        User user = userService.findUserByUsername(username);

        return new SimpleAuthenticationInfo(user,user.getPassword(),this.getClass().getName());
    }

}
