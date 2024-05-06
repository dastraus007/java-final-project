package primitives;
//The class represents a Ray
/*************************************************
the  class Ray
Representing a marble beam from a vector point
_POO=the start of the ray
_direction=the Vector of the ray
**************************************************/

public class Ray {
    // Point of _POO
    private Point3D _POO;
    // Ray direction
    private Vector direction;

    // ***************** Constructors ********************** //
    /*************************************************
	the Constructor function Ray 
	is get non
	It sends the variables to diffuse constructors
	**************************************************/
	
    public Ray(){
        _POO=new Point3D();
        direction=new Vector();
    }
    /*************************************************
	the Constructor function Ray 
	is get non
	It sends the variables to diffuse constructors
	**************************************************/
	
    public Ray(Ray ray){
        _POO=new Point3D(ray._POO);
        direction=new Vector(ray.direction);
    }
    /*************************************************
	the Constructor function Ray 
	is get non
	It sends the variables to diffuse constructors
	**************************************************/
	
    public Ray(Point3D p, Vector d){
        _POO=new Point3D(p);
        direction=new Vector(d);
    }

    // ***************** Getters/Setters ********************** //
    
    /*************************************************
	the name  setPOO
	get the _POO
	**************************************************/
	public void set_POO(Point3D p){
        _POO=new Point3D(p);
    }
	/*************************************************
	the name  setDirection
	get the _direction
	**************************************************/
	public void setDirection(Vector d){
        direction=new Vector(d);
    }
	/*************************************************
	the name  getDirection
	return the _direction
	**************************************************/
	public Vector getDirection(){
        return new Vector(direction);
    }
	/*************************************************
	the name  getPOO
	return the _POO
	**************************************************/
	public Point3D getPOO(){
        return new Point3D(_POO);
    }


}
