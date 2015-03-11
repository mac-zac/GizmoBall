package prototypes;

import javax.swing.UIManager;

import model.Ball;
import model.AbsorberGizmo;
import model.CircleGizmo;
import model.SquareGizmo;
import model.Model;
import model.TriangleGizmo;
import view.RunGui;

/**
 * @author Murray Wood Demonstration of MVC and MIT Physics Collisions 2014
 */

public class AbsorberPrototype {

	public static void main(String[] args) {
		try {
			// Use the platform look and feel
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			System.out.println("Look and Feel error in Main");
		}

		Model model = new Model();

		model.addBall(new Ball("Ball","B1",20,20,100,100));
		
		model.addAbs(new AbsorberGizmo("Absorber","A1",0,480,500,500));
		//model.addTriangle(new TriangleGizmo("Triangle","T3",490,0,25));
		model.addCircle(new CircleGizmo("Circle", "C1", 495, -5));
		//model.getTriangle().get(0).rotate();
		//model.getTriangle().get(0).rotate();
		
		model.setBallSpeed(300, 100);

		model.addSquare(new SquareGizmo("Square","S1",150,150,25));

		RunGui gui = new RunGui(model);
		gui.createAndShowGUI();
	}
}
