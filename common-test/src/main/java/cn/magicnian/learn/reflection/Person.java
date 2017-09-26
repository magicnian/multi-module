package cn.magicnian.learn.reflection;

import javax.annotation.Resource;

/**
 * Created by liunn on 2017/9/26.
 */
@Resource
public class Person {

    public String Name;

    private Integer age;

    private Double height;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }


    private String param(){
        return this.Name+this.age+this.height;
    }
}
