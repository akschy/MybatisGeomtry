package typehandler;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.locationtech.jts.geom.Point;

@MappedTypes(Point.class)
@MappedJdbcTypes(JdbcType.BLOB)
public class WKBPointTypeHandler extends WKBBaseTypeHandler<Point> {

}
