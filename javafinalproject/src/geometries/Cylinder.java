package geometries;

import primitives.*;
import java.awt.Color;
import java.awt.*;
import java.util.List;

/*************************************************
the class Cylinder is extends the class RadialGeometry

It has two variables _axisPoint and _axisDirection

_axisPoint that he Point3D 
Which symbolizes the base point

_axisDirection  that he Vector
It symbolizes the vector of Cylinder
(There is a picture that explains this in a tangible way in presentations)
**************************************************/
public class Cylinder extends RadialGeometry{

    private Point3D _axisPoint;
    private Vector _axisDirection;

    // ***************** Constructors ********************** //
    /*************************************************
	the Constructor function Cylinder 
	is get non
	It sends the variables to diffuse constructors
	**************************************************/
    public Cylinder(){
        super();
        _axisDirection=new Vector();
        _axisPoint=new Point3D();
    }
    /*************************************************
	the Constructor function Cylinder 
	It is get cylinder cable
He sends the variables to the constructors and sends them all in contention
	**************************************************/
    public Cylinder(Cylinder cylinder){
        super(cylinder.getRadius(), cylinder.get_emmission(), cylinder.get_nShininess(), cylinder.get_material());
        _axisPoint=new Point3D(cylinder.getAxisPoint());
        _axisDirection=new Vector(cylinder.getAxisDirection());
    }
    /*************************************************
	the Constructor function Cylinder 
	It is get cylinder They change
He sends the variables to the constructors and sends them all in contention
	**************************************************/
    public Cylinder(double radius, Point3D axisPoint, Vector axisDirection, Color color, Double shininess, Material material){
        super(radius, color, shininess, material);
        _axisPoint=new Point3D(axisPoint);
        _axisDirection=new Vector(axisDirection);
    }

    // ***************** Getters/Setters ********************** //
    /*************************************************
	the name  getAxisPoint
	Returns the _axisPoint
	**************************************************/
    public Point3D getAxisPoint(){
        return new Point3D(_axisPoint);
    }
    /*************************************************
	the name  getAxisDirection
	Returns the _axisDirection
	**************************************************/
    public Vector getAxisDirection(){
        return new Vector(_axisDirection);
    }
    /*************************************************
	the name  axisDirection
	get the axisPoint
	**************************************************/
    public void setAxisPoint(Point3D axisPoint){
        _axisPoint=new Point3D(axisPoint);
    }
    /*************************************************
	the name  setAxisDirection
	get the axisDirection
	**************************************************/
    public void setAxisDirection(Vector axisDirection){
        _axisDirection=new Vector(axisDirection);
    }

    // ***************** Operations ******************** //
    /*************************************************
	Not realized in this Gaumatri
	**************************************************/
    @Override
    public List<Point3D> FindIntersections(Ray ray){
        throw new UnsupportedOperationException("Not supported yet");
    }
    /*************************************************
	Not realized in this
	**************************************************/
    @Override
    public Vector getNormal(Point3D point){
        double a=point.getX().get_coordinate();
        double b=point.getY().get_coordinate();
        double c=point.getZ().get_coordinate();
        double x=_axisDirection.getHead().getX().get_coordinate();
        double y=_axisDirection.getHead().getY().get_coordinate();
        double z=_axisDirection.getHead().getZ().get_coordinate();
        double t=(a*x+b*y+c*z)/(x*x+y*y+z*z);
        Vector temp=new Vector(_axisDirection);
        temp.scale(t);
        Vector normal=new Vector(point);
        normal.subtract(temp);
        normal.normalize();
        return normal;
    }
}
