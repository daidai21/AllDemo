MapStruct是一种类型安全的bean映射类生成java注释处理器。


https://github.com/mapstruct/mapstruct


===

```java
public class Car {
    private String make;
    private int numberOfSeats;
    private CarType type;
}

static enum CarType {
    SEDAN
}
```
```java


public class CarDto {
    private String make;
    private int seatCount;
    private String type; 
}
```
```java


@Mapper
public interface CarMapper {
    CarMapper INSTANCE = Mappers.getMapper( CarMapper.class );
    @Mapping(source = "numberOfSeats", target = "seatCount")
    CarDto carToCarDto(Car car);
}
```

MapStruct是一个代码生成器，简化了不同的Java Bean之间映射的处理，所以映射指的就是从一个实体变化成一个实体。
