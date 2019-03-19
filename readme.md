### SpringCloud学习项目

> 启动顺序与组件功能介绍

* eureka-server     服务注册中心
* eureka-provider   服务提供者
* consumer-ribbon   服务消费者ribbon版
* consumer-feign    服务消费者feign版
* zuul-gateway      微服务网关


访问[http://localhost:8881](http://localhost:8881)查看服务注册中心页面
![image.png](https://upload-images.jianshu.io/upload_images/1846623-3cddc287e1c32872.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

访问[http://localhost:8885/api-a/hello/say/2321312](http://localhost:8885/api-a/hello/say/2321312)    ->ribbon
访问[http://localhost:8885/api-b/hello/say/2321312](http://localhost:8885/api-b/hello/say/2321312)    ->feign

具体查看zuul-gateway网关层配置
