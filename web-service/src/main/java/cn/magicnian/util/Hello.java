package cn.magicnian.util;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by liunn on 2017/8/18.
 */
public class Hello {

    public static void main(String[] args) {

//        String num = "440-";
//
//        System.out.println(num.matches("^\\d+$"));

        List<String> testList = new ArrayList<>();
        testList.add("a");
        testList.add("b");
        testList.add("c");
        Function<String,String> function = s -> s.toUpperCase();

        List<String> outList = testList.stream().map(function).collect(Collectors.toList());

        outList.forEach(System.out::println);


        ActionListener l = (ActionEvent e) -> System.out.println(e.getModifiers());
    }


    public Runnable toDoLater() {
        return () -> {
            System.out.println("later");
        };
    }
}
