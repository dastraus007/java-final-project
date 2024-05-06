package primitives;
//The class represents and Vector and assists a point in three dimensions

public class Vector{//The head of the vector(the point that the vector start from)
    private Point3D _head;

    // ***************** Constructors ********************** //
    /*************************************************
	* FUNCTION
	* Default Constructor
	* PARAMETERS
	* ---
	* RETURN VALUE
	* ---
	* MEANING
	* Set the head of the vector with a new point with a default value.
	* See also Point3D() , Vector(Point3D head) , Vector(Vector vector).
	**************************************************/
	 public Vector() { _head=new Point3D();}
	 /*************************************************
		* FUNCTION
		* Copy Constructor
		* PARAMETERS
		* Vector � object to copy.
		* RETURN VALUE
		* ---
		* MEANING
		* Copy the parameter to our object.
		* SEE ALSO
		* Vector(Point3D p1, Point3D p2) , Vector(double xHead, double yHead, double zHead), Point3D(double x, double y, double z), Point3D() Point3D(Coordinate x, Coordinate y, Coordinate z), Point2D(), Point2D(Coordinate x, Coordinate y)
		**************************************************/
		
    public Vector(Vector v) {
        _head=new Point3D(v.getHead());
    }

    /*************************************************
	* FUNCTION
	* Constructor
	* PARAMETERS
	* double x , y , Z � value of coordinate to set on head point.
	* RETURN VALUE
	* ---
	* MEANING
	* Set the head point with the value of the parameters.
	* SEE ALSO
	* Point2D(), Point2D(Point2D point2D), Coordinate(Coordinate coordinate) , Point3D().
	**************************************************/
	 public Vector(double x,double y,double z) {
        _head=new Point3D(x, y, z);
    }

    /*************************************************
	* FUNCTION
	* Constructor
	* PARAMETERS
	* Point3D � the value to set on the head of the vector.
	* RETURN VALUE
	* ---
	* MEANING
	* Set the head of the vector with the value of the parameter.
	* SEE ALSO
	* Point3D(Point3D), Vector(Point3D head) , Vector(Vector vector).
	**************************************************/
	 public Vector (Point3D head){
        _head=new Point3D(head);
   }
	 /*************************************************
		* FUNCTION
		* Constructor
		* PARAMETERS
		* Points � the value to set on the point.
		* RETURN VALUE
		* ---
		* MEANING
		* Set the point with the substaction.
		* SEE ALSO
		* Point2D(), Point2D(Point2D point2D), Coordinate(Coordinate coordinate) , Point3D().
		**************************************************/
		
    public Vector (Point3D p1, Point3D p2){
       p2.getX().subtract(p1.getX());
       p2.getY().subtract(p1.getY());
       p2.getZ().subtract(p1.getZ());
       _head=new Point3D(p2);
    }

    // ***************** Getters/Setters ********************** //
    /*************************************************
	* FUNCTION
	* getHead
	* PARAMETERS
	* ---
	* MEANING
	* Return the value of the coordinate Z.
	* SEE ALSO
	* getY() , setX(Coordinate _x) , setY(Coordinate _y) , getX() , setZ(Coordinate _z).
	**************************************************/
	
    public Point3D getHead(){
        return new Point3D(_head);
    }

    /*************************************************
	* FUNCTION
	* setHead
	* PARAMETERS
	* coordinate � the value to set on the coordinate Z.
	* RETURN VALUE
	* ---
	* MEANING
	* Set the coordinate with the value of the parameters.
	* SEE ALSO
	* getX() , getY() , setY(Coordinate _y).
	**************************************************/
	 public void setHead(Point3D head){
        _head=new Point3D(head);
    }

           // ***************** Administration ******************** //
	 /*************************************************
		* FUNCTION
		* compareTo
		* PARAMETERS
		* Point3D � the point to compareTo
		* RETURN VALUE
		* if the point are equal return 0
		* else return 1.
		* MEANING
		* compare the two points.
		* SEE ALSO
		**************************************************/

        public int compareTo(Vector vector){
            vector.normalize();
            this.normalize();
            return this._head.compareTo(vector._head);
        }
      //Converts vector to string
    	/*************************************************
    	* FUNCTION
    	* toString
    	* RETURN VALUE
    	* A string that contain the values of the coordinate
    	* MEANING
    	* Convert the point to string and return it
    	* SEE ALSO
    	* 
    	**************************************************/
    	
