

redis

字符串（string）、散列（hash）、列表（list）、集合（set）和有序集合（sorted set）这五种类型的键的底层实现数据结构。

sorted set：   跳跃表

redis事务不支持原子性，可以理解为批量执行的脚本，中间某条命令失效不会导致前面执行的命令回滚，也不影响后续的命令执行。

使用场景：
    商品预减库存数量
    验证码短期内有效
    hash存储
    uuid
    list当做消息队列
    set用作 微博的微关系设计，共同关注的好友
    zset top100榜单 热榜设计


持久化机制：
    RDB， 内存中的数据库记录定时dump到磁盘上的rdb持久化
    AOF（append only file）， 将redis的操作日志以追加的方式写入文件

rdb vs aof

|  | rdb | aof |
| :-: | :-: | :-: |
| 原理 | 快照 | 日志追加 |
| 优点 | 与AOF相比，恢复大数据集的时候会更快；可以最大化Redis的性能，在保存RDB文件，服务器进程只需fork一个子进程来完成RDB文件的创建，父进程不需要做IO操作；RDB快照是一个压缩过的非常紧凑的文件，保存着某个时间点的数据集，适合做数据的备份，灾难恢复 | 数据更完整，安全性更高，秒级数据丢失；AOF文件是一个只进行追加的日志文件，且写入操作是以Redis协议的格式保存的，内容是可读的，适合误删紧急恢复 |
| 缺点 | RDB的数据安全性是不如AOF的，保存整个数据集的过程是比繁重的，根据配置可能要几分钟才快照一次，如果服务器宕机，那么就可能丢失几分钟的数据；Redis数据集较大时，fork的子进程要完成快照会比较耗CPU、耗时；版本兼容RDB格式问题 | 对于相同的数据集，AOF文件的体积要大于RDB文件，数据恢复也会比较慢；AOF 的速度可能会慢于 RDB |

**redis的缓存淘汰策略有：**

* noeviction：当内存不足以容纳新写入数据时，新写入操作会报错。
* allkeys-lru:当内存不足以容纳新写入数据时，在键空间中，移除最近最少使用的key。
* allkeys-random:当内存不足以容纳新写入数据时，在键空间中，随机移除某个key。
* volatile-lru:当内存不足以容纳新写入数据时，在设置了过期时间的键空间中，移除最近最少使用的key。
* volatile-random:当内存不足以容纳新写入数据时，在设置了过期时间的键空间中，随机移除某个key。

**缓存失效策略：**

* 定时过期策略： 每个设置过期时间的key都需要创建一个定时器，到过期时间就会立即清除。该策略可以立即清除过期的数据，对内存很友好；但是会占用大量的CPU资源去处理过期的数据，从而影响缓存的响应时间和吞吐量。
* 惰性过期策略： 只有当访问一个key时，才会判断该key是否已过期，过期则清除。该策略可以最大化地节省CPU资源，却对内存非常不友好。极端情况可能出现大量的过期key没有再次被访问，从而不会被清除，占用大量内存。
* 定期过期策略：每隔一定的时间，会扫描一定数量的数据库的expires字典中一定数量的key，并清除其中已过期的key。该策略是前两者的一个折中方案。通过调整定时扫描的时间间隔和每次扫描的限定耗时，可以在不同情况下使得CPU和内存资源达到最优的平衡效果。

**Redis中同时使用了惰性过期和定期过期两种过期策略。**

```txt

所谓定期删除，指的是 redis 默认是每隔 100ms 就随机抽取一些设置了过期时间的 key，检查其是否过期，如果过期就删除。

假设 redis 里放了 10w 个 key，都设置了过期时间，你每隔几百毫秒，就检查 10w 个 key，那 redis 基本上就死了，cpu 负载会很高的，消耗在你的检查过期 key 上了。注意，这里可不是每隔 100ms 就遍历所有的设置过期时间的 key，那样就是一场性能上的灾难。实际上 redis 是每隔 100ms 随机抽取一些 key 来检查和删除的。

但是问题是，定期删除可能会导致很多过期 key 到了时间并没有被删除掉，那咋整呢？所以就是惰性删除了。这就是说，在你获取某个 key 的时候，redis 会检查一下 ，这个 key 如果设置了过期时间那么是否过期了？如果过期了此时就会删除，不会给你返回任何东西。

获取 key 的时候，如果此时 key 已经过期，就删除，不会返回任何东西。但是实际上这还是有问题的，如果定期删除漏掉了很多过期 key，然后你也没及时去查，也就没走惰性删除，此时会怎么样？如果大量过期 key 堆积在内存里，导致 redis 内存块耗尽了，咋整？答案是：走内存淘汰机制。
```

| 缓存失效策略名称 | 原理 | 优点 | 缺点 |
| :-: |  :-: |  :-: | :-: | 
| 定时过期策略 |  | 节省内存 | 费CPU |
| 定期过期策略 |  |  |  |
| 惰性过期策略 |  |  | 费内存 |


**redis异常问题：**
    缓存雪崩
    缓存预热
    缓存穿透
    缓存降级
    缓存击穿

### 缓存雪崩

如果缓存集中在一段时间内失效，发生大量的缓存穿透，所有的查询都落在数据库上，造成了缓存雪崩由于原有缓存失效，新缓存未到期间所有原本应该访问缓存的请求都去查询数据库了，而对数据库CPU和内存造成巨大压力，严重的会造成数据库宕机。举例来说， 我们在准备一项抢购的促销运营活动，活动期间将带来大量的商品信息、库存等相关信息的查询。 为了避免商品数据库的压力，将商品数据放入缓存中存储。 不巧的是，抢购活动期间，大量的热门商品缓存同时失效过期了，导致很大的查询流量落到了数据库之上。对于数据库来说造成很大的压力。

