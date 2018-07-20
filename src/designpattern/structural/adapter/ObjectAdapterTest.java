package designpattern.structural.adapter;

/**
 * Created by zzx on 2018/7/20.
 */

interface ObjTarget {
    void operation1();

    void operation2();

    void operation3();
}

class ObjAdapter implements ObjTarget{

    private ObjAdaptee adaptee = new ObjAdaptee();

    @Override
    public  void operation1() {
        adaptee.operation1();
    }
    @Override
    public  void operation2() {
        adaptee.operation2();
    }

    @Override
    public  void operation3() {
        System.out.println("operation3");
    }

}

class ObjAdaptee {
    public void operation1() {
        System.out.println("operation1");
    }

    public  void operation2() {
        System.out.println("operation2");
    }
}

public class ObjectAdapterTest {
    public static void main(String[] args) {
        ObjTarget target = new ObjAdapter();
        target.operation1();
        target.operation2();
        target.operation3();
    }
}
