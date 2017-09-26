package cn.magicnian.learn.reflection;

import java.lang.reflect.Field;

/**
 * Created by liunn on 2017/9/26.
 */
public class Learn4 {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        /**
         * 返回的Field对象数组包含了指定类中声明为公有的(public)的所有变量集合
         */
        Field[] fields = Person.class.getFields();

        /**
         * 如果你知道你要访问的变量名称，你可以通过如下的方式获取指定的变量
         * 在调用getField()方法时，如果根据给定的方法参数没有找到对应的变量，那么就会抛出NoSuchFieldException
         */
        Field field = Person.class.getField("age");

        /**
         * 一旦你获取了Field实例，你可以通过调用Field.getName()方法获取他的变量名称
         */
        for (Field f : fields) {
            System.out.println(f.getName());
        }

        /**
         * 可以通过调用Field.getType()方法来获取一个变量的类型（如String, int等等）
         */
        Class fieldType = field.getType();
        System.out.println(fieldType.getName());

        /**
         * 一旦你获得了一个Field的引用，你就可以通过调用Field.get()或Field.set()方法，获取或者设置变量的值
         */
        Person p = new Person();
        p.setAge(12);

        Object value = field.get(p);
        field.set(p,value);
    }
}
