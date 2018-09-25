package designpattern.structural.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zzx on 2018/7/20.
 */

interface IComponent {
    void operation();

    void add(IComponent c);

    void remove(IComponent c);

    IComponent getChild(int i);
}

class Leaf implements IComponent {

    private String name;

    public Leaf(String name) {
        this.name = name;
    }

    @Override
    public void operation() {
        System.out.println("I am a Leaf " + name);
    }

    @Override
    public void add(IComponent c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(IComponent c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public IComponent getChild(int i) {
        throw new UnsupportedOperationException();
    }
}

class Component implements IComponent {

    private List<IComponent> components = new ArrayList<>();

    private String name;

    public Component(String name) {
        this.name = name;
    }

    @Override
    public void operation() {
        System.out.println("I am a component " + name);
        for (IComponent c : components) {
            c.operation();
        }
    }

    @Override
    public void add(IComponent c) {
        components.add(c);
    }

    @Override
    public void remove(IComponent c) {
        components.remove(c);
    }

    @Override
    public IComponent getChild(int i) {
        return components.get(i);
    }

}

public class Test {
    public static void main(String[] args) {
        IComponent component1 = new Component("1");
        component1.add(new Leaf("1"));
        component1.add(new Leaf("2"));
        IComponent component2 = new Component("2");
        component2.add(new Leaf("3"));
        component2.add(new Leaf("4"));
        component2.add(component1);
        component2.operation();
    }
}
