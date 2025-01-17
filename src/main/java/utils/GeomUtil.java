package utils;

import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.PrecisionModel;
import org.locationtech.jts.io.*;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

@SuppressWarnings("unchecked")
public class GeomUtil {

    public static String geomToWKT(Geometry geom) {
        return new WKTWriter().write(geom);
    }

    public static <T> T WKTToGeom(String wkt) {
        if (wkt == null || wkt.isEmpty()) {
            return null;
        }
        try {
            WKTReader reader = new WKTReader();
            Geometry geometry = reader.read(wkt);
            return (T) geometry;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] geomToWKB(Geometry geom) {
        int srid = geom.getSRID();
        byte[] bytes = new WKBWriter(2, ByteOrderValues.LITTLE_ENDIAN).write(geom);
        return ByteBuffer.allocate(bytes.length + 4)
                .order(ByteOrder.LITTLE_ENDIAN)
                .putInt(srid)
                .put(bytes)
                .array();
    }

    public static <T> T WKBToGeom(byte[] bytes) {
        if (bytes == null || bytes.length == 0) {
            return null;
        }

        ByteBuffer buffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN);
        int srid = buffer.getInt();
        byte[] geomBytes = new byte[buffer.remaining()];
        buffer.get(geomBytes);

        GeometryFactory geomFactory = new GeometryFactory(new PrecisionModel(), srid);
        WKBReader reader = new WKBReader(geomFactory);
        try {
            return (T) reader.read(geomBytes);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
