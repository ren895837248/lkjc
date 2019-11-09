package com.lkjc.consumablesmanager.entity;

import java.sql.Timestamp;

public class ConsumableStatiticsInit {

    private int itemId;
    private int typeId;
    private int specificationId;
    private Timestamp timeBegin;
    private String timeBeginStr;
    private Timestamp timeEnd;
    private String timeEndStr;


    public String getTimeBeginStr() {
        return timeBeginStr;
    }

    public void setTimeBeginStr(String timeBeginStr) {
        this.timeBeginStr = timeBeginStr;
    }

    public String getTimeEndStr() {
        return timeEndStr;
    }

    public void setTimeEndStr(String timeEndStr) {
        this.timeEndStr = timeEndStr;
    }

    public Timestamp getTimeBegin() {
        return timeBegin;
    }

    public void setTimeBegin(Timestamp timeBegin) {
        this.timeBegin = timeBegin;
    }

    public Timestamp getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Timestamp timeEnd) {
        this.timeEnd = timeEnd;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public int getSpecificationId() {
        return specificationId;
    }

    public void setSpecificationId(int specificationId) {
        this.specificationId = specificationId;
    }

    @Override
    public String toString() {
        return "ConsumableStatiticsInit{" +
                "itemId=" + itemId +
                ", typeId=" + typeId +
                ", specificationId=" + specificationId +
                ", timeBegin=" + timeBegin +
                ", timeEnd=" + timeEnd +
                '}';
    }
}
