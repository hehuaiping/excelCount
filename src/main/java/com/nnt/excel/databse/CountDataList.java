package com.nnt.excel.databse;

import com.nnt.excel.model.CountData;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author soulmate
 */
@Data
public class CountDataList {
    /**
     * 输出台帐统计数据
     */
    private static final List<CountData> countDataList = new ArrayList<>(2);

    private static final Map<String, CountData> countDataMap = new HashMap<>(8);

    public static void addCountData(CountData countData, String checkTime, int item) {
        // 如果包含当前检测人数据
        if(countDataMap.containsKey(countData.getId())) {
            setCheckTime(countDataMap.get(countData.getId()), checkTime, item);
        }else {
            // 没有当前检测人数据
            setCheckTime(countData, checkTime, item);
        }
        // 放入到Map中
        countDataMap.put(countData.getId(), countData);
    }

    private static void setCheckTime(CountData countData, String checkTime, int item) {
        switch (item){
            case 0 : {
                countData.setCheckOne(checkTime);
                break;
            }
            case 1 : {
                countData.setCheckTwo(checkTime);
                break;
            }
            case 2 : {
                countData.setCheckThree(checkTime);
                break;
            }
            case 3 : {
                countData.setCheckFour(checkTime);
                break;
            }
            default: {
                break;
            }
        }
    }

    /**
     * 获取统计列表
     */
    public static List<CountData> getCountData() {
        countDataMap.forEach((id, dataObject) -> {
            countDataList.add(dataObject);
        });
        return countDataList;
    }
}
