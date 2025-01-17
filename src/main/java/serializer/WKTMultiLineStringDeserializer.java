package serializer;

import org.locationtech.jts.geom.MultiLineString;

public class WKTMultiLineStringDeserializer extends WKTBaseDeserializer<MultiLineString> {

    public final static WKTMultiLineStringDeserializer instance = new WKTMultiLineStringDeserializer();

}
