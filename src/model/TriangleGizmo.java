package model;

import java.awt.Color;
import java.util.ArrayList;

import physics.Angle;
import physics.Circle;
import physics.Geometry;
import physics.LineSegment;
import physics.Vect;

/**
 * @author Maciej Zajac GizmoBall 27/02/2015
 */
public class TriangleGizmo extends Gizmo implements IGizmo {
	private double xpos;
	private double ypos;
	private Color color;
	private double height;
	private String id;
	private ArrayList<Circle> cs;
	private ArrayList<LineSegment> ls;
	private int L = 25;
	
	

	//constructor -- setting up coordinates and height
	public TriangleGizmo(double x, double y, double h){
		xpos = x;
		ypos = y;
		height = h;
		color = Color.DARK_GRAY;
		
	}
	
	public void rotate(){
		Vect centre = new Vect(xpos+L/2, ypos+L/2);
		for (LineSegment l : this.getLSegments())
			l = Geometry.rotateAround(l, centre, Angle.DEG_90);
		for (Circle c : this.getCircles())
			c = Geometry.rotateAround(c, centre, Angle.DEG_90);	
	}
	
	//Getters
	public double getH(){
		return height;
	}
	
	public ArrayList<Circle> getCircles(){
		cs = new ArrayList<Circle>();
		cs.add(new Circle(xpos, ypos, 0));
		cs.add(new Circle(xpos+height, ypos, 0));
		cs.add(new Circle(xpos, ypos+height, 0));
		return cs;
	}
	
	public ArrayList<LineSegment> getLSegments(){
		ls = new ArrayList<LineSegment>();
		ls.add(new LineSegment(xpos, ypos, xpos+height, ypos));
		ls.add(new LineSegment(xpos+height, ypos, xpos, ypos+height));
		ls.add(new LineSegment(xpos, ypos+height, xpos, ypos));
		return ls;
	}
	
}
