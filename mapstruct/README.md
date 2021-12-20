

### mapstruct和lombok合用

### 字段映射

```java
@Mapper
public interface Converter {
    Converter INSTANCE = Mappers.getMapper(Converter.class);

    @Mapping(source = "numberOfSeats", target = "seatCount")
    CarDTO to(Car car);
}
```


### 多字段映射


```java
@Mapper
public interface CarConverter {
    CarConverter INSTANCE = Mappers.getMapper(CarConverter.class);

    @Mapping(source = "numberOfSeats", target = "seatCount")
    @Mapping(target = "make", source = "make", ignore = true, defaultValue = "asd")
    CarDTO carToCarDto(Car car);
}


@Mapper
interface Converter {
    Converter INSTANCE = Mappers.getMapper(Converter.class);

    @Mappings({
            @Mapping(source = "numberOfSeats", target = "seatCount"),
            @Mapping(target = "make", source = "make", ignore = true, defaultValue = "asd")
    })
    CarDTO carToCarDto(Car car);
}
```

### 多层嵌套映射

```java
@Mapper
public interface MultiLevelConverter {
    MultiLevelConverter INSTANCE = Mappers.getMapper(MultiLevelConverter.class);

    @Mappings({
            @Mapping(source = "teacher.wife.name", target = "name"),
            @Mapping(source = "student.age", target = "age")
    })
    StudentDTO toDTO(Student student, Teacher teacher);
}
```

### 更新现有的Bean

```java

@Mapper
public interface UpdateBeanConverter {
    UpdateBeanConverter INSTANCE = Mappers.getMapper(UpdateBeanConverter.class);

    void toDTO(Student student,
               @MappingTarget StudentDTO studentDTO);
}

```


### 映射器工厂


```java
@Mapper
public interface Converter {
    Converter INSTANCE = Mappers.getMapper(Converter.class);

}
```

### 依赖注入


```java
@Mapper(componentModel = "spring")
public interface Converter {
    Converter INSTANCE = Mappers.getMapper(Converter.class);

}
```

### 数据类型转换

TODO

### 映射集合

### 映射枚举


TODO: https://blog.csdn.net/qq_40194399/article/details/110162124
TODO: 常用的都在这里了


TODO: https://github.com/mapstruct/mapstruct-examples

===


[java doc](https://mapstruct.org/documentation/stable/api/)

* `@Mapper`
* `@Mapping`
* `@Mappings`
* `@MappingTarget`

```java
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

```
