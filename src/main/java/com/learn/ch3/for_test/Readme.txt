单元测试：
    针对当前开发的类和方法进行测试，可以简单模拟依赖实现，对运行环境没有依赖；
    缺陷：
        只能验证当前类活方法能否正常工作，当想知道系统的各个部分组合在一起是否能正常工作时；集成测试必要性凸显。

集成测试：
    一般需要来自不同层的不同对象的交互，如：数据库、网络连接、IoC容器等。集成测试为我们提供了一种无需部署或运行
程序来完成验证系统各部分是否能正常协同工作的能力。


Spring通过Spring TestContext Framework对集成测试提供顶级支持。不依赖与特定的测试框架，既可用Junit，也可
使用TestNG.Spring提供了一个SpringJUnit4ClassRunner类，它提供了Spring TESTContext Framework的功能。
通过@ContextConfiguration来配置Application Context，通过@ActiveProfiles确定活动的profile。