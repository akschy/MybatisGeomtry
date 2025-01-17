package serializer;

import org.locationtech.jts.geom.Point;

public class WKTPointDeserializer extends WKTBaseDeserializer<Point> {

    public final static WKTPointDeserializer instance = new WKTPointDeserializer();

}
