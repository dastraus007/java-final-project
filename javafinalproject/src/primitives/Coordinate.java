package primitives;

//A coordinate represents the point on the number axis (in one dimension)
public class Coordinate implements Comparable<Coordinate> {

    private double _coordinate;//Coordinate applied one number to the number axis

   
    // ***************** Constructors ********************** //
    /*************************************************
	* FUNCTION
	* Default Constructor
	* PARAMETERS
	* ---
	* RETURN VALUE
	* ---
	* MEANING
	* Set the coordinate with a default value (zero).
	* See also  Coordinate(double _coordinate) , Coordinate(Coordinate coordinate).
	**************************************************/
    public Coordinate() {
        this._coordinate = 0;//Set the coordinate with a default value (zero).
    }
    /*************************************************
	* FUNCTION
	* Constructor
	* PARAMETERS
	* double � the value to set on the coordinate.
	* RETURN VALUE
	* ---
	* MEANING
	* Set the coordinate with the value of the parameters.
	* SEE ALSO
	* Coordinate() , Coordinate(Coordinate coordinate).
	**************************************************/
    public Coordinate(double _coordinate) {
        this._coordinate = _coordinate;//Set the coordinate with the value of the parameters.
    }
    /*************************************************
	* FUNCTION
	* Copy Constructor
	* PARAMETERS
	* Coordinate � object to copy.
	* RETURN VALUE
	* ---
	* MEANING
	* Copy the parameter to our object.
	* SEE ALSO
	* Coordinate(double _coordinate) , Coordinate().
	**************************************************/
    public Coordinate(Coordinate coordinate) {
        this._coordinate = coordinate.get_coordinate();//Set the value of the parameter our coordinate.
    }

    // ***************** Getters/Setters ********************** //
    /*************************************************
	* FUNCTION
	* get_coordinate
	* PARAMETERS
	* ---
	* MEANING
	* Return the value of the coordinate.
	* SEE ALSO
	* set_coordinate(double _coordinate).
	**************************************************/
    public double get_coordinate() {
        return this._coordinate;
    }
    /*************************************************
	* FUNCTION
	* set_coordinate
	* PARAMETERS
	* double � the value to set on the coordinate.
	* RETURN VALUE
	* ---
	* MEANING
	* Set the coordinate with the value of the parameters.
	* SEE ALSO
	* Coordinate(Coordinate coordinate), get_coordinate().
	**************************************************/
    public void set_soordinate(double _coordinate) {
    	this._coordinate=_coordinate;
    }

    // ***************** Operations ******************** //
  //Connects the two coordinates and tests first to the value of the second
  	/*************************************************
  	* FUNCTION
  	* add
  	* PARAMETERS
  	* Coordinate � object to add on.
  	* RETURN VALUE
  	* ---
  	* MEANING
  	* Add the value of the parameter to our coordinate.
  	* SEE ALSO
  	* subtract(Coordinate coordinate)
  	**************************************************/
    public void add(Coordinate dx) {
    	this._coordinate = this._coordinate + dx.get_coordinate();
    }
  //�Subtracting between the two coordinates and the first tests the value of the second
  	/*************************************************
  	* FUNCTION
  	* subtract
  	* PARAMETERS
  	* Coordinate � object to subtract.
  	* RETURN VALUE
  	* ---
  	* MEANING
  	* Subtract the value of the parameter to our coordinate.
  	* SEE ALSO
  	* add(Coordinate coordinate)
  	**************************************************/
    public void subtract(Coordinate dx) {
    	this._coordinate = this._coordinate - dx.get_coordinate();
    }
    // ***************** Administration ******************** //
  //Administration
  	//Compares the two coordinates if they are equal to this returns 1 If the capitalization is greater than the second it returns -1 and the second is greater than the margin This returns 0
  	
  	/*************************************************
  	* FUNCTION
  	* compareTo
  	* PARAMETERS
  	* Coordinate � the coordinate to compareTo
  	* RETURN VALUE
  	* if the coordinates are equal return 1
  	* if the parameter greater return 0
  	* else return -1.
  	* MEANING
  	* compare the two coordinate.
  	* SEE ALSO
  	**************************************************/
    public int compareTo(Coordinate other) {
        return Double.compare(this._coordinate, other.get_coordinate());
    }

}
