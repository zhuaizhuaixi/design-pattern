package designpattern.structural.proxy;

import java.lang.reflect.*;

/**
 * Created by zzx on 2018/7/24.
 */
class DynamicProxyHandler implements InvocationHandler {
    private Object object;

    public DynamicProxyHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("do before");
        Object result = method.invoke(object, args);
        System.out.println("do after");
        return result;
    }
}

public class DynamicProxyTest {
    public static void main(String[] args) {
        Subject subject = new RealSubject();
        Subject proxy = (Subject) java.lang.reflect.Proxy.newProxyInstance(Subject.class.getClassLoader(),
                new Class[]{Subject.class}, new DynamicProxyHandler(subject));
        proxy.request();
    }
}
