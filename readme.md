### SpringCloud学习项目

> 启动顺序与组件功能介绍

* eureka-server     服务注册中心
* eureka-provider   服务提供者
* consumer-ribbon   服务消费者ribbon版
* consumer-feign    服务消费者feign版
* zuul-gateway      微服务网关


访问[http://localhost:8881](http://localhost:8881)查看服务注册中心页面
![image.png](https://upload-images.jianshu.io/upload_images/1846623-3cddc287e1c32872.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

访问[http://localhost:8885/api/v1/ribbon/hello/say/2321312](http://localhost:8885/api/v1/ribbon/hello/say/2321312)    ->ribbon
访问[http://localhost:8885/api/v1/feign/hello/say/2321312](http://localhost:8885/api/v1/feign/hello/say/2321312)    ->feign

具体查看zuul-gateway网关层配置

### # 特性
* 分布式swagger文档管理中心


### # 资料
* 分布式swagger文档整合    https://blog.csdn.net/yangchuanan/article/details/82774934

* 启动效果

![image.png](https://upload-images.jianshu.io/upload_images/1846623-96153fbcdfb2732b.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

* 服务注册中心
![image.png](https://upload-images.jianshu.io/upload_images/1846623-771d179ea3a70c21.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)





## # TODO
* 附近的人-redis
* 分布式锁-redisson
