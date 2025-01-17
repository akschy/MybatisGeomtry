package serializer;

import org.locationtech.jts.geom.MultiPolygon;

public class WKTMultiPolygonDeserializer extends WKTBaseDeserializer<MultiPolygon> {

    public final static WKTMultiPolygonDeserializer instance = new WKTMultiPolygonDeserializer();
}
