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
	//private double xpos;
	//private double ypos;
	//private Color color;
	private double height;
	//private String id;
	private ArrayList<Circle> cs;
	private ArrayList<LineSegment> ls;
	private int L = 25;
	
	

	//constructor -- setting up coordinates and height
	public TriangleGizmo(String op, String ID, double x, double y, double h){
		xpos1 = x;
		ypos1 = y;
		height = h;
		color = Color.DARK_GRAY;
		opcode = op;
		id =ID;
		
	}
	
	public ArrayList<Circle> getCircles(){
		cs = new ArrayList<Circle>();
		cs.add(new Circle(xpos1, ypos1, 0));
		cs.add(new Circle(xpos1+height, ypos1, 0));
		cs.add(new Circle(xpos1, ypos1+height, 0));
		return cs;
	}
	
	//Getters
	public double getH(){
		return height;
	}
	
	public ArrayList<LineSegment> getLSegments(){
		ls = new ArrayList<LineSegment>();
		ls.add(new LineSegment(xpos1, ypos1, xpos1+height, ypos1));
		ls.add(new LineSegment(xpos1+height, ypos1, xpos1, ypos1+height));
		ls.add(new LineSegment(xpos1, ypos1+height, xpos1, ypos1));
		return ls;
	}
	
	public void rotate(){
		Vect centre = new Vect(xpos1+L/2, ypos1+L/2);
		for (LineSegment l : this.getLSegments())
			l = Geometry.rotateAround(l, centre, Angle.DEG_90);
		for (Circle c : this.getCircles())
			c = Geometry.rotateAround(c, centre, Angle.DEG_90);	
	}
	
}
