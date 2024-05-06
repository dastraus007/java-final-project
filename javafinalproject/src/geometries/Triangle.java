package geometries;

import primitives.*;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.awt.Color;
/*************************************************
the class Triangle
extends Geometry
 _p1, _p2, _p3 it the The vertices of the triangle
**************************************************/
public class Triangle extends Geometry implements FlatGeometry{
    private Point3D _p1;
    private Point3D _p2;
    private Point3D _p3;

    // ***************** Constructors ********************** //
    /*************************************************
	the Constructor function Triangle 
	is get non
	It sends the variables to diffuse constructors
	**************************************************/
    public Triangle(){
        super();
        _p1=new Point3D();
        _p2=new Point3D();
        _p3=new Point3D();
    }
    /*************************************************
	the Constructor function triangle 
	is get non
	It sends the variables to diffuse constructors
	**************************************************/
    public Triangle(Triangle triangle){
        super(triangle.get_emmission(), triangle.get_nShininess(), triangle.get_material());
        _p1=new Point3D(triangle.getP1());
        _p2=new Point3D(triangle.getP2());
        _p3=new Point3D(triangle.getP3());
    }
    /*************************************************
	the Constructor function Triangle 
	It is get cylinder They change
He sends the variables to the constructors and sends them all in contention
	**************************************************/
    public Triangle(Point3D p1, Point3D p2, Point3D p3, Color emission, double shininess, Material material){
        super(emission, shininess, material);
        _p1=new Point3D(p1);
        _p2=new Point3D(p2);
        _p3=new Point3D(p3);
    }
    /*************************************************
	the Constructor function Triangle 
	It is get cylinder They change
He sends the variables to the constructors and sends them all in contention
	**************************************************/
    public Triangle(Point3D p1, Point3D p2, Point3D p3){
        super();
        _p1=new Point3D(p1);
        _p2=new Point3D(p2);
        _p3=new Point3D(p3);
    }

    public Triangle(Map<String, String> attributes){
        super();
    }
    // ***************** Getters/Setters ********************** //
    /*************************************************
	the name  getP1
	Returns the _p1
	**************************************************/
    public Point3D getP1(){return new Point3D(_p1);}
    /*************************************************
	the name  getP2
	Returns the _p2
	**************************************************/
    public Point3D getP2(){return new Point3D(_p2);}
    /*************************************************
	the name  getP3
	Returns the _p3
	**************************************************/
    public Point3D getP3(){return new Point3D(_p3);}
    /*************************************************
	the name  setP1
	get the p1
	**************************************************/
    public void setP1(Point3D p1){_p1=new Point3D(p1);}
    /*************************************************
	the name  setP2
	get the p2
	**************************************************/
    public void setP2(Point3D p2){_p2=new Point3D(p2);}
    /*************************************************
	the name  setP3
	get the p3
	**************************************************/
    public void setP3(Point3D p3){_p3=new Point3D(p3);}

    // ***************** Operations ******************** //
    /*************************************************
	the name  getNormal
	The function returns Normal in the Geometry
	
    He calculates Normal with the points of the triangle. He calculates the ribs and pushes them down and extracts the norm
    U AND V The ribs of the tringl
    N the normal
	**************************************************/
    @Override
    public Vector getNormal(Point3D point){
        Vector v=new Vector(_p2);
        v.subtract(new Vector(_p1));//ribs of the tringl
        Vector w=new Vector(_p3);
        w.subtract(new Vector(_p1));//ribs of the tringl
        v.cross(w);//crossProduct to get N 
        v.normalize();//normalize
        return new Vector(v);//return the normal
    }
    /*************************************************
	the name  FindIntersections
	The function returns the damage points of the beam in Gaumetry
	
	it get a ray for see  The fund's damage to Gaumetri
	it return list of all the returns the points
  
  
  P0=is the camera p0
  n=the normal
  plane=the triangle include in him
  res=all the Intersections
 // injury=get the first Intersections in the list
  P0_P=get the first Intersections in the list-p0
  V1,V2,V3=get the The rib from p3,2,1-p0
  N1,N2,N3 =get the normal
  tmp1,tmp2,tmp3=see if all +/-
  res44=empty list  
	**************************************************/
    @Override
    public List<Point3D> FindIntersections(Ray ray){
        ArrayList<Point3D> list = new ArrayList<>();//will set with the result
        Vector n=new Vector(this.getNormal(_p1));//get the normal
        Plane plane=new Plane(n,_p1, get_emmission(), get_nShininess(), get_material());
        list=new ArrayList<>(plane.FindIntersections(ray));

        if(list.isEmpty())
            return list;//return empty list

        // Step 2: inside-outside test
        Vector C; // vector perpendicular to triangle's plane
        Vector P=new Vector(list.get(0));

        // edge 0
        Vector edge0 = new Vector(_p2);//get the edge of the triangle
        edge0.subtract(new Vector(_p1));//get the edge of the triangle
        Vector vp0 = new Vector(P);
        vp0.subtract(new Vector(_p1));//get the edge of the triangle
        edge0.cross(vp0);//get the edge of the triangle
        C = new Vector(edge0);//made a copy
        if (n.dotProduct(C) < 0) {
            list.clear();//clear the list
            return list;//return empty list
        }// P is on the right side

        // edge 1
        Vector edge1 = new Vector(_p3);
        edge1.subtract(new Vector(_p2));
        Vector vp1 = new Vector(P);//made a copy
        vp1.subtract(new Vector(_p2));
        edge1.cross(vp1);
        C = new Vector(edge1);//made a copy
        if (n.dotProduct(C) < 0)  {
            list.clear();//clear the list
            return list;//return empty list
        } // P is on the right side

        // edge 2
        Vector edge2 = new Vector(_p1);
        edge2.subtract(new Vector(_p3));
        Vector vp2 = new Vector(P);//made a copy
        vp2.subtract(new Vector(_p3));
        edge2.cross(vp2);
        C = new Vector(edge2);//made a copy
        if (n.dotProduct(C) < 0) {
            list.clear();//clear the list
            return list;//return empty list
        } // P is on the right side;

        return list; // this ray hits the triangle
        }
    }
