package model;

import java.awt.Color;

import physics.Circle;
import physics.Vect;

/**
 * @author Maciej Zajac GizmoBall 27/02/2015
 */
public class Ball extends Gizmo implements IGizmo {
	
	//private double xpos;
	//private double ypos;
	//private Color color;
	private Vect velocity;
	private double radius;
	//private String id;
	//private Circle circle;
	private boolean stopped ;
	
	
	//constructor --set coordinates, velo, color and ID
	public Ball(String op, String ID,  double x, double y, double xv, double yv){
		xpos1 = x;
		ypos1 = y;
		velocity = new Vect(xv, yv);
		color =  Color.blue;
		radius  = 10;
		stopped = false;
		opcode = op;
		id = ID;
		
	}
	
	public void setStopped(Boolean b){
		stopped = b;
	}
	
	public boolean getStopped(){
		return stopped;
	}
	
	public Circle getCircle(){
		return new Circle(xpos1, ypos1, radius);
	}
	public double getRadius(){
		return radius;
	}
	
	
	public Vect getVelo(){
		return velocity;
	}
	public void setRadius(double r){
		radius = r;
	}
	public void setVelo(Vect v){
		velocity = v;
	}

}
