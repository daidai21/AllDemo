
===

库存扣减

https://zhuanlan.zhihu.com/p/143866444

```sh
# run
docker run -itd --name mysql-test -p 3306:3306 -e MYSQL_ROOT_PASSWORD=123456 mysql
# enter
docker exec -it mysql-test /bin/bash
# login
mysql -uroot -p123456
```

```sql
create DATABASE ic;
use ic;

CREATE TABLE `goods` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `name` varchar(100) DEFAULT NULL,
    `stock` int(11) DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_name` (`name`) USING HASH
) ENGINE=InnoDB;

select * from goods;

INSERT INTO `goods` VALUES ('1', 'prod11', '1000');
INSERT INTO `goods` VALUES ('2', 'prod12', '1000');
INSERT INTO `goods` VALUES ('3', 'prod13', '1000');
INSERT INTO `goods` VALUES ('4', 'prod14', '1000');
INSERT INTO `goods` VALUES ('5', 'prod15', '1000');
INSERT INTO `goods` VALUES ('6', 'prod16', '1000');
INSERT INTO `goods` VALUES ('7', 'prod17', '1000');
INSERT INTO `goods` VALUES ('8', 'prod18', '1000');
INSERT INTO `goods` VALUES ('9', 'prod19', '1000');

select * from goods;

-- ********************排它锁/悲观锁方案********************
begin;
select * from goods where id = 1 for update;
update goods set stock = stock - 1 where id = 1;
commit;

-- ********************乐观锁方案********************
-- 不加锁获取 id=1 的商品对象
select * from goods where id = 1;
begin;
-- 更新 stock 值，这里需要注意 where 条件 “stock = cur_stock”，只有程序中获取到的库存量与数据库中的库存量相等才执行更新
update goods set stock = stock - 1 where id = 1 and stock = cur_stock;
commit;

-- CAS 版本号
update lock_table 
set version=new_version 
where version=current_version
```

https://zhuanlan.zhihu.com/p/143866444

redis 存储kv，实现 锁
