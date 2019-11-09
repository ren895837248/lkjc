package com.lkjc.consumablesmanager.service;

import com.alibaba.fastjson.JSONObject;
import com.lkjc.consumablesmanager.entity.ConsumableChartData;
import com.lkjc.consumablesmanager.entity.ConsumableStatiticsInit;
import com.lkjc.consumablesmanager.entity.ConsumableType;

import java.util.List;

public interface IConsumableService {
    List<ConsumableChartData> doStatistics(ConsumableStatiticsInit consumableStatiticsInit);
}
