package typehandler;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.locationtech.jts.geom.MultiLineString;

@MappedTypes(MultiLineString.class)
@MappedJdbcTypes(JdbcType.BLOB)
public class WKBMultiLineStringTypeHandler extends WKBBaseTypeHandler<MultiLineString> {

}
