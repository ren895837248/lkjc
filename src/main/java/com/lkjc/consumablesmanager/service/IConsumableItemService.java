package com.lkjc.consumablesmanager.service;

import com.lkjc.consumablesmanager.entity.ConsumableItem;
import com.lkjc.consumablesmanager.entity.PageInfo;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IConsumableItemService {
    List<ConsumableItem> getConsumablesType(ConsumableItem consumableItem);

    void queryPage(PageInfo pageInfo, ConsumableItem consumableItem);

    int insert(ConsumableItem consumableItem);

    @Transactional(rollbackFor = Exception.class)
    int delete(int id);

    @Transactional(rollbackFor = Exception.class)
    List<Integer> deleteBatch(List<Integer> ids);
}
