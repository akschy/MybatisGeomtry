package typehandler;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.locationtech.jts.geom.MultiPolygon;

@MappedTypes(MultiPolygon.class)
@MappedJdbcTypes(JdbcType.BLOB)
public class WKBMultiPolygonTypeHandler extends WKBBaseTypeHandler<MultiPolygon> {
}
