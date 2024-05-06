package renderer;

import java.awt.Color;
import java.util.*;
import java.util.Map.Entry;
import elements.LightSource;
import elements.PointLight;
import geometries.FlatGeometry;
import geometries.Geometry;
//import groovy.util.MapEntry;
import primitives.Point3D;
import primitives.Ray;
import primitives.Coordinate;
import primitives.Vector;
import scene.Scene;
/*************************************************
* FUNCTION
* Constructor
* renderImage=Converts the sin into an image
* calcColor=Calculates the color at a certain point
* constructRefractedRay=R = D - 2(Dדƒ»N)N
* occluded=Computer if there is a shadow to the snare
* addColors=Two color connector
* getSceneRayIntersections=Returns all the damaged points
* getClosestPoint=Returns the nearest point
* calcDiffusiveComp=Returns the eDiffusive of the point
* calcSpecularComp=Returns the Specular of the point
* ---
* RETURN VALUE
* ---
* MEANING
* Converts the sin into an image
* See also  Scene ,_imageWriter
* Variables
* _scene=Gives us the _scene to the picture
* _imageWriter=Makes us a picture
**************************************************/

public class Render {

    private Scene _scene;//Gives us the _scene to the picture
    private ImageWriter _imageWriter;//Makes us a picture
    private final int RECURSION_LEVEL = 3;//So that it was not infinite

    // ***************** Constructors ********************** //
    /*************************************************
	* FUNCTION
	* Constructor
	* Render
	* 
	* Render – the value to set on the .
	* RETURN VALUE
	* ---
	* MEANING
	* Set the color with the value of the parameters.
	* SEE ALSO
	* ImageWriter, scene
	**************************************************/
    public Render(ImageWriter imageWriter, Scene scene) {
        _imageWriter = new ImageWriter(imageWriter);//= new ImageWriter
        _scene = new Scene(scene);//= new Scene
    }

    // ***************** Operations ******************** //
    /*************************************************
 	* FUNCTION
 	* renderImage
 	* 
 	* Render
 	* RETURN VALUE
 	* ---
 	* MEANING
 	* Converts the sin into an image
 	* SEE ALSO
 	* ImageWriter, scene,constructRayThroughPixel,getclosestPoint
 	**************************************************/
      public void renderImage() {
        for (float i = 0; i < _imageWriter.getHeight(); i++) {//go in all the Height of the image
            for (float j = 0; j < _imageWriter.getWidth(); j++) {//go in all the Width of the image
                try//if is a Exception we pot Background
                {
            	// ArrayList<Ray>
              Ray ray = new Ray(_scene.getCamera().constructRayThroughPixel(_imageWriter.getHeight(), _imageWriter.getWidth(), i, j, _scene.getScreenDistance(), _imageWriter.getWidth(), _imageWriter.getHeight()));//get the ray in this pixel
                Map<Geometry, List<Point3D>> intersectionPoints = getSceneRayIntersections(ray);//get all the intersection Points in all the _scene
                if (intersectionPoints.isEmpty()) {//if is no intersection Points
                    _imageWriter.writePixel((int) i, (int) j, _scene.getBackground().getRed(), _scene.getBackground().getGreen(), _scene.getBackground().getBlue());//pot Background
                } else {
                    Map<Geometry, Point3D> closestPoint= getClosestPoint(intersectionPoints);//get the getClosestPoint
                    for(Entry<Geometry, Point3D>entry:closestPoint.entrySet()) {
                    	Color a=calcColor(entry.getKey(), entry.getValue(),ray);//get the color point
                        _imageWriter.writePixel((int) i, (int) j,a.getRed(),a.getGreen(),a.getBlue());//_imageWriter the color
                    }
                }
                }
                catch (Exception e2) {//if is a Exception
                	 _imageWriter.writePixel((int) i, (int) j, _scene.getBackground().getRed(), _scene.getBackground().getGreen(), _scene.getBackground().getBlue());//_image Writer Background
                }
                
            }
        }
        //printGrid(50);
        _imageWriter.writeToimage();//print the image
    }
    

      /*************************************************
  	 * FUNCTION
  	 * calcColor
  	 * PARAMETERS
  	 * Geometry - to know the color of the geometry , Point3D , Ray 
  	 * RETURN VALUE
  	 * color of the point after calcing. 
  	 * MEANING
  	 * calc the color of the point
  	 * SEE ALSO
  	 * renderImage()
  	 **************************************************/
    private Color calcColor(Geometry geometry, Point3D point, Ray ray) {//coll to the  calcColor 
        return calcColor(geometry, point, ray, 0);
    }
    
