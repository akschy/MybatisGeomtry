package serializer;

import org.locationtech.jts.geom.MultiPoint;

public class WKTMultiPointDeserializer extends WKTBaseDeserializer<MultiPoint> {

    public final static WKTMultiPointDeserializer instance = new WKTMultiPointDeserializer();

}
