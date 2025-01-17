package typehandler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.locationtech.jts.geom.Geometry;
import utils.GeomUtil;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class WKBBaseTypeHandler<T extends Geometry> extends BaseTypeHandler<T> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, T parameter, JdbcType jdbcType) throws SQLException {
        // 矢量数据存储方式为WKB
        // 确保 byte[] 数据以二进制形式插入到数据库中
        ps.setBytes(i, GeomUtil.geomToWKB(parameter));
    }

    @Override
    public T getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return GeomUtil.WKBToGeom(rs.getBytes(columnName));
    }

    @Override
    public T getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return GeomUtil.WKBToGeom(rs.getBytes(columnIndex));
    }

    @Override
    public T getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return GeomUtil.WKBToGeom(cs.getBytes(columnIndex));
    }
}
