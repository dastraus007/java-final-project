/*package geometries;

import primitives.Coordinate;
import primitives.Point3D;
import primitives.Vector;

public class IntersectionRecord {
    public final Point3D location = new Point3D();
    public final Vector normal = new Vector();
    public Plane plane = null;
    public double t = 0.0D;

    public IntersectionRecord() {
    }

    public void set(IntersectionRecord inRecord) {
        this.location.setX(new Coordinate(inRecord.location.getX()));
        this.location.setY(new Coordinate(inRecord.location.getY()));
        this.location.setZ(new Coordinate(inRecord.location.getZ()));
        this.normal.setHead(new Point3D(inRecord.normal.getHead()));
        this.plane = inRecord.plane;
        this.t = inRecord.t;
    }
}*/