package typehandler;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.locationtech.jts.geom.LineString;

@MappedTypes(LineString.class)
@MappedJdbcTypes(JdbcType.BLOB)
public class WKBLineStringTypeHandler extends WKBBaseTypeHandler<LineString> {

}
