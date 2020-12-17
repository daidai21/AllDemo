

运行
`docker run -itd --name redis-test -p 6379:6379 redis`


进入redis交互界面
`docker run -it --link redis-test:redis --rm redis redis-cli -h redis -p 6379`
`docker exec -it  redis-test bash`

