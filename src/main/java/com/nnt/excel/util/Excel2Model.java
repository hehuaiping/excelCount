package com.nnt.excel.util;

import com.nnt.excel.annotation.Column;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author soulmate
 */
public class Excel2Model {

    /**
     * 制表符匹配
     */
    public static final Pattern BLANK_PATTERN = Pattern.compile("\\*|\t|\r|\n");

    public static <T> List<T> toModel(Workbook excel, Class<T> clazz, int head) throws Exception {
        List<T> list = new ArrayList<>(8);
        // sheet表格
        Sheet sheet = excel.getSheet(0);
        // 获取所有行
        int rows = sheet.getRows();
        // 获取表头 和 对应的标题
        final Map<Integer, String> header = getHeader(sheet, head);
        for (int i = head + 1; i < rows; i++) {
            Cell[] row = sheet.getRow(i);
            // 将数据转换为model
            final T model = clazz.newInstance();
            // 遍历每一行数据设置到model中
            for (int j = 0; j < row.length; j++) {
                final Field field = getFieldByAnnotation(clazz, header.get(j));
                if(Objects.nonNull(field)) {
                    setFieldValueByCell(model, field, row[j].getContents());
                }
                // System.out.print(header.get(j) + ":");
                // System.out.print(row[j].getContents() + " ");
            }
            list.add(model);
        }
        // 根据标题和行号获取数据
        return list;
    }

    /**
     * 获取表头
     * @param sheet
     * @param head
     * @return
     */
    public static Map<Integer, String> getHeader(Sheet sheet, int head) {
        Map<Integer, String> map = new HashMap<>(8);
        // 获取表头 和 对应的标题
        final Cell[] headRow = sheet.getRow(head);
        for (int j = 0; j < headRow.length; j ++) {
            // 列索引   列名称
            map.put(j, headRow[j].getContents());
        }
        return map;
    }

    /**
     * 根据名字和注解值获取相应的字段
     * @param clazz
     * @param name
     * @return
     */
    public static Field getFieldByAnnotation(Class clazz, String name){
        final Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            // 注解
            final boolean annotationPresent = field.isAnnotationPresent(Column.class);
            if(annotationPresent) {
                final Column annotation = field.getAnnotation(Column.class);
                final String value = annotation.value();
                if(name.equalsIgnoreCase(value)) {
                    return field;
                }
            }
        }

        return null;
    }

    /**
     * 设置model字段值
     */
    public static void setFieldValueByCell(Object obj, Field field, Object value) throws Exception {
        field.setAccessible(true);
        field.set(obj, replaceBlank((String)value));
    }


    public static String replaceBlank(String str) {
        String dest = "";
        if (str!=null) {
            Matcher m = BLANK_PATTERN.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }


    private Excel2Model() {}
}
