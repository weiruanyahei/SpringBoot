组合注解与元注解
    元注解可理解为：能够用于注解到别的注解上的注解。同时，被注解的注解称之为组合注解；组合注解具备元注解的功能。
如：@Configuration就是一个组合@Component注解。

设计恶补：
    模板代码（如：相同的多个注解用到各个类中。），是Spring设计原则中要消除的代码。

