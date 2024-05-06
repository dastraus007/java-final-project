package elements;

import primitives.Point3D;
import primitives.Vector;
import java.awt.Color;

public class DirectionalLight extends Light implements LightSource{

    private Vector _direction;//the direction  of the light

    // ***************** Constructors ********************** //
    /*************************************************
	* FUNCTION
	* Constructor
	* PARAMETERS
	* Color , vector
	* RETURN VALUE
	* ---
	* MEANING
	* Set the color and the direction with the values .
	* See also  Light (Color color) , DirectionalLight(Color color, Vector direction)
	**************************************************/
	
    public DirectionalLight(Color color, Vector direction){
        _color=new Color(color.getRGB());//set the color
        _direction=new Vector(direction);//set the direction
    }

    // ***************** Getters/Setters ********************** //
    
    /*************************************************
	* FUNCTION
	* getDirection
	* PARAMETERS
	* ---
	* RETURN VALUE
	* Vector
	* MEANING
	* return the direction
	* SEE ALSO
	**************************************************/
    public Vector getDirection(){
        return new Vector(_direction);
    }
    /*************************************************
	* FUNCTION
	* setDirection
	* PARAMETERS
	* Color - the value to set on the
	* RETURN VALUE
	* ---
	* MEANING
	* Set the direction 
	* SEE ALSO getColor()
	**************************************************/
    public void setDirection(Vector direction){
        _direction=new Vector(direction);//set the direction
    }
    /*************************************************
	* FUNCTION
	* getL
	* PARAMETERS
	* Point3D
	* RETURN VALUE
	* Vector
	* MEANING
	* return the vetor
	* SEE ALSO
	**************************************************/
    public Vector getL(Point3D point){
        return new Vector(_direction);
    }
    /*************************************************
	* FUNCTION
	* getIntensity
	* PARAMETERS
	* Point3D
	* RETURN VALUE
	* Color
	* MEANING
	* return the light color
	* SEE ALSO
	**************************************************/
    @Override
    public Color getIntensity(Point3D point){
        return new Color(_color.getRGB());
    }
    
}
