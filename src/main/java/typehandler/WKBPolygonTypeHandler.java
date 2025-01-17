package typehandler;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.locationtech.jts.geom.Polygon;

@MappedTypes(Polygon.class)
@MappedJdbcTypes(JdbcType.BLOB)
public class WKBPolygonTypeHandler extends WKBBaseTypeHandler<Polygon> {

}
