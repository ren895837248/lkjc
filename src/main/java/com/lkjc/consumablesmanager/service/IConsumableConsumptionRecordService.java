package com.lkjc.consumablesmanager.service;

import com.lkjc.consumablesmanager.entity.ConsumableConsumptionRecord;
import com.lkjc.consumablesmanager.entity.ConsumablePurchaseRecord;
import com.lkjc.consumablesmanager.entity.PageInfo;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IConsumableConsumptionRecordService {


    void queryPage(PageInfo pageInfo, ConsumableConsumptionRecord consumableConsumptionRecord);

    @Transactional(rollbackFor = Exception.class)
    int insert(ConsumableConsumptionRecord consumableConsumptionRecord);

    @Transactional(rollbackFor = Exception.class)
    int delete(int id);

    @Transactional(rollbackFor = Exception.class)
    List<Integer> deleteBatch(List<Integer> ids);
}
