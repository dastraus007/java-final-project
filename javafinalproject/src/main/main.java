package main;

import java.awt.Color;

import elements.AmbientLight;
import elements.Camera;
import elements.DirectionalLight;
import elements.PointLight;
import elements.SpotLight;
import GUI.GUI;
import geometries.Geometry;
import geometries.Plane;
import geometries.Quadrangle;
import geometries.Sphere;
import geometries.Triangle;
import primitives.Coordinate;
import primitives.Material;
import primitives.Point3D;
import primitives.Vector;
import renderer.ImageWriter;
import renderer.Render;
import scene.Scene;

public class main {
	 /*************************************************
	 * FUNCTION
	 * main
	 * PARAMETERS
	 * String[]
	 * RETURN VALUE
	 * ---. 
	 * MEANING
	 * main of the program
	 * SEE ALSO
	 * 
	 **************************************************/
	public static void main(String[] args) {
		GUI g = new GUI();//Create the GUI platform
	}
	

	 /*************************************************
		 * FUNCTION
		 * createPicture
		 * PARAMETERS
		 * int type , int angel , int  , Color color , String nameFile
		 * RETURN VALUE
		 * ---. 
		 * MEANING
		 * do the test that the user choose
		 * SEE ALSO
		 * Horse()
		 **************************************************/
	public static void createPicture(int type , int angel , int inesity , Color color , String nameFile) throws Exception {
		System.out.println(type);//Print out the value for check
		System.out.println(angel);//Print out the value for check
		System.out.println(inesity);//Print out the value for check
		System.out.println(color);//Print out the value for check
		System.out.println(nameFile);	//Print out the value for check
		
		int t=(int)color.getRed()*(inesity/100);
		int t1=(int)color.getGreen()*(inesity/100);
		int t2=(int)color.getBlue()*(inesity/100);
		Color color1 =new Color(t,t1,t2);//set the new color
		
		
		
		
		
		
		Scene scene = new Scene();//create he scene we will run
              	Sphere sphere = new Sphere(500, new Point3D(0.0, 0.0, -1000),new Color(0, 0, 100),20.0,new Material());//create the shape
		sphere.set_nShininess(20);//set the Shininess
		sphere.set_emmission(new Color(0, 0, 100));
		
		scene.addGeometry(sphere);// add the sphere to the scene
		
		//the background
		Triangle triangle1 = new Triangle(new Point3D(  3500,  3500, -2000),
							 new Point3D( -3500, -3500, -1000),
				 						 new Point3D(  3500, -3500, -2000));

		Triangle triangle2 = new Triangle(new Point3D(  3500,  3500, -2000),
				  						  new Point3D( -3500,  3500, -1000),
				  						  new Point3D( -3500, -3500, -1000));
		
		scene.addGeometry(triangle1);//add the triangles
		scene.addGeometry(triangle2);//that use for background
		
		if(type==0)//check the choose of the user 
		{
		//	public DirectionalLight(Color color, Vector direction)
			DirectionalLight directionallight=new DirectionalLight( color1,  getvec(angel));//if he choose 0 so we do directionallight 
			scene.addLight(directionallight);
		}
		else if(type==1)//check the choose of the user 
		{
			PointLight pointlight=new PointLight(color1,getpoint(angel), 0, 0.000001, 0.0000005);//if he choose 1 so we do PointLight 
			scene.addLight(pointlight);//so we set the PointLight and add i to the scene

		}
		else 
		{
			SpotLight spotlight=new SpotLight(color1,getpoint(angel), getvec1(angel), 0, 0.000001, 0.0000005);//if he choose 2 so we do SpotLight 
			scene.addLight(spotlight);//so we set the SpotLight and add i to the scene

		}
		
		ImageWriter imageWriter = new ImageWriter(nameFile, 500, 500, 500, 500);//set the imageWriter
		
		Render render = new Render(imageWriter, scene);//set a new renderer with our scene and imageWriter
		
		render.renderImage();//Create the picture
	}

		
	
	
	
