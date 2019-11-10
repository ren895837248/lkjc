package com.lkjc.consumablesmanager.service.impl;

import com.lkjc.consumablesmanager.entity.ConsumableConsumptionRecord;
import com.lkjc.consumablesmanager.entity.PageInfo;
import com.lkjc.consumablesmanager.mapper.ConsumableConsumptionRecordMapper;
import com.lkjc.consumablesmanager.service.IConsumableConsumptionRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ConsumableConsumptionRecordService implements IConsumableConsumptionRecordService {
    private static final String STS_USE = "A";
    @Autowired
    private ConsumableConsumptionRecordMapper consumableConsumptionRecordMapper;


    @Override
    public void queryPage(PageInfo pageInfo, ConsumableConsumptionRecord consumableConsumptionRecord) {
        int total = consumableConsumptionRecordMapper.selectCount(consumableConsumptionRecord);
        pageInfo.setTotal(total);

        if (total == 0) {
            pageInfo.setRows(new ArrayList<>());
            return;
        }

        List<ConsumableConsumptionRecord> consumableConsumptionRecords = consumableConsumptionRecordMapper.selectPage(pageInfo, consumableConsumptionRecord);
        pageInfo.setRows(consumableConsumptionRecords);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insert(ConsumableConsumptionRecord consumableConsumptionRecord) {
        consumableConsumptionRecord.setCreateDate(new Date());
        consumableConsumptionRecord.setSts(STS_USE);
        consumableConsumptionRecord.setStsDate(new Date());
        return consumableConsumptionRecordMapper.insert(consumableConsumptionRecord);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int delete(int id) {
        return consumableConsumptionRecordMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<Integer> deleteBatch(List<Integer> ids) {
        List<Integer> result = new ArrayList<>();
        for (Integer id : ids) {
            result.add(consumableConsumptionRecordMapper.deleteByPrimaryKey(id));
        }
        return result;
    }


    /*@Override
    public List<ConsumableConsumptionRecord> consumablepurchasePriceChart(Integer id) {
        ConsumableConsumptionRecord consumableConsumptionRecord = consumableConsumptionRecordMapper.selectByPrimaryKey(id);
        PageInfo pageInfo = new PageInfo();
        pageInfo.setOffset(0);
        pageInfo.setLimit(30);
        pageInfo.setOrder("desc");
        pageInfo.setSortName("create_date");
        List<ConsumableConsumptionRecord> consumableConsumptionRecords = consumableConsumptionRecordMapper.selectPage(pageInfo, consumableConsumptionRecord);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yy-MM-dd HH-mm");
        Function<ConsumablePurchaseRecord, ConsumablePurchaseRecord> cleanUpCreateDate = consumablePurchaseRecordc -> {
            LocalDateTime localDateTime = LocalDateTime.ofInstant(consumablePurchaseRecordc.getCreateDate().toInstant(), ZoneId.systemDefault());
            consumablePurchaseRecordc.setCreateDateFormat(localDateTime.format(dateTimeFormatter));
            return consumablePurchaseRecordc;
        };

        consumablePurchaseRecords = consumableConsumptionRecords.parallelStream().map(cleanUpCreateDate)
                .sorted((o1, o2) -> (int)(o1.getCreateDate().getTime() - o2.getCreateDate().getTime())).collect(Collectors.toList());

        return consumablePurchaseRecords;
    }*/
}
