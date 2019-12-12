package com.duy.demo.excel;

import com.duy.demo.excel.model.ExcelSheetDataBO;
import com.duy.demo.excel.utils.ExeclUtil;
import com.ceway.common.util.ResultMsg;
import java.io.File;
import java.util.List;

/**
 * @auth duyulong
 * @Description
 * @Date 2019/11/18 16:48
 **/
public class T {
    public static void main(String[] args) {
        String path = "D:"+File.separator+"CW6478-files"+File.separator+"实验.xlsx";
        ExeclUtil execlUtil = new ExeclUtil();
        if(execlUtil.validateExcel(path)){
            File file = new File(path);
            List<ExcelSheetDataBO> sheetDataBOS = execlUtil.read(file);
            sheetDataBOS.forEach(sheet -> sheet.getSheetData().forEach(item -> System.out.println(item)));
        }
    }
}
