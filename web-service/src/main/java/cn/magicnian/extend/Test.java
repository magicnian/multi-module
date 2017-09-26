package cn.magicnian.extend;

/**
 * Created by liunn on 2017/9/8.
 */
public class Test {

    public static void main(String[] args) {
        Fish fish = new Fish();
        fish.setTail("tail");
        fish.setType("1");
        Animal animal = (Animal)fish;

        if(animal instanceof Fish){
            System.out.println(((Fish) animal).getTail());
        }
    }
}
