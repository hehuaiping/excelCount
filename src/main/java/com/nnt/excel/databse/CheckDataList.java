package com.nnt.excel.databse;

import com.nnt.excel.model.CheckData;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author soulmate
 */
@Data
public class CheckDataList {
    /**
     * 检测数据
     */
    public static final List<List<CheckData>> checkDataList = new ArrayList<List<CheckData>>(4){{
        // 第一次检测数据
        add(new ArrayList<>());
        // 第二次检测数据
        add(new ArrayList<>());
        // 第三次检测数据
        add(new ArrayList<>());
        // 第四次检测数据
        add(new ArrayList<>());
    }};

    public static void clean() {
        checkDataList.forEach(List::clear);
    }
}
