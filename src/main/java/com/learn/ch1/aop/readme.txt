1、使用@Aspect声明是一个切面；
2、使用@Before/@After/@Around定义通知（advice），可直接将拦截规则（切点）作为参数；
3、其中@Before/@After/@Around参数的拦截规则为切点（Pointcut），为了使切点复用，可使用@Pointcut专门定义拦截规则，
然后在@Before/@After/@Around的参数中调用；
4、其中符合条件的每一个被拦截处为连接点（Joinpoint）。


该包演示基于注解拦截和基于方法规则拦截两种方式，模拟记录操作的日志应用实现。其中注解式拦截能够很好的控制要拦截的粒度和获得更
丰富的信息；Spring本身在事务处理（@transactional）和数据缓存上面都使用此种方式的拦截。