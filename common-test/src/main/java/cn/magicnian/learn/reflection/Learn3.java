package cn.magicnian.learn.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by liunn on 2017/9/26.
 */
public class Learn3 {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class clazz = Person.class;
        /**
         * 返回的Constructor数组包含每一个声明为公有的（Public）构造方法
         */
        Constructor[] constructors = clazz.getConstructors();

        /**
         * 如果你知道你要访问的构造方法的方法参数类型，
         * 你可以用下面的方法获取指定的构造方法
         * 如果没有指定的构造方法能满足匹配的方法参数则会抛出：NoSuchMethodException
         */

        Constructor constructor = clazz.getConstructor(String.class, Integer.class, Double.class);

        /**
         * 可以通过如下方式获取指定构造方法的方法参数信息
         */
        Class[] parameterTypes = constructor.getParameterTypes();
        for (Class cz : parameterTypes) {
            System.out.println(cz.getName());
        }


        /**
         * 可以通过如下方法实例化一个类
         */

        Person person = (Person) constructor.newInstance("Tom", 24, 175.4);
    }
}
