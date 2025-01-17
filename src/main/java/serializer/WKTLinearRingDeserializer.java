package serializer;

import org.locationtech.jts.geom.LinearRing;

public class WKTLinearRingDeserializer extends WKTBaseDeserializer<LinearRing> {

    public final static WKTLinearRingDeserializer instance = new WKTLinearRingDeserializer();

}
