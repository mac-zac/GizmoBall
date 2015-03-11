package prototypes;

import java.util.ArrayList;

import javax.swing.UIManager;

import physics.LineSegment;
import model.Ball;
import model.Flipper;
import model.Model;
import view.RunGui;

public class FlipperColissionPrototype {
	static ArrayList<LineSegment> ls = new ArrayList<LineSegment>();
	 
	
	
	

	public static void main(String[] args) {
		
		
		try {
			// Use the platform look and feel
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			System.out.println("Look and Feel error in Main");
		}

		
		Model model = new Model();
		
		model.addBall(new Ball("ball","b1",88,70,0,0));
		model.setBallSpeed(100, 100);
		
		

		model.addFlipper(new Flipper("RightFlipper", "RF1",160, 170));
		//model.addLeftFlipper(new GizLeftFlipper("Left","l1",100, 400, 0, 0));
		model.addFlipper(new Flipper("LeftFlipper", "LF1",90,170));
		//model.addRightFlipper(new GizRightFlipper("Rgith","r2",400, 200, 0, 0));
		//model.addLeftFlipper(new GizLeftFlipper("Left","l1",400, 400, 0, 0));

		
		
		RunGui gui = new RunGui(model);
		gui.createAndShowGUI();

	}

}
