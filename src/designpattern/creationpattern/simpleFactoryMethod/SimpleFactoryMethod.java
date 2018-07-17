package designpattern.creationpattern.simpleFactoryMethod;

import java.util.Date;
import java.util.Random;

/**
 * Created by zzx on 2018/7/17.
 */

interface AutoInsurance {
    /**
     * 获得保险信息
     *
     * @return 保险信息
     */
    String getInsuranceInfo();
}

class BodyInjury implements AutoInsurance {
    @Override
    public String getInsuranceInfo() {
        return "BodyInjury";
    }
}

class PersonInjury implements AutoInsurance {
    @Override
    public String getInsuranceInfo() {
        return "PersonInjury";
    }
}

class Collision implements AutoInsurance {
    @Override
    public String getInsuranceInfo() {
        return "Collision";
    }
}

class PolicyProducer {
    public static AutoInsurance getInsuranceObj(String option) {
        switch (option) {
            case "person":
                return new PersonInjury();
            case "body":
                return new BodyInjury();
            case "collision":
                return new Collision();
            default:
                return null;
        }
    }
}

/**
 * @author zzx
 */
public class SimpleFactoryMethod {
    public static void main(String[] args) {
        String[] options = {"body", "person", "collision"};
        Random rand = new Random(new Date().getSeconds());
        AutoInsurance ai = PolicyProducer.getInsuranceObj(options[rand.nextInt(3)]);
        if (ai != null) {
            System.out.println(ai.getInsuranceInfo());
        } else {
            System.out.println("Option is wrong.");
        }
    }
}
