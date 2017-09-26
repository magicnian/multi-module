package cn.magicnian.learn.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by liunn on 2017/9/26.
 */
public class Learn5 {

    public static void main(String[] args) throws NoSuchMethodException, ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        /**
         * 可以通过Class对象获取Method对象
         * 返回的Method对象数组包含了指定类中声明为公有的(public)的所有方法集合
         */
        Method[] methods = Person.class.getMethods();

        /**
         * 获取class对象的所有声明方法（public和非public方法）,不包含父类方法
         */
        Method[] methods1 = Person.class.getDeclaredMethods();
        for (Method method:methods1){
            System.out.println(method.getName());
        }


        /**
         * 如果你知道你要调用方法的具体参数类型，你就可以直接通过参数类型来获取指定的方法
         * 同样也是必须是public修饰的方法才能获取到
         * 如果根据给定的方法名称以及参数类型无法匹配到相应的方法，则会抛出NoSuchMethodException
         * 如果你想要获取的方法没有参数，那么在调用getMethod()方法时第二个参数传入null即可
         */
        Method method = Person.class.getMethod("getName");


        /**
         * 可以获取指定方法的方法参数是哪些
         */
        Method method1 = Person.class.getMethod("setAge", Integer.class);
        Class[] parameterTypes = method1.getParameterTypes();

        /**
         * 可以获取指定方法的返回类型
         */
        Class returnType = method.getReturnType();
        System.out.println(returnType.getName());


        /**
         * 可以通过如下方式来调用一个方法
         * 这样做发现整个Learn5类没有对Person类有任何编译期的依赖
         * 也就是说在加载Learn5并初始化Learn5类时不需要关心类Person是否存在
         * 而是等到main()方法执行到调用Class.forName()时才试图对类Person做动态加载
         *
         */
        Class pClass = Class.forName("cn.magicnian.learn.reflection.Person");
        Object o = pClass.newInstance();
        method.invoke(o,null);

    }
}
