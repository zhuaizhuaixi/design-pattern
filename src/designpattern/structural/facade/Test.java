package designpattern.structural.facade;

/**
 * Created by zzx on 2018/7/23.
 */

class Facade {
    private Light light = new Light();
    private Door door = new Door();
    public void open() {
        light.open();
        door.open();
    }

    public void close() {
        light.close();
        door.close();
    }
}

class Light {
    private boolean status = false;

    public void open() {
        status = true;
    }

    public void close() {
        status=false;
    }
}

class Door {
    private boolean status = false;

    public void open() {
        status = true;
    }

    public void close() {
        status=false;
    }
}

public class Test {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.open();
        facade.close();
    }
}
