# mybatis对应mysql的Geometry类型的TypeHandler

## mybatis

```xml

<mapper namespace="com.domain.mapper.TestMapper">
    <resultMap id="resultObjectMap" type="com.domain.pojo.vo.TestVo">
        <result column="id" property="id"/>
        <result column="polygon" property="polygon" typeHandler="com.domain.typeHandler.WkbGeometryTypeHandler"/>
        <result column="point" property="point" typeHandler="com.domain.typeHandler.WkbGeometryTypeHandler"/>
        <result column="multi_polygon" property="multiPolygon"
                typeHandler="com.domain.typeHandler.WkbGeometryTypeHandler"/>
    </resultMap>
    <select id="selectFirst" resultMap="resultObjectMap">
        select id, polygon, point , multi_polygon
        from test
    </select>

    <insert id="insert">
        insert into test (id, polygon, point , multi_polygon) value
        (
        #{entity.id},
        #{entity.polygon     ,typeHandler=com.domain.typeHandler.WkbGeometryTypeHandler},
        #{entity.point       ,typeHandler=com.domain.typeHandler.WkbGeometryTypeHandler},
        #{entity.multiPolygon, typeHandler=com.domain.typeHandler.WkbGeometryTypeHandler}
        )
    </insert>
</mapper>
```

1. 在mybatis的xml 中可以指定所有继承`Geometry`类型的字段的`typeHandler`属性为`WKBGeometryTypeHandler`
2. 同时需要在`ResultMap`标签中指定字段映射的`typeHandler`属性为`WKBGeometryTypeHandler`

## mybatis-plus

```java

@TableName(value = "test", autoResultMap = true)
public class Test {

    @TableId
    private Long id;

    @TableField(value = "point", typeHandler = WKBPointTypeHandler.class)
    private Point point;

    @TableField(value = "point", typeHandler = WKBPolygonTypeHandler.class)
    private Polygon polygon;

    @TableField(value = "point", typeHandler = WKBMultiPolygonTypeHandler.class)
    private MultiPolygon multiPolygon;

}
```

1. 实体类中需要在`@TableName()`注解中指定`autoResultMap`属性为`true`
2. 对应的字段中指定`@TableField()`注解的`typeHandler`属性为对应类型的`TypeHandler`

## 序列化和反序列化

```java

@Bean
public ObjectMapper ObjectMapper() {
    ObjectMapper objectMapper = new ObjectMapper();
    // 形状序列化
    simpleModule.addSerializer(Geometry.class, GeometrySerializer.instance);
    simpleModule.addSerializer(Point.class, GeometrySerializer.instance);
    simpleModule.addSerializer(Polygon.class, GeometrySerializer.instance);
    simpleModule.addSerializer(MultiPolygon.class, GeometrySerializer.instance);

    simpleModule.addDeserializer(Geometry.class, GeometryDeserializer.instance);
    simpleModule.addDeserializer(Point.class, PointDeserializer.instance);
    simpleModule.addDeserializer(Polygon.class, PolygonDeserializer.instance);
    simpleModule.addDeserializer(MultiPolygon.class, MultiPolygonDeserializer.instance);

    objectMapper.registerModule(simpleModule);
    return objectMapper;
}

```

1. 在`ObjectMapper` 中添加 自定义序列化/反序列化类
2. 序列化时全部都使用`GeometrySerializer`
3. 反序列化需要根据不同的类型使用不同的`Deserializer`
