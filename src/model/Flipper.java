package model;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import physics.Circle;
import physics.LineSegment;
/**
 * @author Maciej Zajac GizmoBall 03/03/2015
 */

public class Flipper extends Gizmo implements IGizmo {
	
	public int direction = 0;
	public boolean keyPressed = false;
	private AffineTransform at = new AffineTransform();
	private int deg = 0;
	private double xpos2;
	private double ypos2;
	private ArrayList<LineSegment> ls = new ArrayList<LineSegment>();
	private ArrayList<Circle> circles = new ArrayList<Circle>();
	
	
	/*public Flipper(double x1, double y1){
		xpos1 = x1;
		ypos1 = y1;
		if(this.opcode.equals("LeftFlipper")){
			xpos2 = xpos1;	
		}else{
			xpos2 = xpos1 +35;			
		}
		ypos2 = ypos2+50;
		
	}*/
	public Flipper(String opc, String iD, double x1, double y1){
		opcode = opc;
		id = iD;
		xpos1 = x1;
		ypos1 = y1;
		 double tx1,tx2,ty1,ty2;
		 tx1=0;
		 ty1=0;
		if(opcode.equals("LeftFlipper")){
			System.out.println("Setting up LF");
			xpos2 = xpos1;	
			//ypos2 = ypos1+50;
			this.setColor(Color.LIGHT_GRAY);
			 tx1 = xpos1;
			  ty1= ypos1+5;
			
		}else if(opcode.equals("RightFlipper")){
			System.out.println("Setting up RF");
			this.setColor(Color.red);
			xpos2 = xpos1 +35;	
			  tx1 = xpos1+35;
			  ty1= ypos1+5;
			
		}
		ypos2 = ypos1+50;
		
		
		  tx2 = tx1 +15;
		  ty2 = ty1+25;
		ls.add(new LineSegment(tx1, ty1, tx1, ty2));
		ls.add(new LineSegment(tx1, ty1, tx2, ty1));
		ls.add(new LineSegment(tx2, ty2, tx1, ty2));
		ls.add(new LineSegment(tx2, ty2, tx2, ty1));
		circles.add(new Circle(xpos2, ypos2, 15));
		circles.add(new Circle(tx1, ty1, 15));
		
		
		  
		
		
	}
	
	
	public AffineTransform getTrans(){
		return at;
	}
	//degrees - flipper rotation limit 
	public void degrees() throws InterruptedException{

		if(keyPressed){
			while(deg < 90){
				deg += 15;
				System.out.println("Rotating UP " + opcode);
			}
		}
		else if(!keyPressed){
			while(deg > 0){
				deg -= 15;
				System.out.println("Rotating Down " + opcode);
			}
		}
	}//end degrees
	public double getX2(){
		return xpos2;
	}
	public double getY2(){
		return xpos2;
	}
	//direction of rotation
	public void rotateDirection() {
        if (direction == 0 ) {
                if (deg == 0)
                        direction = 1;
                if (deg == 90)
                        direction = -1;
        }
        else
                direction = -direction;       
	}
	
	//rotate flipper
	public void rotateFlipper(){
		System.out.println("rf "+ this );
		try {
			degrees();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(opcode.equals("RightFlipper")){
			System.out.println("rotating up rF");
			
			at.setToRotation(Math.toRadians(deg), (xpos1+30), (ypos1-5));
			if(deg == 90){
			at.translate(0, -20);
			}
		}else if(opcode.equals("LeftFlipper")){
			System.out.println("rotating up LF");
			at.setToRotation(Math.toRadians(-deg), (xpos1+15), (ypos1));
			if(deg == 90){
			at.translate(0, -10);
			}
		}		
		
	}
	public ArrayList<LineSegment> getLS(){
		return ls;
	}
	public ArrayList<Circle> getCirc(){
		
		return circles;
	}
	/*public Graphics paint(Graphics g) {
		  int x1,x2,y1,y2;
		  x1 = xpos1+35;
		  y1= ypos1+5
		
		Area shape = new Area(new Rectangle2D.Double(xpos1+35, ypos1+5, 25/2+3,25L+25));
		Area pivotedCircle = new Area(new Ellipse2D.Double(xpos2, ypos2, 15,15));
		
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(Color.BLUE);
		g2d.fill(shape);
		g2d.fill(pivotedCircle);
		if(this.opcode.equals("RightFlipper")){
			System.out.println("draw up rF");
			g2d.fillOval((int)xpos1+35,(int) ypos1, 15, 15);
		}else{
			System.out.println("draw up LF");
			g2d.fillOval((int)xpos1,(int) ypos1, 15, 15);
		}
		return g;
	}*/
	

}
