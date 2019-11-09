package com.lkjc.consumablesmanager.controller;


import com.lkjc.consumablesmanager.mapper.AuthorityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(path = "/test")
public class TestController {

    @Autowired
    AuthorityMapper authorityMapper;

    @RequestMapping(method = RequestMethod.GET, path = "test1")
    @ResponseBody
    public void test() {
        List list = authorityMapper.selectAll();
        System.out.println("list");
    }

}
