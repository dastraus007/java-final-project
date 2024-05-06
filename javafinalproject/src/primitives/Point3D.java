package primitives;

//The class represents a point in three dimensions The Department inherits from the class of the point in two dimensions and therefore the class has only one variable

public class Point3D extends Point2D {
    private Coordinate z;//the coordinate Y of the point

    // ***************** Constructors ********************** //
   
    /*************************************************
	* FUNCTION
	* Default Constructor
	* PARAMETERS
	* ---
	* RETURN VALUE
	* ---
	* MEANING
	* Set the point with a new Coordinate with a default value (zero).
	* See also  Coordinate() , Point3D(Coordinate x, Coordinate y, Coordinate z),Point2D(Coordinate x, Coordinate y), Point2D(Point2D point2D).
	**************************************************/
	public Point3D() {
		super();
        z=new Coordinate(0);
    }


	/*************************************************
	* FUNCTION
	* Constructor
	* PARAMETERS
	* Coordinate x, Coordinate y, Coordinate z – the value to set on the point.
	* RETURN VALUE
	* ---
	* MEANING
	* Set the point with the value of the parameters.
	* SEE ALSO
	* Point2D(), Point2D(Point2D point2D), Coordinate(Coordinate coordinate) , Point3D().
	**************************************************/
	
    public Point3D(Coordinate initX, Coordinate initY, Coordinate initZ) {
        x=new Coordinate(initX);
        y=new Coordinate(initY);
        z=new Coordinate(initZ);
    }
    /*************************************************
	* FUNCTION
	* Constructor
	* PARAMETERS
	* double x ,y, z – the value to set on the point.
	* RETURN VALUE
	* ---
	* MEANING
	* Set the point with the value of the parameters.
	* SEE ALSO
	* Point2D(), Point2D(Point2D point2D), Coordinate(Coordinate coordinate) , Point3D().
	**************************************************/
	
    public Point3D(double initX, double initY, double initZ) {
        x=new Coordinate(initX);
        y=new Coordinate(initY);
        z=new Coordinate(initZ);
    }
    /*************************************************
	* FUNCTION
	* Copy Constructor
	* PARAMETERS
	* Point2D – object to copy.
	* RETURN VALUE
	* ---
	* MEANING
	* Copy the parameter to our object.
	* SEE ALSO
	* Point3D(double x, double y, double z), Point3D() Point3D(Coordinate x, Coordinate y, Coordinate z), Point2D(), Point2D(Coordinate x, Coordinate y)
	**************************************************/
	
    public Point3D(Point3D point3D) {
        x=new Coordinate(point3D.getX());
        y=new Coordinate(point3D.getY());
        z=new Coordinate(point3D.getZ());
    }

    // ***************** Getters/Setters ********************** //
  //get Z Coordinate
  	/*************************************************
  	* FUNCTION
  	* getZ
  	* PARAMETERS
  	* ---
  	* MEANING
  	* Return the value of the coordinate Z.
  	* SEE ALSO
  	* getY() , setX(Coordinate _x) , setY(Coordinate _y) , getX() , setZ(Coordinate _z).
  	**************************************************/
  	
    public Coordinate getZ(){
        return new Coordinate(z);
    }
    //set Z Coordinate
	/*************************************************
	* FUNCTION
	* setZ
	* PARAMETERS
	* coordinate – the value to set on the coordinate Z.
	* RETURN VALUE
	* ---
	* MEANING
	* Set the coordinate with the value of the parameters.
	* SEE ALSO
	* getX() , getY() , setY(Coordinate _y).
	**************************************************/
	
    public void setZ(Coordinate val){
        z=new Coordinate(val);
    }

    // ***************** Administration ******************** //
  //compare Point3D to Point3D if == return 1 else return 0
  	/*************************************************
  	* FUNCTION
  	* compareTo
  	* PARAMETERS
  	* Point3D – the point to compareTo
  	* RETURN VALUE
  	* if the point are equal return 0
  	* else return 1.
  	* MEANING
  	* compare the two points.
  	* SEE ALSO
  	**************************************************/
  	 public int compareTo(Point3D other) {
        if(this.x.get_coordinate()<other.getX().get_coordinate())
            return -1;
        if(this.x.get_coordinate()>other.getX().get_coordinate())
            return 1;
        if(this.y.get_coordinate()<other.getY().get_coordinate())
            return -1;
        if(this.y.get_coordinate()>other.getY().get_coordinate())
            return 1;
        if(this.z.get_coordinate()<other.getZ().get_coordinate())
            return -1;
        if(this.z.get_coordinate()>other.getZ().get_coordinate())
            return 1;
        return 0;
    }
  	//Converts Point3D to string
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
 	 public String toString() {
 		//Convert the point to string by system function and it will show 2 numbers after the point
 		return String.format("(%.2f, %.2f, %.2f)",this.x.get_coordinate() ,this.y.get_coordinate() ,this.z.get_coordinate() );

    }

    // ***************** Operations ******************** //
 	//add Vector to Point3D
 	/*************************************************
 	* FUNCTION
 	* add
 	* PARAMETERS
 	* Vector – vector the add the point to the head of this vector
 	* RETURN VALUE
 	* ---
 	* MEANING
 	* Add to our point the head point of the vector
 	* SEE ALSO
 	*subtract(Vector vector)
 	**************************************************/
 public void add(Vector vector){
        x.add(vector.getHead().getX());
        y.add(vector.getHead().getY());
        z.add(vector.getHead().z);
    }

//subtract Vector to Point3D
	/*************************************************
	* FUNCTION
	* add
	* PARAMETERS
	* Vector – vector the subtract the point to the head of this vector
	* RETURN VALUE
	* ---
	* MEANING
	* subtract to our point the head point of the vector
	* SEE ALSO
	*add(Vector vector)
	**************************************************/
	 public void subtract(Vector vector){
        x.subtract(vector.getHead().getX());
        y.subtract(vector.getHead().getY());
        z.subtract(vector.getHead().z);
    }
	// betwin Point3D and Point3D
		/*************************************************
		* FUNCTION
		* distance
		* PARAMETERS
		* Point3D – the calc the distance
		* RETURN VALUE
		* the distance
		* MEANING
		* calc distance between to points
		* SEE ALSO
		**************************************************/
		public double distance(Point3D p) {
        double a = x.get_coordinate() - p.getX().get_coordinate();
        double b = y.get_coordinate() - p.getY().get_coordinate();
        double c =z.get_coordinate() - p.getZ().get_coordinate();
        return Math.sqrt(Math.pow(a,2)+ Math.pow(b,2)+ Math.pow(c,2));
    }
}
