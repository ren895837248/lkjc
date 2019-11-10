package com.lkjc.consumablesmanager.service.impl;

import com.lkjc.consumablesmanager.entity.ConsumableItem;
import com.lkjc.consumablesmanager.entity.ConsumableSpecification;
import com.lkjc.consumablesmanager.entity.PageInfo;
import com.lkjc.consumablesmanager.mapper.ConsumableItemMapper;
import com.lkjc.consumablesmanager.mapper.ConsumableSpecificationMapper;
import com.lkjc.consumablesmanager.service.IConsumableItemService;
import com.lkjc.consumablesmanager.service.IConsumableSpecificationService;
import com.lkjc.consumablesmanager.service.IConsumableTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ConsumableSpecificationService implements IConsumableSpecificationService {
    private static final String STS_USE = "A";
    @Autowired
    private ConsumableSpecificationMapper consumableSpecificationMapper;

    @Override
    public List<ConsumableSpecification> getConsumablesSpecification(ConsumableSpecification consumableSpecification){
        List<ConsumableSpecification> consumableSpecificationList = consumableSpecificationMapper.select(consumableSpecification);
        return consumableSpecificationList;
    }


    @Override
    public void queryPage(PageInfo pageInfo, ConsumableSpecification consumableSpecification) {
        int total = consumableSpecificationMapper.selectCount(consumableSpecification);
        pageInfo.setTotal(total);
        if (total == 0) {
            return;
        }
        List<ConsumableItem> consumableItemList = consumableSpecificationMapper.selectPage(pageInfo,consumableSpecification);
        pageInfo.setRows(consumableItemList);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insert(ConsumableSpecification consumableSpecification) {
        consumableSpecification.setCreateDate(new Date());
        consumableSpecification.setSts(STS_USE);
        consumableSpecification.setStsDate(new Date());
        return consumableSpecificationMapper.insert(consumableSpecification);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int delete(int itemId,int id) {
        return consumableSpecificationMapper.deleteByPrimaryKey(id,itemId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<Integer> deleteBatch(List<String> ids) {
        List<Integer> result = new ArrayList<>();
        for (String id : ids) {
            String[] idArr = id.split(",");
            result.add(consumableSpecificationMapper.deleteByPrimaryKey(Integer.parseInt(idArr[0]),Integer.parseInt(idArr[1])));
        }
        return result;
    }

}
