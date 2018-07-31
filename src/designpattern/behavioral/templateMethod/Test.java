package designpattern.behavioral.templateMethod;

/**
 * Created by zzx on 2018/7/31.
 */

abstract class AbstractClass {
    public void templateMethod() {
        System.out.println("this is a template method");
        this.subMethod();
    }

    public abstract void subMethod();
}

class ConcreteClass extends AbstractClass {
    @Override
    public void subMethod() {
        System.out.println("this is a sub method");
    }
}

public class Test {
    public static void main(String[] args) {
        AbstractClass myClass = new ConcreteClass();
        myClass.templateMethod();
    }
}
