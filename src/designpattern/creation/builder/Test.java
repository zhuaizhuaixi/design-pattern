package designpattern.creation.builder;

/**
 * Created by zzx on 2018/7/19.
 */
class Director {
    private Builder builder;

    public Director(Builder b) {
        builder = b;
    }

    public void buildProduct() {
        builder.buildA();
        builder.buildB();
    }

    public Product getResult() {
        return builder.getResult();
    }
}

interface Builder {
    Product getResult();

    void buildA();

    void buildB();
}

class ConcreteBuilder implements Builder {
    Product product = new Product();

    @Override
    public Product getResult() {
        return product;
    }

    @Override
    public void buildA() {
        product.setA("yes");
    }

    @Override
    public void buildB() {
        product.setB("yes");
    }
}

class Product {
    private String a;
    private String b;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "A: " + a + " B: " + b;
    }
}

public class Test {
    public static void main(String[] args) {
        Director director = new Director(new ConcreteBuilder());
        director.buildProduct();
        Product product = director.getResult();
        System.out.println(product);
    }
}
