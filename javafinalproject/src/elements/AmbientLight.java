package elements;


import java.awt.*;
import java.util.Map;

public class  AmbientLight extends Light{

    private final double _Ka = 0.1;

    // ***************** Constructors ********************** //
    /*************************************************
	* FUNCTION
	* Default Constructor
	* PARAMETERS
	* ---
	* RETURN VALUE
	* ---
	* MEANING
	* Set the color with a default value .
	* See also  Light (Color color) , AmbientLight(int r, int g, int b)
	**************************************************/
    public AmbientLight(){}
    /*************************************************
	* FUNCTION
	* Constructor
	* PARAMETERS
	* AmbientLight – the value to set on the .
	* RETURN VALUE
	* ---
	* MEANING
	* Set the color with the value of the parameters.
	* SEE ALSO
	* Light (), AmbientLight() , AmbientLight(int r, int g, int b)
	**************************************************/
    public AmbientLight(AmbientLight aLight){ _color=new Color(aLight._color.getRGB()); }
    /*************************************************
	* FUNCTION
	* Constructor
	* PARAMETERS
	* int r, int g, int b – the value to set on the .
	* RETURN VALUE
	* ---
	* MEANING
	* Set the color with the value of the parameters.
	* SEE ALSO
	* Light (), AmbientLight() , AmbientLight(AmbientLight aLight)
	**************************************************/
    public AmbientLight(int r, int g, int b){ _color=new Color(r,g,b);}
    public AmbientLight(Map<String, String> attributes){}


    // ***************** Getters/Setters ********************** //
    /*************************************************
	* FUNCTION
	* getColor
	* PARAMETERS
	* ---
	* RETURN VALUE
	* Color
	* MEANING
	* return the color
	* SEE ALSO
	**************************************************/

    public Color getColor(){
        return new Color(_color.getRGB());
    }
    /*************************************************
	* FUNCTION
	* setColor
	* PARAMETERS
	* Color - the value to set on the
	* RETURN VALUE
	* ---
	* MEANING
	* Set the color
	* SEE ALSO getColor()
	**************************************************/
	
    public void setColor(Color color){
        _color=new Color(color.getRGB());
    }
    /*************************************************
	* FUNCTION
	* getKa
	* PARAMETERS
	* ---
	* RETURN VALUE
	* double return the brightness
	* MEANING
	* return the brightness
	* SEE ALSO
	**************************************************/
	
    public double getKa(){
        return _Ka;
    }
    /*************************************************
	* FUNCTION
	* getIntensity
	* PARAMETERS
	* ---
	* RETURN VALUE
	* Color
	* MEANING
	* return the light color
	* SEE ALSO
	**************************************************/
	
    @Override
    public Color getIntensity(){
        int r=_color.getRed();//Set the colors
        int g=_color.getGreen();//Set the colors
        int b=_color.getBlue();//Set the colors
        r*=_Ka;//calc with the KA
        g*=_Ka;
        b*=_Ka;
        return new Color(r, g, b);//return the color
    }
}
