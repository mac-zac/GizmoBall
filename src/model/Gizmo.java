package model;

import java.awt.Color;

public class Gizmo implements IGizmo {

	private double xpos;
	private double ypos;
	private Color color;
	private String id;
	

	public void setColor(Color c) {
		color = c;
	}

	public void setID(String s) {
		id = s;
	}

	public void setX(double x) {
		xpos = x;
	}

	public void setY(double y) {
		ypos = y;
	}
	
	
	
	public Color getColor() {
		return color;
	}

	public String getID() {
		return id;
	}

	@Override
	public double getX() {

		return xpos;
	}

	@Override
	public double getY() {
		return ypos;
	}
	
}	
	
	
	
	
	
	
	
	
	
	
	
	
	