
@Autowired

循环依赖
自动装载

@Service


@Component

@repository

@Bean
    Spring的@Bean注解用于告诉方法，产生一个Bean对象，然后这个Bean对象交给Spring管理。 产生这个Bean对象的方法Spring只会调用一次，随后这个Spring将会将这个Bean对象放在自己的IOC容器中。
    @Autowired就可以自动装配了

@controller

import org.springframework.beans.factory.annotation.Value;


TODO: springboot 常用注解

===


Spring 使用三级缓存来解决循环依赖的问题，三级缓存分别是：

singletonObjects： 一级缓存，存储单例对象，Bean 已经实例化，初始化完成。
earlySingletonObjects： 二级缓存，存储 singletonObject，这个 Bean 实例化了，还没有初始化。
singletonFactories： 三级缓存，存储 singletonFactory。

https://mrbird.cc/%E6%B7%B1%E5%85%A5%E7%90%86%E8%A7%A3Spring%E5%BE%AA%E7%8E%AF%E4%BE%9D%E8%B5%96.html

