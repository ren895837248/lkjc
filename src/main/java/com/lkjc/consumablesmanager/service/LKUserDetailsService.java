package com.lkjc.consumablesmanager.service;

import com.lkjc.consumablesmanager.entity.Role;
import com.lkjc.consumablesmanager.entity.User;
import com.lkjc.consumablesmanager.entity.UserRoleRel;
import com.lkjc.consumablesmanager.mapper.RoleMapper;
import com.lkjc.consumablesmanager.mapper.UserMapper;
import com.lkjc.consumablesmanager.mapper.UserRoleRelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LKUserDetailsService implements UserDetailsService {
    private static final String STS_USE = "A";

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private UserRoleRelMapper userRoleRelMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = new User();
        user.setLoginName(username);
        user.setSts(STS_USE);
        List<User> users = userMapper.select(user);
        if (users == null || users.size() == 0) {
            return null;
        }
        user = users.get(0);
        UserRoleRel userRoleRel = new UserRoleRel();

        userRoleRel.setUserId(String.valueOf(user.getUserId()));
        userRoleRel.setSts(STS_USE);
        List<UserRoleRel> userRoleRels = userRoleRelMapper.select(userRoleRel);
        if (userRoleRel == null) {
            return user;
        }
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        for (UserRoleRel userRoleRelTemp : userRoleRels) {
            Role role = roleMapper.selectByPrimaryKey(String.valueOf(userRoleRelTemp.getRoleId()));
            if (role == null) {
                continue;
            }

            String desc = role.getRoleName();

            grantedAuthorityList.add(new SimpleGrantedAuthority("ROLE_" + desc.toUpperCase()));
        }

        user.setAuthorityList(grantedAuthorityList);

        return user;
    }
}
