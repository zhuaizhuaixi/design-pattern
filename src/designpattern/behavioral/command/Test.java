package designpattern.behavioral.command;

/**
 * Created by zzx on 2018/7/26.
 */

class Invoker {
    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void invoke() {
        command.excute();
    }
}

interface Command {
    void excute();
}

class ConcreteCommand1 implements Command {
    private Receiver receiver;

    public ConcreteCommand1(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void excute() {
        System.out.println("running concrete command 1");
    }
}

class ConcreteCommand2 implements Command {
    private Receiver receiver;

    public ConcreteCommand2(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void excute() {
        System.out.println("running concrete command 2");
    }
}

class Receiver {

}

public class Test {
    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        Command command1 = new ConcreteCommand1(receiver);
        Invoker invoker1 = new Invoker(command1);
        invoker1.invoke();
        Command command2 = new ConcreteCommand2(receiver);
        Invoker invoker2 = new Invoker(command2);
        invoker2.invoke();

    }
}
