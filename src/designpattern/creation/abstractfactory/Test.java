package designpattern.creation.abstractfactory;

/**
 * Created by zzx on 2018/7/18.
 */

abstract class BuildingFactory {
    public static BuildingFactory getBuildingFactory(String type) {
        if ("medium".equals(type)) {
            return new MediumBuildingFactory();
        } else {
            return new SuperBuildingFactory();
        }
    }

    public abstract House getHouse();

    public abstract Condo getCondo();
}

class MediumBuildingFactory extends BuildingFactory {
    @Override
    public House getHouse() {
        return new MediumHouse();
    }

    @Override
    public Condo getCondo() {
        return new MediumCondo();
    }
}

class SuperBuildingFactory extends BuildingFactory {
    @Override
    public House getHouse() {
        return new SuperHouse();
    }

    @Override
    public Condo getCondo() {
        return new SuperCondo();
    }
}

interface House {
    String getHouseInfo();
}

class SuperHouse implements House {
    @Override
    public String getHouseInfo() {
        return "SuperHouse";
    }
}

class MediumHouse implements House {
    @Override
    public String getHouseInfo() {
        return "MediumHouse";
    }
}

interface Condo {
    String getCondoInfo();
}

class SuperCondo implements Condo {
    @Override
    public String getCondoInfo() {
        return "SuperCondo";
    }
}

class MediumCondo implements Condo {
    @Override
    public String getCondoInfo() {
        return "MediumCondo";
    }
}

/**
 * @author zzx
 */
public class Test {
    public static void main(String[] args) {
        BuildingFactory superBf = BuildingFactory.getBuildingFactory("super");
        BuildingFactory mediumBf = BuildingFactory.getBuildingFactory("medium");
        House superHouse = superBf.getHouse();
        House mediumHouse = mediumBf.getHouse();
        Condo superCondo = superBf.getCondo();
        Condo mediumCondo = mediumBf.getCondo();
        System.out.println(superHouse.getHouseInfo());
        System.out.println(mediumHouse.getHouseInfo());
        System.out.println(superCondo.getCondoInfo());
        System.out.println(mediumCondo.getCondoInfo());
    }
}
