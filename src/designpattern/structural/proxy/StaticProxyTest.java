package designpattern.structural.proxy;

/**
 * Created by zzx on 2018/7/24.
 */

interface Subject {
    void request();
}

class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("doing real subject");
    }
}

class Proxy implements Subject {
    private Subject realSubject;

    public Proxy() {
        this.realSubject = new RealSubject();
    }

    @Override
    public void request() {
        System.out.println("doing by proxy subject");
        realSubject.request();
    }
}


public class StaticProxyTest {
    public static void main(String[] args) {
        Subject proxy = new Proxy();
        proxy.request();
    }
}
