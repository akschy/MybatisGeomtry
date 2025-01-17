package typehandler;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.locationtech.jts.geom.LineString;
import org.locationtech.jts.geom.LinearRing;

@MappedTypes(LinearRing.class)
@MappedJdbcTypes(JdbcType.BLOB)
public class WKBLinearRingTypeHandler extends WKBBaseTypeHandler<LinearRing> {

}
