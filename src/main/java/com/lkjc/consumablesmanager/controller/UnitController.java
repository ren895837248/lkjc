package com.lkjc.consumablesmanager.controller;


import com.lkjc.consumablesmanager.entity.UnitItem;
import com.lkjc.consumablesmanager.mapper.UnitItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UnitController {


    @Autowired
    private UnitItemMapper unitItemMapper;

    @RequestMapping(value = "unititems", method = RequestMethod.GET)
    @ResponseBody
    public List<UnitItem>  queryAll() {
        UnitItem item = new UnitItem();
        item.setSts("A");
        List<UnitItem> unitItems = unitItemMapper.select(item);
        return unitItems;
    }

}
