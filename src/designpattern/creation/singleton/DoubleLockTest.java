package designpattern.creation.singleton;

/**
 * 双重检查锁
 * 仅在不存在singleton的时候才进行同步操作，并在初始化前再进行一次检查
 * 相比于整个方法进行同步，节省了不需要同步时的资源
 *
 * Created by zzx on 2018/7/19.
 */
class Singleton2 {
    private volatile static Singleton2 singleton;
    private Singleton2(){}
    public static Singleton2 getSingleton(){
        if (singleton == null) {
            synchronized (Singleton2.class) {
                if (singleton == null) {
                    singleton = new Singleton2();
                }
            }
        }
        return singleton;
    }
}

public class DoubleLockTest {
    public static void main(String[] args) {
        Singleton2 singleton = Singleton2.getSingleton();
    }
}
