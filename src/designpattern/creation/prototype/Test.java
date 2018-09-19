package designpattern.creation.prototype;

/**
 * Created by zzx on 2018/7/19.
 */

interface Prototype extends Cloneable {
    Prototype clone();
}

class ConcretePrototype implements Prototype {
    private String name;
    private String birthday;

    public ConcretePrototype(String n, String b) {
        name = n;
        birthday = b;
    }

    @Override
    public Prototype clone() {
        Prototype p = null;
        try {
            p = (Prototype) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return p;
    }

    @Override
    public String toString() {
        return "姓名：" + name + " 生日:" + birthday;
    }

    @Override
    public boolean equals(Object object) {
        ConcretePrototype prototypeObject = (ConcretePrototype) object;
        return name.equals(prototypeObject.getName()) &&
                birthday.equals(prototypeObject.getBirthday());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}

public class Test {
    public static void main(String[] args) {
        Prototype prototype = new ConcretePrototype("zzx", "19960606");
        System.out.println(prototype);
        Prototype fakePrototype = prototype.clone();
        System.out.println(fakePrototype);

        System.out.println(prototype == fakePrototype);
        System.out.println(prototype.getClass() == fakePrototype.getClass());
        System.out.println(prototype.equals(fakePrototype));

        ((ConcretePrototype) prototype).setBirthday("123");
        System.out.println(((ConcretePrototype) prototype).getBirthday());
    }
}
