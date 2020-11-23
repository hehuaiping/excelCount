package com.nnt.excel.web;

import com.nnt.excel.databse.PersonData;
import com.nnt.excel.util.Excel2Model;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author soulmate
 */
@RestController
@RequestMapping("/upload")
public class FileUploadController {
    @PostMapping("/userData")
    public String userData(@RequestParam("file")MultipartFile file) throws Exception {
        Workbook excel = null;
        excel = Workbook.getWorkbook(file.getInputStream());
        Excel2Model.toModel(excel, PersonData.class, 0);
        return "";
    }
}
