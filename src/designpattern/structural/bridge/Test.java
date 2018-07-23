package designpattern.structural.bridge;

/**
 * Created by zzx on 2018/7/23.
 */
interface TeaSize {
    double getPrice();
}

class BigCup implements TeaSize {
    private TeaKind teaKind;

    public BigCup(TeaKind teaKind) {
        this.teaKind = teaKind;
    }

    @Override
    public double getPrice() {
        return teaKind.getPrice() * 2;
    }
}

class SmallCup implements TeaSize {
    private TeaKind teaKind;

    public SmallCup(TeaKind teaKind) {
        this.teaKind = teaKind;
    }

    @Override
    public double getPrice() {
        return teaKind.getPrice() * 0.5;
    }
}

interface TeaKind {
    double getPrice();
}

class RedTea implements TeaKind {
    private final double PRICE = 4;

    @Override
    public double getPrice() {
        return PRICE;
    }
}

class GreenTea implements TeaKind {
    private final double PRICE = 5;

    @Override
    public double getPrice() {
        return PRICE;
    }
}

public class Test {
    public static void main(String[] args) {
        TeaSize teaSize = new BigCup(new GreenTea());
        System.out.println(teaSize.getPrice());
    }
}