	 /*************************************************
	 * FUNCTION
	 * getvec
	 * PARAMETERS
	 * int
	 * RETURN VALUE
	 * vector
	 * MEANING
	 * return the vector with the angel
	 * SEE ALSO
	 * 
	 **************************************************/
private static Vector getvec(int angel) {
		
	if(angel==90)//return the vector with the angel
	{
		return new Vector(0, 0, -1.0);//return the vector with the angel
		
	}
	if(angel>90)//return the vector with the angel
	{
		return new Vector(0.5, 0, -1.0);//return the vector with the angel
	}
	else//return the vector with the angel
	{
		return  new Vector(-0.5, 0, -1.0);//return the vector with the angel
	}

	}

	private static Vector getvec1(int angel) {
		return new Vector(-1, -2, -3);//return the vector with the angel
	}


	 /*************************************************
	 * FUNCTION
	 * Horse
	 * PARAMETERS
	 * int type , int angel  , Color color , String nameFile
	 * RETURN VALUE
	 * ---. 
	 * MEANING
	 * create the Horse
	 * SEE ALSO
	 * 
	 **************************************************/
	 /*************************************************
		 * FUNCTION
		 * Horse
		 * PARAMETERS
		 * int type , int angel , int inesity , Color color , String nameFile
		 * RETURN VALUE
		 * ---. 
		 * MEANING
		 * create the Horse
		 * SEE ALSO
		 * 
		 **************************************************/
		public static void Horse() {
			System.out.println("Drowing a horse...");

			ImageWriter imageWriter = new ImageWriter("10000", 600, 600, 1, 1);//set the scene
			
			
			
			AmbientLight ambientLight=new AmbientLight(210,210,210);//set the light of the scene
			Camera camera = new Camera((new Point3D(0.0 ,0.0 ,100.0)),(new Vector (0.0, 1.0, 0.0)),(new Vector (0.0, 0.0, -1.0)));//set the camera of the scene
			

			
			Scene scene =new Scene( ambientLight , new Color(0,0,0), camera, 1);//set the scene
			
			
			
			
			scene.setScreenDistance(50);//set the screen distance
		    
			
			//create  a huge array of the shapes that the horse build with
		    Geometry [] shapes = {
		     
		    		new Quadrangle(P( 0 ,00),P(-63 , -11), P(-7,-133) , P(29 , -159)),
		    		new Quadrangle(P(-63 , -11) , P(-7,-133)  , P(-119 , -120),P(-120 , -21)),
		    		new Quadrangle( P(-7,-133) , P(-119 , -120), P(-113 , -155),P(-69 , -159)),
		    		new Triangle(P(-69 , -159) , P(-7,-133), P(29 , -159)),
		    		new Triangle(P(-113 , -155),P(-69 , -159),P(-108,-177)),
		    		new Quadrangle(P(-108,-177) , P(-144 , -254) , P(-119 , -120) , P(-173 , -183)),
		    		new Quadrangle(P(-119 , -120) ,P(-120 , -21) , P(-264 , -202) , P(-173 , -183)),
		    		new Quadrangle(P(-120 , -21) ,P(-264 , -202) ,P(-274 , -103) , P(-232 , -36)),
		    		new Quadrangle( P(-232 , -36) , P(0 , 0) ,P(-77 , 15) , P(-132 , 12)),
		    		//P(-79 ,  15)
		    		new Quadrangle(P(-173 , -183) , P(-144 , -254) , P(-264 , -202) , P(-227 , -350)),
		    		new Triangle(P(-264 , -202) ,P(-227 , -350) , P(-298 , -350)),
		    		new Quadrangle(P(-298 , -350) ,P(-227 , -350) , P(-367 , -375) , P(-362 , -403)),
		    		new Quadrangle(  P(-316 , -380) , P(-362 , -403) , P(-388 , -453) , P(-348 , -459)),
		    		
		    		new Triangle(P(-119 , -112) , P(-144 , -256) , P(-109 , -183) ),
		    		new Triangle(P(-264 , -205) , P(-228 , -349) , P(-145 , -258)),
		    		new Triangle(P(-109 , -183) , P(-134 , -238) , P(-4 , -288)),
		    		new Triangle(P(42 , -285) , P(36 , -326) , P(9 , -325)),
		    	new Triangle(P(-262 , -204) , P(-174 , -184) , P(-229 , -350)),
		    		  new Quadrangle( P(-388 , -453) ,  P(-399 , -519)  , P(-348 , -512),P(-348 , -459)),
		    	    new Quadrangle(P(-399 , -519) , P(-348 , -512),P(-383 , -544) , P(-325 , -547)),
		    	    new Quadrangle(P(-70 , -156) , P(2 , -159) , P(44 , -283) , P(-1 , -287)),
		    	    new Triangle(P(-108 , -177) , P(-70 , -156) , P(-2 , -287)),
		    	    new Quadrangle(P(-108 , -177) ,P(-2 , -287) , P(-137 , -239) , P(-45 , -323)),
		    	    new Quadrangle(P(44 , -283) ,P(-1 , -285) , P(37 , -336) , P(11, -328)),
		    	    new Quadrangle(P(11, -328), P(28 , -326) , P(31 , -328) , P(11 , -332)),
		    	    new Quadrangle(P(-42 , -323) ,P(-2 , -287) , P(12 , -373) , P(-62 , -379)),
		    	    new Triangle(P(9 , -329) , P(38 , -328) , P(11 , -370) ),
		    	    new Quadrangle(P(-43 , -335) , P(-42 , -375) , P(-152 , -366) , P(-132 , -347)),
		    	    new Quadrangle( P(-152 , -366) , P(-87 , -370), P(-69 , -456) , P(-26 , -436)),
		    	    new Quadrangle(P(-26 , -436) , P(-16 , -472) , P(-39 ,-463 ) , P(-53 , -438)),
		    	    new Quadrangle(P(-39 ,-463 ) ,P(-60 , -478) , P(-72 , -454) , P(-54 , -439)),
		    	    new Quadrangle(P(-60 , -478) ,P(-39 ,-463 ) ,P(-12 , -506) , P(-63 , -502)),
		    	    new Quadrangle(P(-39 ,-463 ) ,P(-13 , -506) , P(5 , -497) ,P(-15 , -470) ),
		    	    new Triangle(P(-77 ,14) , P(169 , -58) , P(149 , 116)),
		    	    new Triangle(P(0 , 0) , P(169 , -58) ,P(29 , -158)),
		    	    new Quadrangle(P(169 , -58) ,P(207 , -58) , P(175 , -92) , P(93 , -117)),
		    	   new Quadrangle(P(169 , -58) ,P(207 , -58) ,P(229 , 14) , P(151 , 40)),
		    	   //v
		    	   new Quadrangle(P(150 , 41) , P(229 , 14) , P(261 , 69) , P(229 , 103)),
		    	   new Quadrangle(P(150 , 41) ,  P(261 , 69) , P(213 , 182) , P(148 , 116)),
		    	   new Quadrangle(P(148 , 116) , P(212 , 180) , P(129 , 282) , P(62 , 208)),
		    	   
		    	   new Triangle(P(61 , 210) , P( 15, 110) , P(6 , 161)),
		    	  // new Quadrangle(P(169 , -58) P(151 , 40), P(213 , 182) , P(149 , 120)),
		    	  // new Quadrangle(P(148 , 116) , P(213 , 182) , P(231 , 102),P(287 , 50)),
		    	  //  new Quadrangle(P(231 , 102),P(211 , 182) , P(127 , 284) , P(61 , 210)),
		    	    new Triangle(P(-3, 47) , P(61 , 210) ,P(149 , 116) ),
		    	    new Triangle(P(-55 , 112) , P(65,208) , P(-35 , 188)),
		    	    new Quadrangle(P(-77 , 188) , P(132 , 282) , P(125 , 334) , P(-25 , 262)),//���� ���� �����
		    	    new Quadrangle(P(125 , 338) , P(229 , 328) , P(195 , 366) , P(131 , 282)),
		    	    new Quadrangle(P(131 , 282) , P(219 , 252) , P(247 , 290) , P(231 , 328)),
		    	    new Quadrangle(P(123 , 342) , P(117 , 452) , P(193 , 368) , P(195 , 386)),
		    	
		    	    new Triangle(P(188 , 387) , P(202 , 318) , P(97 , 324)),
		    	    new Quadrangle(P(131 , 282) ,P(125 , 338) ,P(-75 , 188) , P(36 , 188)),
		    	       new Triangle(P(117 , 452) ,P(94 , 474) , P(119 , 452)),
		    	    new Triangle(P(99 , 446) , P(125 , 342) ,P(49 , 466) ),
		    	    new Triangle(P(73 , 426) , P(-31 , 332) , P(121 , 338)),
		    	    new Triangle(P(-53 , 264) , P(-31 , 332) , P(121 , 338)),
		    	    new Quadrangle(P(231 , 106) , P(257 , 116) , P(313 , 238) , P(221 , 160)),
		    	    new Triangle(P(313 , 238) , P(221 , 160) , P(263 , 230)),
		    	    new Quadrangle(P(313 , 238) , P(345 , 184) , P(335 , 138) , P(289 , 130)),
		    	    new Quadrangle(P(305 , 58) , P(311 , -14) , P(279 , 2) , P(281 , 42)),
		    	    new Quadrangle(P(277 , 0) , P(231 , -16) , P(233 , -98) , P(307 , -12)),
		    	    new Quadrangle(P(231 , 104) , P(327 , 138) , P(371 , 84) , P(263 , 64)),
		    	    new Quadrangle(P(327 , 138) , P(309 , -70) , P(375 , 110) , P(389 , -64)),
		    	    new Triangle(P(309 , -70) ,P(347 , -48) , P(333 , -182)),
		    	    new Quadrangle(P(333 , -182) , P(341 , -94) , P(311 , -104) , P(307 , -132)),
		    	    new Quadrangle(P(-259 , -70) ,P(-243 , -58) , P(-295 , 86) , P(-409 , 170)),
		    	    new Triangle( P(-409 , 170) , P(-325 , 28) , P(-483 , 76))
		          }; 
		    //create a array with the colors
		Color [] colors = {
		    new Color(32,178,170),
		    new Color(45 , 17 , 199),
		    new Color(32 , 57 , 190),
		    new Color(90, 39, 12),
		    new Color(32 , 54 , 19),
		    new Color(78 , 91 , 31),
		    new Color(32 , 157 , 190),
		    new Color(78 , 91 , 231),
		    new Color(190, 139, 112),
		    new Color(63 , 81 , 100),
		    new Color(7 , 91 , 31),
		    new Color(132,17,170),
		    new Color(35 , 137 , 199),
		    new Color(0 , 92 , 87),
		    new Color(56 , 28 , 123),
		    new Color(72 , 91 , 0),
		    new Color(190, 139, 52),
		    new Color(63 , 181 , 100),
		    new Color(78 , 191 , 31),
		    new Color(72 , 91 , 0),
		    new Color(195, 139, 52),
		    new Color(163 , 181 , 100),
		    new Color(178 , 191 , 31),
		    new Color(232 , 157 , 190),
		    new Color(88 , 91 , 231),
		    new Color(197, 0, 112),
		    new Color(56 , 28 , 123),
		    new Color(72 , 91 , 0),
		    new Color(190, 139, 52),
		    new Color(63 , 181 , 100),
		    new Color(78 , 191 , 31),
		    new Color(72 , 91 , 0),
		    new Color(195, 139, 52),
		    new Color(32,178,170),
		    new Color(45 , 17 , 199),
		    new Color(32 , 57 , 190),
		    new Color(90, 39, 12),
		    new Color(32 , 54 , 19),
		    new Color(78 , 91 , 31),
		    new Color(32 , 157 , 190),
		    new Color(78 , 91 , 231),
		    new Color(190, 139, 112),
		    new Color(63 , 81 , 100),
		    new Color(7 , 91 , 31),
		    new Color(132,17,170),
		    new Color(35 , 137 , 199),
		    new Color(0 , 92 , 87),
		    new Color(56 , 28 , 123),
		    new Color(72 , 91 , 0),
		    new Color(190, 139, 52),
		    new Color(63 , 181 , 100),
		    new Color(78 , 191 , 31),
		    new Color(72 , 91 , 0),
		    new Color(195, 139, 52),
		    new Color(163 , 181 , 100),
		    new Color(178 , 191 , 31),
		    new Color(232 , 157 , 190),
		    new Color(88 , 91 , 231),
		    new Color(197, 0, 112),
		    new Color(56 , 28 , 123),
		    new Color(72 , 91 , 0),
		    new Color(190, 139, 52),
		    new Color(63 , 181 , 100),
		    new Color(78 , 191 , 31),
		    new Color(72 , 91 , 0),
		    new Color(195, 139, 52)
		    
			};

		     // x = 650 - x (picture)
		     // y = y (picture) - 650
		
		
			//set the shapes and colors to the scene
		     for (int i = 0; i < shapes.length; i++)
		     {
		         shapes[i].set_emmission(colors[i]);//set the colors to the shapes
		         scene.addGeometry(shapes[i]);//add the shapes
		     }

			
			Render renderer=new Render(imageWriter,scene);//create and set the renderer
			renderer.renderImage();//create the picture
		}
			
		
		
	
	
