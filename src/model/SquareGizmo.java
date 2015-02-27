package model;

import java.awt.Color;
import java.util.ArrayList;

import physics.Circle;
import physics.LineSegment;

public class SquareGizmo extends Gizmo implements IGizmo {

	private double xpos;
	private double ypos;
	private Color color;
	private double height;
	private String id;
	private ArrayList<Circle> cs;
	private ArrayList<LineSegment> ls;
	private int L = 25;
	
	//constructor
	public SquareGizmo(double x, double y, double h){
		xpos = x;
		ypos = y;
		height = h;
		color  = Color.red;
	}
	
	public double getH(){
		return height;
	}
	
	public ArrayList<Circle> getCircles(){
		cs = new ArrayList<Circle>();
		cs.add(new Circle(xpos, ypos, 0));
		cs.add(new Circle(xpos+height, ypos, 0));
		cs.add(new Circle(xpos+height, ypos+height, 0));
		cs.add(new Circle(xpos, ypos+height, 0));
		return cs;
	}
	
	public ArrayList<LineSegment> getLSegments(){
		ls = new ArrayList<LineSegment>();
		ls.add(new LineSegment(xpos, ypos, xpos+height, ypos));
		ls.add(new LineSegment(xpos, ypos, xpos, ypos+height));
		ls.add(new LineSegment(xpos+height, ypos, xpos+height, ypos+height));
		ls.add(new LineSegment(xpos, ypos+height, xpos+height, ypos+height));
		return ls;
	}
	 
	

}
