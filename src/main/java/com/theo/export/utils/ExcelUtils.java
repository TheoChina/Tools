package com.theo.export.utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class ExcelUtils<T> {
    Class<T> clazz;
    public ExcelUtils(Class<T> clazz) {
        this.clazz = clazz;
    }

    public XSSFWorkbook exportExcel(List<T> list, String sheetName){
        XSSFWorkbook workbook = new XSSFWorkbook();
        List<Field> fieldList = new ArrayList<>();
        for(Field field:clazz.getDeclaredFields()){
            if(field.isAnnotationPresent(ExcelVOAttribute.class)){
                fieldList.add(field);
            }
        }

        Sheet sheet = workbook.createSheet(sheetName);
        //创建表头
        Row row = sheet.createRow(0);
        CellStyle style = workbook.createCellStyle();
        style.setAlignment(CellStyle.ALIGN_CENTER);
        for(int i=0;i<fieldList.size();i++){
            Cell cell = row.createCell(i);
            cell.setCellStyle(style);
            cell.setCellValue(fieldList.get(i).getAnnotation(ExcelVOAttribute.class).name());
        }
        int rowNum = 1;
        for(int k=0;k<list.size();k++){
            Row row1 = sheet.createRow(rowNum);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            for(int m=0;m<fieldList.size();m++){
                try {
                    fieldList.get(m).setAccessible(true);
                    if(fieldList.get(m).get(list.get(k)) !=null){
                        Object fieldValue = fieldList.get(m).get(list.get(k));
                        if(fieldValue instanceof Date){
                            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
                            row1.createCell(m).setCellValue(simpleDateFormat.format(fieldValue));
                        } else row1.createCell(m).setCellValue(fieldValue.toString());

                    }else {
                        row1.createCell(m).setCellValue("");
                    }

                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            rowNum++;
        }
        return workbook;
    }
}
