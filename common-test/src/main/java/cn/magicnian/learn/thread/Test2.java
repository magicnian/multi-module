package cn.magicnian.learn.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by liunn on 2017/9/27.
 */
public class Test2 {

    public static void main(String[] args) {
        AtomicInteger a = new AtomicInteger(1);
        Count c1 = new Count(a);
        c1.increase();
        System.out.println(c1.getNum());

        Count c2 = new Count(a);
        c2.increase();
        System.out.println(c2.getNum());
    }
}
