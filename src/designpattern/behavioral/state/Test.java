package designpattern.behavioral.state;

/**
 * @author zzx
 *         Created by zzx on 2018/7/30.
 */

class Context {

    private State state1;
    private State state2;
    private State currentState;

    public Context() {
        state1 = new ConcreteState1();
        state2 = new ConcreteState2();
        currentState = this.state1;
    }

    public void changeState() {
        if (currentState.getClass() == ConcreteState1.class) {
            this.currentState = state2;
        } else if (currentState.getClass() == ConcreteState2.class){
            this.currentState = state1;
        }
    }

    public void doAction() {
        this.currentState.handle();
    }
}

interface State {
    /**
     * State父类方法
     */
    void handle();
}

class ConcreteState1 implements State {
    @Override
    public void handle() {
        System.out.println("ConcreteState1 is handling");
    }
}

class ConcreteState2 implements State {
    @Override
    public void handle() {
        System.out.println("ConcreteState2 is handling");
    }
}

/**
 * @author zzx
 */
public class Test {
    public static void main(String[] args) {
        Context context = new Context();
        context.doAction();
        context.changeState();
        context.doAction();
        context.changeState();
        context.doAction();
        context.changeState();
        context.doAction();
        context.changeState();
        context.doAction();
    }
}
