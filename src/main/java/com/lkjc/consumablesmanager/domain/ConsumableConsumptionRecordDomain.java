package com.lkjc.consumablesmanager.domain;

import com.lkjc.consumablesmanager.entity.ConsumableChartData;
import com.lkjc.consumablesmanager.entity.ConsumableConsumptionRecord;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

@Component
public class ConsumableConsumptionRecordDomain {


    public void getCharDataFrom(List<ConsumableConsumptionRecord> consumableConsumptionRecords, Map<String, ConsumableChartData> repeatCharDataMap) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        if(consumableConsumptionRecords!=null && consumableConsumptionRecords.size()>0){
            for(ConsumableConsumptionRecord ccr : consumableConsumptionRecords){
                String fullSpecificationValue = ccr.getConsumableTypeId()+"."+ccr.getConsumableItemId()+"."+ccr.getConsumableSpecificationId();
                String fullSpecificationName = ccr.getConsumableTypeName()+"-"+ccr.getConsumableItemName()+"-"+ccr.getConsumableSpecificationName();

                ConsumableChartData consumableChartData =  repeatCharDataMap.get(fullSpecificationValue);

                if(consumableChartData == null){
                    consumableChartData = new ConsumableChartData();
                    repeatCharDataMap.put(fullSpecificationValue,consumableChartData);
                }
                consumableChartData.setConsumableName(fullSpecificationName);
                ConsumableChartData.Record record = new ConsumableChartData.Record();
                ccr.getCreateDate();
                record.setDate(sdf.format(ccr.getCreateDate()));
                record.setDateTime(ccr.getCreateDate().getTime());
                record.setValue(-ccr.getCount());
                consumableChartData.getRecords().add(record);
            }
        }
    }

}
