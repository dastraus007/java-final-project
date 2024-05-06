package primitives;

//The department represents the Type of matter when we create a triangle of what color it was and the objects it was transparent
/*************************************************
the  class Material
The department represents the Type of matter when we create a triangle of what color it was and the objects it was transparent
_Kd=Diffusion attenuation coefficient
_Ks=Specular attenuation coefficient
_Kr= Reflection coefficient (1 for mirror)
_Kt= Refraction coefficient (1 for transparent)
_n=Refraction index
**************************************************/
public class Material {
    private double _Kd; // Diffusion attenuation coefficient
    private double _Ks; // Specular attenuation coefficient
    private double _Kr; // Reflection coefficient (1 for mirror)
    private double _Kt; // Refractive coefficient (1 for transparent)
    private double _n; // Refractive index

    // ***************** Constructors ********************** //
    /*************************************************
	the Constructor function Material 
	is get non
	It sends the variables to diffuse constructors
	**************************************************/
    public Material()
    {
        _Kd = 1;
        _Ks = 1;
        _Kr = 0;
        _Kt = 0;
        _n = 1;
    }
    /*************************************************
	the Constructor function Material 
	Restive double d, double s, double r, double t, double n
	It sends the variables to diffuse constructors
	**************************************************/
    public Material(double d, double s, double r, double t, double n){
        _Kd = d;
        _Ks = s;
        _Kr = r;
        _Kt = t;
        _n = n;
    }
    /*************************************************
	the Constructor function Material 
	is get non
	It sends the variables to diffuse constructors
	**************************************************/
    public Material(Material material){
        _Kd = material.getKd();
        _Ks = material.getKs();
        _Kr = material.getKr();
        _Kt = material.getKt();
        _n = material.getN();
    }
    // ***************** Getters/Setters ********************** //
    
    /*************************************************
	the name  setKd
	get the _Kd
	**************************************************/
	//Gets a number and puts it into the variable of the material
	
    public void setKd(double d){
        _Kd=d;
    }
    /*************************************************
	the name  setKs
	get the _Ks
	**************************************************/
	//Gets a number and puts it into the variable of the material
	
    public void setKs(double s){
        _Ks=s;
    }
    /*************************************************
	the name  setKr
	get the _Kr
	**************************************************/
	//Gets a number and puts it into the variable of the material
	
    public void setKr(double r){
        _Kr=r;
    }
    /*************************************************
	the name  setKt
	get the _Kt
	**************************************************/
	//Gets a number and puts it into the variable of the material
	
    public void setKt(double t){
        _Kt=t;
    }
    /*************************************************
	the name  setN
	get the _n
	**************************************************/
	//Gets a number and puts it into the variable of the material
	
    public void setN (double n){
        _n=n;
    }
    /*************************************************
	the name  getKd
	return the _Kd
	**************************************************/
	//Left the value of a certain part of the material (left number)
	
    public double getKd(){
        return _Kd;
    }
    /*************************************************
	the name  getKs
	return the _Ks
	**************************************************/
	//Left the value of a certain part of the material (left number)
	
    public double getKs(){
        return _Ks;
    }
    /*************************************************
	the name  getKr
	return the _Kr
	**************************************************/
	//Left the value of a certain part of the material (left number)
	
    public double getKr(){
        return _Kr;
    }
    /*************************************************
	the name  getKt
	return the _Kt
	**************************************************/
	//Left the value of a certain part of the material (left number)
	
    public double getKt(){
        return _Kt;
    }
    /*************************************************
	the name  getN
	return the _n
	**************************************************/
	//Left the value of a certain part of the material (left number)
	
    public double getN(){
        return _n;
    }
}
