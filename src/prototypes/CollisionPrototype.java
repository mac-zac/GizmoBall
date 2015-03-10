package prototypes;

import javax.swing.UIManager;

import model.Ball;
import model.Model;
import model.SquareGizmo;

import model.CircleGizmo;
import model.TriangleGizmo;
import view.RunGui;


public class CollisionPrototype {

	public static void main(String[] args) {
		try {
			// Use the platform look and feel
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			System.out.println("Look and Feel error in Main");
		}

		Model model = new Model();

	
		

		// Ball
		model.addBall(new Ball("ball","b1",25,50,0,0));
	//	model.addBall(new Ball("ball","b2",50,250,0,0));
		
		model.setBallSpeed(400, 400);
		// Triangle
		model.addTriangle(new TriangleGizmo("Triangle","T1",200,250,25));
		model.addTriangle(new TriangleGizmo("Triangle","T2",400,300,25));
		
		model.addTriangle(new TriangleGizmo("Triangle","T3",80,300,25));
		model.addTriangle(new TriangleGizmo("Triangle","T4",400,150,25));
		
		model.addTriangle(new TriangleGizmo("Triangle","T5",40,250,25));
		model.addTriangle(new TriangleGizmo("Triangle","T6",250,30,25));
		
		model.addTriangle(new TriangleGizmo("Triangle","T7",400,250,25));
		model.addTriangle(new TriangleGizmo("Triangle","T8",400,300,25));
		
		// Squares
		model.addSquare(new SquareGizmo("Square","S1",80,90,25));
		
		// Circles
		model.addCircle(new CircleGizmo("Circle","C1",160, 180));

		
		RunGui gui = new RunGui(model);
		gui.createAndShowGUI();
	}
}
