package designpattern.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zzx on 2018/8/1.
 */

interface Subject {
    void attach(Observer o);

    void detach(Observer o);

    void notify1();
}

class ConcreteSubject implements Subject {
    private List<Observer> list = new ArrayList<>();

    @Override
    public void attach(Observer observer) {
        list.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        list.remove(observer);
    }

    @Override
    public void notify1() {
        for (Observer observer : list) {
            observer.update();
        }
    }
}

interface Observer {
    void update();
}

class ConcreteObserver implements Observer {
    private String observerState;

    public ConcreteObserver(String observerState) {
        this.observerState = observerState;
    }

    @Override
    public void update() {
        System.out.println(observerState + " updated to 777");
        observerState = "777";
    }
}

public class Test {
    public static void main(String[] args) {
        Observer observer1 = new ConcreteObserver("observer 1");
        Observer observer2 = new ConcreteObserver("observer 2");
        Observer observer3 = new ConcreteObserver("observer 3");
        Subject subject = new ConcreteSubject();
        subject.attach(observer1);
        subject.attach(observer2);
        subject.attach(observer3);
        subject.detach(observer2);
        subject.notify1();
    }
}
