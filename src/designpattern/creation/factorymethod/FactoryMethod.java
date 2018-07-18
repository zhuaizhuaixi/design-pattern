package designpattern.creation.factorymethod;

/**
 *
 * Created by zzx on 2018/7/17.
 */
interface Product {
    /**
     * 产品操作：返回产品信息
     *
     * @return 产品信息
     */
    String operation();
}

class LeftProduct implements Product {
    @Override
    public String operation() {
        return "leftProduct";
    }
}

class RightProduct implements Product {
    @Override
    public String operation() {
        return "rightProduct";
    }
}

interface Creator {

    /**
     * 工厂超类的工厂方法，用于生成产品
     *
     * @return 产品
     */
    Product factory();
}

class LeftCreator implements Creator {
    @Override
    public Product factory() {
        return new LeftProduct();
    }
}

class RightCreator implements Creator {
    @Override
    public Product factory() {
        return new RightProduct();
    }
}

/**
 * @author zzx
 */
public class FactoryMethod {
    public static void main(String[] args) {
        Creator[] creators = {new LeftCreator(), new RightCreator()};
        System.out.println(creators[0].factory().operation());
        System.out.println(creators[1].factory().operation());
    }
}
