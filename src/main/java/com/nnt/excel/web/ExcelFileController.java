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
        //
    }

    @RequestMapping("/")
    public String index() {
        return "excel.html";
    }
}
