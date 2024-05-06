package renderer;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

import elements.AmbientLight;
import elements.Camera;
import elements.DirectionalLight;
import elements.PointLight;
import elements.SpotLight;
import geometries.Plane;
import geometries.Sphere;
import geometries.Triangle;
import primitives.Material;
import primitives.Point3D;
import primitives.Vector;
import scene.Scene;

public class RenderTest {

/*	@Test
	public void shadowTest1(){
		
		Scene scene = new Scene();
		new Point3D( 3500.0,  3500.0, -2000.0);
              	Sphere sphere = new Sphere(500, new Point3D(0.0,0.0,-1000.0),new Color(255,255,255),0.0, new Material());
		sphere.set_nShininess(20);
		sphere.set_emmission(new Color(0, 0, 100));
		
		scene.addGeometry(sphere);
		
		Triangle triangle1 = new Triangle(new Point3D(  3500.0,  3500.0, -2000.0),
							 new Point3D( -3500.0, -3500.0, -1000.0),
				 						 new Point3D(  3500.0, -3500.0, -2000.0),new Color(255,255,255),0.0, new Material());

		Triangle triangle2 = new Triangle(new Point3D(  3500.0,  3500.0, -2000.0),
				  						  new Point3D( -3500.0,  3500.0, -1000.0),
				  						  new Point3D( -3500.0, -3500.0, -1000.0),new Color(255,255,255),0.0, new Material());
		
		scene.addGeometry(triangle1);
		scene.addGeometry(triangle2);
		
		scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(200.0, 200.0, -100.0), 
				   new Vector(-2, -2, -3), 0, 0.000001, 0.0000005));
	
		
		ImageWriter imageWriter = new ImageWriter("Shadow111111111 test", 500, 500, 500, 500);
		
		Render render = new Render(imageWriter, scene);
		
		render.renderImage();
	//	render.writeToImage();
		
	}
 /*


	 @Test
	    public void basicRendering2(){

	        Camera camera=new Camera(new Point3D(0.0, 0.0, 0.0), new Vector(0,1,0), new Vector(0, 0, -1));
	        Scene scene = new Scene(new AmbientLight(255, 255, 255), new Color(0,0,0), camera, 100);

	        scene.addGeometry(new Plane(new Vector(0,1, 0), new Point3D(0.0, -5.0 , 0.0), new Color(0,0,0), 10.0 , new Material(1, 1, 0, 0 ,1)));
	        scene.addGeometry(new Sphere(1.5, new Point3D(-5.0, -3.5 , -4.0),new Color(0,0,50), 50.0 , new Material(1, 1, 0, 0 ,1)));
	        scene.addGeometry(new Triangle(new Point3D(0.0, -5.0, -5.0), new Point3D(-15.0, 40.0, -12.5), new Point3D(-30.0, -5.0, -20.0), new Color(0,0,0), 1.0 , new Material(1, 1, 1, 0 ,1)));
	        scene.addGeometry(new Triangle(new Point3D(5.0, 10.0, -25.0), new Point3D(0.0, 2.0, -25.0), new Point3D(-30.0, 2.0, -25.0), new Color(0,40,0), 1.0 , new Material(1, 1, 0, 0 ,1)));

	        scene.addLight(new PointLight(new Color(255,50,50), new Point3D(0.0, 15.0, -6.0), 0.1, 0.1, 0.1));
	        //scene.addLight(new PointLight(new Color(255,50,50), new Point3D(0.0, 15.0, -6.0), 0.1, 0.1, 0.1));
	        ImageWriter imageWriter = new ImageWriter("Render test1", 500, 500, 500, 500);

	        Render render = new Render(imageWriter, scene);
	        render.renderImage();
	    }

	    /**
	     * ambiant_light+emission-Test
	     
	    @Test
	    public void testRenderImage() throws Exception {
	        Camera camera=new Camera(new Point3D(0.0, 0.0, 0.0), new Vector(0,1,0), new Vector(0, 0, -1));
	        Scene scene = new Scene(new AmbientLight(255, 255, 255), new Color(0,0,0), camera, 48);
	        scene.addGeometry(new Triangle(new Point3D(100.0, 0.0, -49.0), new Point3D(0.0, 100.0, -49.0), new Point3D(100.0, 100.0, -49.0), new Color(241,91,91), 1.0 , new Material(1, 1, 0, 0 ,1)));
	        scene.addGeometry(new Sphere(10.0, new Point3D(0.0, 0.0 , -50.0),new Color(0,0,0), 1.0 , new Material(1, 1, 0, 0 ,1)));
	        scene.addGeometry(new Triangle(new Point3D(-100.0, 0.0, -49.0), new Point3D(0.0, 100.0, -49.0), new Point3D(-100.0, 100.0, -49.0), new Color(91,241,92), 1.0 , new Material(1, 1, 0, 0 ,1)));
	        scene.addGeometry(new Triangle(new Point3D(100.0, 0.0, -49.0), new Point3D(0.0, -100.0, -49.0), new Point3D(100.0, -100.0, -49.0), new Color(91,91,241), 1.0 , new Material(1, 1, 0, 0 ,1)));
	        scene.addGeometry(new Triangle(new Point3D(-100.0, 0.0, -49.0), new Point3D(0.0, -100.0, -49.0), new Point3D(-100.0, -100.0, -49.0), new Color(0,0,0), 1.0 , new Material(1, 1, 0, 0 ,1)));
	        ImageWriter imageWriter = new ImageWriter("Render test2", 500, 500, 500, 500);
	        Render render = new Render(imageWriter, scene);
	        render.renderImage();
	    }
	    /**
	     * pointlight
	     
	    @Test
	    public void sceneTestPoint() throws Exception {
	        Camera camera=new Camera(new Point3D(0.0, 0.0, 0.0), new Vector(0,1,0), new Vector(0, 0, -1));
	        Scene scene = new Scene(new AmbientLight(255, 255, 255), new Color(0,0,0), camera, 100);
	        //scene.addGeometry(new Plane(new Vector(0,1, 0), new Point3D(0.0, -130.0 , 0.0), new Color(0,0,0), 200.0 , new Material(0, 0, 0, 0 ,0)));
	        scene.addGeometry(new Sphere(900.0, new Point3D(0.0, 0.0 , -1300.0),new Color(17,15,116), 35.0 , new Material(1, 1, 0, 1,0)));
	        //scene.addGeometry(new Triangle(new Point3D(1000.0, -200.0, -600.0), new Point3D(-100.0, -200.0, -1000.0), new Point3D(400.0, 1000.0, -800.0), new Color(0,0,0), 1.0 , new Material(0, 0, 1, 0 ,0)));
	        scene.addGeometry(new Sphere(700.0, new Point3D(-200.0, 0.0 , -1500.0),new Color(116,15,17), 35.0 , new Material(0.5, 0.5, 0, 0.5,1)));
	        //  scene.addGeometry(new Sphere(300.0, new Point3D(-200.0, 0.0 , -1500.0),new Color(15,200,17), 35.0 , new Material(1, 1, 0, 0,1)));
	        scene.addLight(new PointLight(new Color(255,50,50), new Point3D(200.0, 200.0, -20.0), 0.002, 0.002, 0.001));
	        //scene.addLight(new SpotLight(new Color(255, 50, 50), new Point3D(200.0, 200.0, -20.0), new Vector(-200.0, -200.0, -1280.0),0.002, 0.002, 0.001));
	        ImageWriter imageWriter = new ImageWriter("SceneTestPoint1", 500, 500, 500, 500);
	        Render render = new Render(imageWriter, scene);
	        render.renderImage();
	    }
	    
	     //* pointlight2
	     
	    @Test
	    public void sceneTestPoint2() throws Exception {
	        Camera camera=new Camera(new Point3D(0.0, 0.0, 0.0), new Vector(0,1,0), new Vector(0, 0, -1));
	        Scene scene = new Scene(new AmbientLight(255, 255, 255), new Color(0,0,0), camera, 100);
	        scene.addGeometry(new Sphere(900.0, new Point3D(0.0, 0.0 , -1300.0),new Color(17,15,116), 35.0 , new Material(1, 1, 0, 1,0)));
	        scene.addLight(new PointLight(new Color(255,50,50), new Point3D(200.0, 200.0, -20.0), 0.002, 0.002, 0.001));
	        ImageWriter imageWriter = new ImageWriter("SceneTestPoint2", 500, 500, 500, 500);
	        Render render = new Render(imageWriter, scene);
	        render.renderImage();
	    }

	    
	       *sceneTestSpot1
	     
	    @Test
	    public void SceneTestSpot() throws Exception {
	        Camera camera=new Camera(new Point3D(0.0, 0.0, 0.0), new Vector(0,1,0), new Vector(0, 0, -1));
	        Scene scene = new Scene(new AmbientLight(255, 255, 255), new Color(0, 0, 0), camera, 100);
	        //scene.addGeometry(new Plane(new Vector(0,1, 0), new Point3D(0.0, -130.0 , 0.0), new Color(0,0,0), 200.0 , new Material(0, 0, 0, 0 ,0)));
	      scene.addGeometry(new Sphere(900.0, new Point3D(0.0, 0.0 , -1300.0),new Color(255, 14, 199), 35.0 , new Material(1, 1, 0, 1,0)));
	       //scene.addGeometry(new Triangle(new Point3D(40.0, -70.0, -444.0), new Point3D(-100.0, -200.0, -1000.0), new Point3D(400.0, 1000.0, -800.0), new Color(255, 254, 25), 1.0 , new Material(0, 0, 1, 0 ,0)));
	     //  scene.addGeometry(new Sphere(700.0, new Point3D(-200.0, 0.0 , -1500.0),new Color(116,15,17), 35.0 , new Material(0.5, 0.5, 0, 0.5,1)));
	    //scene.addGeometry(new Sphere(990.0, new Point3D(-200.0, 0.0 , -1500.0),new Color(15,200,17), 35.0 , new Material(1, 1, 0, 0,1)));
	     // scene.addLight(new PointLight(new Color(149, 255, 90), new Point3D(200.0, 200.0, -20.0), 0.00005, 0.00005, 0.00001));
	        scene.addGeometry(new Triangle(new Point3D(200.0, 200.0, -300.0), new Point3D(0.0, 200.0, -300.0), new Point3D(100.0, 400.0, -300.0), new Color(64, 86, 255), 1.0 , new Material(0.2, 0.2, 0, 0 ,1)));
	        //scene.addGeometry(new Triangle(new Point3D(500.0, 200.0, -300.0), new Point3D(0.0, 200.0, -300.0), new Point3D(100.0, 400.0, -300.0), new Color(0,0,0), 1.0 , new Material(0.2, 0.2, 0, 0 ,1)));
	        //scene.addGeometry(new Triangle(new Point3D(200.0, -0.0, -300.0), new Point3D(100.0, -200.0, -300.0), new Point3D(0.0, -0.0, -300.0), new Color(0,0,0), 1.0 , new Material(0.2, 0.2, 0, 0 ,1)));

	      //  scene.addGeometry(new Sphere(900.0, new Point3D(0.0, 0.0 , -1300.0),new Color(0,0,0), 35.0 , new Material(1, 1, 0, 0,1)));

	        // scene.addLight(new DirectionalLight(new Color(50,50,50),new Vector(50.0,50.0,50.0)));
	        scene.addLight(new DirectionalLight(new Color(255, 254, 25),new Vector(0.0,0.0,-20)));
	       // scene.addLight(new SpotLight(new Color(255, 38, 28), new Point3D(200.0, 200.0, -20.0), new Vector(-200.0, -200.0, -280.0),0.00005, 0.00005, 0.00001));
	        ImageWriter imageWriter = new ImageWriter("sceneTestSpot112&directi12a11a11", 500, 500, 500, 500);
	        Render render = new Render(imageWriter, scene);
	        render.renderImage();
	    }

	   
	   //  * sceneTestShadow
	     
	    @Test
	    public void sceneTestShadow() throws Exception {
	        Camera camera=new Camera(new Point3D(0.0, 0.0, 0.0), new Vector(0,1,0), new Vector(0, 0, -1));
	        Scene scene = new Scene(new AmbientLight(255, 255, 255), new Color(0,0,0), camera, 100);
	        scene.addGeometry(new Sphere(900.0, new Point3D(0.0, 0.0 , -1300.0),new Color(0,0,0), 35.0 , new Material(1, 1, 0, 0,1)));
	        scene.addGeometry(new Triangle(new Point3D(200.0, 200.0, -300.0), new Point3D(400.0, 100.0, -300.0), new Point3D(200.0, 0.0, -300.0), new Color(0,0,0), 1.0 , new Material(0.2, 0.2, 0, 0 ,1)));
	        scene.addGeometry(new Triangle(new Point3D(0.0, 200.0, -300.0), new Point3D(0.0, 0.0, -300.0), new Point3D(-200.0, 100.0, -300.0), new Color(0,0,0), 1.0 , new Material(0.2, 0.2, 0, 0 ,1)));
	        scene.addGeometry(new Triangle(new Point3D(200.0, -0.0, -300.0), new Point3D(100.0, -200.0, -300.0), new Point3D(0.0, -0.0, -300.0), new Color(0,0,0), 1.0 , new Material(0.2, 0.2, 0, 0 ,1)));
	        scene.addGeometry(new Triangle(new Point3D(200.0, 200.0, -300.0), new Point3D(0.0, 200.0, -300.0), new Point3D(100.0, 400.0, -300.0), new Color(0,0,0), 1.0 , new Material(0.2, 0.2, 0, 0 ,1)));
	        scene.addLight(new PointLight(new Color(255,50,50), new Point3D(600.0, 200.0, -20.0), 0.000004, 0.000004, 0.000002));scene.addLight(new PointLight(new Color(255,50,50), new Point3D(600.0, 200.0, -20.0), 0.000004, 0.000004, 0.000002));
	        ImageWriter imageWriter = new ImageWriter("sceneTestShadow2", 500, 500, 500, 500);
	        Render render = new Render(imageWriter, scene);
	        render.renderImage();
	    }

	    @Test
	    public void newTestScene(){

	        Camera camera=new Camera(new Point3D(0.0, 0.0, 0.0), new Vector(0,1,0), new Vector(0, 0, -1));
	        Scene scene = new Scene(new AmbientLight(255, 255, 255), new Color(0,0,0), camera, 100);

	        scene.addGeometry(new Triangle(new Point3D(0.0, -5.0, -5.0), new Point3D(-15.0, 40.0, -12.5), new Point3D(-30.0, -5.0, -20.0), new Color(0,0,0), 1.0 , new Material(1, 1, 1, 0 ,1)));
	        scene.addGeometry(new Triangle(new Point3D(0.0, -5.0, -5.0), new Point3D(-15.0, 40.0, -12.5), new Point3D(-30.0, -5.0, -20.0), new Color(0,0,0), 1.0 , new Material(1, 1, 1, 0 ,1)));
	        scene.addGeometry(new Triangle(new Point3D(5.0, 10.0, -25.0), new Point3D(0.0, 2.0, -25.0), new Point3D(-30.0, 2.0, -25.0), new Color(0,40,0), 1.0 , new Material(1, 1, 0, 0 ,1)));
	        scene.addLight(new SpotLight(new Color(255, 50, 50), new Point3D(200.0, 200.0, -20.0), new Vector(-200.0, -200.0, -1280.0),0.002, 0.002, 0.001));
	        scene.addLight(new PointLight(new Color(255,50,50), new Point3D(0.0, 15.0, -6.0), 0.1, 0.1, 0.1));
	        //scene.addLight(new PointLight(new Color(255,50,50), new Point3D(0.0, 15.0, -6.0), 0.1, 0.1, 0.1));
	        ImageWriter imageWriter = new ImageWriter("Render test1", 500, 500, 500, 500);

	        Render render = new Render(imageWriter, scene);
	        render.renderImage();
	    }

	    @Test
	    public void shadowTest() {

	        Scene scene = new Scene();
	        scene.addGeometry(new Sphere(500, new Point3D(0.0, 0.0, -1000.0), new Color(0, 0, 100), 20.0, new Material()));


	        Triangle triangle = new Triangle(new Point3D(3500.0, 3500.0, -2000.0), new Point3D(-3500.0, -3500.0, -1000.0), new Point3D(3500.0, -3500.0, -2000.0));

	        Triangle triangle2 = new Triangle(new Point3D(3500.0, 3500.0, -2000.0),
	                new Point3D(-3500.0, 3500.0, -1000.0),
	                new Point3D(-3500.0, -3500.0, -1000.0));

	        scene.addGeometry(triangle);
	        scene.addGeometry(triangle2);

	        scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(200.0, 200.0, -100.0), new Vector(-2, -2, -3), 0, 0.000001, 0.0000005));


	        ImageWriter imageWriter = new ImageWriter("shadowTrst", 500, 500, 500, 500);

	        Render render = new Render(imageWriter, scene);

	        render.renderImage();
	        imageWriter.writeToimage();

	    }

	    @Test
	    public void newTT() throws Exception {


	        Camera camera = new Camera(new Point3D(0.0,0.0,0.0), new Vector(0, 0,1), new Vector(1,0,0));
	        Scene scene = new Scene(new AmbientLight(90, 90, 90), new Color(0, 0, 0), camera, 100);
	      //  scene.addGeometry(new Sphere(500, new Point3D(80.0, 100.0, 1000.0), new Color(0, 0, 100), 20.0, new Material()));
	        scene.addGeometry(new Triangle(new Point3D(162.500000,700.000000,124.000000),new Point3D(0.000000,0.000000,0.000000),new Point3D(0.000000,0.000000,0.000000),new Color(255,255,255),0.0, new Material()));
	        scene.addGeometry(new Triangle(new Point3D(162.500000,700.000000,124.000000),new Point3D(0.000000,0.000000,0.000000),new Point3D(0.000000,0.000000,0.000000),new Color(255,255,255),0.0, new Material()));
	        scene.addGeometry(new Triangle(new Point3D(38.650002,700.000000,124.000000),new Point3D(0.000000,0.000000,0.000000),new Point3D(0.000000,0.000000,0.000000),new Color(255,255,255),0.0, new Material()));
	        scene.addGeometry(new Triangle(new Point3D(38.650002,700.000000,124.000000),new Point3D(0.000000,0.000000,0.000000),new Point3D(0.000000,0.000000,0.000000),new Color(255,255,255),0.0, new Material()));
	        scene.addGeometry(new Triangle(new Point3D(38.650002,700.000000,-124.000000),new Point3D(0.000000,0.000000,0.000000),new Point3D(0.000000,0.000000,0.000000),new Color(255,255,255),0.0, new Material()));
	        scene.addGeometry(new Triangle(new Point3D(38.650002,700.000000,-124.000000),new Point3D(0.000000,0.000000,0.000000),new Point3D(0.000000,0.000000,0.000000),new Color(255,255,255),0.0, new Material()));
	        scene.addGeometry(new Triangle(new Point3D(162.500000,700.000000,-124.000000),new Point3D(0.000000,0.000000,0.000000),new Point3D(0.000000,0.000000,0.000000),new Color(255,255,255),0.0, new Material()));
	        scene.addGeometry(new Triangle(new Point3D(162.500000,700.000000,-124.000000),new Point3D(0.000000,0.000000,0.000000),new Point3D(0.000000,0.000000,0.000000),new Color(255,255,255),0.0, new Material()));
	        scene.addGeometry(new Triangle(new Point3D(38.650002,700.000000,-124.000000),new Point3D(0.000000,0.000000,0.000000),new Point3D(0.000000,0.000000,0.000000),new Color(255,255,255),0.0, new Material()));
	        scene.addGeometry(new Triangle(new Point3D(38.650002,700.000000,-124.000000),new Point3D(0.000000,0.000000,0.000000),new Point3D(0.000000,0.000000,0.000000),new Color(255,255,255),0.0, new Material()));
	        scene.addGeometry(new Triangle(new Point3D(162.500000,450.500000,124.000000),new Point3D(0.000000,0.000000,0.000000),new Point3D(0.000000,0.000000,0.000000),new Color(255,255,255),0.0, new Material()));
	        scene.addGeometry(new Triangle(new Point3D(162.500000,450.500000,124.000000),new Point3D(0.000000,0.000000,0.000000),new Point3D(0.000000,0.000000,0.000000),new Color(255,255,255),0.0, new Material()));
	        scene.addGeometry(new Triangle(new Point3D(173.500000,870.000000,64.500000),new Point3D(0.000000,0.000000,0.000000),new Point3D(0.000000,0.000000,0.000000),new Color(255,255,255),0.0, new Material()));
	        scene.addGeometry(new Triangle(new Point3D(173.500000,870.000000,64.500000),new Point3D(0.000000,0.000000,0.000000),new Point3D(0.000000,0.000000,0.000000),new Color(255,255,255),0.0, new Material()));
	        scene.addGeometry(new Triangle(new Point3D(30.050001,870.000000,64.500000),new Point3D(0.000000,0.000000,0.000000),new Point3D(0.000000,0.000000,0.000000),new Color(255,255,255),0.0, new Material()));
	        scene.addGeometry(new Triangle(new Point3D(30.050001,870.000000,64.500000),new Point3D(0.000000,0.000000,0.000000),new Point3D(0.000000,0.000000,0.000000),new Color(255,255,255),0.0, new Material()));
	        scene.addGeometry(new Triangle(new Point3D(30.050001,870.000000,-59.500004),new Point3D(0.000000,0.000000,0.000000),new Point3D(0.000000,0.000000,0.000000),new Color(255,255,255),0.0, new Material()));
	        scene.addGeometry(new Triangle(new Point3D(30.050001,870.000000,-59.500004),new Point3D(0.000000,0.000000,0.000000),new Point3D(0.000000,0.000000,0.000000),new Color(255,255,255),0.0, new Material()));
	        scene.addGeometry(new Triangle(new Point3D(173.500000,870.000000,-59.500004),new Point3D(0.000000,0.000000,0.000000),new Point3D(0.000000,0.000000,0.000000),new Color(255,255,255),0.0, new Material()));
	        scene.addGeometry(new Triangle(new Point3D(173.500000,870.000000,-59.500004),new Point3D(0.000000,0.000000,0.000000),new Point3D(0.000000,0.000000,0.000000),new Color(255,255,255),0.0, new Material()));
	        scene.addGeometry(new Triangle(new Point3D(30.050001,870.000000,-59.500004),new Point3D(0.000000,0.000000,0.000000),new Point3D(0.000000,0.000000,0.000000),new Color(255,255,255),0.0, new Material()));
	        scene.addGeometry(new Triangle(new Point3D(30.050001,870.000000,-59.500004),new Point3D(0.000000,0.000000,0.000000),new Point3D(0.000000,0.000000,0.000000),new Color(255,255,255),0.0, new Material()));
	        scene.addGeometry(new Triangle(new Point3D(173.500000,750.000000,64.500000),new Point3D(0.000000,0.000000,0.000000),new Point3D(0.000000,0.000000,0.000000),new Color(255,255,255),0.0, new Material()));
	        scene.addGeometry(new Triangle(new Point3D(173.500000,750.000000,64.500000),new Point3D(0.000000,0.000000,0.000000),new Point3D(0.000000,0.000000,0.000000),new Color(255,255,255),0.0, new Material()));
	        scene.addGeometry(new Triangle(new Point3D(157.500000,400.500000,123.500000),new Point3D(0.000000,0.000000,0.000000),new Point3D(0.000000,0.000000,0.000000),new Color(255,255,255),0.0, new Material()));
	        scene.addGeometry(new Triangle(new Point3D(157.500000,400.500000,123.500000),new Point3D(0.000000,0.000000,0.000000),new Point3D(0.000000,0.000000,0.000000),new Color(255,255,255),0.0, new Material()));
	        scene.addGeometry(new Triangle(new Point3D(44.600002,400.500000,123.500000),new Point3D(0.000000,0.000000,0.000000),new Point3D(0.000000,0.000000,0.000000),new Color(255,255,255),0.0, new Material()));
	        scene.addGeometry(new Triangle(new Point3D(44.600002,400.500000,123.500000),new Point3D(0.000000,0.000000,0.000000),new Point3D(0.000000,0.000000,0.000000),new Color(255,255,255),0.0, new Material()));
	        scene.addGeometry(new Triangle(new Point3D(44.600002,400.500000,24.299999),new Point3D(0.000000,0.000000,0.000000),new Point3D(0.000000,0.000000,0.000000),new Color(255,255,255),0.0, new Material()));
	        scene.addGeometry(new Triangle(new Point3D(44.600002,400.500000,24.299999),new Point3D(0.000000,0.000000,0.000000),new Point3D(0.000000,0.000000,0.000000),new Color(255,255,255),0.0, new Material()));
	        scene.addGeometry(new Triangle(new Point3D(157.500000,400.500000,24.299999),new Point3D(0.000000,0.000000,0.000000),new Point3D(0.000000,0.000000,0.000000),new Color(255,255,255),0.0, new Material()));
	        scene.addGeometry(new Triangle(new Point3D(157.500000,400.500000,24.299999),new Point3D(0.000000,0.000000,0.000000),new Point3D(0.000000,0.000000,0.000000),new Color(255,255,255),0.0, new Material()));
	        scene.addGeometry(new Triangle(new Point3D(44.600002,400.500000,24.299999),new Point3D(0.000000,0.000000,0.000000),new Point3D(0.000000,0.000000,0.000000),new Color(255,255,255),0.0, new Material()));
	        scene.addGeometry(new Triangle(new Point3D(44.600002,400.500000,24.299999),new Point3D(0.000000,0.000000,0.000000),new Point3D(0.000000,0.000000,0.000000),new Color(255,255,255),0.0, new Material()));
	        scene.addGeometry(new Triangle(new Point3D(157.500000,152.500000,123.500000),new Point3D(0.000000,0.000000,0.000000),new Point3D(0.000000,0.000000,0.000000),new Color(255,255,255),0.0, new Material()));
	        scene.addGeometry(new Triangle(new Point3D(157.500000,152.500000,123.500000),new Point3D(0.000000,0.000000,0.000000),new Point3D(0.000000,0.000000,0.000000),new Color(255,255,255),0.0, new Material()));
	        scene.addGeometry(new Triangle(new Point3D(161.500000,700.000000,198.000000),new Point3D(0.000000,0.000000,0.000000),new Point3D(0.000000,0.000000,0.000000),new Color(255,255,255),0.0, new Material()));
	        scene.addGeometry(new Triangle(new Point3D(161.500000,700.000000,198.000000),new Point3D(0.000000,0.000000,0.000000),new Point3D(0.000000,0.000000,0.000000),new Color(255,255,255),0.0, new Material()));
	        scene.addGeometry(new Triangle(new Point3D(37.349998,700.000000,198.000000),new Point3D(0.000000,0.000000,0.000000),new Point3D(0.000000,0.000000,0.000000),new Color(255,255,255),0.0, new Material()));
	        scene.addGeometry(new Triangle(new Point3D(37.349998,700.000000,198.000000),new Point3D(0.000000,0.000000,0.000000),new Point3D(0.000000,0.000000,0.000000),new Color(255,255,255),0.0, new Material()));
	        scene.addGeometry(new Triangle(new Point3D(37.349998,700.000000,124.000000),new Point3D(0.000000,0.000000,0.000000),new Point3D(0.000000,0.000000,0.000000),new Color(255,255,255),0.0, new Material()));
	        scene.addGeometry(new Triangle(new Point3D(37.349998,700.000000,124.000000),new Point3D(0.000000,0.000000,0.000000),new Point3D(0.000000,0.000000,0.000000),new Color(255,255,255),0.0, new Material()));
	        scene.addGeometry(new Triangle(new Point3D(161.500000,700.000000,124.000000),new Point3D(0.000000,0.000000,0.000000),new Point3D(0.000000,0.000000,0.000000),new Color(255,255,255),0.0, new Material()));
	        scene.addGeometry(new Triangle(new Point3D(161.500000,700.000000,124.000000),new Point3D(0.000000,0.000000,0.000000),new Point3D(0.000000,0.000000,0.000000),new Color(255,255,255),0.0, new Material()));
	        scene.addGeometry(new Triangle(new Point3D(37.349998,700.000000,124.000000),new Point3D(0.000000,0.000000,0.000000),new Point3D(0.000000,0.000000,0.000000),new Color(255,255,255),0.0, new Material()));
	        scene.addGeometry(new Triangle(new Point3D(37.349998,700.000000,124.000000),new Point3D(0.000000,0.000000,0.000000),new Point3D(0.000000,0.000000,0.000000),new Color(255,255,255),0.0, new Material()));
	        scene.addGeometry(new Triangle(new Point3D(161.500000,450.500000,198.000000),new Point3D(0.000000,0.000000,0.000000),new Point3D(0.000000,0.000000,0.000000),new Color(255,255,255),0.0, new Material()));
	        scene.addGeometry(new Triangle(new Point3D(161.500000,450.500000,198.000000),new Point3D(0.000000,0.000000,0.000000),new Point3D(0.000000,0.000000,0.000000),new Color(255,255,255),0.0, new Material()));
	        scene.addGeometry(new Triangle(new Point3D(163.500000,700.000000,-123.000000),new Point3D(0.000000,0.000000,0.000000),new Point3D(0.000000,0.000000,0.000000),new Color(255,255,255),0.0, new Material()));
	        scene.addGeometry(new Triangle(new Point3D(163.500000,700.000000,-123.000000),new Point3D(0.000000,0.000000,0.000000),new Point3D(0.000000,0.000000,0.000000),new Color(255,255,255),0.0, new Material()));
	        scene.addGeometry(new Triangle(new Point3D(39.750000,700.000000,-123.000000),new Point3D(0.000000,0.000000,0.000000),new Point3D(0.000000,0.000000,0.000000),new Color(255,255,255),0.0, new Material()));
	        scene.addGeometry(new Triangle(new Point3D(39.750000,700.000000,-123.000000),new Point3D(0.000000,0.000000,0.000000),new Point3D(0.000000,0.000000,0.000000),new Color(255,255,255),0.0, new Material()));
	        scene.addGeometry(new Triangle(new Point3D(39.750000,700.000000,-197.500000),new Point3D(0.000000,0.000000,0.000000),new Point3D(0.000000,0.000000,0.000000),new Color(255,255,255),0.0, new Material()));
	        scene.addGeometry(new Triangle(new Point3D(39.750000,700.000000,-197.500000),new Point3D(0.000000,0.000000,0.000000),new Point3D(0.000000,0.000000,0.000000),new Color(255,255,255),0.0, new Material()));
	        scene.addGeometry(new Triangle(new Point3D(163.500000,700.000000,-197.500000),new Point3D(0.000000,0.000000,0.000000),new Point3D(0.000000,0.000000,0.000000),new Color(255,255,255),0.0, new Material()));
	        scene.addGeometry(new Triangle(new Point3D(163.500000,700.000000,-197.500000),new Point3D(0.000000,0.000000,0.000000),new Point3D(0.000000,0.000000,0.000000),new Color(255,255,255),0.0, new Material()));
	        scene.addGeometry(new Triangle(new Point3D(39.750000,700.000000,-197.500000),new Point3D(0.000000,0.000000,0.000000),new Point3D(0.000000,0.000000,0.000000),new Color(255,255,255),0.0, new Material()));
	        scene.addGeometry(new Triangle(new Point3D(39.750000,700.000000,-197.500000),new Point3D(0.000000,0.000000,0.000000),new Point3D(0.000000,0.000000,0.000000),new Color(255,255,255),0.0, new Material()));
	        scene.addGeometry(new Triangle(new Point3D(163.500000,450.500000,-123.000000),new Point3D(0.000000,0.000000,0.000000),new Point3D(0.000000,0.000000,0.000000),new Color(255,255,255),0.0, new Material()));
	        scene.addGeometry(new Triangle(new Point3D(163.500000,450.500000,-123.000000),new Point3D(0.000000,0.000000,0.000000),new Point3D(0.000000,0.000000,0.000000),new Color(255,255,255),0.0, new Material()));
	        scene.addGeometry(new Triangle(new Point3D(124.500000,750.000000,24.900000),new Point3D(0.000000,0.000000,0.000000),new Point3D(0.000000,0.000000,0.000000),new Color(255,255,255),0.0, new Material()));
	        scene.addGeometry(new Triangle(new Point3D(124.500000,750.000000,24.900000),new Point3D(0.000000,0.000000,0.000000),new Point3D(0.000000,0.000000,0.000000),new Color(255,255,255),0.0, new Material()));
	        scene.addGeometry(new Triangle(new Point3D(75.000000,750.000000,24.900000),new Point3D(0.000000,0.000000,0.000000),new Point3D(0.000000,0.000000,0.000000),new Color(255,255,255),0.0, new Material()));
	        scene.addGeometry(new Triangle(new Point3D(75.000000,750.000000,24.900000),new Point3D(0.000000,0.000000,0.000000),new Point3D(0.000000,0.000000,0.000000),new Color(255,255,255),0.0, new Material()));
	        scene.addGeometry(new Triangle(new Point3D(75.000000,750.000000,-24.650000),new Point3D(0.000000,0.000000,0.000000),new Point3D(0.000000,0.000000,0.000000),new Color(255,255,255),0.0, new Material()));
	        scene.addGeometry(new Triangle(new Point3D(75.000000,750.000000,-24.650000),new Point3D(0.000000,0.000000,0.000000),new Point3D(0.000000,0.000000,0.000000),new Color(255,255,255),0.0, new Material()));
	        scene.addGeometry(new Triangle(new Point3D(124.500000,750.000000,-24.650000),new Point3D(0.000000,0.000000,0.000000),new Point3D(0.000000,0.000000,0.000000),new Color(255,255,255),0.0, new Material()));
	        scene.addGeometry(new Triangle(new Point3D(124.500000,750.000000,-24.650000),new Point3D(0.000000,0.000000,0.000000),new Point3D(0.000000,0.000000,0.000000),new Color(255,255,255),0.0, new Material()));
	        scene.addGeometry(new Triangle(new Point3D(75.000000,750.000000,-24.650000),new Point3D(0.000000,0.000000,0.000000),new Point3D(0.000000,0.000000,0.000000),new Color(255,255,255),0.0, new Material()));
	        scene.addGeometry(new Triangle(new Point3D(75.000000,750.000000,-24.650000),new Point3D(0.000000,0.000000,0.000000),new Point3D(0.000000,0.000000,0.000000),new Color(255,255,255),0.0, new Material()));
	        scene.addGeometry(new Triangle(new Point3D(124.500000,700.000000,24.900000),new Point3D(0.000000,0.000000,0.000000),new Point3D(0.000000,0.000000,0.000000),new Color(255,255,255),0.0, new Material()));
	        scene.addGeometry(new Triangle(new Point3D(124.500000,700.000000,24.900000),new Point3D(0.000000,0.000000,0.000000),new Point3D(0.000000,0.000000,0.000000),new Color(255,255,255),0.0, new Material()));
	        scene.addGeometry(new Triangle(new Point3D(162.500000,450.500000,125.000000),new Point3D(0.000000,0.000000,0.000000),new Point3D(0.000000,0.000000,0.000000),new Color(255,255,255),0.0, new Material()));
	        scene.addGeometry(new Triangle(new Point3D(162.500000,450.500000,125.000000),new Point3D(0.000000,0.000000,0.000000),new Point3D(0.000000,0.000000,0.000000),new Color(255,255,255),0.0, new Material()));
	        scene.addGeometry(new Triangle(new Point3D(38.550003,450.500000,125.000000),new Point3D(0.000000,0.000000,0.000000),new Point3D(0.000000,0.000000,0.000000),new Color(255,255,255),0.0, new Material()));
	        scene.addGeometry(new Triangle(new Point3D(38.550003,450.500000,125.000000),new Point3D(0.000000,0.000000,0.000000),new Point3D(0.000000,0.000000,0.000000),new Color(255,255,255),0.0, new Material()));
	        scene.addGeometry(new Triangle(new Point3D(38.550003,450.500000,-122.500000),new Point3D(0.000000,0.000000,0.000000),new Point3D(0.000000,0.000000,0.000000),new Color(255,255,255),0.0, new Material()));
	        scene.addGeometry(new Triangle(new Point3D(38.550003,450.500000,-122.500000),new Point3D(0.000000,0.000000,0.000000),new Point3D(0.000000,0.000000,0.000000),new Color(255,255,255),0.0, new Material()));
	        scene.addGeometry(new Triangle(new Point3D(162.500000,450.500000,-122.500000),new Point3D(0.000000,0.000000,0.000000),new Point3D(0.000000,0.000000,0.000000),new Color(255,255,255),0.0, new Material()));
	        scene.addGeometry(new Triangle(new Point3D(162.500000,450.500000,-122.500000),new Point3D(0.000000,0.000000,0.000000),new Point3D(0.000000,0.000000,0.000000),new Color(255,255,255),0.0, new Material()));
	        scene.addGeometry(new Triangle(new Point3D(38.550003,450.500000,-122.500000),new Point3D(0.000000,0.000000,0.000000),new Point3D(0.000000,0.000000,0.000000),new Color(255,255,255),0.0, new Material()));
	        scene.addGeometry(new Triangle(new Point3D(38.550003,450.500000,-122.500000),new Point3D(0.000000,0.000000,0.000000),new Point3D(0.000000,0.000000,0.000000),new Color(255,255,255),0.0, new Material()));
	        scene.addGeometry(new Triangle(new Point3D(162.500000,400.500000,125.000000),new Point3D(0.000000,0.000000,0.000000),new Point3D(0.000000,0.000000,0.000000),new Color(255,255,255),0.0, new Material()));
	        scene.addGeometry(new Triangle(new Point3D(162.500000,400.500000,125.000000),new Point3D(0.000000,0.000000,0.000000),new Point3D(0.000000,0.000000,0.000000),new Color(255,255,255),0.0, new Material()));
	        scene.addGeometry(new Triangle(new Point3D(163.500000,400.500000,-23.250000),new Point3D(0.000000,0.000000,0.000000),new Point3D(0.000000,0.000000,0.000000),new Color(255,255,255),0.0, new Material()));
	        scene.addGeometry(new Triangle(new Point3D(163.500000,400.500000,-23.250000),new Point3D(0.000000,0.000000,0.000000),new Point3D(0.000000,0.000000,0.000000),new Color(255,255,255),0.0, new Material()));
	        scene.addGeometry(new Triangle(new Point3D(39.750000,400.500000,-23.250000),new Point3D(0.000000,0.000000,0.000000),new Point3D(0.000000,0.000000,0.000000),new Color(255,255,255),0.0, new Material()));
	        scene.addGeometry(new Triangle(new Point3D(39.750000,400.500000,-23.250000),new Point3D(0.000000,0.000000,0.000000),new Point3D(0.000000,0.000000,0.000000),new Color(255,255,255),0.0, new Material()));
	        scene.addGeometry(new Triangle(new Point3D(39.750000,400.500000,-122.500000),new Point3D(0.000000,0.000000,0.000000),new Point3D(0.000000,0.000000,0.000000),new Color(255,255,255),0.0, new Material()));
	        scene.addGeometry(new Triangle(new Point3D(39.750000,400.500000,-122.500000),new Point3D(0.000000,0.000000,0.000000),new Point3D(0.000000,0.000000,0.000000),new Color(255,255,255),0.0, new Material()));
	        scene.addGeometry(new Triangle(new Point3D(163.500000,400.500000,-122.500000),new Point3D(0.000000,0.000000,0.000000),new Point3D(0.000000,0.000000,0.000000),new Color(255,255,255),0.0, new Material()));
	        scene.addGeometry(new Triangle(new Point3D(163.500000,400.500000,-122.500000),new Point3D(0.000000,0.000000,0.000000),new Point3D(0.000000,0.000000,0.000000),new Color(255,255,255),0.0, new Material()));
	        scene.addGeometry(new Triangle(new Point3D(39.750000,400.500000,-122.500000),new Point3D(0.000000,0.000000,0.000000),new Point3D(0.000000,0.000000,0.000000),new Color(255,255,255),0.0, new Material()));
	        scene.addGeometry(new Triangle(new Point3D(39.750000,400.500000,-122.500000),new Point3D(0.000000,0.000000,0.000000),new Point3D(0.000000,0.000000,0.000000),new Color(255,255,255),0.0, new Material()));
	        scene.addGeometry(new Triangle(new Point3D(163.500000,152.500000,-23.250000),new Point3D(0.000000,0.000000,0.000000),new Point3D(0.000000,0.000000,0.000000),new Color(255,255,255),0.0, new Material()));
	        scene.addGeometry(new Triangle(new Point3D(163.500000,152.500000,-23.250000),new Point3D(0.000000,0.000000,0.000000),new Point3D(0.000000,0.000000,0.000000),new Color(255,255,255),0.0, new Material()));


	        ImageWriter imageWriter = new ImageWriter("NEWTEST1", 500, 500, 500, 500);
	        Render render = new Render(imageWriter, scene);
	        render.renderImage();
	    }
	    */
	@Test
	public void shadowTest(){
		
		Scene scene = new Scene();
              	Sphere sphere = new Sphere(500, new Point3D(0.0, 0.0, -1000),new Color(0, 0, 100),20.0,new Material());
	//	Sphere sphere = new Sphere(300, new Point3D(-550, -500, -1000),new Color(0, 0, 100),20.0,new Material());
		sphere.set_nShininess(20);
		sphere.set_emmission(new Color(0, 0, 100));
		
		scene.addGeometry(sphere);
		
		Triangle triangle1 = new Triangle(new Point3D(  3500,  3500, -2000),
							 new Point3D( -3500, -3500, -1000),
				 						 new Point3D(  3500, -3500, -2000));

		Triangle triangle2 = new Triangle(new Point3D(  3500,  3500, -2000),
				  						  new Point3D( -3500,  3500, -1000),
				  						  new Point3D( -3500, -3500, -1000));
		
		scene.addGeometry(triangle1);
		scene.addGeometry(triangle2);
		
		scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(200, 200, -100), 
				   new Vector(-2, -2, -3), 0, 0.000001, 0.0000005));
	
		
		ImageWriter imageWriter = new ImageWriter("Shadow test", 500, 500, 500, 500);
		
		Render render = new Render(imageWriter, scene);
		
		render.renderImage();
