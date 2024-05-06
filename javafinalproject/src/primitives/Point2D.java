package primitives;

//The class represents a point in 2 dimensions that it uses in both x, y coordinates

public class Point2D implements Comparable<Point2D> {

    protected Coordinate x;//the coordinate x of the point
    protected Coordinate y;//the coordinate x of the point

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
	* See also  Coordinate() , Point2D(Coordinate x, Coordinate y), Point2D(Point2D point2D).
	**************************************************/
    public Point2D() {
        x=new Coordinate(0);//Sends the receiver to Cordina's diffuse Coordinate
        y=new Coordinate(0);//Sends the receiver to Cordina's diffuse Coordinate
    }
    /*************************************************
	* FUNCTION
	* Constructor
	* PARAMETERS
	* Coordinate x, Coordinate y � the value to set on the point.
	* RETURN VALUE
	* ---
	* MEANING
	* Set the point with the value of the parameters.
	* SEE ALSO
	* Point2D(), Point2D(Point2D point2D), Coordinate(Coordinate coordinate).
	**************************************************/
    public Point2D(Coordinate X, Coordinate Y) {
        x = new Coordinate(X);//In order to get into the coordinates, he sends them to the grid of the coordinates
        y = new Coordinate(Y);//In order to get into the coordinates, he sends them to the grid of the coordinates
    }
    /*************************************************
	* FUNCTION
	* Copy Constructor
	* PARAMETERS
	* Point2D � object to copy.
	* RETURN VALUE
	* ---
	* MEANING
	* Copy the parameter to our object.
	* SEE ALSO
	* Point2D(), Point2D(Coordinate x, Coordinate y)
	**************************************************/
    public Point2D(Point2D point2D) {
        x=new Coordinate(point2D.getX());//In order to get into the coordinates, he sends them to the grid of the coordinates
        y=new Coordinate(point2D.getY());//In order to get into the coordinates, he sends them to the grid of the coordinates
    }

    // ***************** Getters/Setters ********************** //
  //The coordinates of a point remains in two dimensions (the coordinates remains)
  	/*************************************************
  	* FUNCTION
  	* getX
  	* PARAMETERS
  	* ---
  	* MEANING
  	* Return the value of the coordinate x.
  	* SEE ALSO
  	* getY() , setX(Coordinate _x) , setY(Coordinate _y).
  	**************************************************/
    public Coordinate getX() {
        return new Coordinate(x);//return the value of the x coordinate.
    }
  //The coordinates of a point remains in two dimensions (the cordenta remains)
  	/*************************************************
  	* FUNCTION
  	* getY
  	* PARAMETERS
  	* ---
  	* MEANING
  	* Return the value of the coordinate y.
  	* SEE ALSO
  	* getX() , setX(Coordinate _x) , setY(Coordinate _y).
  	**************************************************/
    public Coordinate getY() {
        return new Coordinate(y);//return the value of the x coordinate.
    }
  //Gets the coordinates and puts it into a point in both dimensions
  	/*************************************************
  	* FUNCTION
  	* setX
  	* PARAMETERS
  	* coordinate � the value to set on the coordinate x.
  	* RETURN VALUE
  	* ---
  	* MEANING
  	* Set the coordinate with the value of the parameters.
  	* SEE ALSO
  	* getX() , getY() , setY(Coordinate _y).
  	**************************************************/
    public void setX(Coordinate val) {
        x=new Coordinate(val);//Set the coordinate with the value of the parameters.
    }
  //Gets the coordinates and puts it into a point in both dimensions
  	/*************************************************
  	* FUNCTION
  	* setY
  	* PARAMETERS
  	* coordinate � the value to set on the coordinate Y.
  	* RETURN VALUE
  	* ---
  	* MEANING
  	* Set the coordinate with the value of the parameters.
  	* SEE ALSO
  	* getX() , setX(Coordinate _x) , getY().
  	**************************************************/
    public void setY(Coordinate val) {
        y=new Coordinate(val);//Set the coordinate with the value of the parameters.
    }

    // ***************** Administration ******************** //
  //Compares the two points in the two quantifiers if they are equal to this one returns and whether it returns 0
  	/*************************************************
  	* FUNCTION
  	* compareTo
  	* PARAMETERS
  	* Point2D � the point to compareTo
  	* RETURN VALUE
  	* if the point are equal return 1
  	* if the parameter greater return 0
  	* else return -1.
  	* MEANING
  	* compare the two points.
  	* SEE ALSO
  	**************************************************/
    @Override
    public int compareTo(Point2D other) {
        if(this.x.get_coordinate()<other.getX().get_coordinate())
            return -1;
        if(this.x.get_coordinate()>other.getX().get_coordinate())
            return 1;
        if(this.y.get_coordinate()<other.getY().get_coordinate())
            return -1;
        if(this.y.get_coordinate()>other.getY().get_coordinate())
            return 1;
        return 0;
    }

}


