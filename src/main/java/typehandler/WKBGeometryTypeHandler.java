package typehandler;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.locationtech.jts.geom.Geometry;

/**
 * 在mybatis 的xml中所有继承Geometry的形状都可以直接使用这个 TypeHandler
 *
 * @author haocvg
 * @since 2025/1/17
 */
@MappedTypes(Geometry.class)
@MappedJdbcTypes(JdbcType.BLOB)
public class WKBGeometryTypeHandler extends WKBBaseTypeHandler<Geometry> {

}
