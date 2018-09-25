package designpattern.structural.adapter;

class ClassAdaptee {
    public void operation1() {
        System.out.println("operation1");
    }
}

class ClassAdapter extends ClassAdaptee implements ClassTarget {
    @Override
    public void operation2() {
        System.out.println("operation2");
    }
}

interface ClassTarget {
    void operation1();

    void operation2();
}

public class ClassAdapterTest {
    public static void main(String[] args) {
        ClassTarget target = new ClassAdapter();
        target.operation1();
        target.operation2();
    }
}
