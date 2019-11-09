package com.lkjc.consumablesmanager.service.impl;

import com.lkjc.consumablesmanager.domain.ConsumableConsumptionRecordDomain;
import com.lkjc.consumablesmanager.domain.ConsumablePurchaseRecordDomain;
import com.lkjc.consumablesmanager.entity.ConsumableChartData;
import com.lkjc.consumablesmanager.entity.ConsumableConsumptionRecord;
import com.lkjc.consumablesmanager.entity.ConsumablePurchaseRecord;
import com.lkjc.consumablesmanager.entity.ConsumableStatiticsInit;
import com.lkjc.consumablesmanager.mapper.*;
import com.lkjc.consumablesmanager.service.IConsumableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service

public class ConsumableService implements IConsumableService {

    private static final Logger logger = LoggerFactory.getLogger(ConsumableService.class);
    @Autowired
    private ConsumableSpecificationMapper consumableSpecificationMapper;
    @Autowired
    private ConsumableTypeMapper consumableTypeMapper;
    @Autowired
    private ConsumableItemMapper consumableItemMapper;
    @Autowired
    private ConsumableConsumptionRecordMapper consumableConsumptionRecordMapper;
    @Autowired
    private ConsumablePurchaseRecordMapper consumablePurchaseRecordMapper;
    @Autowired
    private ConsumableConsumptionRecordDomain consumableConsumptionRecordDomain;
    @Autowired
    private ConsumablePurchaseRecordDomain consumablePurchaseRecordDomain;

    @Override
    public List<ConsumableChartData> doStatistics(ConsumableStatiticsInit consumableStatiticsInit){
        if(consumableStatiticsInit==null){
            throw new IllegalArgumentException("参数不能为空");
        }

        logger.info("开始根据{}参数进行耗材统计",consumableStatiticsInit.toString());

        cleanUpInitParams(consumableStatiticsInit);

        List<ConsumablePurchaseRecord> consumablePurchaseRecords =  consumablePurchaseRecordMapper.conductStatistics(consumableStatiticsInit);
        List<ConsumableConsumptionRecord> consumableConsumptionRecords =  consumableConsumptionRecordMapper.conductStatistics(consumableStatiticsInit);

        List<ConsumableChartData> consumableChartDataList = new ArrayList<>();
        Map<String,ConsumableChartData> repeatCharDataMap = new HashMap<>();

        consumablePurchaseRecordDomain.getCharDataFrom(consumablePurchaseRecords, repeatCharDataMap);
        consumableConsumptionRecordDomain.getCharDataFrom(consumableConsumptionRecords, repeatCharDataMap);

        cleanUpCharData(consumableChartDataList, repeatCharDataMap);

        return consumableChartDataList;

    }

    private void cleanUpInitParams(ConsumableStatiticsInit consumableStatiticsInit) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String timeBeginStr = consumableStatiticsInit.getTimeBeginStr();
        String timeEndStr = consumableStatiticsInit.getTimeEndStr();
        try {
            consumableStatiticsInit.setTimeBegin(new Timestamp(simpleDateFormat.parse(timeBeginStr).getTime()));
            consumableStatiticsInit.setTimeEnd(new Timestamp(simpleDateFormat.parse(timeEndStr).getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if(StringUtils.isEmpty(consumableStatiticsInit.getItemId())){
            consumableStatiticsInit.setItemId(0);
        }

        if(StringUtils.isEmpty(consumableStatiticsInit.getSpecificationId())){
            consumableStatiticsInit.setSpecificationId(0);
        }
    }

    private void cleanUpCharData(List<ConsumableChartData> consumableChartDataList, Map<String, ConsumableChartData> repeatCharDataMap) {
        for(Map.Entry<String,ConsumableChartData> entry : repeatCharDataMap.entrySet()){
            ConsumableChartData consumableChartData = entry.getValue();
            consumableChartData.setConsumableNameValue(entry.getKey());
            List<ConsumableChartData.Record> records= consumableChartData.getRecords();

            Collections.sort(records);

            int count = 0;
            for(ConsumableChartData.Record record : records){
                count += record.getValue();
                record.setCurrentCount(count);
            }
            consumableChartDataList.add(entry.getValue());
        }
    }


}
