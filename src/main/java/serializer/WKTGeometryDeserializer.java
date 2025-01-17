package serializer;

import org.locationtech.jts.geom.Geometry;

public class WKTGeometryDeserializer extends WKTBaseDeserializer<Geometry> {

    public final static WKTGeometryDeserializer instance = new WKTGeometryDeserializer();
}
