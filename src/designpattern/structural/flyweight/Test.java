package designpattern.structural.flyweight;

import java.util.HashMap;

/**
 * Created by zzx on 2018/7/24.
 */
class FlyweightFactory {
    private static HashMap<Integer, Flyweight> flyweights = new HashMap<>();

    static Flyweight getFlyweight(int key) {
        Flyweight flyweight = flyweights.get(key);
        if (flyweight == null) {
            flyweight = new ConcreteFlyweight();
            flyweights.put(key, flyweight);
        }
        return flyweight;
    }
}

interface Flyweight {
    /**
     * 对对象外蕴状态进行赋值操作
     *
     * @param extrinsicState 外蕴状态
     */
    void operation(int extrinsicState);

    /**
     * 显示对象内部信息
     */
    void display();
}

class ConcreteFlyweight implements Flyweight {

    private int intrinsicState;

    private int extrinsicState;

    ConcreteFlyweight() {
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

/**
 * @author zzx
 */
public class Test {
    public static void main(String[] args) {
        Flyweight flyweight = FlyweightFactory.getFlyweight(1);
        flyweight.display();
        flyweight.operation(123);
        flyweight.display();
        Flyweight flyweight1 = FlyweightFactory.getFlyweight(1);
        flyweight1.display();
        Flyweight flyweight2 = FlyweightFactory.getFlyweight(2);
        flyweight2.display();
        System.out.println(flyweight == flyweight1);
    }
}
