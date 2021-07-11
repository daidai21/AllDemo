

===
#{} ${}

#{}是预编译处理，$ {}是字符串替换。

MyBatis在处理#{}时，会将SQL中的#{}替换为?号，使用PreparedStatement的set方法来赋值；MyBatis在处理 $ { } 时，就是把 ${ } 替换成变量的值。

使用 #{} 可以有效的防止SQL注入，提高系统安全性。

https://www.cnblogs.com/liaowenhui/p/12217959.html

===

解决Mybatis当实体类中的属性名和表中的字段名不一致的问题

https://blog.csdn.net/qq_17623363/article/details/104664590

1. 可以通过在查询的SQL语句中定义字段的别名，让字段名的别名和实体类的属性名一致。

```xml
<select id="getUserById" parameterType="int" resultType="cn.truedei.entity.OsEntity">
    select filesystem Filesystem,used Used where mounted = #{Mounted}
</select>
```

2. 通过来映射字段名和实体类属性名的一 一对应的关系。

```xml
<resultMap id="osEntityMap" type="cn.truedei.entity.OsEntity">
    <!--用<id></id>标签映射主键字段  property（被映射的）：实体类中的，column（映射的）：数据表中的-->
    <id property="Mounted" column="mounted"/>
    <!--用<result>映射非主键字段，-->
    <result property="Filesystem" column="filesystem"/>
    <result property="Used" column="used"/>
</resultMap>

```

===

MyBatis 模糊查询

直接传参法  java代码中拼接好 "%keyWord%"

CONCAT()函数  sql中拼接 CONCAT('%', #{keyWord}, '%')

bind标签
```java
List<BLOG> selectBykeyWord(@Param("keyword") String keyword);
```

```xml
<select id="selectBlogsLike" resultType="Blog">
  <bind name="pattern" value="'%' + keyword + '%'" />
  SELECT * 
  FROM BLOG
  WHERE title LIKE #{pattern}
</select>
```

https://mybatis.org/mybatis-3/zh/dynamic-sql.html

===

Mybatis批量插入数据

批量foreach插入

https://mybatis.org/mybatis-3/zh/dynamic-sql.html

https://segmentfault.com/a/1190000021290975

===

MyBatis + MySQL返回插入成功后的主键id

useGeneratedKeys="true" keyProperty="id"

https://www.cnblogs.com/han-1034683568/p/8305122.html

https://mybatis.org/mybatis-3/zh/sqlmap-xml.html

===

MyBatis

同一个 namespace下id不可以重复，不同namespace下id可以重复

===

MyBatis

https://tech.meituan.com/2018/01/19/mybatis-cache.html


clear / update / delete / insert

增删改操作就会失效