	private static Point3D getpoint(int angel) {
		boolean flag=false;
		if(angel==90)
		{
			return new Point3D(0,100,200);
		}
		if(angel==180)
		{
			return new Point3D(-1500,100,200);
		}
		if(angel==0)
		{
			return new Point3D(2000,100,200);
		}
		if(angel>90)
		{
			angel=angel-90;
			flag=true;
		}
		double X=(22.33333*angel);
		if(flag)
		{
			X=X*-1;
		}
		
		if(angel>=70&&angel<90)
		{
			X=X/10;
		}
		return new Point3D(X,100,200);
	}

	public static Point3D P(int x, int y)
    {
        return new Point3D(new Coordinate(x),new Coordinate(y),new Coordinate(-50));
    }

public static void RecursiveTest(int type , int angel , int inesity , Color color , String nameFile) throws Exception {
	
	System.out.println(type);
	System.out.println(angel);
	System.out.println(inesity);
	System.out.println(color);
	System.out.println(nameFile);	
	
	int t=(int)color.getRed()*(inesity/100);
	int t1=(int)color.getGreen()*(inesity/100);
	int t2=(int)color.getBlue()*(inesity/100);
	Color color1 =new Color(t,t1,t2);
	

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
	

	if(type==0)
	{
		DirectionalLight directionallight=new DirectionalLight( color1,  getvec(angel));//getvec10
		scene.addLight(directionallight);
	}
	else if(type==1)
	{
		PointLight pointlight=new PointLight(color1,getpoint1(angel), 0, 0.000001, 0.0000005);
		scene.addLight(pointlight);

	}
	else 
	{
		SpotLight spotlight=new SpotLight(color1,getpoint1(angel), getvec100(angel), 0, 0.000001, 0.0000005);
		scene.addLight(spotlight);

	}

	ImageWriter imageWriter = new ImageWriter(nameFile, 500, 500, 500, 500);
	
	Render render = new Render(imageWriter, scene);
	
	render.renderImage();

	
	
	
	
}

private static Vector getvec10(int angel) {
	Vector a=new Vector(new Point3D(0.0, 0.0, -1000),getpoint1(angel));
	return a;

}

private static Vector getvec100(int angel) {
	return  new Vector(2, 2, -3);
}

private static Point3D getpoint1(int angel) {
	
	
	
	boolean flag=false;
	if(angel==90)
	{
		return new Point3D(0, 0, -150);
	}
	if(angel==180)
	{
		return new Point3D(-200, -300, -150);
	}
	if(angel==0)
	{
		return new Point3D(-200, 300, -150);
	}
	if(angel>=90)
	{
		angel=angel-90;
		flag=true;
	}
	
	double Y=(3.33333*angel);
	if(flag)
	{
		Y=Y*-1;
	}
	if(angel>=70&&angel<90)
	{
		Y=Y/10;
	}
	return new Point3D(-200, Y, -150);
	
	
	}

}