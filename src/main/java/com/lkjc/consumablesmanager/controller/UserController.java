package com.lkjc.consumablesmanager.controller;


import com.lkjc.consumablesmanager.entity.UnitItem;
import com.lkjc.consumablesmanager.entity.User;
import com.lkjc.consumablesmanager.mapper.UnitItemMapper;
import com.lkjc.consumablesmanager.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@Controller
public class UserController {


    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value = "users", method = RequestMethod.GET)
    @ResponseBody
    public List<User>  queryAll() {
        User user = new User();
        user.setSts("A");
        List<User> users = userMapper.select(user);
        return users;
    }

}