    /*************************************************
	 * FUNCTION
	 * calcColor
	 * PARAMETERS
	 * Geometry - to know the color of the geometry , Point3D , Ray 
	 * RETURN VALUE
	 * color of the point after calcing. 
	 * MEANING
	 * recution
	 * SEE ALSO
	 * renderImage()
	 **************************************************/
    private Color calcColor(Geometry geometry, Point3D point, Ray inRay, int level) { // Recursive
        if (level == RECURSION_LEVEL)//if is the end of the Recursive
            return new Color(0, 0, 0);//return 0
        Color ambientLight =  new Color(_scene.getAmbientLight().getIntensity().getRGB());//AmbientLight color
        Color emissionLight = new Color(geometry.get_emmission().getRGB());//emissionLight colot
        Iterator<LightSource> lights = _scene.getLightsIterator();//get the Lights Iterator
        Color dL = new Color(0, 0, 0);//=0
        Color sL = new Color(0, 0, 0);//=0
        //inRay.getDirection().scale(-1);
        while (lights.hasNext()) {//go in all the lights
            LightSource light = lights.next();//Iterator next
            if (!occluded(light, point, geometry)) {//if it have a shadow
                //diffuse light
                dL=addColors(dL, calcDiffusiveComp(geometry.get_material().getKd(), geometry.getNormal(point), light.getL(point), light.getIntensity(point)));//the calc Diffusive Comp
                //specular light
                sL=addColors(sL, calcSpecularComp(geometry.get_material().getKs(),inRay.getDirection(), geometry.getNormal(point), light.getL(point), geometry.get_nShininess(), light.getIntensity(point)));//specular light

            }
        }
        //Recursive call for a Reflected Ray
        Ray reflectedRay = constructReflectedRay(geometry.getNormal(point), point, inRay);//get the refracion ray
        Map<Geometry, Point3D> reflectedEntry = getClosestPoint(getSceneRayIntersections(reflectedRay));//get Closest Point 
        Color reflectedLight=new Color(0,0,0);//=0
        if (!reflectedEntry.isEmpty() && geometry.get_material().getKr() != 0) {//if is isEmpty &&getKr!=0
            //inRay.getDirection().scale(-1);
            Color reflectedColor = calcColor((Geometry) (reflectedEntry.keySet().toArray()[0]), (Point3D) (reflectedEntry.get(reflectedEntry.keySet().toArray()[0])), inRay, level + 1); //reflected ray
            
            double kr = geometry.get_material().getKr();//kr
            double t1=(int) (reflectedLight.getRed()*kr);//Red*kr
            double t2=(int) (reflectedLight.getGreen()*kr);//Green*kr
            double t3=(int) (reflectedLight.getBlue()*kr);//Blue*kr
              reflectedLight = new Color((int)t1,(int)t2,(int)t3);//the color
          //  reflectedLight = new Color((int) (kr * reflectedColor.getRGB()));
        }
        //Recursive call for a Refracted Ray
        Ray refractedRay = constructRefractedRay(geometry, point, inRay);//get the refracion ray
        Map<Geometry, Point3D> refractedEntry = (getClosestPoint(getSceneRayIntersections(refractedRay)));////get Closest Point
        Color refractedLight=new Color(0,0,0);//=0
        if (!refractedEntry.isEmpty() && geometry.get_material().getKt() != 0) {//if is isEmpty &&getKr!=0
            Color refractedColor = calcColor((Geometry) refractedEntry.keySet().toArray()[0], (Point3D) refractedEntry.get(refractedEntry.keySet().toArray()[0]), inRay, level + 1);//refracted ray
            double kt = geometry.get_material().getKt();//kr
            refractedLight = new Color((int) kt * refractedColor.getRGB());//kr*RGB
        }
        Color phong=addColors(ambientLight,emissionLight);//add 
        phong=addColors(phong, dL);//add
        phong=addColors(phong, sL);//add
        phong=addColors(phong, reflectedLight);//add
        phong=addColors(phong, refractedLight);//add


        return new Color(phong.getRGB());//return the color
    }

    
    
