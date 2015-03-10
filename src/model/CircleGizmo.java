package model;

import java.awt.Color;

import physics.Circle;
import physics.Vect;

/**
 * @author Maciej Zajac GizmoBall 27/02/2015
 */
public class CircleGizmo extends Gizmo implements IGizmo {
	
	private double radius;
	

	//constructor -- setting up coordinates, radius and color
	public CircleGizmo(String op, String ID, double x, double y){
		xpos1 =x;
		ypos1 = y;
		radius = 25;
		color = Color.orange;
		opcode = op;
		id = ID;
	}
	//setters
	
	public Circle getCircle(){
		return new Circle (xpos1, ypos1, radius);
	}
	
	
	//getters
	
	public double getRadius(){
		return radius;
	}
	public void setRadius(double r){
		radius = r;
	}

}
