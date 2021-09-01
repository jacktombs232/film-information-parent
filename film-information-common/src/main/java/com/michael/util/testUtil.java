package com.michael.util;

import com.michael.pojo.Student;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;

import java.beans.PropertyDescriptor;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

public class testUtil {
    public static XSSFWorkbook export(List<?> list){
        XSSFWorkbook workbook = new XSSFWorkbook();
        try {


            XSSFSheet sheet = workbook.createSheet("信息表");


            CellRangeAddress region = new CellRangeAddress(0, 0, 0, 3);
            sheet.addMergedRegion(region);

            XSSFCellStyle style = workbook.createCellStyle();

            SetBorder(style);

            XSSFRow row1 = sheet.createRow(0);
            XSSFCell cell = row1.createCell(0);
            //设置值，这里合并单元格后相当于标题
            cell.setCellValue("人员信息表");
            //将样式添加生效
            cell.setCellStyle(style);

            XSSFRow firstRow = sheet.createRow(1);//第一行表头
            XSSFCell cells[] = new XSSFCell[3];

            Class claz = list.get(0).getClass();
            //获得所有的属性
            Field[] fieldss = claz.getDeclaredFields();
            String[] titles = new String[fieldss.length];
            for (int i = 0;i<fieldss.length;i++){
                titles[i]=fieldss[i].getName();
            }

            //循环设置表头信息
            for (int i=0;i<titles.length;i++){
                cells[0]=firstRow.createCell(i);
                cells[0].setCellValue(titles[i]);
                cells[0].setCellStyle(style);
            }

            //遍历list,将数据写入Excel中
            for (int i=1;i<list.size()+1;i++){
                //行
                XSSFRow row = sheet.createRow(i + 1);

                Class clazz = list.get(i-1).getClass();
                //获得所有的属性
                Field[] fields = clazz.getDeclaredFields();

                //对列赋值
                for (int j = 0; j < fields.length; j++) {
                    cell=row.createCell(j);
                    PropertyDescriptor pd = new PropertyDescriptor(fields[j].getName(), clazz);
                    Method method = pd.getReadMethod();
                    cell.setCellValue(String.valueOf(method.invoke(list.get(i-1))));
                    cell.setCellStyle(style);
                }
            }

        } catch (Exception e){
            e.printStackTrace();
        }
        return workbook;
    }


    public static void SetBorder( XSSFCellStyle cellStyle){
        cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN); //下边框
        cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框
        cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框
        cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框

        //水平居中
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        //垂直居中
        cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
    }

}
