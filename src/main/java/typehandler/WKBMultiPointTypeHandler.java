package typehandler;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.locationtech.jts.geom.MultiPoint;
import org.locationtech.jts.geom.Point;

@MappedTypes(MultiPoint.class)
@MappedJdbcTypes(JdbcType.BLOB)
public class WKBMultiPointTypeHandler extends WKBBaseTypeHandler<MultiPoint> {

}
