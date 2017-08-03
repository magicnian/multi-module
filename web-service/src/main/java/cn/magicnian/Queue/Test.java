package cn.magicnian.Queue;

import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by liunn on 2017/6/5.
 */
public class Test {

    public static void main(String[] args) {
        LinkedBlockingDeque<String> queue = new LinkedBlockingDeque<>(4);

//        while(true){
//            if(!queue.offer("134")){
//                System.out.println("队列已满,当前队列大小： "+queue.size());
//                break;
//
//            }
//        }
//
//        for (String string:queue
//             ) {
//            System.out.println(string);
//        }
        queue.offer("1");
        queue.offer("2");
        queue.offer("3");
        queue.offer("4");
        System.out.println(queue.pop());
        System.out.println(queue.size());
    }
}
