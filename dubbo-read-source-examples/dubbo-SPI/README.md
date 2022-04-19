SPI（Service Provider Interface）

[03 Dubbo SPI 精析，接口实现两极反转（上）](https://learn.lianglianglee.com/%E4%B8%93%E6%A0%8F/Dubbo%E6%BA%90%E7%A0%81%E8%A7%A3%E8%AF%BB%E4%B8%8E%E5%AE%9E%E6%88%98-%E5%AE%8C/03%20%20Dubbo%20SPI%20%E7%B2%BE%E6%9E%90%EF%BC%8C%E6%8E%A5%E5%8F%A3%E5%AE%9E%E7%8E%B0%E4%B8%A4%E6%9E%81%E5%8F%8D%E8%BD%AC%EF%BC%88%E4%B8%8A%EF%BC%89.md)

https://zhuanlan.zhihu.com/p/67665359

output:
```shell
java.util.ServiceLoader[com.example.demo.Log]
Log4j:JDK SPI
Logback:JDK SPI

Process finished with exit code 0
```

`@Activate`  `org.apache.dubbo.common.extension.Activate`
