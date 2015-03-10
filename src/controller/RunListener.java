package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.Timer;

import physics.Vect;
import model.Model;

public class RunListener implements ActionListener, KeyListener {

	private Timer timer;
	private Model model;

	public RunListener(Model m) {
		model = m;
		timer = new Timer(50, this);
	}

	@Override
	public final void actionPerformed(final ActionEvent e) {

		if (e.getSource() == timer) {
			model.moveBall();
		} else
			switch (e.getActionCommand()) {
			case "Start":
				timer.start();
				for(int i = 0; i < model.balls.size(); i++){
					model.getBall().get(i).setStopped(false);
				}
				break;
			case "Stop":
				model.moveBall();
				break;
			case "Tick":
				model.moveFlipper();
				break;
			case "Quit":
				System.exit(0);
				break;
			}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("here"+e.getKeyCode());
		if (e.getKeyCode() == KeyEvent.VK_X){
			System.out.println("now here");
			for(int i = 0; i < model.flippers.size(); i++){
				if(model.getFlipper().get(i).getOpCode().equals("RightFlipper")){
				model.flippers.get(i).keyPressed = true;
				model.moveFlipper();
				}
			}
		}

		if (e.getKeyCode() == KeyEvent.VK_Z){
			System.out.println("now here");
			for(int i = 0; i < model.flippers.size(); i++){
				if(model.getFlipper().get(i).getOpCode().equals("LeftFlipper")){
				model.flippers.get(i).keyPressed = true;
				model.moveFlipper();
				}

			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("here"+e.getKeyCode());
		if (e.getKeyCode() == KeyEvent.VK_X){
			System.out.println("now here");
			for(int i = 0; i < model.flippers.size(); i++){
				if(model.getFlipper().get(i).getOpCode().equals("RightFlipper")){
				model.flippers.get(i).keyPressed = false;
				model.moveFlipper();
				}

			}
		}
		if (e.getKeyCode() == KeyEvent.VK_Z){
			System.out.println("now here");

			for(int i = 0; i < model.flippers.size(); i++){
				if(model.getFlipper().get(i).getOpCode().equals("RightFlipper")){
				model.flippers.get(i).keyPressed = true;
				model.moveFlipper();
				}
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
