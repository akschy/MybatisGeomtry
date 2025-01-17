package serializer;

import org.locationtech.jts.geom.Polygon;

public class WKTPolygonDeserializer extends WKTBaseDeserializer<Polygon> {

    public final static WKTPolygonDeserializer instance = new WKTPolygonDeserializer();
}
