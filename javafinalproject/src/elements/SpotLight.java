package elements;

import primitives.Point3D;
import primitives.Vector;
import java.awt.Color;

public class SpotLight extends PointLight{

    private Vector _direction;//the direction of the light

    // ***************** Constructor ********************** //
    /*************************************************
	* FUNCTION
	* Constructor
	* PARAMETERS
	* Color ,Vector ,  Point3D, double , double ,double
	* RETURN VALUE
	* ---
	* MEANING
	* Set the fills with the values of the parmters .
	* See also  Light (Color color) 
	**************************************************/
    public SpotLight(Color color, Point3D position, Vector direction, double kc, double kl, double kq){
        super(color, position, kc, kl, kq);
        _direction=new Vector(direction);
        _direction.normalize();
    }

    // ***************** Getters/Setters ********************** //
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
        Vector l=getL(point);//get the diretion
        _direction.normalize();//normalize it
        Double tmp=l.dotProduct(_direction);//get the angel
        double d=point.distance(_position);//the distance
        double r=(_color.getRed()*tmp)/(_Kc+(_Kl*d)+(_Kq*Math.pow(d,2)));//calc the r
        double g=(_color.getGreen()*tmp)/(_Kc+(_Kl*d)+(_Kq*Math.pow(d,2)));//calc the g
        double b=(_color.getBlue()*tmp)/(_Kc+(_Kl*d)+(_Kq*Math.pow(d,2)));//calc the b
        if(r>255)r=255;//Checks that there is no exception if there is exception set on 255
        if(g>255)g =255;//Checks that there is no exception
        if(b>255)b=255;//Checks that there is no exception
        if(r<0)r=0;//Checks that there is no exception if there is exception set on 0
        if(g<0)g =0;//Checks that there is no exception
        if(b<0)b=0;//Checks that there is no exception
        return new Color((int)r, (int)g, (int)b);//return the color
    }
}
