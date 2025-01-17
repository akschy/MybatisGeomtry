package serializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.locationtech.jts.geom.Geometry;
import utils.GeomUtil;

import java.io.IOException;

public class WKTBaseDeserializer<T extends Geometry> extends JsonDeserializer<T> {

    @Override
    public T deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        return GeomUtil.WKTToGeom(p.getText());
    }
}
