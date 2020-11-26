package com.nnt.excel.model;

import com.nnt.excel.annotation.Column;
import lombok.Data;

/**
 * @author soulmate
 */
@Data
public class CheckData {
    /**
     * 序号
     */
    @Column("序号")
    private String number;
    /**
     * 名称
     */
    @Column("姓名")
    private String name;
    /**
     * 电话
     */
    @Column("电话")
    private String phone;
    /**
     * 身份证号码
     */
    @Column("身份证号")
    private String id;
    /**
     * 创建时间
     */
    @Column("采样时间")
    private String checkTime;
    /**
     * 地址
     */
    @Column("地址")
    private String addr;
    /**
     * 地址
     */
    @Column("备注")
    private String remark;

    public CheckData(){}
}
