package cn.magicnian.learn.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by liunn on 2017/9/27.
 */
public class Count {

    private AtomicInteger num;

    public Count(AtomicInteger num){
        this.num = num;
    }

    public AtomicInteger getNum() {
        return num;
    }

    public void setNum(AtomicInteger num) {
        this.num = num;
    }

    public void increase(){
        num.addAndGet(2);
    }
}
