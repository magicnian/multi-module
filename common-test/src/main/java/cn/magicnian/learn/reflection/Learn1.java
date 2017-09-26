package cn.magicnian.learn.reflection;

import java.lang.reflect.Method;

/**
 * Created by liunn on 2017/9/26.
 */
public class Learn1 {

    public static void main(String[] args) {
        /**
         * 通过调用Person类的class属性获取对应的Class类对象
         * 通过这个Class类的对象获取Person类中的方法集合
         * 迭代这个方法集合并且打印每个方法的名字
         */
        Method[] methods = Person.class.getMethods();
        for (Method method : methods) {
            System.out.println("method = " + method.getName());
        }
    }
}
