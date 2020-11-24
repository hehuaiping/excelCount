package com.nnt.excel.model;

import lombok.Data;

/**
 * @author soulmate
 */
@Data
public class CountData {
    /**
     * 序号
     */
    private Integer number;
    /**
     * 名称
     */
    private String name;
    /**
     * 电话
     */
    private String phone;
    /**
     * 身份证
     */
    private String id;
    /**
     * 地址
     */
    private String addr;

    /**
     * 第一次检测时间
     */
    private String checkOne;
    /**
     * 第二次检测时间
     */
    private String checkTwo;
    /**
     * 第三次检测时间
     */
    private String checkThree;
    /**
     * 第四次检测时间
     */
    private String checkFour;
    /**
     * 备注
     */
    private String remark;

    public CountData() {

    }
}
