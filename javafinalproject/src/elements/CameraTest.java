package elements;

import static org.junit.Assert.*;

import org.junit.Test;

import primitives.Coordinate;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class CameraTest {

	  @Test
	    public void testConstructRayThroughPixel() {
	        System.out.println("constructRayThroughPixel");
	        int Nx = 3;
	        int Ny = 3;
	        double x = 2;
	        double y = 2;
	        double screenDistance = 1;
	        double screenWidth = 9;
	        double screenHeight = 9;
	        Point3D P0=new Point3D(new Coordinate(0),new Coordinate(0),new Coordinate(0));
	        Vector vUp=new Vector(new Point3D(new Coordinate(0),new Coordinate(1),new Coordinate(0)));
	        Vector vTo=new Vector(new Point3D(new Coordinate(0),new Coordinate(0),new Coordinate(-1)));
	        Camera instance = new Camera(P0, vUp, vTo);
	        Ray expResult = new Ray(P0, vTo);
	        Ray result = instance.constructRayThroughPixel(Nx, Ny, x, y, screenDistance, screenWidth, screenHeight);
	        assertEquals(expResult.toString(), result.toString());
	    }



}
