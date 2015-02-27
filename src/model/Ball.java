package model;

import java.awt.Color;

import physics.Circle;
import physics.Vect;

/**
 * @author Maciej Zajac GizmoBall 27/02/2015
 */
public class Ball extends Gizmo implements IGizmo {
	
	private double xpos;
	private double ypos;
	private Color color;
	private Vect velocity;
	private double radius;
	private String id;
	//private Circle circle;
	
	
	//constructor --set coordinates, velo, color and ID
	public Ball( double x, double y, double xv, double yv){
		
		velocity = new Vect(xv, yv);
		color =  Color.blue;
		radius  = 10;
		
	}
	//setters
	
	public void setRadius(double r){
		radius = r;
	}
	public void setVelo(Vect v){
		velocity = v;
	}
	
	
	//getters
	
	public double getRadius(){
		return radius;
	}
	public Vect getVelo(){
		return velocity;
	}
	public Circle getCircle(){
		return new Circle(xpos, ypos, radius);
	}

}
