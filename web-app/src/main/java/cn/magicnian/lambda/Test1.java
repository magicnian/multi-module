package cn.magicnian.lambda;

import cn.magicnian.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liunn on 2017/7/4.
 */
public class Test1
{

    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        userList.add(new User("Tom", 20, 1));
        userList.add(new User("Marry", 21, 2));
        userList.add(new User("Jack", 18, 1));
        userList.add(new User("Lith", 19, 2));
        userList.add(new User("Jerry", 20, 1));

        userList.forEach(user -> System.out.println(user.getAge()));
        userList.forEach(Test1::getAge);
        ArrayList<User> newlist = userList.stream()
                .filter(user -> user.getAge() == 20)
                .collect(ArrayList::new,ArrayList::add,ArrayList::addAll);
        System.out.println("======================>");
        newlist.forEach(Test1::getAge);

    }

    public static void getAge(User user) {
        System.out.println(user.getAge());
    }
}
