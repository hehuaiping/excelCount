package com.nnt.excel.model;

import com.nnt.excel.annotation.Column;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * @author soulmate
 */
@Data
public class CountData implements Comparable<CountData>{

    public static final String[] headers = new String[]{
            "序号","名称","电话","身份证","地址","第一次检测时间","第二次检测时间",
            "第三次检测时间","第四次检测时间","备注"
    };


    public static Integer ITEM = 1;

    /**
     * 序号
     */
    @Column("序号")
    private Integer number;
    /**
     * 名称
     */
    @Column("名称")
    private String name;
    /**
     * 电话
     */
    @Column("电话")
    private String phone;
    /**
     * 身份证
     */
    @Column("身份证")
    private String id;
    /**
     * 地址
     */
    @Column("地址")
    private String addr;

    /**
     * 第一次检测时间
     */
    @Column("第一次检测时间")
    private String checkOne;
    /**
     * 第二次检测时间
     */
    @Column("第二次检测时间")
    private String checkTwo;
    /**
     * 第三次检测时间
     */
    @Column("第三次检测时间")
    private String checkThree;
    /**
     * 第四次检测时间
     */
    @Column("第四次检测时间")
    private String checkFour;
    /**
     * 备注
     */
    @Column("备注")
    private String remark;

    public static synchronized int getItem() {
        return ITEM ++;
    }

    public CountData() {

    }

    @Override
    public int compareTo(CountData o) {
        if(Objects.isNull(this.getNumber())) {
            return 0;
        }
        return this.getNumber() - o.getNumber();
    }
}
