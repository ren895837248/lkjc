package com.lkjc.consumablesmanager.service.impl;

import com.lkjc.consumablesmanager.entity.ConsumablePurchaseRecord;
import com.lkjc.consumablesmanager.entity.PageInfo;
import com.lkjc.consumablesmanager.mapper.ConsumablePurchaseRecordMapper;
import com.lkjc.consumablesmanager.service.IConsumablePurchaseRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class ConsumablePurchaseRecordService implements IConsumablePurchaseRecordService {
    private static final String STS_USE = "A";
    @Autowired
    private ConsumablePurchaseRecordMapper consumablePurchaseRecordMapper;


    @Override
    public void queryPage(PageInfo pageInfo, ConsumablePurchaseRecord consumablePurchaseRecord) {
        int total = consumablePurchaseRecordMapper.selectCount(consumablePurchaseRecord);
        pageInfo.setTotal(total);

        if (total == 0) {
            pageInfo.setRows(new ArrayList<>());
            return;
        }

        List<ConsumablePurchaseRecord> consumablePurchaseRecords = consumablePurchaseRecordMapper.selectPage(pageInfo, consumablePurchaseRecord);
        pageInfo.setRows(consumablePurchaseRecords);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insert(ConsumablePurchaseRecord consumablePurchaseRecord) {
        consumablePurchaseRecord.setCreateDate(new Date());
        consumablePurchaseRecord.setSts(STS_USE);
        consumablePurchaseRecord.setStsDate(new Date());
        return consumablePurchaseRecordMapper.insert(consumablePurchaseRecord);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int delete(int id) {
        return consumablePurchaseRecordMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<Integer> deleteBatch(List<Integer> ids) {
        List<Integer> result = new ArrayList<>();
        for (Integer id : ids) {
            result.add(consumablePurchaseRecordMapper.deleteByPrimaryKey(id));
        }
        return result;
    }


    @Override
    public List<ConsumablePurchaseRecord> consumablepurchasePriceChart(Integer id) {
        ConsumablePurchaseRecord consumablePurchaseRecord = consumablePurchaseRecordMapper.selectByPrimaryKey(id);
        PageInfo pageInfo = new PageInfo();
        pageInfo.setOffset(0);
        pageInfo.setLimit(30);
        pageInfo.setOrder("desc");
        pageInfo.setSortName("create_date");
        List<ConsumablePurchaseRecord> consumablePurchaseRecords = consumablePurchaseRecordMapper.selectPage(pageInfo, consumablePurchaseRecord);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yy-MM-dd HH-mm");
        Function<ConsumablePurchaseRecord, ConsumablePurchaseRecord> cleanUpCreateDate = consumablePurchaseRecordc -> {
            LocalDateTime localDateTime = LocalDateTime.ofInstant(consumablePurchaseRecordc.getCreateDate().toInstant(), ZoneId.systemDefault());
            consumablePurchaseRecordc.setCreateDateFormat(localDateTime.format(dateTimeFormatter));
            return consumablePurchaseRecordc;
        };

        consumablePurchaseRecords = consumablePurchaseRecords.parallelStream().map(cleanUpCreateDate)
                .sorted((o1, o2) -> (int)(o1.getCreateDate().getTime() - o2.getCreateDate().getTime())).collect(Collectors.toList());

        return consumablePurchaseRecords;
    }
}
