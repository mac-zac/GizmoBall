package model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class Praser {

	private final int L = 25;

	BufferedReader reader;
	public void fileReader(Model gm){
		try {
			String file = "gizmoball.txt";	
			
			String opcode;
			String id;
			int coorX;
			int coorY;
			int absorberX;
			int absorberY;

			FileInputStream input = new FileInputStream(file);
			//Use bufferReader next time
			Scanner scanLine = new Scanner(input);
			while (scanLine.hasNextLine()) {
				try{
					opcode = scanLine.next();
					coorX = 0;
					coorY = 0;
					absorberX = 0;
					absorberY = 0;
					if(opcode.equals("Square")){
						id = scanLine.next();
						coorX = scanLine.nextInt()*L;
						coorY = scanLine.nextInt()*L;
						gm.addGizmo(opcode, id, coorX, coorY,25,absorberX,absorberY);
					}
					else if(opcode.equals("Triangle")){
						id = scanLine.next();
						coorX = scanLine.nextInt()*L;
						coorY = scanLine.nextInt()*L;
						gm.addGizmo(opcode, id, coorX, coorY,25,absorberX,absorberY);
					}
					else if(opcode.equals("Circle")){
						id = scanLine.next();
						coorX = scanLine.nextInt()*L;
						coorY = scanLine.nextInt()*L;
						gm.addGizmo(opcode, id, coorX, coorY,25,absorberX,absorberY);
					}
					else if(opcode.equals("LeftFlipper")){
						id = scanLine.next();
						coorX = scanLine.nextInt()*L;
						coorY = scanLine.nextInt()*L;
						gm.addGizmo(opcode, id, coorX, coorY,0,absorberX,absorberY);
					}
					else if(opcode.equals("RightFlipper")){
						id = scanLine.next();
						coorX = scanLine.nextInt()*L;
						coorY = scanLine.nextInt()*L;
						gm.addGizmo(opcode, id, coorX, coorY,0,absorberX,absorberY);
					}
					else if(opcode.equals("Absorber")){
						id = scanLine.next();
						coorX = scanLine.nextInt()*L;
						coorY = scanLine.nextInt()*L;
						absorberX = scanLine.nextInt()*L;
						absorberY = scanLine.nextInt()*L;
						gm.addGizmo(opcode, id, coorX, coorY,absorberX,absorberY,0);
					}
					else if(opcode.equals("Connect")){
						id = scanLine.next();
						gm.addGizmo(opcode, id, coorX, coorY,25,absorberX,absorberY);
					}
					else if(opcode.equals("KeyConnect")){
						id = scanLine.next();
						gm.addGizmo(opcode, id, coorX, coorY,25,absorberX,absorberY);
					}
					else if(opcode.equals("Rotate")){
						id = scanLine.next();
						gm.addGizmo(opcode, id, coorX, coorY,0,absorberX,absorberY);
					}
					else if(opcode.equals("Ball")){
						id = scanLine.next();
						gm.addGizmo(opcode, id, coorX, coorY,25,absorberX,absorberY);
					}

				}
				catch(NoSuchElementException e){
					System.out.println("Element not found");
				}
			}
			scanLine.close();
		}

		catch(FileNotFoundException e){
			System.out.println("File not found.");
		}
	}

	public void fileWriter() {
		//TODO similar to above
	}
}	