    // return a string representation of the vector
        public String toString() {
            return _head.toString();
        }
    // ***************** Operations ******************** //
    // return this + v
      //add Vector to vector
    	/*************************************************
    	* FUNCTION
    	* add
    	* PARAMETERS
    	* Vector � vector the add the point to the head of this vector
    	* RETURN VALUE
    	* ---
    	* MEANING
    	* Add to our point the head point of the vector
    	* SEE ALSO
    	*subtract(Vector vector)
    	**************************************************/
    public void add(Vector v) {
        _head.add(v);
    }

  //subtract Vector to vector
  	/*************************************************
  	* FUNCTION
  	* add
  	* PARAMETERS
  	* Vector � vector the subtract the point to the head of this vector
  	* RETURN VALUE
  	* ---
  	* MEANING
  	* subtract to our point the head point of the vector
  	* SEE ALSO
  	*add(Vector vector)
  	**************************************************/
  	public void subtract(Vector v) {
  		_head.subtract(v);
  	}
  //subtract Vector to vector
  	/*************************************************
  	* FUNCTION
  	* scale
  	* PARAMETERS
  	* Vector � vector the subtract the point to the head of this vector
  	* RETURN VALUE
  	* ---
  	* MEANING
  	* scale to our  vectors
  	* SEE ALSO
  	*add(Vector vector)
  	**************************************************/
  	
    // create and return a new object whose value is (this * factor)
    public void scale(double factor) {
        _head.setX(new Coordinate(_head.getX().get_coordinate()*factor));
        _head.setY(new Coordinate(_head.getY().get_coordinate()*factor));
        _head.setZ(new Coordinate(_head.getZ().get_coordinate()*factor));
    }
    /*************************************************
  	* FUNCTION
  	* cross
  	* PARAMETERS
  	* Vector � vector the subtract the point to the head of this vector
  	* RETURN VALUE
  	* ---
  	* MEANING
  	* cross to our  vectors
  	* SEE ALSO
  	*add(Vector vector)
  	**************************************************/
  	
    public void cross(Vector v) {
        double x1=_head.getX().get_coordinate();
        double y1=_head.getY().get_coordinate();
        double z1=_head.getZ().get_coordinate();

        double x2=v.getHead().getX().get_coordinate();
        double y2=v.getHead().getY().get_coordinate();
        double z2=v.getHead().getZ().get_coordinate();

        _head.setX(new Coordinate(y1*z2-z1*y2));
        _head.setY(new Coordinate(-(x1*z2-z1*x2)));
        _head.setZ(new Coordinate(x1*y2-y1*x2));
    }

    /*************************************************
  	* FUNCTION
  	* length
  	* PARAMETERS
  	* ---
  	* RETURN VALUE
  	* double
  	* MEANING
  	* return the length
  	* SEE ALSO
  	*add(Vector vector)
  	**************************************************/
  	 public double length (){
        return Math.sqrt(Math.pow(_head.getX().get_coordinate(), 2)+Math.pow(_head.getY().get_coordinate(), 2)+Math.pow(_head.getZ().get_coordinate(), 2));
    }
  	 /*************************************************
   	* FUNCTION
   	* normalize
   	* PARAMETERS
   	* ---
   	* RETURN VALUE
   	* ---
   	* MEANING
   	* normalize the vector
   	* SEE ALSO
   	*add(Vector vector)
   	**************************************************/
   
    public void normalize(){
        double l = length();
        if (l == 0) /*throw new IllegalArgumentException("Length is equal to zero");*/
            return;
        _head.setX(new Coordinate(_head.getX().get_coordinate()/l));
        _head.setY(new Coordinate(_head.getY().get_coordinate()/l));
        _head.setZ(new Coordinate(_head.getZ().get_coordinate()/l));
    }
    /*************************************************
   	* FUNCTION
   	* dotProduct
   	* PARAMETERS
   	* ---
   	* RETURN VALUE
   	* double
   	* MEANING
   	* dotProduct
   	* SEE ALSO
   	*add(Vector vector)
   	**************************************************/
    // return the inner product of this Vector a and b
    public double dotProduct(Vector v) {
        double sum = 0.0;
        sum+= _head.getX().get_coordinate()*v.getHead().getX().get_coordinate();
        sum+= _head.getY().get_coordinate()*v.getHead().getY().get_coordinate();
        sum+= _head.getZ().get_coordinate()*v.getHead().getZ().get_coordinate();
        return sum;
    }



}
