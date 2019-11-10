package com.lkjc.consumablesmanager.entity;

import java.util.List;

public class PageInfo {
    private int total;
    private List<? extends Entity> rows;
    private int pageSize;
    private int offset;
    private int limit;
    private String order;
    private String sortName;

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    private int page;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<? extends Entity> getRows() {
        return rows;
    }

    public void setRows(List<? extends Entity> rows) {
        this.rows = rows;
    }
}
