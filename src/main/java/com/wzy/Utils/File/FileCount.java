package com.wzy.Utils.File;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Created by wzy on 2018/11/6 19:22
 **/
public final class FileCount {
    private FileCount() {
    }
    /**
     * 统计String在文件中出现的次数
     */
    public static int CountWord(File source,String word){
        int counter = 0;
        try (FileReader fr = new FileReader(source);
             BufferedReader br = new BufferedReader(fr))
        {

                String line = null;
                while ((line = br.readLine()) != null) {
                    int index = -1;
                    while (line.length() >= word.length() && (index = line.indexOf(word)) >= 0) {
                        counter++;
                        line = line.substring(index + word.length());
                    }
                }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return counter;
    } //这个方法有局限性  统计重复String只能按行 跨行的就没法处理了


    /**
     * 统计当前目录中非文件夹的文件数
     */
    public static int filesCount(String path){
        int count=0;
        File tar=new File(path);
        for(File f:tar.listFiles()){
            if(f.isFile()){
                count++;
            }

        }
        return count;
    } //当前文件夹 文件数
    /**
     * 统计目录下包括子文件夹内部的全部文件数
     */
    public static int filesCountAll(String path){
        int count=0;
        File tar=new File(path);
        for(File f:tar.listFiles()){
            if(f.isFile()){
                count++;
            }
            else{
                count=count+filesCountAll(f.getAbsolutePath());
            }

        }
        return count;
    }  //目录下包括子文件夹内部的全部文件数
}
