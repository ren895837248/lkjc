package com.lkjc.consumablesmanager.service;

import com.lkjc.consumablesmanager.entity.ConsumableItem;
import com.lkjc.consumablesmanager.entity.ConsumableSpecification;

import java.util.List;

public interface IConsumableSpecificationService {
    List<ConsumableSpecification> getConsumablesSpecification(ConsumableSpecification consumableItem);
}
