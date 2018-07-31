package designpattern.structural.flyweight;

import java.util.HashMap;

/**
 * Created by zzx on 2018/7/24.
 */
class FlyweightFactory {
    private static HashMap<Integer, Flyweight> flyweights = new HashMap<>();

    public static Flyweight getFlyweight(int key) {
        Flyweight flyweight = flyweights.get(key);
        if (flyweight == null) {
            if (key == 1) {
                flyweight = new ConcreteFlyweight();
            }
            flyweights.put(key, flyweight);
        }
        return flyweight;
    }
}

interface Flyweight{
    void operation(int extrinsicState);

    void display();
}

class ConcreteFlyweight implements Flyweight{

    private int intrinsicState;

    private int extrinsicState;

    public ConcreteFlyweight() {
        intrinsicState = 1;
        extrinsicState = 1;
    }

    @Override
    public void operation(int extrinsicState) {
        this.extrinsicState = extrinsicState;
    }

    @Override
    public void display() {
        System.out.println("intrinsicState: " + intrinsicState);
        System.out.println("extrinsicState: " + extrinsicState);
    }
}


public class Test {
    public static void main(String[] args) {
        Flyweight flyweight = FlyweightFactory.getFlyweight(1);
        flyweight.display();
        flyweight.operation(123);
        flyweight.display();
    }
}
