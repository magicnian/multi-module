package cn.magicnian.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by liunn on 2017/9/24.
 */
public class Test {

    public static void main(String[] args) throws Exception{
        Set<String> set = new HashSet<>();
        FileReader f = new FileReader("e:\\test.txt");
        BufferedReader bf = new BufferedReader(f);
        String line="";
        while((line=bf.readLine())!=null){
            set.add(line);
        }

        System.out.println(set.size());
    }
}
