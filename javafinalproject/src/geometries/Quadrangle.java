package geometries;

import java.util.ArrayList;
import java.util.List;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class Quadrangle extends Geometry implements FlatGeometry{
	Triangle _tri1 , _tri2;
	// ***************** Constructors ********************** //
		/*************************************************
		the Constructor function Triangle 
		is get non
		It sends the variables to diffuse constructors
		**************************************************/
		public Quadrangle()
		{
			_tri1 = new Triangle();
			_tri2 = new Triangle();
		}


	/*************************************************
		the Constructor function triangle 
		is get non
		It sends the variables to diffuse constructors
		**************************************************/

		public Quadrangle(Quadrangle quadrangle)
		{
			_tri1 = new Triangle(quadrangle._tri1);
			_tri2 = new Triangle(quadrangle._tri2);
		}

	/*************************************************
		the Constructor function Triangle 
		It is get cylinder They change
	He sends the variables to the constructors and sends them all in contention
		**************************************************/
		public Quadrangle (Point3D P1, Point3D P2, Point3D P3, Point3D P4)
		{
		_tri1 = new Triangle(P1, P2, P4);
		_tri2 = new Triangle(P2, P3, P4);
		}

		// ***************** Getters/Setters ********************** //
		/*************************************************
		the name  getP1
		Returns the _p1
		**************************************************/
		public Point3D getP1()
		{
			return this._tri1.getP1();
		}
		/*************************************************
		the name  getP2
		Returns the _p2
		**************************************************/
		public Point3D getP2()
		{
			return this._tri1.getP2();
		}
		/*************************************************
		the name  getP3
		Returns the _p3
		**************************************************/
		public Point3D getP3()
		{
			return this._tri2.getP2();
		}
		/*************************************************
		the name  getP4
		Returns the _p4
		**************************************************/
		public Point3D getP4()
		{
			return this._tri2.getP3();
		}
		/*************************************************
		the name  setP1
		get the p1
		**************************************************/
		public void setP1(Point3D p1)
		{
			this._tri1.setP1(p1);
		}
		/*************************************************
		the name  setP2
		get the p2
		**************************************************/
		public void setP2(Point3D p2)
		{
			this._tri1.setP2(p2);
		}
		/*************************************************
		the name  setP3
		get the p3
		**************************************************/
		public void setP3(Point3D p3)
		{
			this._tri2.setP2(p3);
		}
		/*************************************************
		the name  setP4
		get the p4
		**************************************************/
		public void setP4(Point3D p4)
		{
			this._tri2.setP3(p4);
		}
		// ***************** Operations ******************** //
		/*************************************************
		the name  getNormal
		The function returns Normal in the Geometry
		
	    He calculates Normal with the points of the triangle. He calculates the ribs and pushes them down and extracts the norm
		**************************************************/
		@Override
		public Vector getNormal(Point3D point)
		{
			Vector U=new Vector(this._tri1.getP1(),this._tri1.getP2());//ribs of the triangle
			Vector V=new Vector(this._tri1.getP1(),this._tri1.getP3());//ribs of the triangle
			U.cross(V);
			Vector N=new Vector(U);//crossProduct to get N 
			N.normalize();//normalize
			N.scale(-1);//get to the oder way
			return N;//return the normal
		}
		/*************************************************
		the name  FindIntersections
		The function returns the damage points of the beam in Geometry
		
		it get a ray for see  The fund's damage to Geometry
		it return list of all the returns the points
	  
	    return the Intersections by using the find Intersections of the triangle
		**************************************************/
		@Override
		public List FindIntersections(Ray ray)
		{
			List res  = this._tri1.FindIntersections(ray);
			if (res == null)
				return this._tri2.FindIntersections(ray);
			return res;
			

		}

}
