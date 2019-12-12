package com.duy.demo.others;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @auth duyulong
 * @description
 * @Date 2019/9/9 15:17
 **/
public class T{
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream("D:"+File.separator+"CW6478-files"+File.separator+"资料.txt");
        FileOutputStream outputStream = new FileOutputStream("D:"+File.separator+"CW6478-files"+File.separator+"资料1.txt");
        byte[] bytes = new byte[256];
        int len;
        while ((len=inputStream.read(bytes))!=-1){
            outputStream.write(bytes);
            bytes = new byte[256];
        }
        inputStream.close();
        outputStream.close();
    }
}
