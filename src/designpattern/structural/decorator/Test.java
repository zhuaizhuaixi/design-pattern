package designpattern.structural.decorator;

/**
 * Created by zzx on 2018/7/23.
 */
interface Component{
    void operation();
}

class ConcreteComponent implements Component {
    @Override
    public void operation() {
        System.out.println("one function");
    }
}

class Decorator implements Component {
    private Component component;

    public Decorator(Component component) {
        this.component = component;
    }
    @Override
    public void operation() {
        component.operation();
    }
}

class ConcreteDecorator extends Decorator {
    public ConcreteDecorator(Component component) {
        super(component);
    }

    public void anotherOperation() {
        System.out.println("another operation");
    }

    @Override
    public void operation() {
        super.operation();
        anotherOperation();
    }
}

public class Test {
    public static void main(String[] args) {
        ConcreteDecorator cd = new ConcreteDecorator(new ConcreteComponent());
        cd.operation();
    }
}
