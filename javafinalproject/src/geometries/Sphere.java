package geometries;

import primitives.*;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Sphere extends RadialGeometry{

    private Point3D _center;

    // ***************** Constructors ********************** //
    /*************************************************
	the Constructor function Sphere 
	is get non
	It sends the variables to diffuse constructors
	**************************************************/
    public Sphere(){
        super();
        _center=new Point3D();
    }
    /*************************************************
	the Constructor function Sphere 
	is get non
	It sends the variables to diffuse constructors
	**************************************************/
    public Sphere (Sphere sphere){
        super(sphere.getRadius(), sphere.get_emmission(), sphere.get_nShininess(), sphere.get_material());
        _center=new Point3D(sphere._center);
    }
    /*************************************************
	the Constructor function Sphere 
	It is get cylinder They change
He sends the variables to the constructors and sends them all in contention
	**************************************************/
    public Sphere(double radius, Point3D center, Color color, double shininess, Material material){
        super(radius, color, shininess, material);
        _center=new Point3D(center);
    }
    public Sphere(Map<String, String> attributes){}

    // ***************** Getters/Setters ********************** //
    /*************************************************
	the name  getRadius
	Returns the _radius
	**************************************************/
    public Point3D getCenter(){
        return new Point3D(_center);
    }
    /*************************************************
	the name  setCenter
	get the center
	**************************************************/
    public void setCenter(Point3D center){
        _center=new Point3D(center);
    }

    // ***************** Operations ******************** //
    /*************************************************
	the name  FindIntersections
	The function returns the damage points of the beam 
	
  
  O=The ball
  p0
  tmp=p0 by vec
  vv=v in the ray
  l=/L=o-tmp
  Tm=/tm=l*v
  d=d=l^2-tm^2
  res=list
  t1=Tm-Th;
  t2=Tm+Th;
  v=vv
  p1,p2=Intersections
  
	**************************************************/
    @Override
    public List<Point3D> FindIntersections(Ray ray){
        ArrayList<Point3D> list =new ArrayList<Point3D>();
        Vector L=new Vector(_center);//get the center
        L.subtract(new Vector(ray.getPOO()));//subtract the center with the root of the ray
        double tm=L.dotProduct(ray.getDirection());//get the angel between the direction and the result of the subtraction
        double d=Math.sqrt(L.dotProduct(L)-tm*tm);//d=l^2-tm^2
        if(d>_radius)return list;//if there is no interaction return empty list
        double th=Math.sqrt(_radius*_radius-d*d);//this._radius^2-d^2
        double t1=tm-th;
        double t2=tm+th;
        Vector V=new Vector(ray.getDirection());
        if(t1>=0){//one interaction 
            Point3D p1=new Point3D(ray.getPOO());//v
            V.scale(t1);//v*t1
            p1.add(V);//p0+v
            list.add(p1);}//add the interaction
        if(t2>=0){//anther interaction 
            Point3D p2=new Point3D(ray.getPOO());//v
            V=new Vector(ray.getDirection());//The direction the the ray
            V.scale(t2);//v*t2
            p2.add(V);//p0+v
            list.add(p2);}//add the interaction
        return list;
    }
    /*************************************************
	the name  getNormal
	The function returns Normal in the Geometry
	
   Tighten the receptor received point-_center
    N the normal
	**************************************************/
    @Override
    public Vector getNormal(Point3D point){
        Vector v=new Vector(point);//point-_center
        v.subtract(new Vector(_center));
        v.normalize();//normalize n
        return new Vector(v);//return the normal
    }
}
