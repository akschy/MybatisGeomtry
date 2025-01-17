package serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.locationtech.jts.geom.Geometry;
import utils.GeomUtil;

import java.io.IOException;

/**
 * WKT 的序列化只需要统一调用 形状序列化即可
 *
 * @author haocvg
 * @since 2025/1/17
 */
public class WKTGeometrySerializer extends JsonSerializer<Geometry> {

    public final static WKTGeometrySerializer instance = new WKTGeometrySerializer();

    @Override
    public void serialize(Geometry value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeString(GeomUtil.geomToWKT(value));
    }
}
