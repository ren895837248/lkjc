package com.lkjc.consumablesmanager.service;

import com.alibaba.fastjson.JSONObject;
import com.lkjc.consumablesmanager.entity.ConsumableType;

import java.util.List;

public interface IConsumableTypeService {
    List<JSONObject> getConsumablesType(ConsumableType consumableType);
}
