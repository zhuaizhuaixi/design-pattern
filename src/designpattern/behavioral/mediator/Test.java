package designpattern.behavioral.mediator;

import org.w3c.dom.CDATASection;

/**
 * Created by zzx on 2018/7/27.
 */
class Mediator {

}

class ConcreteMediator extends Mediator {
    private Colleague colleague1;
    private Colleague colleague2;

    public void registerColleague1(Colleague cc1) {
        colleague1 = cc1;
    }

    public void registerColleague2(Colleague cc2) {
        colleague2 = cc2;
    }

    public void callColleague1() {
        colleague1.operation();
    }

    public void callColleague2() {
        colleague2.operation();
    }
}

interface Colleague {
    void operation();
}

class ConcreteColleague1 implements Colleague {
    @Override
    public void operation(){
        System.out.println("operating ConcreteColleague1");
    }
}

class ConcreteColleague2 implements Colleague {
    @Override
    public void operation(){
        System.out.println("operating ConcreteColleague2");
    }
}

public class Test {
    public static void main(String[] args) {
        ConcreteMediator concreteMediator = new ConcreteMediator();
        Colleague colleague1 = new ConcreteColleague1();
        Colleague colleague2 = new ConcreteColleague2();
        concreteMediator.registerColleague1(colleague1);
        concreteMediator.registerColleague2(colleague2);
        concreteMediator.callColleague1();
        concreteMediator.callColleague2();
    }
}
