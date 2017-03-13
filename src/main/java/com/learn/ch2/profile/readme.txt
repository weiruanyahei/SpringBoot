Profile为在不同环境下使用不同的配置提供了支持（开发环境下的配置和生产环境下的配置通常有差异，如：数据库的配置）。
a、通过设定Environment的ActiveProfiles来设定当前context需要使用的配置环境。在开发中使用@Profile注解类或者
方法，达到在不同情况下选择实例化不同的bean。
b、通过设定jvm的spring.profiles.active参数来设置配置环境。
c、Web项目设置在Servlet的context parameter中。
    Servlet2.5及以下：
    <servlet>
        <servlet-name>dispatcher</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <init-param>
            <param-name>spring.profiles.active</param-name>
            <param-value>production</param-value>
        </init-param>
    </servlet>
    Servlet3.0及以上：
    public class WebInit implements WebApplicationInitializer{
        @Override
        public void onStartup(ServletContext container)throws ServletException{
            container.setInitParameter("spring.profiles.default","dev");
        }
    }


