package cn.magicnian.learn.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 * Created by liunn on 2017/9/26.
 */
public class Learn2 {

    public static void main(String[] args) throws ClassNotFoundException{

        /**
         * 如果在编译期知道一个类的名字的话，可以这样获取一个类的Class对象
         */
        Class PersonClass = Person.class;

        /**
         * 如果在编译期不知道类的名字，但是在运行期可以获取到类名的字符串（全称），可以这样获取Class对象
         */
        String className = "cn.magicnian.learn.reflection.Person";
        Class clazz = Class.forName(className);
        System.out.println(clazz.getFields()[0]);//getFileds()方法只能获取到public修饰的属性


        /**
         * 可以从Class对象中获取两个版本的类名
         */

        /**
         * getName()方法返回类的全限定类名
         */
        String fullName = clazz.getName();
        System.out.println(fullName);

        /**
         * getSimpleName()仅仅获取类名
         */
        String simpleName = clazz.getSimpleName();
        System.out.println(simpleName);

        /**
         * 可以通过Class对象来访问一个类的修饰符，即public,private,static等等的关键字
         * 修饰符都被包装成一个int类型的数字，这样每个修饰符都是一个位标识(flag bit)，这个位标识可以设置和清除修饰符的类型'
         * 可以使用java.lang.reflect.Modifier类中的方法来检查修饰符的类型
         *
         * Modifier.isAbstract(int modifiers);
         * Modifier.isFinal(int modifiers);
         * Modifier.isInterface(int modifiers);
         * Modifier.isNative(int modifiers);
         * Modifier.isPrivate(int modifiers);
         * Modifier.isProtected(int modifiers);
         * Modifier.isPublic(int modifiers);
         * Modifier.isStatic(int modifiers);
         * Modifier.isStrict(int modifiers);
         * Modifier.isSynchronized(int modifiers);
         * Modifier.isTransient(int modifiers);
         * Modifier.isVolatile(int modifiers);
         */
        int modifers = clazz.getModifiers();
        System.out.println(Modifier.isPublic(modifers));


        /**
         * 获取包信息
         */

        Package pack = clazz.getPackage();
        System.out.println(Arrays.toString(pack.getAnnotations()));

        /**
         * 获取父类
         */
        Class superClass = clazz.getSuperclass();
        System.out.println("superClass:"+superClass.getName());

        /**
         * 可以通过如下方式获取指定类所实现的接口集合
         * 由于一个类可以实现多个接口，因此getInterfaces();
         * 方法返回一个Class数组，在Java中接口同样有对应的Class对象
         * getInterfaces()方法仅仅只返回当前类所实现的接口。
         * 当前类的父类如果实现了接口，这些接口是不会在返回的Class集合中的，尽管实际上当前类其实已经实现了父类接口
         */

        Class[] interfaces = clazz.getInterfaces();
        System.out.println("interfaces size: "+interfaces.length);

        /**
         * 可以通过如下方式访问一个类的构造方法
         */
        Constructor[] constructors = clazz.getConstructors();
        System.out.println("constructors size: "+constructors.length);

        /**
         * 可以通过如下方式访问一个类的所有方法
         * 只有public修饰的方法才能获取
         */
        Method[] methods = clazz.getMethods();
        for (Method method:methods) {
            System.out.println("method: "+method.getName());
        }

        /**
         * 可以通过如下方式访问一个类的成员变量
         * 只有public修饰的成员变量才能获取
         */

        Field[] fields = clazz.getFields();
        for (Field field:fields) {
            System.out.println("field: "+field.getName());
        }

        /**
         * 可以通过如下方式访问一个类的注解
         */
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation:annotations){
            System.out.println("annotation: "+annotation.toString());
        }
    }
}
