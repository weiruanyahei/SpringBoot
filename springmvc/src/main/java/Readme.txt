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
















