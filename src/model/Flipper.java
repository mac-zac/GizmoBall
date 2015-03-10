package model;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
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
	
	public Flipper(double x1, double y1){
		xpos1 = x1;
		ypos1 = y1;
		if(this.opcode.equals("LeftFlipper")){
			xpos2 = xpos1;	
		}else{
			xpos2 = xpos1 +35;			
		}
		ypos2 = ypos2+50;
		
	}
	public Flipper(String opc, String iD, double x1, double y1){
		opcode = opc;
		id = iD;
		xpos1 = x1;
		ypos1 = y1;
		if(this.opcode.equals("LeftFlipper")){
			xpos2 = xpos1;	
		}else{
			xpos2 = xpos1 +35;			
		}
		ypos2 = ypos2+50;
	}
	//degrees - flipper rotation limit 
	public void degrees() throws InterruptedException{

		if(keyPressed){
			while(deg < 90){
				deg += 15;
				System.out.println("Rotating UP");
			}
		}
		else if(!keyPressed){
			while(deg > 0){
				deg -= 15;
				System.out.println("Rotating Down");
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
		
		try {
			degrees();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(this.getOpCode().equals("RightFlipper")){
			at.setToRotation(Math.toRadians(deg), (xpos1+30), (ypos1-5));
			if(deg == 90){
			at.translate(0, -20);
			}
		}else if(this.getOpCode().equals("LeftFlipper")){
			at.setToRotation(Math.toRadians(deg), (xpos1+15), (ypos1));
			if(deg == 90){
			at.translate(0, -10);
			}
		}		
		
	}
	public Graphics paint(Graphics g) {
		  
		
		Area shape = new Area(new Rectangle2D.Double(xpos1+35, ypos1+5, 25/2+3,25L+25));
		Area pivotedCircle = new Area(new Ellipse2D.Double(xpos2, ypos2, 15,15));
		
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(Color.BLUE);
		g2d.fill(shape);
		g2d.fill(pivotedCircle);
		if(this.opcode.equals("RightFlipper")){
			g2d.fillOval((int)xpos1+35,(int) ypos1, 15, 15);
		}else{
			g2d.fillOval((int)xpos1,(int) ypos1, 15, 15);
		}
		return g;
	}
	

}
