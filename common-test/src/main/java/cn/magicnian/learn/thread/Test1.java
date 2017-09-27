package cn.magicnian.learn.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * AtomicInteger和Integer两者的比较
 * 前者是线程安全的，后者是不安全的
 * Created by liunn on 2017/9/27.
 */
public class Test1 {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(4);

        AtomicInteger count = new AtomicInteger(0);
        int count1 = 0;
        for (int i=0;i<1000;i++){
            executor.submit(new CountTask(count,count1));
        }


        executor.shutdown();

    }
}
