package geometries;

import primitives.Material;
import java.awt.Color;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;
import java.util.List;
/*************************************************
the name  abstract class Geometry
 is the Geometry Color
_material is the Geometry Material
_nShininess is the Geometry  Shininess 
Returns the _nShininess
**************************************************/
public abstract class Geometry {
	
	  private Material _material ;
	    private double _nShininess ;
	    private Color _emmission = new Color(0, 0, 0);

	    public abstract List<Point3D> FindIntersections(Ray ray);
	    public abstract Vector getNormal (Point3D point3D);

	 // ***************** Constructors ********************** //
		/*************************************************
		* FUNCTION
		* Constructor
		* PARAMETERS
		* Color color, double shininess, Material material
		* RETURN VALUE
		* ---
		* MEANING
		* Set the color with value of the prameters.
		* See also  Geometry()
		**************************************************/
    public Geometry(Color color, double shininess, Material material){
        set_emmission(color);
        set_material(material);
        set_nShininess(shininess);
    }
    /*************************************************
	* FUNCTION
	* Default Constructor
	* PARAMETERS
	* ---
	* RETURN VALUE
	* ---
	* MEANING
	* Set with Default values .
	* See also  Geometry()
	**************************************************/
    public Geometry() {
        set_emmission(new Color(0,0,0));
        _nShininess=1;
        _material= new Material();
    }

    /*************************************************
	the name  getShininess
	Returns the _nShininess
	**************************************************/
    public double get_nShininess(){return _nShininess;}
    /*************************************************
	the name  getAxisDirection
	Returns the _material
	**************************************************/
    public Material get_material(){return new Material(_material);}
    /*************************************************
	the name  getEmmission
	Returns  
	**************************************************/
    public Color get_emmission(){return new Color(_emmission.getRGB());}
    /*************************************************
	the name  setShininess
	get the n
	**************************************************/
    public void set_nShininess(double s){_nShininess=s;}
    /*************************************************
	the name  setMaterial
	get the _material
	**************************************************/
    public void set_material(Material m){_material=new Material(m);}
    /*************************************************
	the name  setEmmission
	**************************************************/
    public void set_emmission(Color c){ _emmission=new Color(c.getRGB());}
    /*************************************************
	the name  setKs
	get the ks
	**************************************************/
    public void setKs(double Ks){_material.setKs(Ks);}
    /*************************************************
	the name  setKd
	get the kd
	**************************************************/
    public void setKd(double Kd){_material.setKd(Kd);}
    /*************************************************
	the name  setKr
	get the Kr
	**************************************************/
    public void setKr(double Kr){_material.setKr(Kr);}
    /*************************************************
	the name  setKt
	get the Kt
	**************************************************/
    public void setKt(double Kt){_material.setKt(Kt);}

}
