package serializer;

import org.locationtech.jts.geom.LineString;

public class WKTLineStringDeserializer extends WKTBaseDeserializer<LineString> {

    public final static WKTLineStringDeserializer instance = new WKTLineStringDeserializer();

}
