package elements;

import primitives.Point3D;
import primitives.Vector;
import java.awt.Color;

public class PointLight extends Light implements LightSource{
    //protected double _area;
    protected Point3D _position;
    protected double _Kc, _Kl, _Kq;//The coefficients of decay 

    // ***************** Constructors ********************** //
    /*************************************************
	* FUNCTION
	* Constructor
	* PARAMETERS
	* Color , Point3D, double , double ,double
	* RETURN VALUE
	* ---
	* MEANING
	* Set the fills with the values  .
	* See also  Light (Color color) 
	**************************************************/
    public PointLight(Color color, Point3D position, double kc, double kl, double kq){
        _position=new Point3D(position);
        _Kc=kc;
        _Kl=kl;
        _Kq=kq;
        _color=new Color(color.getRGB());
      //  _area=1;
    }
   /* /*************************************************
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
   /* public PointLight(Color color, Point3D position, double area, double kc, double kl, double kq){
        _position=new Point3D(position);
      //  _area=area;
        _Kc=kc;
        _Kl=kl;
        _Kq=kq;
        _color=new Color(color.getRGB());
    }*/

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
        double d=point.distance(_position);//the distance between the points
        double r=_color.getRed()/(_Kc+_Kl*d+_Kq*Math.pow(d,2));//calc the r
        double g=_color.getGreen()/(_Kc+_Kl*d+_Kq*Math.pow(d,2));//calc the g
        double b=_color.getBlue()/(_Kc+_Kl*d+_Kq*Math.pow(d,2));//calc the b
        if(r>255)r=255;//Checks that there is no exception
        if(g>255)g =255;//Checks that there is no exception
        if(b>255)b=255;//Checks that there is no exception
        if(r<0)r=0;//Checks that there is no exception
        if(g<0)g =0;//Checks that there is no exception
        if(b<0)b=0;//Checks that there is no exception
        return new Color((int)r,(int)g,(int)b);//return the color that calced
    }

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
    @Override
    public Vector getL(Point3D point){
        Vector v=new Vector(point);//get the vector to the point
        v.subtract(new Vector(_position));//Substrate the vector o the point by the vector of the position
        v.normalize();//
        return v;//return the result of the subtract
    }
    /*************************************************
	* FUNCTION
	* get_position
	* PARAMETERS
	* ---
	* RETURN VALUE
	* Point3D
	* MEANING
	* return the position
	* SEE ALSO
	**************************************************/  
    public Point3D get_position(){
        return new Point3D(_position);
    }


}
