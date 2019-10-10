package com.duy.demo.others;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 * @auth duyulong
 * @Description
 * @Date 2019/9/9 15:17
 **/
public class T{
    public static void main(String[] args) throws IOException {
//        ExecutorService executor = Executors.newSingleThreadExecutor();
//        for (int i = 0; i < 10; i++) {
//            executor.execute(() -> {
//                System.out.println(Thread.currentThread().getName() + " Start. Time = " + new Date());
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(Thread.currentThread().getName() + " End. Time = " + new Date());
//            });
//        }
//        //终止线程池
//        executor.shutdown();
//        while (!executor.isTerminated()) {
//        }
//        System.out.println("Finished all threads");

        ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(1,
                new BasicThreadFactory.Builder().namingPattern("example-schedule-pool-%d").daemon(true).build());
        for (int i = 0; i < 5; i++) {
            executorService.execute(() -> {
                System.out.println(Thread.currentThread().getName() + " Start. Time = " + new Date());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " End. Time = " + new Date());
            });

        }
    }
}
