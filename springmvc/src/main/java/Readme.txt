什么是MVC?与三层架构关系？
MVC:Model + View + Controller（数据模型+视图+控制器）
三层架构：Presentation tier + Application tier + Data tier（展现层+应用层+数据访问层）

同时，MVC只存在三层架构的展现层，M实际上是数据模型，是包含数据的对象。在Spring MVC里，有一个专门的类叫Model，
用来与V之间的数据交互、传值；V指的是视图页面，包含JSP、freeMarker、Velocity、Thymeleaf、Tile等；C即：控制
器（Spring MVC的注解@Controller的类）。三层架构是整个应用的架构，由Spring框架负责管理；一般项目结构中都有
Service层、DAO层，这两个反馈在应用层和数据访问层。

本节将关注：基于注解和Java配置的零配置（无xml配置）的Spring MVC开发。

    Spring MVC提供了一个DispatcherServlet来开发Web应用。Servlet2.5及以下的时候只要在web.xml下配置<servlet>
元素即可。本节将使用Servlet3.0+无web.xml的配置方式，在Spring MVC里实现WebApplicationInitializer接口便可实现
等同于web.xml的配置。


ViewResolver接口：Spirng MVC视图渲染的核心机制；实现这个接口要重写方法resolveViewName()，这个方法的返回值是接口
View，而View的职责就是使用model、request、response对象，并将渲染的视图（可能是html/json/xml/pdf等）返回给客户端。


Spring MVC常用注解：
@Controller
    注解在类上，表明当前类是Spring MVC里的Controller，Dispatcher Servlet会自动扫描注解了此注解的类，并将
Web请求映射到注解了@RequestMapping的方法上。特指出：在Spring MVC声明控制器Bean时，只能用@Controller。

@RequestMapping
    用来映射Web请求（访问路径和参数）、处理类和方法的。可注解在类或方法上。当注解到方法上时，会继承在类上的注解的路径；
支持Servlet的request和response作为参数，也支持对request和response的媒体类型进行配置。

@ResponseBody
    支持将返回值放到response体内，而不是返回一个页面。在很多基于Ajax的程序的时候，可以以此注解返回数据而不是页面；此注解
可放置在返回值前或者方法上。

@RequestBody
    允许request的参数在request体中，而不是在直接链接在地址后面。此注解放置在参数前。

@PathVariable
    用来接收路径参数，如/books/101,可接收101作为参数，此注解放置在参数前。

@RestController
    此为一个组合注解，组合了@Controller和@ResponseBody，即：只开发一个和页面交互数据的控制的时候，使用此注解规避模板代
码霸屏（取代@Controller和ResponseBody两个注解）。


# Spring MVC基本配置:
    Spring MVC的定制配置需要扩展的配置类继承一个WebMvcConfigurerAdapter类，并在扩展类上使用@EnableWebMvc注解，来
开启对Spring MVC的配置支持，此时，就可以重写类方法，完成常用配置。
* 静态资源配置
    程序的静态文件（js、css、图片等）需要直接访问，此时可以重写类方法addResourceHandlers方法来实现。

* 拦截器配置
    拦截器（Interceptor）实现对每一个请求处理前后进行相关的业务处理，类似于Servlet的Filter。
    普通的Bean实现HandlerInterceptor接口或者继承HandlerInterceptorAdapter类来实现自定义拦截器。通过重写
WebMvcConfigurerAdapter的addInterceptors方法来注册自定义的拦截器。

* @ControllerAdvice
    可以将对于控制器的全局配置放置在同一个位置，注解了@Controller的类的方法可使用@ExceptionHandler、@InitBinder、
@ModelAttribute注解到方法上，这对所有注解了@RequestMapping的控制器内的方法有效。
@ExceptionHandler：用于全局处理控制器里的异常。
@InitBinder: 用来设置WebDataBinder，WebDataBinder用来自动绑定前台请求参数到Model中。
@ModelAttribute：本来的作用是绑定键值对到Model里，此处是让全局的@RequestMapping都能获得在此处设置的键值对。

* 其他配置
*a、快捷的ViewController
    可通过在配置中重写addViewControllers来简化类似简单的页面跳转配置。如：
        /**
         * 简化跳转配置
         * @param registry
         */
        @Override
        public void addViewControllers(ViewControllerRegistry registry) {
            registry.addViewController("/index/home").setViewName("index");
        }

*b、路径匹配参数配置
    在Spring MVC中，路径参数如果带"."的话，"."后面的值将被忽略；通过重写configurePathMatch方法可不忽略"."后面
的参数。（http://localhost:8080/rest/pathvar/xx.yy）

*c、更多配置
    可查看WebMvcConfigurerAdapter类、WebMvcConfigurer接口的API开展深度配置。


#Spring MVC高级配置
*文件上传配置
    Spring MVC通过配置一个MultipartResolver来上传文件，通过



#Spring MVC的测试：
    为了测试Web项目通常不需要启动项目，此时需要一些Servlet相关的模拟对象，如：MockMvc/MockHttpServletRequest/
MockHttpServletResponse/MockHttpSession等；在Spring里，使用@WebAppConfiguration指定加载的ApplicationContext
是一个WebApplicationContext。
    实际开发中，先有需求，即：先知道想要的是什么样，然后按照想要的样子去开发。

    测试驱动开发（Test Driven Development,TDD）:
        按照需求先写一个自己预期结果的测试用例，这个测试用例刚开始肯定是失败的测试，随着不断的编码和重构，最终让测试用例通过测
    试，这样才能保证软件的质量和可控性。
















