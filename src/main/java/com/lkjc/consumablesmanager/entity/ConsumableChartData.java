package com.lkjc.consumablesmanager.entity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ConsumableChartData {
    private String consumableName;
    private String consumableNameValue;
    private List<Record> records = new ArrayList<>();
    private double count;

    public double getCount() {
        return count;
    }

    public void setCount(double count) {
        this.count = count;
    }

    public static class Record implements Comparable<Record>{
        private String date;
        private double value;
        private double currentCount;
        private long dateTime;

        public long getDateTime() {
            return dateTime;
        }

        public void setDateTime(long dateTime) {
            this.dateTime = dateTime;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public double getValue() {
            return value;
        }

        public void setValue(double value) {
            this.value = value;
        }

        public double getCurrentCount() {
            return currentCount;
        }

        public void setCurrentCount(double currentCount) {
            this.currentCount = currentCount;
        }

        @Override
        public int compareTo(Record o) {
            return (int) (this.dateTime - o.dateTime);
        }
    }


    public String getConsumableName() {
        return consumableName;
    }

    public void setConsumableName(String consumableName) {
        this.consumableName = consumableName;
    }

    public String getConsumableNameValue() {
        return consumableNameValue;
    }

    public void setConsumableNameValue(String consumableNameValue) {
        this.consumableNameValue = consumableNameValue;
    }

    public List<Record> getRecords() {
        return records;
    }

    public void setRecords(List<Record> records) {
        this.records = records;
    }


}