    /*************************************************
 	* FUNCTION
 	* constructRefractedRay
 	* 
 	* Render
 	* RETURN VALUE
 	* ---
 	* MEANING
 	* return the reflacion ray
 	* SEE ALSO
 	* constructReflectedRay
 	**************************************************/
    private Ray constructRefractedRay(Geometry geometry, Point3D point, Ray inRay){
        Vector epsVector = new Vector(inRay.getDirection());//get the ray Direction
        epsVector.scale(0.00001);//*0.00001
        Point3D gPoint=new Point3D(point);//=point
        gPoint.add(epsVector);//gPoint+epsVector
        Vector nVector=new Vector(inRay.getDirection());//get the ray Direction
        nVector.normalize();//normalize it
        return new Ray(gPoint, nVector);//return the ray
    }
    
    
    /*************************************************
 	* FUNCTION
 	* constructReflectedRay
 	* 
 	* Render
 	* RETURN VALUE
 	* ---
 	* MEANING
 	* R = D - 2(Dדƒ»N)N
 	* SEE ALSO
 	* constructRefractedRay
 	**************************************************/
    private Ray constructReflectedRay(Vector normal, Point3D point, Ray inRay){
        //R = D - 2(Dדƒ»N)N
        Vector D=new Vector(inRay.getDirection());//get the ray Direction
        double temp=D.dotProduct(normal);//d*normal
        temp*=2;//*2
        Vector n=new Vector(normal);//=normal
        n.scale(temp);//n*temp
        D=new Vector(inRay.getDirection());//get the ray Direction
        D.subtract(n);//d=n
        return new Ray(point, D);//return the ray
    }
    
    
    
    
    
    /*************************************************
 	* FUNCTION
 	* occluded
 	* 
 	* Render
 	* RETURN VALUE
 	* ---
 	* MEANING
 	* Computer if there is a shadow to the snare
 	* SEE ALSO
 	* calcolor
 	**************************************************/
    private boolean occluded(LightSource light, Point3D point, Geometry geometry){
        Vector lightDirection=light.getL(point);//get the light Direction
        lightDirection.scale(-1);//lightDirection*-1
        Point3D geometryPoint=new Point3D(point);//geometryPoint=point
        Vector epsVector=new Vector(geometry.getNormal(point));//get the epsVector
        epsVector.scale(0.1);
        geometryPoint.add(epsVector);//add geometryPoint+epsVector
        Ray lightRay=new Ray(geometryPoint, lightDirection);//get the rat
        Map<Geometry, List<Point3D>> intersectionPoints=getSceneRayIntersections(lightRay);//get ther a Intersections

        //flat geometry cannot self intersect
        if(geometry instanceof FlatGeometry){//if is 2D
            intersectionPoints.remove(geometry);//remove geometry
        }
        for (Entry<Geometry, List<Point3D>> entry: intersectionPoints.entrySet()){//if ther a Intersections
            //if (entry.getKey().get_material().getKt()==0)
                return true;
        }
        return false;

    }

    
    
    
    
    
    /*************************************************
   	* FUNCTION
   	* calcSpecularComp
   	* 
   	* Render
   	* RETURN VALUE
   	* ---
   	* MEANING
   	* =Returns the light of the point
   	* SEE ALSO
   	* calcDiffusiveComp
   	**************************************************/
    private Color calcSpecularComp(double ks, Vector inRay, Vector normal, Vector l, double shininess, Color lightIntensity){
        //KS(Vדƒ»R)^n*IL
        //R=2(Nג‹…L)Nגˆ’L
        inRay.normalize();//normalize it
        l.normalize();//normalize it
        normal.normalize();//normalize it
        Vector nL=new Vector(normal);//new Vector normal
        double temp=nL.dotProduct(l);//dotProduct
        temp*=2.0D;//temp*2
        Vector n=new Vector(normal);//new Vector normal
        n.scale(temp);
        l.subtract(n);//switched between l and n
        l.normalize();//normalize l
        double vR=inRay.dotProduct(l);//changed n to l
        vR=Math.pow(vR, shininess);
        int r=(int)(Math.abs(ks*vR*lightIntensity.getRed()));//get the r
        int g=(int)(Math.abs(ks*vR*lightIntensity.getGreen()));//get the g
        int b=(int)(Math.abs(ks*vR*lightIntensity.getBlue()));//get the b
        return new Color(r, g, b);//return the color
    }

    
    
    
    
    
    /*************************************************
 	* FUNCTION
 	* calcDiffusiveComp
 	* 
 	* Render
 	* RETURN VALUE
 	* ---
 	* MEANING
 	* =Returns the Diffusive light of the point
 	* SEE ALSO
 	* calcSpecularComp
 	**************************************************/
    private Color calcDiffusiveComp(double kd, Vector normal, Vector l, Color lightIntensity){
        normal.normalize();//normalize it
        l.normalize();////normalize it
        double nL=normal.dotProduct(l);//dotProduct it 
        int r=(int)(Math.abs(kd*nL*lightIntensity.getRed()));//get the r
        int g=(int)(Math.abs(kd*nL*lightIntensity.getGreen()));//get the g
        int b=(int)(Math.abs(kd*nL*lightIntensity.getBlue()));//get the b
        return new Color(r, g, b);//return the color
    }

    
    
    
    /*************************************************
 	* FUNCTION
 	* getClosestPoint
 	* PARAMETERS
 	* Map<Geometry,List<Point3D>> -  the intersection points
 	* RETURN VALUE
 	* A map with the closest Point
 	* MEANING
 	* Find the closest point in the map of the intersection points.
 	* SEE ALSO
 	* findClosesntIntersection(Ray) , getSceneRayIntersections(ray).
 **************************************************/
    private Map<Geometry, Point3D> getClosestPoint(Map<Geometry, List<Point3D>> intersectionPoints){
        double distance=Double.MAX_VALUE;//final
        Point3D P0=_scene.getCamera().getP0();//get P0
        Map<Geometry, Point3D>minDistancePoint=new HashMap<>();//new HashMap
        for (Entry<Geometry, List<Point3D>>entry: intersectionPoints.entrySet()){//go all of the intersection Points
            for (Point3D point: entry.getValue()){//go in the list
                if(P0.distance(point)<distance) {//if is the Closest Point
                    minDistancePoint.clear();//go it
                    minDistancePoint.put(entry.getKey(), new Point3D(point));
                    distance=P0.distance(point);
                }
            }
        }
        return minDistancePoint;//return the Closest Point
    }


    
    
    
    
