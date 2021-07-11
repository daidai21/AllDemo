
===

rocketmq

Producer： RocketMQ提供多种发送方式，同步发送、异步发送、顺序发送、单向发送。同步和异步方式均需要Broker返回确认信息，单向发送不需要。
Consumer： 拉取式消费、推动式消费。


RocketMQ 支持两种消息模式：集群消费（Clustering）和广播消费（Broadcasting）。

集群消费模式下,相同Consumer Group的每个Consumer实例平均分摊消息。
广播消费模式下，相同Consumer Group的每个Consumer实例都接收全量的消息。


普通顺序消费模式下，消费者通过同一个消费队列收到的消息是有顺序的，不同消息队列收到的消息则可能是无顺序的。
严格顺序消息模式下，消费者收到的所有消息均是有顺序的。


Topic MessageId Tag Key  MessageBody

消息顺序： 全局顺序、 分区顺序

回溯消费： 例如consumer重复消费1h前的数据

死信队列：  当一条消息初次消费失败，消息队列会自动进行消息重试；达到最大重试次数后，若消费依然失败，则表明消费者在正常情况下无法正确地消费该消息，此时，消息队列 不会立刻将消息丢弃，而是将其发送到该消费者对应的特殊队列中。


同步刷盘
异步刷盘


负载均衡
    Producer的负载均衡： 消息分摊到多个队列中
    Consumer的负载均衡： 在一个消息消费队列在同一时间只允许被同一消费组内的一个消费者消费，一个消息消费者能同时消费多个消息队列

事务： 是用的2PC实现的



消息过滤： 主题下的 tag和properties
    https://help.aliyun.com/document_detail/29543.html


OpenMessaging:  统一接口标准化规范


延迟消息
    https://www.jianshu.com/p/c6a4ede528a8
    http://childe.net.cn/2019/03/18/%E7%AC%94%E8%AE%B0-%E7%94%B1rocketmq%E5%BB%B6%E6%97%B6%E9%98%9F%E5%88%97%E6%80%9D%E8%80%83%E4%BB%BB%E5%8A%A1%E8%A7%84%E5%88%92/

    18个level，同一个level的放在一个子主题下

定时消息
    https://help.aliyun.com/document_detail/43349.html

https://github.com/apache/rocketmq/blob/master/docs/cn/README.md
