package com.nnt.excel.web;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.nnt.excel.databse.CheckDataList;
import com.nnt.excel.databse.CountDataList;
import com.nnt.excel.databse.PersonData;
import com.nnt.excel.model.CheckData;
import com.nnt.excel.model.CountData;
import com.nnt.excel.util.Model2Excel;
import org.springframework.boot.jackson.JsonObjectSerializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


/**
 * @author soulmate
 */
@Controller
public class ExcelFileController {

    @RequestMapping("/exportExcel")
    public void exportExcel(HttpServletRequest request, HttpServletResponse response) throws IOException {
        CountDataList.clean();
        // 遍历人员数据
        PersonData.personList.forEach(person -> {
            boolean findFlag = false;
            CountData countData = new CountData();
            countData.setId(person.getId());
            countData.setName(person.getName());
            countData.setAddr(person.getAddr());
            // 遍历检测数据
            System.out.println(CheckDataList.checkDataList.size());
            for (int i = 0; i < CheckDataList.checkDataList.size(); i++) {

                for (CheckData checkData : CheckDataList.checkDataList.get(i)) {
                    // 身份数据相同
                    if(person.getId().equals(checkData.getId())) {
                        findFlag = true;
                        countData.setPhone(checkData.getPhone());
                        // 添加到数据统计列表中
                        CountDataList.addCountData(countData, checkData.getCheckTime(), i);
                    }
                }
            }

            // 没有核酸检测数据
            if(!findFlag) {
                CountDataList.addCountData(countData, "", 0);
            }
        });
        // 生成台帐
        List<CountData> countData = CountDataList.getCountData();
        if(Objects.isNull(countData) || countData.isEmpty()) {
            return;

        }
        // 按序号排序
        Collections.sort(countData);
        // 设置附件名字
        String fileName = new String("核酸检测核对台帐.xls".getBytes(),"ISO8859-1");
        response.setContentType("application/octet-stream;charset=ISO8859-1");
        response.setHeader("Content-Disposition", "attachment;filename="+ fileName);
        response.addHeader("Pargam", "no-cache");
        response.addHeader("Cache-Control", "no-cache");
        Model2Excel.toExcel(CountData.headers, countData, "sheet1", response.getOutputStream());
    }




    @RequestMapping("/")
    public String index() {
        System.out.println("asdas");
        return "excel.html";
    }
}
