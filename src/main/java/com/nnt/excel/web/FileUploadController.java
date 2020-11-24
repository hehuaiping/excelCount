package com.nnt.excel.web;

import com.nnt.excel.databse.CheckDataList;
import com.nnt.excel.databse.PersonData;
import com.nnt.excel.model.CheckData;
import com.nnt.excel.model.CountData;
import com.nnt.excel.model.Person;
import com.nnt.excel.util.Excel2Model;
import jxl.Workbook;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author soulmate
 */
@RestController
@RequestMapping("/upload")
public class FileUploadController {
    private static Integer CHECK_DATA_ITEM = 0;

    @PostMapping("/userData")
    public String userData(@RequestParam("file")MultipartFile file) throws Exception {
        // 清空list
        PersonData.personList.clear();
        Workbook excel = null;
        excel = Workbook.getWorkbook(file.getInputStream());
        // 人员数据
        final List<Person> list = Excel2Model.toModel(excel, Person.class, 0);
        PersonData.personList.addAll(list);
        System.out.println(list);
        return "";
    }

    @PostMapping("/checkData")
    public String checkData(@RequestParam("file")MultipartFile file) throws Exception {
        if(CHECK_DATA_ITEM == 4) {
            return "";
        }
        Workbook excel = null;
        excel = Workbook.getWorkbook(file.getInputStream());
        // 检测数据
        final List<CheckData> list = Excel2Model.toModel(excel, CheckData.class, 1);
        CheckDataList.checkDataList.get(CHECK_DATA_ITEM).addAll(list);
        System.out.println(list);
        CHECK_DATA_ITEM ++;
        return "";
    }
}
