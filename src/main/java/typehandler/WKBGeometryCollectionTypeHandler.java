package typehandler;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.locationtech.jts.geom.GeometryCollection;

@MappedTypes(GeometryCollection.class)
@MappedJdbcTypes(JdbcType.BLOB)
public class WKBGeometryCollectionTypeHandler extends WKBBaseTypeHandler<GeometryCollection> {

}
