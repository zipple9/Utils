package com.wzy.Utils.DATE;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @Author wzy
 * @Date 2019/6/27
 */
public class dateDemo {


    /**
     * jdk1.8 自带了一个java.time包 对原有的Date和Candidate日期包进行了优化
     * 不像之前烦的要命，这个可以用一用了
     *
     */


    public static void main(String args[]){

        LocalTime time=LocalTime.now();
        LocalDate date=LocalDate.now();
        LocalDateTime dateTime=LocalDateTime.now();


        System.out.println(time);
        System.out.println(date);
        System.out.println(dateTime);

        LocalDate tomorrow = LocalDate.now().plusDays(1);
        System.out.println(tomorrow);

    }
}
