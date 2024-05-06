package scene;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import elements.AmbientLight;
import elements.Camera;
import elements.LightSource;
import geometries.Geometry;

public class Scene {
    private Color _background;//The color of the background
    private AmbientLight _ambientLight;
    private List<Geometry> _geometries = new ArrayList<>(); //List with all the Geometry on the scene.
    private Camera _camera;// The camera that we will photograph with
    private double _screenDistance;//the Distance of the screen
    private List<LightSource> _lights = new ArrayList<>(); //List with all the lights
    private String _sceneName = "scene";// the name of the scene

    // ***************** Constructors ********************** //
    /*************************************************
    * FUNCTION
    * Default Constructor
    * PARAMETERS
    * ---
    * RETURN VALUE
    * ---
    * MEANING
    * Set the scene with a default values .
    * SEE ALSO
    * Scene (Scene scene),Scene(AmbientLight aLight, Color background,Camera camera, double screenDistance)
    **************************************************/

    public Scene(){
        _background=new Color(0,0,0);
        _ambientLight=new AmbientLight();
        _camera=new Camera();
        _sceneName="scene";
        _screenDistance=150;
    }
    /*************************************************
    * FUNCTION
    * Copy Constructor
    * PARAMETERS
    * Scene – object to copy.
    * RETURN VALUE
    * ---
    * MEANING
    * Copy the parameter to our object.
    * SEE ALSO
    * Scene (), Scene(AmbientLight aLight, Color background,Camera camera, double screenDistance).
    **************************************************/

    public Scene (Scene scene){
        _background=new Color(scene.getBackground().getRGB());
        _ambientLight=new AmbientLight(scene.getAmbientLight());
        _geometries=new ArrayList<>(scene._geometries);
        _camera=new Camera(scene.getCamera());
        _screenDistance=scene.getScreenDistance();
        _lights=new ArrayList<>(scene._lights);
        _sceneName=scene.getSceneName();
    }
    /*************************************************
    * FUNCTION
    * Constructor
    * PARAMETERS
    * AmbientLight aLight, Color background,Camera camera, double screenDistance
    * RETURN VALUE
    * ---
    * MEANING
    * Set the Scene with the values of the parameters.
    * SEE ALSO
    * Scene (Scene scene),Scene ().
    **************************************************/

    public Scene(AmbientLight aLight, Color background, Camera camera, double screenDistance){
        _background=new Color(background.getRGB());
        _ambientLight=new AmbientLight(aLight);
        _geometries=new ArrayList<>();
        _camera=new Camera(camera);
        _screenDistance=screenDistance;
        _lights=new ArrayList<>();
    }

    // ***************** Getters/Setters ********************** //
    /*************************************************
    * FUNCTION
    * getBackground
    * PARAMETERS
    * ---
    * MEANING
    * Return the color of the background.
    * SEE ALSO
    * setBackground(Color).
    **************************************************/

    public Color getBackground(){
        return new Color(_background.getRGB());
    }
    /*************************************************
    * FUNCTION
    * get_coordinate
    * PARAMETERS
    * ---
    * MEANING
    * Return the AmbientLight of the scene.
    * SEE ALSO
    * setAmbientLight(AmbientLight ambientLight).
    **************************************************/
    public AmbientLight getAmbientLight(){
        return new AmbientLight(_ambientLight);
    }
    /*************************************************
    * FUNCTION
    * getCamera
    * PARAMETERS
    * ---
    * MEANING
    * Return the Camera of the scene.
    * SEE ALSO
    * setCamera(Camera camera).
    **************************************************/

