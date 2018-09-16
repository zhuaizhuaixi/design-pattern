package designpattern.behavioral.chainOfResponsibility;

interface Handler {

    /**
     * 示意处理请求的方法，虽然这个示意方法是没有传入参数的
     * 但实际是可以传入参数的，根据具体需要来选择是否传递参数
     */
    void handleRequest();

    /**
     * 取值方法
     */
     Handler getSuccessor();

    /**
     * 赋值方法，设置后继的责任对象
     */
    void setSuccessor(Handler successor);
}

class ConcreteHandler implements Handler {
    private Handler successor;
    /**
     * 处理方法，调用此方法处理请求
     */
    @Override
    public void handleRequest() {
        /**
         * 判断是否有后继的责任对象
         * 如果有，就转发请求给后继的责任对象
         * 如果没有，则处理请求
         */
        if (getSuccessor() != null) {
            System.out.println("放过请求");
            getSuccessor().handleRequest();
        } else {
            System.out.println("处理请求");
        }
    }

    @Override
    public Handler getSuccessor() {
        return successor;
    }

    @Override
    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }
}

public class Test {
    public static void main(String[] args) {
        //组装责任链
        Handler handler1 = new ConcreteHandler();
        Handler handler2 = new ConcreteHandler();
        handler1.setSuccessor(handler2);
        //提交请求
        handler1.handleRequest();
    }
}