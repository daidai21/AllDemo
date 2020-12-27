application.properties


### @Value

根据注入的内容来源可分为两类：

* 一类为默认的Spring Boot会自动加载的配置文件application.properties中的属性；
* 另一类为自定义配置文件中的属性，需要先通过@PropertySource加载。
    * 注入普通字符串
    * 注入操作系统属性
    * 注入表达式结果
    * 注入其他Bean属性
    * 注入文件资源
    * 注入URL资源
