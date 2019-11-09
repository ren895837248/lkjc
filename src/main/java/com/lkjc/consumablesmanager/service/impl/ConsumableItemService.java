package com.lkjc.consumablesmanager.service.impl;

import com.lkjc.consumablesmanager.entity.ConsumableItem;
import com.lkjc.consumablesmanager.entity.PageInfo;
import com.lkjc.consumablesmanager.mapper.ConsumableItemMapper;
import com.lkjc.consumablesmanager.service.IConsumableItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ConsumableItemService implements IConsumableItemService {

    @Autowired
    private ConsumableItemMapper consumableItemMapper;

    private static final String STS_USE = "A";

    @Override
    public List<ConsumableItem> getConsumablesType(ConsumableItem consumableItem) {
        List<ConsumableItem> consumableItemList = consumableItemMapper.select(consumableItem);
        return consumableItemList;
    }

    @Override
    public void queryPage(PageInfo pageInfo, ConsumableItem consumableItem) {
        int total = consumableItemMapper.selectCount(consumableItem);
        pageInfo.setTotal(total);
        if (total == 0) {
            return;
        }
        List<ConsumableItem> consumableItemList = consumableItemMapper.selectPage(pageInfo,consumableItem);
        pageInfo.setRows(consumableItemList);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insert(ConsumableItem consumableItem) {
        consumableItem.setCreateDate(new Date());
        consumableItem.setSts(STS_USE);
        consumableItem.setStsDate(new Date());
        return consumableItemMapper.insert(consumableItem);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int delete(int id) {
        return consumableItemMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<Integer> deleteBatch(List<Integer> ids) {
        List<Integer> result = new ArrayList<>();
        for (Integer id : ids) {
            result.add(consumableItemMapper.deleteByPrimaryKey(id));
        }
        return result;
    }

}
