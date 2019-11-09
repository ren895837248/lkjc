package com.lkjc.consumablesmanager.controller;

import com.alibaba.fastjson.JSONObject;
import com.lkjc.consumablesmanager.entity.*;
import com.lkjc.consumablesmanager.service.IConsumableItemService;
import com.lkjc.consumablesmanager.service.IConsumableService;
import com.lkjc.consumablesmanager.service.IConsumableSpecificationService;
import com.lkjc.consumablesmanager.service.IConsumableTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
@RequestMapping(path = "/consumable")
public class ConsumablesController {
    private static final Logger logger = LoggerFactory.getLogger(ConsumablesController.class);
    @Autowired
    private IConsumableTypeService consumableTypeService;

    @Autowired
    private IConsumableItemService consumableItemService;
    @Autowired
    private IConsumableService consumableService;


    @Autowired
    private IConsumableSpecificationService consumableSpecificationService;

    @RequestMapping(path = "/consumabletype", method = RequestMethod.GET)
    @ResponseBody
    public List<JSONObject> consumablesType() {
        List<JSONObject> result = consumableTypeService.getConsumablesType(new ConsumableType());
        return result;
    }


    @RequestMapping(path = "/{typeId}/consumableitem", method = RequestMethod.GET)
    @ResponseBody
    public List<ConsumableItem> consumablesItem(@PathVariable(name = "typeId") int typeId) {
        ConsumableItem consumableItem = new ConsumableItem();
        consumableItem.setConsumableTypeId(typeId);
        List<ConsumableItem> result = consumableItemService.getConsumablesType(consumableItem);
        return result;
    }


    @RequestMapping(path = "/{iteamId}/consumablespecification", method = RequestMethod.GET)
    @ResponseBody
    public List<ConsumableSpecification> consumablesSpecification(@PathVariable(name = "iteamId") int iteamId) {
        ConsumableSpecification consumableSpecification = new ConsumableSpecification();
        consumableSpecification.setConsumableItemId(iteamId);
        List<ConsumableSpecification> result = consumableSpecificationService.getConsumablesSpecification(consumableSpecification);
        return result;
    }

    //statistics
    @RequestMapping(path = "/{typeId}/{itemId}/{specificationId}/statistics", method = RequestMethod.GET)
    @ResponseBody
    public List<ConsumableChartData> conductStatistics(@ModelAttribute ConsumableStatiticsInit consumableStatiticsInit){
        return consumableService.doStatistics(consumableStatiticsInit);
    }

    @RequestMapping(path = "/consumablesitem/show")
    public String consumablesItem(){
        return "consumables/consumablesitem-show";
    }

    @RequestMapping(path = "/consumablesitem",method = RequestMethod.GET)
    @ResponseBody
    public  PageInfo consumablesItem(@ModelAttribute PageInfo pageInfo,@ModelAttribute ConsumableItem consumableItem){
        consumableItemService.queryPage(pageInfo,consumableItem);
        return pageInfo;
    }

    @RequestMapping(path = "/consumablesitem",method = RequestMethod.POST)
    @ResponseBody
    public void consumablesItem(ConsumableItem consumableItem){
        consumableItemService.insert(consumableItem);
    }


    @RequestMapping(path = "/consumablesitems",method = RequestMethod.DELETE)
    @ResponseBody
    public void consumablesItem(  List<Integer> ids){
        consumableItemService.deleteBatch(ids);
    }

}
