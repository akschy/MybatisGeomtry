package serializer;

import org.locationtech.jts.geom.GeometryCollection;

public class WKTGeometryCollectionDeserializer extends WKTBaseDeserializer<GeometryCollection> {

    public final static WKTGeometryCollectionDeserializer instance = new WKTGeometryCollectionDeserializer();
}
