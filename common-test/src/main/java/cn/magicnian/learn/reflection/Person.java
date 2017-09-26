package cn.magicnian.learn.reflection;

import javax.annotation.Resource;

/**
 * Created by liunn on 2017/9/26.
 */
@Resource
public class Person {

    public String name;

    public Integer age;

    private Double height;

    public Person(){

    }

    public Person(String name,Integer age,Double height){
        this.name = name;
        this.age = age;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name;
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
        return this.name+this.age+this.height;
    }
}
