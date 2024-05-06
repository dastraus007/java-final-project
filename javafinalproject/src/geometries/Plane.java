package geometries;

import primitives.Point3D;
import primitives.Material;
import primitives.Ray;
import primitives.Vector;
import java.awt.Color;
import java.util.ArrayList;

import java.util.List;
/*************************************************
the class Plane
He inherits the Geometry and is also an exponent
_Q =Point of the Plane
_normal=the normal of the Plane
**************************************************/
public class Plane extends Geometry implements FlatGeometry{
    private Vector _normal;
    private Point3D _Q;

    // ***************** Constructors ********************** //
 	/*************************************************
 	the Constructor function Plane 
 	is get non
 	It sends the variables to diffuse constructors
 	**************************************************/
    public Plane(){
        super();
        _Q = new Point3D();
        _normal = new Vector();
    }

/*************************************************
	the Constructor function Plane 
	is get non
	It sends the variables to diffuse constructors
	**************************************************/
    public Plane (Plane plane){
        super(plane.get_emmission(), plane.get_nShininess(), plane.get_material());
        this._Q = new Point3D(plane._Q);
        this._normal = new Vector(plane._normal);
        this.set_emmission(new Color(plane.get_emmission().getRGB()));
        this.set_nShininess(plane.get_nShininess());
        this.set_material(new Material(plane.get_material()));
    }
    /*************************************************
	the Constructor function Plane 
	It is get Plane They change
He sends the variables to the constructors and sends them all in contention
	**************************************************/
    public Plane (Vector normal, Point3D q, Color color, double shininess, Material material){
        super(color, shininess, material);
        this._Q = new Point3D(q);
        this._normal = new Vector(normal);
    }

    // ***************** Getters/Setters ********************** //
    /*************************************************
	the name  getNormal
	The function returns Normal in the Geometry
	Returns the _normal
	**************************************************/
    @Override
    public Vector getNormal(Point3D point)
    {
        Vector normal = new Vector(_normal);//made a copy
        normal.normalize();//normalize the copy
        return normal;//return it
    }
    /*************************************************
	the name  getQ
	Returns the _Q
	**************************************************/
    public Point3D getQ(){return new Point3D(_Q);}
    /*************************************************
	the name  setNormal
	get the normal
	**************************************************/
    public void setNormal(Vector normal){this._normal=new Vector(normal);}
    /*************************************************
	the name  setQ
	get the d
	**************************************************/
    public void setQ(Point3D d){this._Q=new Point3D(d);}

    // ***************** Operations ******************** //
    /*************************************************
	the name  FindIntersections
	The function returns the damage points of the beam in 
	
  
  	P0=in the camera
  	Q0=point in the plan
  	N=normal in the plan
  	V=ray.v
  	v=p0-q0
  	tmp=-1 not
  	N1=normal in the plan
  	U1=p0(vec)
  	TMP=Intersections
  	res=list returning
	**************************************************/
    @Override
    public List<Point3D> FindIntersections(Ray ray){

        ArrayList list = new ArrayList();//the result
        Vector tmp=new Vector(ray.getPOO());//create a vector with the direction of the origin
        Vector direction=new Vector(ray.getDirection());//get the direction of the ray
        tmp.subtract(new Vector(_Q));//subtract the vector of the direction of the origin by vector of Q 
        double d1,d2,t;//Set with...

        //Find angle between plane and direction of ray
        d2 = _normal.dotProduct(direction);//the value of the angel between the plan and the ray

        //Is ray parallel to plane
        if (Math.abs(d2) < 0.00000001) {
            return list;
        }

        d1 = _normal.dotProduct(tmp);
        t = - (d1/d2);
        if (t>0) {//if it good (have a Intersections)
            direction.scale(t);//v-t
            Point3D p = new Point3D(ray.getPOO());
            p.add(direction);//p0+v
            list.add(p);//Intersections
        }
        return list;
    }
}
