package com.lkjc.consumablesmanager.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lkjc.consumablesmanager.entity.ConsumableType;
import com.lkjc.consumablesmanager.mapper.ConsumableTypeMapper;
import com.lkjc.consumablesmanager.service.IConsumableTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConsumableTypeService implements IConsumableTypeService {

    @Autowired
    private ConsumableTypeMapper consumableTypeMapper;

    @Override
    public List<JSONObject> getConsumablesType(ConsumableType consumableType){
        List<JSONObject> result = new ArrayList<>();
        List<ConsumableType> consumableTypeList = consumableTypeMapper.select(consumableType);
        if(consumableTypeList!=null){
            for(ConsumableType consumableTypeTemp : consumableTypeList){
                result.add((JSONObject) JSON.toJSON(consumableTypeTemp));
            }
        }
        return result;
    }


}
