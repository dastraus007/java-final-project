package geometries;

import primitives.Material;

import java.awt.*;

/*************************************************
the name  abstract class RadialGeometry
He inherited the geometric and gives him a gift of radius
_radius the radius
**************************************************/
abstract public class RadialGeometry extends Geometry{

    protected double _radius;
    /*************************************************
	the Constructor function RadialGeometry 
	is get non
	It _radius=0; by dfolt
	**************************************************/
    public RadialGeometry(){
        super();
        _radius=0;
    }
    /*************************************************
	the Constructor function RadialGeometry 
	parameters double radius, Color color, Double shininess, Material material
	is get non
	It _radius=0;
	**************************************************/
    public RadialGeometry(double radius, Color color, Double shininess, Material material){
        super(color, shininess, material);
        _radius=radius;
    }
    /*************************************************
	the name  getRadius
	Returns the _radius
	**************************************************/
    public double getRadius(){return _radius;}
    /*************************************************
	the name  setRadius
	get the radius
	**************************************************/
    public void setRadius(double radius){_radius=radius;}

}
