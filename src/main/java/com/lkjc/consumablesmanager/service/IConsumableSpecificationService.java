package com.lkjc.consumablesmanager.service;

import com.lkjc.consumablesmanager.entity.ConsumableItem;
import com.lkjc.consumablesmanager.entity.ConsumableSpecification;
import com.lkjc.consumablesmanager.entity.PageInfo;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IConsumableSpecificationService {
    List<ConsumableSpecification> getConsumablesSpecification(ConsumableSpecification consumableItem);

    void queryPage(PageInfo pageInfo, ConsumableSpecification consumableItem);

    @Transactional(rollbackFor = Exception.class)
    int insert(ConsumableSpecification consumableSpecification);

    @Transactional(rollbackFor = Exception.class)
    int delete(int itemId, int id);

    @Transactional(rollbackFor = Exception.class)
    List<Integer> deleteBatch(List<String> ids);
}
