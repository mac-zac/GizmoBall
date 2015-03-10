package prototypes;

import javax.swing.UIManager;

import model.Flipper;

//import model.Circle;
import model.Model;
import view.RunGui;


public class FlipperPrototype {

	public static void main(String[] args) {
		try {
			// Use the platform look and feel
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			System.out.println("Look and Feel error in Main");
		}

		Model model = new Model();

		model.addFlipper(new Flipper("RightFlipper", "RF1",100, 200));
		//model.addLeftFlipper(new GizLeftFlipper("Left","l1",100, 400, 0, 0));
		model.addFlipper(new Flipper("LeftFlipper", "LF1",100,400));
		//model.addRightFlipper(new GizRightFlipper("Rgith","r2",400, 200, 0, 0));
		//model.addLeftFlipper(new GizLeftFlipper("Left","l1",400, 400, 0, 0));

		
		
		RunGui gui = new RunGui(model);
		gui.createAndShowGUI();
	}
}
