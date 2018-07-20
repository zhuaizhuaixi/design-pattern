package designpattern.structural.adapter;

/**
 * Created by zzx on 2018/7/20.
 */

interface Target {
    void operation1();

    void operation2();

    void operation3();
}

class Adaptee {
    public void operation1() {
        System.out.println("operation1");
    }

   public  void operation2() {
        System.out.println("operation2");
    }
}

class Adapter extends Adaptee implements Target {
    @Override
    public void operation3() {
        System.out.println("operation3");
    }
}

public class ClassAdapterTest {
    public static void main(String[] args) {
        Target target = new Adapter();
        target.operation1();
        target.operation2();
        target.operation3();
    }
}
