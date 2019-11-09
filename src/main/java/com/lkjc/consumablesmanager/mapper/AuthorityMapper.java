package com.lkjc.consumablesmanager.mapper;

import com.lkjc.consumablesmanager.entity.Authority;

import java.util.List;

public interface AuthorityMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table authority
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String authorityId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table authority
     *
     * @mbg.generated
     */
    int insert(Authority record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table authority
     *
     * @mbg.generated
     */
    Authority selectByPrimaryKey(String authorityId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table authority
     *
     * @mbg.generated
     */
    List<Authority> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table authority
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Authority record);
}