package com.nnt.excel.databse;

import com.nnt.excel.model.CountData;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author soulmate
 */
@Data
public class CountDataList {
    /**
     * 输出台帐统计数据
     */
    public static final List<CountData> countDataList = new ArrayList<>(2);

}
