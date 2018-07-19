package designpattern.creation.singleton;

/**
 * Created by zzx on 2018/7/19.
 */

class Singleton {
    private static Singleton uniqueSingleton;

    private String name;

    private Singleton(String n) {
        name = n;
    }

    public static synchronized Singleton getInstance(String name) {
        if (uniqueSingleton == null) {
            uniqueSingleton = new Singleton(name);
        }
        return uniqueSingleton;
    }

    @Override
    public String toString() {
        return "unique " + name;
    }
}

public class Test {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance("abc");
        System.out.println(singleton);

    }
}