//		render.writeToImage();
		
	}
 

	
		
	@Test
	public void recursiveTest()
       {
		Scene scene = new Scene();
		scene.setScreenDistance(300);
		
		Sphere sphere = new Sphere(500, new Point3D(0.0, 0.0, -1000),new Color(0, 0, 100),20.0,new Material());
		sphere.set_nShininess(20);
		sphere.set_emmission(new Color(0, 0, 100));
              sphere.setKt(0.5);
		scene.addGeometry(sphere);
		
		Sphere sphere2 = new Sphere(250, new Point3D(0.0, 0.0, -1000),new Color(0, 0, 100),20.0,new Material());
		sphere2.set_nShininess(20);
		sphere2.set_emmission(new Color(100, 20, 20));
		sphere2.setKt(0);
		scene.addGeometry(sphere2);
		
		scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -150), 
					   new Vector(2, 2, -3), 0.1, 0.00001, 0.000005));
	
		ImageWriter imageWriter = new ImageWriter("Recursive Test 11", 500, 500, 500, 500);
		
		Render render = new Render(imageWriter, scene);
		
		render.renderImage();
//		render.writeToImage();
	}
	
/*	
	@Test
	public void recursiveTest2()
	
	{	
		Scene scene = new Scene();
		scene.setScreenDistance(300);
		
		Sphere sphere = new Sphere(300, new Point3D(-550, -500, -1000),new Color(0, 0, 100),20.0,new Material());
		sphere.set_nShininess(20);
		sphere.set_emmission(new Color(0, 0, 100));
		sphere.setKt(0.0);
		scene.addGeometry(sphere);
		
		Sphere sphere2 = new Sphere(150, new Point3D(-550, -500, -1000),new Color(0, 0, 100),20.0,new Material());
		sphere2.set_nShininess(20);
		sphere2.set_emmission(new Color(100, 20, 20));
		sphere2.setKt(0);
		scene.addGeometry(sphere2);
		
		Triangle triangle = new Triangle(new Point3D(  1500, -1500, -1500),
				 						 new Point3D( -1500,  1500, -1500),
				 						 new Point3D(  200,  200, -375));
		
		Triangle triangle2 = new Triangle(new Point3D(  1500, -1500, -1500),
										  new Point3D( -1500,  1500, -1500),
										  new Point3D( -1500, -1500, -1500));
		
		triangle.set_emmission(new Color(20, 20, 20));
		triangle2.set_emmission(new Color(20, 20, 20));
		triangle.setKr(1);
		triangle2.setKr(1);
		scene.addGeometry(triangle);
		scene.addGeometry(triangle2);

		scene.addLight(new SpotLight(new Color(255, 100, 100),  new Point3D(200, 200, -150), 
				   new Vector(-2, -2, -3), 0, 0.00001, 0.000005));
	
		ImageWriter imageWriter = new ImageWriter("Recursive Test 2", 500, 500, 500, 500);
		
		Render render = new Render(imageWriter, scene);
		
		render.renderImage();
	//	render.writeToImage();
		
		
	}
*/
	
