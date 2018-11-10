package com.wzy.Utils.txtProcessing;

import java.io.*;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Created by wzy on 2018/11/10 12:44
 **/
public final class ADFilter {

    private ADFilter(){}


    public static void deleteAD(String path){
        File tar=new File(path);
        char cbuf[]=new char[5000]; //buffer区大小
        try{
            BufferedReader in=new BufferedReader(new FileReader(tar));
            BufferedWriter out=new BufferedWriter(new FileWriter(new File(path.replace(".","_processed."))));



            while (in.read(cbuf,0,1000)!=-1){
//                cbuf=filt(new String(cbuf)).toCharArray(); //如果(off + len) > cbuf.length 会报异常 肯定是不能动缓存区的
                out.write(filt(new String(cbuf)),0,1000);

                /**
                 * 这里是什么问题呢 缓存区是5000个字符，一次读500个字符，读到的500字符过滤后不足500，最后几位是空字符。但是写的时候还是写了500个字符
                 * 所以会导致文本中出现一段空格，怎么处理？
                 * 把write的入参改成 String即可
                 */
            }
//            StringBuffer sb=new StringBuffer();
//            for(char c:cbuf){
//                sb.append(c);
//            }
//
//            sb=new StringBuffer(filt(sb.toString()));
//            System.out.println(sb);

            in.close();
            out.close();


        }catch (Exception e){ e.printStackTrace();}


    }

    /**
     * 这个方法是用来把一段文本中的广告信息去除的 例如 棉花糖小说网 等等
     * 使用正则表达式
     * @param txt
     * @return
     */


    public static String filt(String txt){

        String a="<.*>";
//        txt=txt.replaceAll(a+".*qiushu.*"+a,"");   //这种regex拼接才是正确打开方式啊
        txt=txt.replaceAll("\\[.*棉花糖小说网.*\\]","");
        txt=txt.replaceAll("\\（.*棉花糖小说网.*\\）","");

        txt=txt.replaceAll("<strong>.*</strong>","");
        txt=txt.replaceAll("\\（.*q|Qi|Lu|Us|Sh|Hu|U.*\\）","");
        txt=txt.replaceAll("\\[.*q|Qi|Lu|Us|Sh|Hu|U.*\\]","");

        txt=txt.replaceAll("\\[.*80txt.*\\]","");
        txt=txt.replaceAll("\\（.*80txt.*\\）","");

        txt=txt.replaceAll("txt下载80txt.com","");

        txt=txt.replaceAll("(&#[\\d]+;)+(&#[\\d]+)","");


        return txt;

    }
}
