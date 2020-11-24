package com.nnt.excel.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.lang.management.MonitorInfo;

/**
 * @author soulmate
 */
@Controller
public class ExcelFileController {

    @PostMapping("/exportExcel")
    @ResponseBody
    public void exportExcel() {
        // 遍历人员数据

        // 遍历检测数据

        // 生成台帐
    }

    @RequestMapping("/")
    public String index() {
        return "excel.html";
    }
}
