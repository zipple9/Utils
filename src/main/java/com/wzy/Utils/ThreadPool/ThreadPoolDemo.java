package com.wzy.Utils.ThreadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author wzy
 * @Date 2019/9/2
 */
public class ThreadPoolDemo {





    public static void main(String args[]){

        Vector resource=new Vector();

        Callable producer=new Callable() {
            @Override
            public Object call() throws Exception {
                List result=new ArrayList();
                int count=new Random().nextInt(10);
                for (int i = 0; i <count ; i++) {
                    result.add(new Object());
                }
                resource.add(result);
                System.out.println(Thread.currentThread().getName()+"----------"+count);
                System.out.println("resource-----"+resource.size());
                return result;
            }
        };


        Callable consumer=new Callable() {
            @Override
            public Object call() throws Exception {
                return null;
            }
        };


        //创建一个fixed线程池
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);

        //向线程池提交任务
        for (int i = 0; i <5 ; i++) {
            fixedThreadPool.submit(producer);
        }


    }
}