/*	
	@Test
	public void recursiveTest3(){
		
		Scene scene = new Scene();
		scene.setScreenDistance(300);
		
		Sphere sphere = new Sphere(300, new Point3D(0, 0, -1000),new Color(0, 0, 100),20.0,new Material());
		sphere.set_nShininess(20);
		sphere.set_emmission(new Color(0, 0, 100));
		sphere.setKt(0.5);
		scene.addGeometry(sphere);
		
		Sphere sphere2 = new Sphere(150, new Point3D(0, 0, -1000),new Color(0, 0, 100),20.0,new Material());
		sphere2.set_nShininess(20);
		sphere2.set_emmission(new Color(100, 20, 20));
		sphere2.setKt(0);
		scene.addGeometry(sphere2);
		
		Triangle triangle = new Triangle(new Point3D(  2000, -1000, -1500),
				 						 new Point3D( -1000,  2000, -1500),
				 						 new Point3D(  700,  700, -375));
		
		Triangle triangle2 = new Triangle(new Point3D(  2000, -1000, -1500),
										  new Point3D( -1000,  2000, -1500),
										  new Point3D( -1000, -1000, -1500));
		
		triangle.set_emmission(new Color(20, 20, 20));
		triangle2.set_emmission(new Color(20, 20, 20));
		triangle.setKr(1);
		triangle2.setKr(0.5);
		scene.addGeometry(triangle);
		scene.addGeometry(triangle2);

		scene.addLight(new SpotLight(new Color(255, 100, 100),  new Point3D(200, 200, -150), 
				   new Vector(-2, -2, -3), 0, 0.00001, 0.000005));
	
		ImageWriter imageWriter = new ImageWriter("Recursive Test 3", 500, 500, 500, 500);
		
		Render render = new Render(imageWriter, scene);
		
		render.renderImage();
	//	render.writeToImage();
	}

	    @Test

	    public void spotLightTest2(){


	        Scene scene = new Scene();

	        scene.setScreenDistance(200);
	        

	        scene.addGeometry(new Sphere(500,new Point3D(0.0, 0.0, -1000.0),new Color(0, 0, 100),20.0,new Material()));
	        scene.addGeometry(new Triangle(new Point3D(-125.0, -225.0, -260.0),new Point3D(-225.0, -125.0, -260.0), new Point3D(-225.0, -225.0, -270.0),new Color (0, 0, 100),4.0,new Material()));
	        scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200.0, -200.0, -150.0), new Vector(2, 2, -3), 0.1, 0.00001, 0.000005));

	  //scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -150),

	    //new Vector(2, 2, -3), 0.001, 0.000001, 0.000005));


	        ImageWriter imageWriter = new ImageWriter("Spot lighting test 2", 500, 500, 500, 500);


	        Render render = new Render(imageWriter, scene);


	        render.renderImage();


	    }
	*/
	   // @Test

	   /* public void newSceneTest() throws Exception {
	        Camera camera=new Camera(new Point3D(0.0, 0.0, 0.0), new Vector(0,1,0), new Vector(-2.5, 0, 0));
	        Scene scene = new Scene(new AmbientLight(255, 255, 255), new Color(0,0,0), camera, 100);
	        scene.addGeometry(new Sphere(900.0, new Point3D(-3.0, 0.0 , 0.0),new Color(46,43,125),200.0 , new Material(1, 0.9, 0, 0,0.3)));
	        scene.addGeometry(new Sphere(900.0, new Point3D(-3.0, 0.0 , -2.1),new Color(43,125,46),200.0 , new Material(1, 0.9, 0, 0,0.3)));
	        scene.addGeometry(new Sphere(900.0, new Point3D(-3.0, 0.0 , -2.1),new Color(127,46,43),200.0 , new Material(1, 0.9, 0, 0,0.3)));
	        scene.addGeometry(new Plane(new Point3D(200.0,200.0,-300.0),new Color(125,125,125),20,new Material(1,0.9,0,0,3)));
	        scene.addLight(new PointLight(new Color(255,50,50), new Point3D(600.0, 200.0, -20.0), 0.000004, 0.000004, 0.000002));scene.addLight(new PointLight(new Color(255,50,50), new Point3D(600.0, 200.0, -20.0), 0.000004, 0.000004, 0.000002));
	        ImageWriter imageWriter = new ImageWriter("NLA", 500, 500, 500, 500);
	        Render render = new Render(imageWriter, scene);
	        render.renderImage();
	        */
	    

	    /*




	-<mesh name="open_room.obj">


	-<material_solid>

	<color b="0.5" g="0.5" r="0.5"/>

	<phong exponent="20" ks="1.0" kd="0.9" ka="0.3"/>

	<reflectance r="0.0"/>

	<transmittance t="0.0"/>

	<refraction iof="0.0"/>

	</material_solid>

	</mesh>

	</surfaces>

	</scene>
	     *//*
	    *//**
	     * sceneTestTransparent
	     *//*
	    @Test
	    public void sceneTestTransparent() throws Exception {
	        Render render = new Render(1);
	        render.sceneBuilder.setFilePath("./src/sceneTestTransparent.xml");
	        render.imageWriter = new ImageWriter("sceneTestTransparent", 500, 500, 500, 500);
	        render.renderImage();
	        render.writeToImage();
	    }
	    *//**
	     * sceneTest_Reflection_transparent
	     *//*
	    @Test
	    public void sceneTest_Reflection_transparent() throws Exception {
	        Render render = new Render(1);
	        render.sceneBuilder.setFilePath("./src/sceneTest_Reflection_transparent.xml");
	        render.imageWriter = new ImageWriter("sceneTest_Reflection_transparent", 500, 500, 500, 500);
	        render.renderImage();
	        render.writeToImage();
	    }
	    *//**
	     * sceneTest_Reflection_transparent_glossy
	     *//*
	    @Test
	    public void sceneTest_Reflection_transparent_glossy() throws Exception {
	        Render render = new Render(1);
	        render.sceneBuilder.setFilePath("./src/sceneTest_Reflection_transparent_glossy.xml");
	        render.imageWriter = new ImageWriter("sceneTest_Reflection_transparent_glossy", 500, 500, 500, 500);
	        render.renderImage();
	        render.writeToImage();
	    }
	     * sceneTest_soft_Shadows
	     *//*
	    @Test
	    public void sceneTest_soft_Shadows() throws Exception {
	        Render render = new Render(2);
	        render.sceneBuilder.setFilePath("./src/sceneTest_soft_Shadows.xml");
	        render.imageWriter = new ImageWriter("sceneTest_soft_Shadows", 500, 500, 500, 500);
	        render.renderImage();
	        render.writeToImage();
	    }
	    *//**
	     * sceneTest_Shadow
	     *//*
	    @Test
	    public void sceneTest_Shadow() throws Exception {
	        Render render = new Render(1);
	        render.sceneBuilder.setFilePath("./src/sceneTest_Shadow.xml");
	        render.imageWriter = new ImageWriter("sceneTest_Shadow", 500, 500, 500, 500);
	        render.renderImage();
	        render.writeToImage();
	    }
	@Test
    public void basicRendering(){

        Scene scene = new Scene();

        scene.addGeometry(new Sphere(15, new Point3D(0.0, 0.0, -50.0), Color.BLACK, 10.0, new Material()));

        Triangle triangle = new Triangle(new Point3D( 100.0, 0.0, -149.0),
                new Point3D(  0.0, 100.0, -149.0),
                new Point3D( 100.0, 100.0, -149.0), Color.BLACK, 10.0, new Material());

        Triangle triangle2 = new Triangle(new Point3D( 100.0, 0.0, -149.0),
                new Point3D(  0.0, -100.0, -149.0),
                new Point3D( 100.0,-100.0, -149.0), Color.GREEN, 10.0, new Material());

        Triangle triangle3 = new Triangle(new Point3D(-100.0, 0.0, -149.0),
                new Point3D(  0.0, 100.0, -149.0),
                new Point3D(-100.0, 100.0, -149.0), Color.RED, 10.0, new Material());

        Triangle triangle4 = new Triangle(new Point3D(-100.0, 0.0, -149.0),
                new Point3D(  0.0,  -100.0, -149.0),
                new Point3D(-100.0, -100.0, -149.0), Color.BLUE, 10.0, new Material());

        scene.addGeometry(triangle);
        scene.addGeometry(triangle2);
        scene.addGeometry(triangle3);
        scene.addGeometry(triangle4);
        scene.addLight(new PointLight(new Color(255,255,255), new Point3D(0.0, 15.0, -6.0), 0.1, 0.1, 0.1));

        ImageWriter imageWriter = new ImageWriter("EmissionTest", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);
        render.printGrid(50);
        render.renderImage();

    }

*/
}
