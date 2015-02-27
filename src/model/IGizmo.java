package model;

import java.awt.Color;

/**
 * @author Maciej Zajac GizmoBall 27/02/2015
 */
public interface IGizmo {
	
	public void setColor (Color c);
	public void setID(String s);
	public void setX(double x);
	public void setY(double y);
	
	public Color getColor();
	public String getID();
	public double getX();
	public double getY();
	

}
