Bean在使用之前或者之后做些必要的操作，Spring对Bean的生命周期的操作提供了支持。在使用Java配置和注解配置下
提供如下两种方式：
a、Java配置方式：使用@Bean的initMethod和destroyMethod（相当于xml配置的init-method和destory-method）。
b、注解方式：利用JSR-250的@PostConstruct和@PreDestroy。