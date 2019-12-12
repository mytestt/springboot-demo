package com.duy.demo.excel.utils;

import com.duy.demo.excel.model.ExcelSheetDataBO;
import com.google.common.collect.Lists;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @auth duyulong
 * @Description
 * @Date 2019/11/18 16:00
 **/
public class ExeclUtil {
    /**
     * 1. 检验文件是否为Excel格式以及是Excel哪个版本
     * @param fileName
     * @return
     */
    public boolean validateExcel(String fileName){
        if(fileName.matches("^.+\\.(?i)(xls)$")||fileName.matches("^.+\\.(?i)(xlsx)$")){
            return true;
        }else{
            return false;
        }
    }
    public String validateType(String fileName){
        if(fileName.matches("^.+\\.(?i)(xls)$")){
            return "2003";
        }else if(fileName.matches("^.+\\.(?i)(xlsx)$")){
            return "2007";
        }else {
            return null;
        }
    }

    /**
     * 2. 根据文件读取Excel文件
     * @param file
     * @return
     */
    public List<ExcelSheetDataBO> read(File file){
        InputStream inputStream = null;
        String excelType = null;
        try {
            excelType = validateType(file.getName());
            inputStream = new FileInputStream(file);
            return read(inputStream,excelType);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(inputStream!=null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
    /**
     * 3. 根据流读取Excel文件
     */
    public List<ExcelSheetDataBO> read(InputStream inputStream,String excelType){
        Workbook workbook;
        try {
            if("2003".equals(excelType)){
                workbook = new HSSFWorkbook(inputStream);
            }else{
                workbook = new XSSFWorkbook(inputStream);
            }
            FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
            return read(workbook);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 最终读取Excel文件的方法
     * @Param workbook
     */
    public  List<ExcelSheetDataBO> read(Workbook workbook){
        List<ExcelSheetDataBO> sheetDataBOS = Lists.newArrayList();
        int sheetNum = workbook.getNumberOfSheets();
        Sheet sheet = null;
        for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
            List<List<String>> sheetData = Lists.newArrayList();
            ExcelSheetDataBO bo = new ExcelSheetDataBO();
            sheet = workbook.getSheetAt(i);
            bo.setSheetName(sheet.getSheetName());
            int rowCount = sheet.getPhysicalNumberOfRows();
            for (int j = 0; j < rowCount; j++) {
                Row row = sheet.getRow(j);
                List<String> cells = Lists.newArrayList();
                int cellCount = row.getPhysicalNumberOfCells();
                for (int k = 0; k < cellCount; k++) {
                    Cell cell = row.getCell(k);
                    String cellValue = "";
                    switch (cell.getCellType()){
                        case Cell.CELL_TYPE_STRING:
                            cellValue = cell.getStringCellValue();
                            break;
                        case Cell.CELL_TYPE_BOOLEAN:
                            cellValue = cell.getBooleanCellValue()+"";
                            break;
                        case Cell.CELL_TYPE_NUMERIC:
                            cellValue = cell.getNumericCellValue()+"";
                            break;
                        case Cell.CELL_TYPE_BLANK:
                            cellValue = "";
                            break;
                        default:
                            cellValue = "未知类型";
                            break;
                    }
                    cells.add(cellValue);
                }
                sheetData.add(cells);
            }
            bo.setSheetData(sheetData);
            sheetDataBOS.add(bo);
        }
        return sheetDataBOS;
    }

}
