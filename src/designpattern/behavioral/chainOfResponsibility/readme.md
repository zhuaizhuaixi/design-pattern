## 责任链模式

UML图：

![Alt text](../../../../img/chainOfResponsibilityPatternUML.png)

定义：

使多个对象都有机会处理请求，从而避免请求的发送者和接受者之间的耦合关系， 将这个对象连成一条链，并沿着这条链传递该请求，直到有一个对象处理他为止

servlet中的filter就是使用责任链模式