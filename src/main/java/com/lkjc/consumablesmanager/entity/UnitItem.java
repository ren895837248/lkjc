package com.lkjc.consumablesmanager.entity;

import java.util.Date;

public class UnitItem {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column unit_item.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column unit_item.name
     *
     * @mbg.generated
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column unit_item.sts
     *
     * @mbg.generated
     */
    private String sts;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column unit_item.sts_date
     *
     * @mbg.generated
     */
    private Date stsDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column unit_item.create_date
     *
     * @mbg.generated
     */
    private Date createDate;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column unit_item.id
     *
     * @return the value of unit_item.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column unit_item.id
     *
     * @param id the value for unit_item.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column unit_item.name
     *
     * @return the value of unit_item.name
     *
     * @mbg.generated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column unit_item.name
     *
     * @param name the value for unit_item.name
     *
     * @mbg.generated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column unit_item.sts
     *
     * @return the value of unit_item.sts
     *
     * @mbg.generated
     */
    public String getSts() {
        return sts;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column unit_item.sts
     *
     * @param sts the value for unit_item.sts
     *
     * @mbg.generated
     */
    public void setSts(String sts) {
        this.sts = sts == null ? null : sts.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column unit_item.sts_date
     *
     * @return the value of unit_item.sts_date
     *
     * @mbg.generated
     */
    public Date getStsDate() {
        return stsDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column unit_item.sts_date
     *
     * @param stsDate the value for unit_item.sts_date
     *
     * @mbg.generated
     */
    public void setStsDate(Date stsDate) {
        this.stsDate = stsDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column unit_item.create_date
     *
     * @return the value of unit_item.create_date
     *
     * @mbg.generated
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column unit_item.create_date
     *
     * @param createDate the value for unit_item.create_date
     *
     * @mbg.generated
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}