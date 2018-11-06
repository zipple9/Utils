package com.wzy.Utils;

import com.wzy.Utils.File.FileCopy;
import com.wzy.Utils.File.FileCount;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by wzy on 2018/11/6 17:48
 **/
public class tset {


    public static void main(String []args) throws IOException {

//        for (int i = 0; i <1 ; i++) {
//            try {
////                FileCopy.copyFileUsingFileStreams(("F:/fitness log.xlsx"));
//                FileCopy.fileCopyNIO("F:/fitness log.xlsx");
//
//            }catch (Exception e){}
//
//        }

        int a=FileCount.filesCountAll("F:\\迅雷下载\\DEEP_Win7x64_CJB");
        System.out.println(a);
        System.out.println(FileCount.filesCount("F:/迅雷下载"));



    }
}
