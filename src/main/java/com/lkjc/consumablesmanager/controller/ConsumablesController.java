package com.lkjc.consumablesmanager.controller;

import com.alibaba.fastjson.JSONObject;
import com.lkjc.consumablesmanager.entity.*;
import com.lkjc.consumablesmanager.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
    private IConsumablePurchaseRecordService consumablePurchaseRecordService;


    @Autowired
    private IConsumableSpecificationService consumableSpecificationService;


    @Autowired
    private IConsumableConsumptionRecordService consumableConsumptionRecordService;

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
    public Result consumablesItem(ConsumableItem consumableItem){
        consumableItemService.insert(consumableItem);
        return new Result.Builder().success().message("创建成功").build();

    }


    @RequestMapping(path = "/consumablesitems",method = RequestMethod.DELETE)
    @ResponseBody
    public Result consumablesItem(@RequestBody ArrayList<Integer> ids){
        consumableItemService.deleteBatch(ids);
        return new Result.Builder().success().message("删除成功").build();
    }

    //===================================================================================================


    @RequestMapping(path = "/consumablesspecification/show")
    public String consumableSspecification(){
        return "consumables/consumablesspecification-show";
    }
    //consumablesspecification

    @RequestMapping(path = "/consumablesspecification",method = RequestMethod.GET)
    @ResponseBody
    public  PageInfo queryConsumablesspecificationPage(@ModelAttribute PageInfo pageInfo,@ModelAttribute ConsumableSpecification consumableSpecification){
        consumableSpecificationService.queryPage(pageInfo,consumableSpecification);
        return pageInfo;
    }


    @RequestMapping(path = "/consumablesspecification",method = RequestMethod.POST)
    @ResponseBody
    public  Result createConsumablesspecification(@ModelAttribute ConsumableSpecification consumableSpecification){
        consumableSpecificationService.insert(consumableSpecification);
        return new Result.Builder().success().message("创建成功").build();
    }

    @RequestMapping(path = "/consumablesspecification",method = RequestMethod.DELETE)
    @ResponseBody
    public Result deleteConsumablesspecification(@RequestBody ArrayList<String> ids){
        consumableSpecificationService.deleteBatch(ids);
        return new Result.Builder().success().message("删除成功").build();
    }


    //===================================================================================================



    @RequestMapping(path = "/consumablepurchase/show")
    public String consumablePurchaseRecord(){
        return "consumables/consumablepurchase-show";
    }

    @RequestMapping(path = "/consumablepurchase",method = RequestMethod.GET)
    @ResponseBody
    public  PageInfo queryConsumablePurchaseRecordPage(@ModelAttribute PageInfo pageInfo,@ModelAttribute ConsumablePurchaseRecord consumablePurchaseRecord){
        consumablePurchaseRecordService.queryPage(pageInfo,consumablePurchaseRecord);
        return pageInfo;
    }

    @RequestMapping(path = "/consumablepurchase",method = RequestMethod.POST)
    @ResponseBody
    public  Result createConsumablepurchase(@ModelAttribute ConsumablePurchaseRecord consumablePurchaseRecord){
        consumablePurchaseRecordService.insert(consumablePurchaseRecord);
        return new Result.Builder().success().message("创建成功").build();
    }

    @RequestMapping(path = "/consumablepurchase",method = RequestMethod.DELETE)
    @ResponseBody
    public Result deleteConsumablepurchase(@RequestBody ArrayList<Integer> ids){
        consumablePurchaseRecordService.deleteBatch(ids);
        return new Result.Builder().success().message("删除成功").build();
    }


    @RequestMapping(path = "/consumablepurchase/{id}/prices",method = RequestMethod.GET)
    @ResponseBody
    public List<ConsumablePurchaseRecord> consumablepurchasePriceChart(@PathVariable(name = "id") Integer id){
        return consumablePurchaseRecordService.consumablepurchasePriceChart(id);
    }


    //===================================================================================================



    @RequestMapping(path = "/consumableconsumption/show")
    public String consumableConsumptionRecord(){
        return "consumables/consumableconsumption-show";
    }

    @RequestMapping(path = "/consumableconsumption",method = RequestMethod.GET)
    @ResponseBody
    public  PageInfo queryconsumableConsumptionPage(@ModelAttribute PageInfo pageInfo,@ModelAttribute ConsumableConsumptionRecord  consumableConsumptionRecord){
        consumableConsumptionRecordService.queryPage(pageInfo,consumableConsumptionRecord);
        return pageInfo;
    }

    @RequestMapping(path = "/consumableconsumption",method = RequestMethod.POST)
    @ResponseBody
    public  Result createconsumableConsumption(@ModelAttribute ConsumableConsumptionRecord  consumableConsumptionRecord){
        consumableConsumptionRecordService.insert(consumableConsumptionRecord);
        return new Result.Builder().success().message("创建成功").build();
    }

    @RequestMapping(path = "/consumableconsumption",method = RequestMethod.DELETE)
    @ResponseBody
    public Result deleteconsumableConsumption(@RequestBody ArrayList<Integer> ids){
        consumableConsumptionRecordService.deleteBatch(ids);
        return new Result.Builder().success().message("删除成功").build();
    }


    /*@RequestMapping(path = "/consumableconsumption/{id}/prices",method = RequestMethod.GET)
    @ResponseBody
    public List<ConsumablePurchaseRecord> consumablepurchasePriceChart(@PathVariable(name = "id") Integer id){
        return consumablePurchaseRecordService.consumablepurchasePriceChart(id);
    }*/


    @RequestMapping(path = "/consumablemonitor")
    public String consumableMonitor(){
        return "consumables/consumables-monitor";
    }
}
