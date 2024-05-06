package elements;

import primitives.Coordinate;
import primitives.Point3D;
import primitives.Vector;
import primitives.Ray;

import java.util.ArrayList;
import java.util.Map;
/*************************************************
the class class Camera

The camera realizes a camera like it really is

He has two crowns and one point

_P0=The point where the camera is placed
_vUp=The voter above
_vTo=And the cat that looked like a dummy
_vRight=Should be calculated as the cross product if vUp and vTo
**************************************************/
public class Camera {

    //Eye point of the camera
    private Point3D _P0;
    private Vector _vUp;
    private Vector _vTo;
    //Should be calculated as the cross product of vUp and vTo
    private Vector _vRight;

    // ***************** Constructors ********************** //
    /*************************************************
	the Constructor function Camera 
	is get non
	It sends the variables to diffuse constructors
	**************************************************/

    public Camera(){
        _P0 = new Point3D();
        _vUp = new Vector(new Point3D(new Coordinate(),new Coordinate(1),new Coordinate()));
        _vTo = new Vector(new Point3D(new Coordinate(),new Coordinate(),new Coordinate(-1)));
        _vRight = new Vector(new Point3D(new Coordinate(1),new Coordinate(),new Coordinate()));
    }
    /*************************************************
	the Constructor function Camera 
	It is get cylinder cable
He sends the variables to the constructors and sends them all in contention
	**************************************************/
	
    public Camera (Camera camera){
        _P0 = new Point3D(camera.getP0());
        _vUp = new Vector(camera.get_vUp());
        _vTo=new Vector(camera.get_vTo());
        Vector v=new Vector(_vUp);
        v.cross(new Vector(_vTo));
        _vRight = new Vector(v);
    }
    /*************************************************
	
    the Constructor function Camera 
	It is get cylinder They change
He sends the variables to the constructors and sends them all in contention
	**************************************************/
	
    public Camera (Point3D P0, Vector vUp, Vector vTo){
        _P0 = new Point3D(P0);
        _vUp = new Vector(vUp);
        _vTo=new Vector(vTo);
        _vRight = new Vector(new Point3D(new Coordinate(1),new Coordinate(),new Coordinate()));
    }
    /*************************************************
	 * nothing
	**************************************************/
	
    public Camera (Map<String, String> attributes){}

    // ***************** Getters/Setters ********************** //
    /*************************************************
	the name  get_vUp
	Returns the _vUp
	**************************************************/
	
    public Vector get_vUp(){ return new Vector(_vUp);}
    /*************************************************
	the name  set_vUp
	get the vUp
	**************************************************/
	
    public void set_vUp(Vector vUp){ _vUp=new Vector(vUp);}
    /*************************************************
	the name  get_vTo
	Returns the _vTo
	**************************************************/
	
    public Vector get_vTo(){return new Vector(_vTo);}
    /*************************************************
	the name  set_vTo
	Returns the vTo
	**************************************************/
	
    public void set_vTo(Vector vTo){_vTo=new Vector(vTo);}
    /*************************************************
	the name  getP0
	Returns the _P0
	**************************************************/
	
    public Point3D getP0(){return new Point3D(_P0);}
    /*************************************************
	the name  setP0
	Returns the P0
	**************************************************/
	
    public void setP0(Point3D P0){_P0=new Point3D(_P0);}
    /*************************************************
	the name  get_vRight
	Returns the _vRight
	**************************************************/
	
    public Vector get_vRight(){return new Vector(_vRight);}

    // ***************** Administration ********************** //
    @Override
  //Camera vector to string
  	/*************************************************
  	the name  toString
  	Camera vector to string
  	**************************************************/

    public String toString(){
        return "Camera Origin: " + _P0 + " Up Vector: " + _vUp + " Right Vector: " + _vRight + " Fowards Vector: " + _vTo;
    }




    public Ray constructRayThroughPixel (int Nx, int Ny, double x, double y, double screenDist, double screenWidth, double screenHeight){
        Double Rx=screenWidth / Nx;//get the Ratio of the size to the pixel
        Double Ry=screenHeight / Ny;//get the Ratio of the size to the pixel
        Point3D center=new Point3D(_P0);//Get the center that the ray come form their
        Vector vRight=new Vector(_vRight);//the the vectors
        Vector vTo=new Vector(_vTo);//the the vectors
        Vector vUp=new Vector(_vUp);//the the vectors
        vTo.scale(screenDist);//t0*screenDist
        center.add(vTo);//p0+T0 
        vRight.scale(((x-Nx/2.0)*Rx) - Rx/2);//vr=Of the formula
        vUp.scale(((y-Ny/2.0)*Ry) - Ry/2);//vu=Of the formula
        vRight.subtract(vUp);//vr-vu
        center.add(vRight);//pc+vr
        Vector p=new Vector(_P0);//create a vector 
        center.subtract(p);//pc-p0
        Vector rayV=new Vector(center);//create a new vector o center
        rayV.normalize();//normalize it
        return new Ray(new Point3D(_P0), rayV);
    }
}

