package designpattern.creation.singleton;

/**
 * 使用静态内部类实现单例模式
 * 使用classloader机制保证初始化instance时只有一个线程
 * 实现懒加载，只有在getInstant被调用时才会初始化
 *
 * Created by zzx on 2018/7/19.
 */

class Singleton1 {
    private static class SingletonHolder {
        private static final Singleton1 INSTANCE = new Singleton1();
    }

    private Singleton1() {
    }

    public static Singleton1 getInstance() {
        return SingletonHolder.INSTANCE;
    }
}

public class StaticInnerClassTest {
    public static void main(String[] args) {
        Singleton1 singleton = Singleton1.getInstance();
        Singleton1 singleton1 = Singleton1.getInstance();
        System.out.println(singleton);
        System.out.println(singleton1);
    }
}
