## 简单工厂方法

UML图：
![Alt text](../../../../img/simpleFactoryMethodUML.png)

图中左半部分成为产品类，由接口IProduct和实现类Product_A和Product_B组成

各组成部分：
1. Creator：简单工厂方法的核心，包括业务逻辑，当客户需要的时候委托工厂类创建产品类对象
2. IProduct： 可以使接口或者抽象类，是具体自雷的超类或共同接口。
3. Product： 实现IProduct接口的具体类。

简单工厂方法模式的优点：
1. 工厂方法包括了选择需要初始化的类的业务逻辑
2. 客户不直接操作类，只是单纯的消费者
3. 实现责任分离
4. 客户无需知道对象是如何创建的，以及创建的是什么类
5. 客户类中没有创建对象所需语句

简单工厂方法模式的缺点：
1. 增加产品时需要对工厂类进行修改，不符合*开闭原则*
2. 由于工厂方法是静态的，所以工厂类的方法不能被继承，只能是一个单独的类