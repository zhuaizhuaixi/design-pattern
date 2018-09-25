package designpattern.behavioral.iterator;

import java.lang.instrument.ClassDefinition;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zzx on 2018/7/25.
 */

interface Aggregate<T> {
    Iterator<T> createIterator();

    Iterator<T> createAntiIterator();
}

class ConcreteAggregate<T> implements Aggregate<T> {
    List<T> list;

    ConcreteAggregate(List<T> list) {
        this.list = list;
    }

    @Override
    public Iterator<T> createIterator() {
        return new ConcreteIterator<T>(this);
    }

    @Override
    public Iterator<T> createAntiIterator() {
        return new ConcreteAntiIterator<T>(this);
    }
}

interface Iterator<T> {
    T next();
}

class ConcreteIterator<T> implements Iterator<T> {

    private ConcreteAggregate<T> list;

    private int index = 0;

    public ConcreteIterator(ConcreteAggregate<T> list) {
        this.list = list;
    }

    @Override
    public T next() {
        return list.list.get(index++);
    }
}

class ConcreteAntiIterator<T> implements Iterator<T> {

    private ConcreteAggregate<T> list;

    private int index;

    public ConcreteAntiIterator(ConcreteAggregate<T> list) {
        this.list = list;
        index = list.list.size();
    }

    @Override
    public T next() {
        return list.list.get(--index);
    }
}

public class Test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Aggregate<Integer> aggregate = new ConcreteAggregate<>(list);
        Iterator<Integer> integerIterator = aggregate.createIterator();
        System.out.println(integerIterator.next());
        System.out.println(integerIterator.next());
        System.out.println(integerIterator.next());
        Iterator<Integer> integerIterator1 = aggregate.createAntiIterator();
        System.out.println(integerIterator1.next());
        System.out.println(integerIterator1.next());
        System.out.println(integerIterator1.next());
    }
}
