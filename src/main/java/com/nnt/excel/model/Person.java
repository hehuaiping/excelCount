package com.nnt.excel.model;

import com.nnt.excel.annotation.Column;
import lombok.Data;

/**
 * @author soulmate
 */
@Data
public class Person {
    @Column("身份证号码")
    private String id;
    @Column("姓名")
    private String name;
    @Column("电话")
    private String phone;
    @Column("地址")
    private String addr;

    public Person(){}
}
