package com.lkjc.consumablesmanager.mapper;

import com.lkjc.consumablesmanager.entity.ConsumableConsumptionRecord;
import com.lkjc.consumablesmanager.entity.ConsumablePurchaseRecord;
import com.lkjc.consumablesmanager.entity.ConsumableStatiticsInit;
import com.lkjc.consumablesmanager.entity.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ConsumableConsumptionRecordMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table consumable_consumption_record
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table consumable_consumption_record
     *
     * @mbg.generated
     */
    int insert(ConsumableConsumptionRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table consumable_consumption_record
     *
     * @mbg.generated
     */
    ConsumableConsumptionRecord selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table consumable_consumption_record
     *
     * @mbg.generated
     */
    List<ConsumableConsumptionRecord> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table consumable_consumption_record
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(ConsumableConsumptionRecord record);

    List<ConsumableConsumptionRecord> conductStatistics(ConsumableStatiticsInit consumableStatiticsInit);

    List<ConsumableConsumptionRecord> selectPage(@Param("pageInfo") PageInfo pageInfo, @Param("consumableConsumptionRecord") ConsumableConsumptionRecord record);

    int selectCount(@Param("consumableConsumptionRecord") ConsumableConsumptionRecord record);

}