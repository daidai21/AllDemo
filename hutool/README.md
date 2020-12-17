# Hutool V5.4.0

## AOP

TODO

## bloomFilter

* 接口BloomFilter包含了contains和add方法，BitSetBloomFilter和BitMapBloomFilter类实现了BloomFilter接口，BloomFilterUtil工具类提供了两个静态方法createBitSet和createBitMap。
* 各种Hash算法的过滤器实现。
* 定义了BitMap接口，有IntMap和LongMap两种实现方式。

## cache

* 定义了Cache接口；CacheUtil静态工具类提供了FIFO、LFU、LRU、Timed、Timed等Cache创建方法；全局缓存清理定时器池类GlobalPruneTimer。
* AbstractFileCache将小文件缓存在内存中。
* 实现各种Cache

## core


TODO

* core.lang
    * TODO

TODO

* core.net
    * TODO
TODO

* core.thread
    * TODO
* core.thread.lock
    * TODO
* core.thread.threadlocal
    * TODO
* core.util
    * TODO

## cron 定时任务

TODO

## http

* http
    * TODO
* http.body
    * TODO
* http.cookie
    * TODO
* http.server
    * TODO
* http.server.action
    * TODO
* http.server.handler
    * TODO
* http.ssl
    * TODO
* http.useragent
    * TODO
* http.webservice
    * TODO

## socket 套接字，包括BIO、NIO、AIO封装

* socket Socket套接字相关工具类封装
    * Socket通讯配置类SocketConfig
    * SocketRuntimeException
    * SocketUtil提供方法getRemoteAddress和isConnected
* socket.aio AIO封装
    * TODO
* socket.nio NIO封装
    * TODO
* socket.protocol
    * TODO

## system

HOST信息、JDK信息、JRE包信息、Java说明书信息、JVM信息、JVM说明书信息、操作系统信息、运行时信息、系统属性名称常量、CPU信息

===

TODO: setting script poi log json extra (扩展工具类 其他库的封装) dfa db crypto captcha（验证码） 
