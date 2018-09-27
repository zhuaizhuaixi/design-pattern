package designpattern.behavioral.strategy;

/**
 * Created by zzx on 2018/7/27.
 */
interface Strategy {
    void execute(String str);
}

class ConcreteStrategy1 implements Strategy {
    @Override
    public void execute(String str){
        System.out.println("executing " + str + " in ConcreteStrategy1");
    }
}

class ConcreteStrategy2 implements Strategy {
    @Override
    public void execute(String str){
        System.out.println("executing " + str + " in ConcreteStrategy2");
    }
}

public class Test {
    public static void main(String[] args) {
        String str = "main";
        new ConcreteStrategy1().execute(str);
        new ConcreteStrategy2().execute(str);
    }
}
