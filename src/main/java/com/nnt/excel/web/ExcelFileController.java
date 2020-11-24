package com.nnt.excel.web;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.nnt.excel.databse.CheckDataList;
import com.nnt.excel.databse.CountDataList;
import com.nnt.excel.databse.PersonData;
import com.nnt.excel.model.CheckData;
import com.nnt.excel.model.CountData;
import org.springframework.boot.jackson.JsonObjectSerializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * @author soulmate
 */
@Controller
public class ExcelFileController {

    @RequestMapping("/exportExcel")
    @ResponseBody
    public Object exportExcel() {
        // 遍历人员数据
        PersonData.personList.forEach(person -> {
            // 遍历检测数据
            for (int i = 0; i < CheckDataList.checkDataList.size(); i++) {

                for (CheckData checkData : CheckDataList.checkDataList.get(i)) {
                    // 身份数据相同
                    if(person.getId().equals(checkData.getId())) {
                        CountData countData = new CountData();
                        countData.setId(person.getId());
                        countData.setName(person.getName());
                        countData.setAddr(person.getAddr());
                        countData.setPhone(checkData.getPhone());
                        // 添加到数据统计列表中
                        CountDataList.addCountData(countData, checkData.getCheckTime(), i);
                        return;
                    }
                }
            }

        });
        // 生成台帐
        List<CountData> countData = CountDataList.getCountData();
        System.out.println(countData);
        return countData;
    }



    @RequestMapping("/")
    public String index() {
        return "excel.html";
    }
}
