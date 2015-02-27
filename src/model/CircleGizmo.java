package model;

import java.awt.Color;

import physics.Circle;
import physics.Vect;

/**
 * @author Maciej Zajac GizmoBall 27/02/2015
 */
public class CircleGizmo extends Gizmo implements IGizmo {
	private double xpos;
	private double ypos;
	private Color color;
	private double radius;
	private String id;

	//constructor -- setting up coordinates, radius and color
	public CircleGizmo(double x, double y){
		xpos =x;
		ypos = y;
		radius = 10;
		color = Color.orange;
	}
	//setters
	
	public void setRadius(double r){
		radius = r;
	}
	
	
	//getters
	
	public double getRadius(){
		return radius;
	}
	public Circle getCircle(){
		return new Circle (xpos, ypos, radius);
	}

}
