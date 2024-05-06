package geometries;

import static org.junit.Assert.*;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Vector;

import org.junit.Test;

import elements.Camera;
import primitives.Coordinate;
import primitives.Material;
import primitives.Point3D;
import primitives.Ray;

public class PlaneTest {

  /*  @Test
    public void testFindIntersections() {
        System.out.println("FindIntersections");
        int count=0;
        Camera c=new Camera();
        Plane inPlane=new Plane(new Vector(new Point3D(new Coordinate(),new Coordinate(),new Coordinate(-1))), new Point3D(new Coordinate(),new Coordinate(),new Coordinate(-5)), Color.WHITE, 1.0, new Material());
        //Sphere instance = new Sphere(new Point3D(new Coordinate(),new Coordinate(),new Coordinate(-3.0)),1.0);
        ArrayList<Ray> rayList=new ArrayList<>();
        ArrayList<ArrayList<Point3D>> list=new ArrayList<>();
        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                rayList.add(c.constructRayThroughPixel(3, 3, i, j, 1, 10, 10));
            }
        }
        for (Ray ray : rayList) {
            ArrayList<Point3D> listOfPoints = new ArrayList<>(inPlane.FindIntersections(ray));
            list.add(listOfPoints);
        }

        for (ArrayList<Point3D> arrayList : list) {
            count+=arrayList.size();
        }
        int result=count;
        int expResult = 9;

        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    /**
     * Test of FindIntersections method, of class Plane.
     
    @Test
    public void testFindIntersections2() {
        System.out.println("FindIntersections");
        int count=0;
        Camera c=new Camera();
        Plane inPlane=new Plane(new Vector(new Point3D(new Coordinate(),new Coordinate(),new Coordinate())), new Point3D(new Coordinate(),new Coordinate(),new Coordinate(-5)), Color.WHITE, 1.0, new Material());
        //Sphere instance = new Sphere(new Point3D(new Coordinate(),new Coordinate(),new Coordinate(-3.0)),1.0);
        ArrayList<Ray> rayList=new ArrayList<>();
        ArrayList<ArrayList<Point3D>> list=new ArrayList<>();
        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                rayList.add(c.constructRayThroughPixel(3, 3, i, j, 1, 10, 10));
            }
        }
        for (Ray ray : rayList) {
            ArrayList<Point3D> listOfPoints = new ArrayList<>(inPlane.FindIntersections(ray));
            list.add(listOfPoints);
        }

        for (ArrayList<Point3D> arrayList : list) {
            count+=arrayList.size();
        }
        int result=count;
        int expResult = 0;

        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    /**
     * Test of FindIntersections method, of class Plane.
     */
 /*   @Test
    public void testFindIntersections3() {
        System.out.println("FindIntersections");
        int count=0;
        Camera c=new Camera();
        Plane inPlane=new Plane(new Vector(new Point3D(new Coordinate(),new Coordinate(),new Coordinate(0.1))), new Point3D(new Coordinate(),new Coordinate(),new Coordinate(-5)), Color.WHITE, 1.0, new Material());
        //Sphere instance = new Sphere(new Point3D(new Coordinate(),new Coordinate(),new Coordinate(-3.0)),1.0);
        ArrayList<Ray> rayList=new ArrayList<>();
        ArrayList<ArrayList<Point3D>> list=new ArrayList<>();
        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                rayList.add(c.constructRayThroughPixel(3, 3, i, j, 1, 10, 10));
            }
        }
        for (Ray ray : rayList) {
            ArrayList<Point3D> listOfPoints = new ArrayList<>(inPlane.FindIntersections(ray));
            list.add(listOfPoints);
        }

        for (ArrayList<Point3D> arrayList : list) {
            count+=arrayList.size();
        }
        int result=count;
        int expResult = 9;

        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }*/


}