解决办法：

* 加锁排队
* 数据预热
* 双层缓存策略： C1为原始缓存，C2为拷贝缓存，C1失效时，可以访问C2，C1缓存失效时间设置为短期，C2设置为长期
* 定时更新缓存策略： 实效性要求不高的缓存，容器启动初始化加载，采用定时任务更新或移除缓存
* 设置不同的过期时间，让缓存失效的时间点尽量均匀

### 缓存预热

缓存预热就是系统上线后，将相关的缓存数据直接加载到缓存系统。这样就可以避免在用户请求的时候，先查询数据库，然后再将数据缓存的问题。用户直接查询事先被预热的缓存数据。

解决办法：

1. 数据量不大的时候，工程启动的时候进行加载缓存动作；
2. 数据量大的时候，设置一个定时任务脚本，进行缓存的刷新；
3. 数据量太大的时候，优先保证热点数据进行提前加载到缓存

# 缓存穿透

缓存穿透是指用户查询数据，在数据库没有，自然在缓存中也不会有。这样就导致用户查询的时候，在缓存中找不到对应key的value，每次都要去数据库再查询一遍，然后返回空（相当于进行了两次无用的查询）。这样请求就绕过缓存直接查数据库

解决办法：

1. 缓存空对象： 简单粗暴的方法，如果一个查询返回的数据为空（不管是数据不存在，还是系统故障），我们仍然把这个空结果进行缓存，但它的过期时间会很短，最长不超过五分钟。
2. 布隆过滤器： 占用内存空间很小，位存储；性能特别高，使用key的hash判断key存不存在将所有可能存在的数据哈希到一个足够大的bitmap中，一个一定不存在的数据会被 这个bitmap拦截掉，从而避免了对底层存储系统的查询压力

### 缓存降级

降级的情况，就是缓存失效或者缓存服务挂掉的情况下，我们也不去访问数据库。我们直接访问内存部分数据缓存或者直接返回默认数据。

### 缓存击穿


缓存击穿是指缓存中没有但数据库中有的数据（一般是缓存时间到期），这时由于并发用户特别多，同时读缓存没读到数据，又同时去数据库去取数据，引起数据库压力瞬间增大，造成过大压力

解决办法：

1. 使用互斥锁：  如果是单机，可以用synchronized或者lock来处理，如果是分布式环境可以用分布式锁就可以了（分布式锁，可以用memcache的add, redis的setnx, zookeeper的添加节点操作）。
2. "永远不过期"
3. 缓存屏障
```java
// example
class MyCache {
    private ConcurrentHashMap < String, String > map;
    private CountDownLatch countDownLatch;
    private AtomicInteger atomicInteger;
    public MyCache(ConcurrentHashMap < String, String > map, CountDownLatch countDownLatch, AtomicInteger atomicInteger) {
        this.map = map;
        this.countDownLatch = countDownLatch;
        this.atomicInteger = atomicInteger;
    }

    public String get(String key) {
        String value = map.get(key);
        if (value != null) {
            System.out.println(Thread.currentThread().getName() + "\t 线程获取value值 value=" + value);
            return value;
        } 
        // 如果没获取到值
        // 首先尝试获取token，然后去查询db，初始化化缓存；
        // 如果没有获取到token，超时等待
        if (atomicInteger.compareAndSet(0, 1)) {
            System.out.println(Thread.currentThread().getName() + "\t 线程获取token");
            return null;
        } 
        // 其他线程超时等待
        try {
            System.out.println(Thread.currentThread().getName() + "\t 线程没有获取token，等待中。。。");
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } // 初始化缓存成功，等待线程被唤醒
        // 等待线程等待超时，自动唤醒    
        System.out.println(Thread.currentThread().getName() + "\t 线程被唤醒，获取value =" + map.get("key"));
        return map.get(key);
    }

    public void put(String key, String value) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        map.put(key, value); // 更新状态 
        atomicInteger.compareAndSet(1, 2); // 通知其他线程      
        countDownLatch.countDown();
        System.out.println();

        System.out.println(Thread.currentThread().getName() + "\t 线程初始化缓存成功！value =" + map.get("key"));
    }
}

class MyThread implements Runnable {
    private MyCache myCache;
    public MyThread(MyCache myCache) {
        this.myCache = myCache;
    }
    @Override public void run() {
        String value = myCache.get("key");
        if (value == null) {
            myCache.put("key", "value");
        }
    }
}

public class CountDownLatchDemo {
    public static void main(String[] args) {
        MyCache myCache = new MyCache(new ConcurrentHashMap < > (), new CountDownLatch(1), new AtomicInteger(0));
        MyThread myThread = new MyThread(myCache);
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            executorService.execute(myThread);
        }
    }
}
```


TODO: 主从复制


TODO: 分布式锁

http://redisbook.com/



**Docker Redis command opt**


```sh
# run
docker run -itd --name redis-test -p 6379:6379 redis
# connect
docker exec -it redis-test /bin/bash

# 默认 dump.rdb在容器的 "/data/dump.rdb"中

# 从容器拷贝文件到宿主机
docker cp redis-test:/data/dump.rdb ./

# 解析rdb文件
pip3 install rdbtools python-lzf
rdb --command json dump.rdb > dump.json
rdb -c memory dump.rdb > dump.csv

# copy aof文件
docker cp redis-test:/data/appendonly.aof ./

# aof
bgrewriteaof

npm install -g waoffle
cat appendonly.aof | waoffle > appendonly.sh

redis-check-aof --fix appendonly.aof
```
