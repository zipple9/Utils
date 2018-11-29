package com.wzy.Utils.codeTransformation;

/**
 * Created by wzy on 2018/11/29 14:58
 **/
public final class GBKtoUTF8 {
    public static String trans(String tar){

        try{
            String iso8859 = new String(tar.toString().getBytes("iso8859-1"));
            String gbk = new String(tar.toString().getBytes("gbk"));
            String utf8 = new String(tar.toString().getBytes("utf-8"));
            if(iso8859.equals(tar.toString())){
                System.out.println("iso8859");
            }else  if(gbk.equals(tar.toString())){
                System.out.println("gbk");
            }else  if(utf8.equals(tar.toString())){
                System.out.println("utf8");
            }

        }catch (Exception e){e.printStackTrace();}

        return tar;

    }
}
