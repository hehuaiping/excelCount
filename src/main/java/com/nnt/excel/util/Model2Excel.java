package com.nnt.excel.util;

import com.nnt.excel.annotation.Column;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 *
 * 模型转换为Excel
 * @author soulmate
 */
public class Model2Excel {
    public static <T> void toExcel(String[] header, List<T> list, String sheetName, OutputStream outputStream)  {
        WritableWorkbook workbook = null;
        try {
            // 当前行号
            int rowNum = 0;
            // 工作簿
            workbook = Workbook.createWorkbook(outputStream);
            // sheet表
            final WritableSheet sheet = workbook.createSheet(sheetName, 0);
            //  标题
            for (int i = 0; i < header.length; i ++ ) {
                sheet.addCell(new Label(i, 0, header[i]));
            }
            rowNum ++;
            final Map<String, Integer> headerMap = getHeaderMap(header);
            // 内容
            for (T t : list) {
                setCellValue(rowNum, sheet, headerMap, t);
                rowNum ++;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                // 写出数据
                workbook.write();
                workbook.close();
                outputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                workbook = null;
                outputStream = null;
            }
        }
    }

    private static Map<String, Integer> getHeaderMap(String[] header) {
        Map<String, Integer> map = new HashMap<>(header.length);
        for (int i = 0; i < header.length; i ++ ) {
            map.put(header[i], i);
        }
        return map;
    }


    private static <T> void setCellValue(int startRowNum, WritableSheet sheet, Map<String, Integer> headerMap, T t) throws Exception {
        final Field[] fields = t.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            if(fields[i].isAnnotationPresent(Column.class)) {
                final Column column = fields[i].getAnnotation(Column.class);
                // 字段对应索引位置
                final Integer integer = headerMap.get(column.value());
                // 设置为可访问
                fields[i].setAccessible(true);
                // 获取字段值
                Object value = fields[i].get(t);
                if(Objects.nonNull(value)) {
                    sheet.addCell(new Label(integer, startRowNum, value.toString()));
                }
            }
        }
    }

    private Model2Excel() {

    }
}
