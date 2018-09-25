package designpattern.structural.proxy;

import org.w3c.dom.CDATASection;

import java.lang.reflect.*;
import java.lang.reflect.Proxy;
import java.util.Arrays;

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
        System.out.println(object);
        System.out.println(proxy.getClass().getName());
        System.out.println(method);
        System.out.println(Arrays.toString(args));
        System.out.println("do before");
        Object result = method.invoke(object, args);
        System.out.println("do after");
        return result;
    }
}

public class DynamicProxyTest {
    public static void main(String[] args) {
        Subject subject = new RealSubject();
        System.out.println(Subject.class.getClassLoader());
        System.out.println(DynamicProxyHandler.class.getClassLoader());
        Subject proxy = (Subject) Proxy.newProxyInstance(Subject.class.getClassLoader(),
                subject.getClass().getInterfaces(), new DynamicProxyHandler(subject));
        System.out.println(proxy.getClass().getName());
        proxy.request();
    }
}
