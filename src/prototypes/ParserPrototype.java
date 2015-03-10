package prototypes;

import javax.swing.UIManager;
import javax.swing.text.html.parser.Parser;

import view.RunGui;
import model.Ball;
import model.Praser;
import model.Model;


public class ParserPrototype {

	public static void main(String[] args) {
		
		try {
			// Use the platform look and feel
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			System.out.println("Look and Feel error in Main");
		}

		Model model = new Model();
		model.addBall(new Ball("Ball", "B1",25, 25, 0, 0));
		model.addBall(new Ball("Ball", "B2", 135, 5, 0, 0));
		Praser parser = new Praser();
		
		parser.fileReader(model);
		
		RunGui gui = new RunGui(model);
		gui.createAndShowGUI();
	}
}
