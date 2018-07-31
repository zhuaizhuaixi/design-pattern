package designpattern.behavioral.interpreter;

import sun.rmi.runtime.Log;

import java.util.Stack;

/**
 * Created by zzx on 2018/7/30.
 */

interface AbstractExpression {
    int interpreter();
}

class NumExpression implements AbstractExpression {
    private int num;

    public NumExpression(int num) {
        this.num = num;
    }

    @Override
    public int interpreter() {
        return num;
    }
}

abstract class OperatorExpression implements AbstractExpression {
    protected AbstractExpression mArithmeticExpression1, mArithmeticExpression2;

    public OperatorExpression(AbstractExpression arithmeticExpression1,
                              AbstractExpression arithmeticExpression2) {
        mArithmeticExpression1 = arithmeticExpression1;
        mArithmeticExpression2 = arithmeticExpression2;
    }
}

class AdditionExpression extends OperatorExpression {
    public AdditionExpression(AbstractExpression arithmeticExpression1,
                              AbstractExpression arithmeticExpression2) {
        super(arithmeticExpression1, arithmeticExpression2);
    }

    @Override
    public int interpreter() {
        return mArithmeticExpression1.interpreter() + mArithmeticExpression2.interpreter();
    }
}

class Calculator {

    protected Stack<AbstractExpression> mArithmeticExpressionStack = new Stack<>();

    public Calculator(String expression) {
        AbstractExpression arithmeticExpression1, arithmeticExpression2;
        String[] elements = expression.split(" ");
        for (int i = 0; i < elements.length; ++i) {
            switch (elements[i].charAt(0)) {
                case '+':
                    arithmeticExpression1 = mArithmeticExpressionStack.pop();
                    arithmeticExpression2 = new NumExpression(Integer.valueOf(elements[++i]));
                    mArithmeticExpressionStack.push(
                            new AdditionExpression(arithmeticExpression1, arithmeticExpression2));
                    break;
                default:
                    mArithmeticExpressionStack.push(new NumExpression(Integer.valueOf(elements[i])));
                    break;
            }
        }
    }

    public int calculate() {
        return mArithmeticExpressionStack.pop().interpreter();
    }
}

public class Test {
    public static void main(String[] args) {
        Calculator calculator = new Calculator("123 + 124 + 125 + 126");
        System.out.println(calculator.calculate());
    }
}
