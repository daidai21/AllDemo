
```java
@Transactional(
    propagation = Propagation.REQUIRES_NEW,
    rollbackFor = {RuntimeException.class, IOException.class}
)
class DemoManager {} // or method
```


* [使用声明式事务](https://www.liaoxuefeng.com/wiki/1252599548343744/1282383642886177)

TODO: need connect DB