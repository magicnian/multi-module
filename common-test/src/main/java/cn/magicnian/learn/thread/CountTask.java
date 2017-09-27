package cn.magicnian.learn.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by liunn on 2017/9/27.
 */
public class CountTask extends Thread {


    /**
     * AtomicInteger是引用类型
     * 每new一个新的CountTask对象都会
     * 在栈上分配内存，栈上存储的是“引用”
     * 指向的是堆中的实例对象
     * CountTask的构造方法其实就是将这个新的
     * 引用指向同一个堆中的对象
     */
    private AtomicInteger count;

    /**
     * int是基本数据类型，每new一个新的CountTask对象都会在栈上新开辟一块内存
     * Integer虽然是引用类型，但是源码中存放int值的变量是final修饰的，所以每次
     * new一个CountTask对象也会新创建一个Integer对象
     * 所以这里用int和Integer效果是一样的
     */
    private int count1;

    public CountTask(AtomicInteger count,int count1){
        this.count = count;
        this.count1 = count1;
    }

    @Override
    public void run(){
        count.addAndGet(2);
        System.out.println("count=====:"+count);
        count1 = count1+1;
        System.out.println("count1====:"+count1);
    }

    public AtomicInteger getCount(){
        return this.count;
    }

    public Integer getCount1(){
        return this.count1;
    }
}