    public Camera getCamera(){
        return new Camera(_camera);
    }
    /*************************************************
    * FUNCTION
    * getSceneName
    * PARAMETERS
    * ---
    * MEANING
    * Return the name of the scene.
    * SEE ALSO
    * setSceneName(String sceneNAme).
    **************************************************/
    public String getSceneName(){
        return _sceneName;
    }
    /*************************************************
    * FUNCTION
    * getScreenDistance
    * PARAMETERS
    * ---
    * MEANING
    * Return the distance of the screen of the coordinate.
    * SEE ALSO
    * setScreenDistance(double screenDistance)
    **************************************************/
    public double getScreenDistance(){
        return _screenDistance;
    }
    /*************************************************
    * FUNCTION
    * setBackground
    * PARAMETERS
    * Color – the value to set on the background.
    * RETURN VALUE
    * ---
    * MEANING
    * Set the background with the value of the parameter.
    * SEE ALSO
    * getBackground().
    **************************************************/
    public void setBackground(Color background){
        _background=new Color(background.getRGB());
    }
    /*************************************************
    * FUNCTION
    * setAmbientLight
    * PARAMETERS
    * AmbientLight – the value to set on the ambientLight of the scene.
    * RETURN VALUE
    * ---
    * MEANING
    * Set the ambientLight with the value of the parameter.
    * SEE ALSO
    * getAmbientLight().
    **************************************************/
    public void setAmbientLight(AmbientLight ambientLight){
        _ambientLight=new AmbientLight(ambientLight);
    }
    /*************************************************
    * FUNCTION
    * setCamera
    * PARAMETERS
    * Camera – the value to set on the Camera of the scen.
    * RETURN VALUE
    * ---
    * MEANING
    * Set the Camera with the value of the parameter.
    * SEE ALSO
    * getCamera().
    **************************************************/

    public void setCamera(Camera camera){
        _camera=new Camera(camera);
    }
    /*************************************************
    * FUNCTION
    * setSceneName
    * PARAMETERS
    * String – the value to set on the name.
    * RETURN VALUE
    * ---
    * MEANING
    * Set the name of the scene with the value of the parameter.
    * SEE ALSO
    * getSceneName().
    **************************************************/

    public void setSceneName(String sceneName){
        _sceneName=sceneName;
    }
    /*************************************************
    * FUNCTION
    * set_coordinate
    * PARAMETERS
    * double – the value to set on the screen distance.
    * RETURN VALUE
    * ---
    * MEANING
    * Set the distance of the screen with the value of the parameter.
    * SEE ALSO
    * getScreenDistance.
    **************************************************/

    public void setScreenDistance(double screenDistance){
        _screenDistance=screenDistance;
    }

    // ***************** Operations ******************** //
    /*************************************************
    * FUNCTION
    * addGeometry
    * PARAMETERS
    * Geometry – Geometry to add to the scene
    * RETURN VALUE
    * ---
    * MEANING
    * Add the parameter to the scene
    * SEE ALSO
    * addLight(Light)
    **************************************************/

    public void addGeometry(Geometry geometry){
        _geometries.add(geometry);//adding the geometry to the list
    }
    /*************************************************
    * FUNCTION
    * getGeometriesIterator
    * PARAMETERS
    * ---
    * RETURN VALUE
    * The Iterator to the list of Geometry
    * MEANING
    * return Iterator to the list of Geometries
    * SEE ALSO
    * getLightsIterator()
    **************************************************/

    public Iterator<Geometry> getGeometriesIterator(){
        return _geometries.iterator();//return the iterator
    }
    /*************************************************
    * FUNCTION
    * addLight
    * PARAMETERS
    * LightSource – LightSource to add to the scene
    * RETURN VALUE
    * ---
    * MEANING
    * Add LightSource to the scene
    * SEE ALSO
    * addGeometry(Geometry geometry)
    **************************************************/

    public void addLight(LightSource light){
        _lights.add(light);//Adding the light to the List
    }
    /*************************************************
    * FUNCTION
    * getLightsIterator
    * PARAMETERS
    * ---
    * RETURN VALUE
    * The Iterator to the list of light source
    * MEANING
    * return Iterator to the list of light source
    * SEE ALSO
    * getGeometriesIterator()
    **************************************************/

    public Iterator<LightSource> getLightsIterator(){
        return _lights.iterator();//return the iterator
    }
}
