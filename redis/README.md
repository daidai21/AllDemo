# Docker Redis command opt

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
