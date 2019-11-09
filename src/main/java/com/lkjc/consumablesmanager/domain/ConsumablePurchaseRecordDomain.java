package com.lkjc.consumablesmanager.domain;

import com.lkjc.consumablesmanager.entity.ConsumableChartData;
import com.lkjc.consumablesmanager.entity.ConsumablePurchaseRecord;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

@Component
public class ConsumablePurchaseRecordDomain {

    public void getCharDataFrom(List<ConsumablePurchaseRecord> consumablePurchaseRecords, Map<String, ConsumableChartData> repeatCharDataMap) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        if(consumablePurchaseRecords!=null && consumablePurchaseRecords.size()>0){
            for(ConsumablePurchaseRecord cpr : consumablePurchaseRecords){
                String fullSpecificationValue = cpr.getConsumableTypeId()+"."+cpr.getConsumableItemId()+"."+cpr.getConsumableSpecificationId();
                String fullSpecificationName = cpr.getConsumableTypeName()+"-"+cpr.getConsumableItemName()+"-"+cpr.getConsumableSpecificationName();
                ConsumableChartData consumableChartData =  repeatCharDataMap.get(fullSpecificationValue);
                if(consumableChartData == null){
                    consumableChartData = new ConsumableChartData();
                    repeatCharDataMap.put(fullSpecificationValue,consumableChartData);
                }
                consumableChartData.setConsumableName(fullSpecificationName);
                ConsumableChartData.Record record = new ConsumableChartData.Record();
                cpr.getCreateDate();
                record.setDate(sdf.format(cpr.getCreateDate()));
                record.setValue(cpr.getCount());
                record.setDateTime(cpr.getCreateDate().getTime());
                consumableChartData.getRecords().add(record);
            }
        }
    }

}
