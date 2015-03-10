package model;

import java.awt.Color;
/**
 * @author Maciej Zajac GizmoBall 27/02/2015
 */
public class Gizmo implements IGizmo {

	protected double xpos1;
	protected double ypos1;
	protected Color color;
	protected String id;
	protected String opcode;
	

	public Color getColor() {
		return color;
	}

	public String getID() {
		return id;
	}
	
	public String getOpCode() {
		return opcode;
	}

	public double getX1() {

		return xpos1;
	}

	@Override
	public double getY1() {
		return ypos1;
	}
	
	
	
	public void setColor(Color c) {
		color = c;
	}

	public void setID(String s) {
		id = s;
	}
	
	public void setOpCode(String s) {
		opcode = s;
	}

	public void setX1(double x) {
		xpos1 = x;
	}

	public void setY1(double y) {
		ypos1 = y;
	}
	
}	
	
	
	
	
	
	
	
	
	
	
	
	
	