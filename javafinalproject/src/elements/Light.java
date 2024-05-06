package elements;

import java.awt.Color;

abstract public class Light {

    protected Color _color;

    // ***************** Constructors ********************** //
    /*************************************************
	* FUNCTION
	* Default Constructor
	* PARAMETERS
	* ---
	* RETURN VALUE
	* ---
	* MEANING
	* Set the coordinate with a default value .
	* See also  Light (Color color)
	**************************************************/
    public Light(){
    	_color=new Color(0, 0, 0);//Set the default
    }
    /*************************************************
	* FUNCTION
	* Constructor
	* PARAMETERS
	* Color – the value to set on the .
	* RETURN VALUE
	* ---
	* MEANING
	* Set the color with the value of the parameters.
	* SEE ALSO
	* Coordinate() , Coordinate(Coordinate coordinate).
	**************************************************/
    public Light (Color color){_color=new Color(color.getRGB());}

    // ***************** Getters/Setters ********************** //
    /*************************************************
	* FUNCTION
	* getIntensity
	* PARAMETERS
	* ---
	* RETURN VALUE
	* Color
	* MEANING
	* return the color
	* SEE ALSO
	**************************************************/
    public Color getIntensity(){
        return new Color(_color.getRGB());
    }

}
