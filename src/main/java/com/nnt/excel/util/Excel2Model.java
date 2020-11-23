package com.nnt.excel.util;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author soulmate
 */
public class Excel2Model {
    public static <T> List<T> toModel(Workbook excel, Class<T> clazz, int head) {
        List<T> list = new ArrayList<>(8);
        Sheet sheet = excel.getSheet(0);
        int rows = sheet.getRows();
        for (int i = 0; i < rows; i++) {
            Cell[] row = sheet.getRow(i);
            for (int j = 0; j < row.length; j++) {
                System.out.print(row[j].getContents());
                //System.out.print(row[j].getColumn());
            }
            System.out.println();
        }
        // 根据标题和行号获取数据
        return list;
    }

    private Excel2Model() {}
}