    /*************************************************
   	* FUNCTION
   	* getSceneRayIntersections
   	* PARAMETERS
   	* Ray – of the intersection
   	* RETURN VALUE
   	* A map with all the intersection in the shapes in the scene
   	* MEANING
   	* find and return all the intersection in the shapes of the scene
   	* SEE ALSO
   	* getClosestPoint(Map<Geometry, List<Point3D>>)
   	**************************************************/
    private Map<Geometry, List<Point3D>> getSceneRayIntersections(Ray ray) {
        Iterator<Geometry> geometries = _scene.getGeometriesIterator();//get Geometries Iterator
        Map<Geometry, List<Point3D>> intersectionPoints = new HashMap<Geometry, List<Point3D>>();//new HashMap
        while (geometries.hasNext()) {//go in all the geometries
            Geometry geometry = geometries.next();//Iterator ++
            List<Point3D> geometryIntersectionPoints = new ArrayList<>(geometry.FindIntersections(ray));//new ArrayList
            if (!geometryIntersectionPoints.isEmpty()) {//if is a Intersection Points
                intersectionPoints.put(geometry, geometryIntersectionPoints);//add it
            }
        }
        return intersectionPoints;// all of the Intersection Points
    }
    
    
    
    /*************************************************
   	* FUNCTION
   	* addColors
   	* PARAMETERS
   	* Color a, Color b - colors the add them
   	* RETURN VALUE
   	* color of the result of the add
   	* MEANING
   	* add two colors
   	* SEE ALSO
   	* calcColor(Geometry geometry, Point3D point, Ray ray)
   	**************************************************/
    private Color addColors(Color a, Color b){
        int r=a.getRed()+b.getRed();//add the Red
        int g=a.getGreen()+b.getGreen();//add the Green
        int bl=a.getBlue()+b.getBlue();//add the Blue
        if(r>255)//if it big moor the max
            r=255;//give it the max
        if(r<0)
            r=0;
        if(g>255)//if it big moor the max
            g=255;//give it the max
        if(g<0)
            g=0;
        if(bl>255)//if it big moor the max
            bl=255;//give it the max
        if(bl<0)
            bl=0;
        return new Color(r, g, bl);
    }

}
