package designpattern.behavioral.mediator;

import org.w3c.dom.CDATASection;

/**
 * Created by zzx on 2018/7/27.
 */
interface Mediator {
    void operator(Colleague colleague);

}

class ConcreteMediator implements Mediator {
    private Colleague colleague1;
    private Colleague colleague2;

    public void registerColleague1(Colleague cc1) {
        colleague1 = cc1;
    }

    public void registerColleague2(Colleague cc2) {
        colleague2 = cc2;
    }

    @Override
    public void operator(Colleague colleague) {
        if (colleague instanceof ConcreteColleague1) {
            colleague2.getMessage("abc");
        } else if (colleague instanceof ConcreteColleague2) {
            colleague1.getMessage("abc");
        }
    }

}

interface Colleague {
    void contact();

    void getMessage(String message);
}

class ConcreteColleague1 implements Colleague {
    private Mediator mediator;

    public ConcreteColleague1(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void getMessage(String message) {
        System.out.println("colleague1 receive " + message);
    }

    @Override
    public void contact() {
        System.out.println("operating ConcreteColleague1");
        mediator.operator(this);
    }
}

class ConcreteColleague2 implements Colleague {
    private Mediator mediator;

    public ConcreteColleague2(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void getMessage(String message) {
        System.out.println("colleague2 receive " + message);
    }

    @Override
    public void contact() {
        System.out.println("operating ConcreteColleague2");
        mediator.operator(this);
    }
}

public class Test {
    public static void main(String[] args) {
        ConcreteMediator mediator = new ConcreteMediator();
        Colleague colleague1 = new ConcreteColleague1(mediator);
        Colleague colleague2 = new ConcreteColleague2(mediator);
        mediator.registerColleague1(colleague1);
        mediator.registerColleague2(colleague2);
        colleague1.contact();
        colleague2.contact();
    }
}
