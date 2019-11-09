package com.lkjc.consumablesmanager.service.impl;

import com.lkjc.consumablesmanager.entity.ConsumableItem;
import com.lkjc.consumablesmanager.entity.ConsumableSpecification;
import com.lkjc.consumablesmanager.mapper.ConsumableItemMapper;
import com.lkjc.consumablesmanager.mapper.ConsumableSpecificationMapper;
import com.lkjc.consumablesmanager.service.IConsumableItemService;
import com.lkjc.consumablesmanager.service.IConsumableSpecificationService;
import com.lkjc.consumablesmanager.service.IConsumableTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsumableSpecificationService implements IConsumableSpecificationService {

    @Autowired
    private ConsumableSpecificationMapper consumableSpecificationMapper;

    @Override
    public List<ConsumableSpecification> getConsumablesSpecification(ConsumableSpecification consumableItem){
        List<ConsumableSpecification> consumableSpecificationList = consumableSpecificationMapper.select(consumableItem);
        return consumableSpecificationList;
    }


}
