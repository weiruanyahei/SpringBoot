Spring通过任务执行器（TaskExecutor）来实现多线程和并发编程。使用ThreadPoolTaskExecutor可实现一个基于线程池的
TaskExecutor.而实际开发中任务一般是异步的，因此，需要在配置类中通过@EnableAsync开始对异步任务的支持，并通过在实际
执行的Bean的方法中使用@Async注解来声明其是一个异步任务。

特别注意：目前线程池并不会随spring容器的关闭而shutdown。
When more control is desired, a @Configuration class may implement SchedulingConfigurer.
This allows access to the underlying ScheduledTaskRegistrar instance.
 For example, the following example demonstrates how to customize the Executor used to execute scheduled
 tasks:
   @Configuration
   @EnableScheduling
   public class AppConfig implements SchedulingConfigurer {

       @Override
       public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
           taskRegistrar.setScheduler(taskExecutor());
       }

       @Bean(destroyMethod="shutdown")
       public Executor taskExecutor() {
           return Executors.newScheduledThreadPool(100);
       }
   }
Note in the example above the use of @Bean(destroyMethod="shutdown"). This ensures that the task executor
is properly shut down when the Spring application context itself is closed.