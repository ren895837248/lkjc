package com.lkjc.consumablesmanager.service;

import com.lkjc.consumablesmanager.entity.ConsumablePurchaseRecord;
import com.lkjc.consumablesmanager.entity.ConsumableSpecification;
import com.lkjc.consumablesmanager.entity.PageInfo;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IConsumablePurchaseRecordService {


    void queryPage(PageInfo pageInfo, ConsumablePurchaseRecord consumablePurchaseRecord);

    @Transactional(rollbackFor = Exception.class)
    int insert(ConsumablePurchaseRecord consumablePurchaseRecord);

    @Transactional(rollbackFor = Exception.class)
    int delete(int id);

    @Transactional(rollbackFor = Exception.class)
    List<Integer> deleteBatch(List<Integer> ids);

    List<ConsumablePurchaseRecord> consumablepurchasePriceChart(Integer id);
}
