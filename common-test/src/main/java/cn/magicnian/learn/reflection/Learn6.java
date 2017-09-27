package cn.magicnian.learn.reflection;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by liunn on 2017/9/27.
 */
public class Learn6 {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, ClassNotFoundException, InstantiationException, NoSuchMethodException, InvocationTargetException {

//        PrivateObject privateObject = new PrivateObject("This is private value");
//
//        Field field = PrivateObject.class.getDeclaredField("privateString");
//        field.setAccessible(true);
//
//        String fieldValue = (String) field.get(privateObject);
//
//        System.out.println("privateString is "+fieldValue);


        Class clazz = ClassLoader.getSystemClassLoader().loadClass("cn.magicnian.learn.reflection.PrivateObject");
        PrivateObject o = (PrivateObject)clazz.getDeclaredConstructor(String.class).newInstance("new value");

    }
}
