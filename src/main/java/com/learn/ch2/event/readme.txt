    Spring的事件（Application Event）为Bean与Bean之间的消息通信提供了支持。当一个Bean处理完一个任务之后，
希望另外一个Bean知道并能做相应的处理；此时需要让另外一个Bean监听当前Bean所发送的事件。
Spring的事件需要遵循如下流程：
①、自定义事件，集成ApplicationEvent。
②、定义事件监听器，实现ApplicationListener。
③、使用容器发布事件。