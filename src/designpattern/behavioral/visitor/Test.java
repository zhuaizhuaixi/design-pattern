package designpattern.behavioral.visitor;

/**
 * Created by zzx on 2018/7/26.
 */

interface Visitor {
    void visitElementA(ConcreteElementA cea);

    void visitElementB(ConcreteElementB ceb);
}

class ConcreteVisitor implements Visitor {
    @Override
    public void visitElementA(ConcreteElementA cea) {
        System.out.println("visiting element A");
    }

    @Override
    public void visitElementB(ConcreteElementB cea) {
        System.out.println("visiting element B");
    }
}

interface Element {
    void accept(Visitor v);
}

class ConcreteElementA implements Element {
    @Override
    public void accept(Visitor v) {
        v.visitElementA(this);
    }
}

class ConcreteElementB implements Element {
    @Override
    public void accept(Visitor v) {
        v.visitElementB(this);
    }
}

public class Test {
    public static void main(String[] args) {
        Visitor visitor = new ConcreteVisitor();
        new ConcreteElementA().accept(visitor);
        new ConcreteElementB().accept(visitor);
    }
}
