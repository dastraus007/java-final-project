package elements;

import primitives.Point3D;
import primitives.Vector;
import java.awt.Color;

public interface LightSource {
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
	* getL(Point3D point)
	**************************************************/
    public abstract Color getIntensity(Point3D point);
    /*************************************************
	* FUNCTION
	* getL
	* PARAMETERS
	* ---
	* RETURN VALUE
	* Vector of the line of the light
	* MEANING
	* Calc and return return the Vector of the line of the light
	* SEE ALSO
	* getIntensity(Point3D point)
	**************************************************/
    public abstract Vector getL(Point3D point); // light to point vector

}
