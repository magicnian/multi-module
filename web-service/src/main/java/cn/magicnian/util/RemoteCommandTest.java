package cn.magicnian.util;

import java.util.UUID;

/**
 * Created by liunn on 2017/8/17.
 */
public class RemoteCommandTest {
    public static void main(String[] args) {
//        RemoteExecuteCommand rec = new RemoteExecuteCommand("49.74.216.165",20087,"root","root123");
//        System.out.println(rec.exec("LC_ALL=C ifconfig  | grep -E 'inet.[0-9]' | grep -v '127.0.0.1' | grep -v '192*' | awk '{ print $2}'"));
        System.out.println(UUID.randomUUID().toString());
    }
}
