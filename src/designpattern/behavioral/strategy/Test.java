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
        System.out.println("executing " + str + "in ConcreteStrategy1");
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
        Strategy strategy1 = new ConcreteStrategy1();
        Strategy strategy2 = new ConcreteStrategy2();
        strategy1.execute(str);
        strategy2.execute(str);
    }
}
