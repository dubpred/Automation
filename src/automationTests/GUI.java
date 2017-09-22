package automationTests;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Ellipse2D.Float;

import javax.swing.JFrame;


public class GUI extends JFrame {

	static int [][] grid = new int[4][4];
	
	
	public static void drawFrame(){
		JFrame frame = new GUI();
		frame.setSize(400, 400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public void paint(Graphics g){
		Graphics2D ga = (Graphics2D)g;
		
		int xIncrement = 0;
		int yIncrement = 0;
		
		//populate grid with circles 	
		for (int i = 0; i< grid.length;i++){
			for(int j = 0; j<grid[i].length;j++){
				ga.draw(new Ellipse2D.Float(xIncrement, yIncrement, 100, 100));
				yIncrement +=100;
				
			}
			yIncrement = 0; 
			xIncrement += 100; 
		}
		
		 
		//draw grid
		 ga.draw(new Line2D.Double(0, 100, 500, 100));
		 ga.draw(new Line2D.Double(0, 200, 500, 200));
		 ga.draw(new Line2D.Double(0, 300, 500, 300));
		 ga.draw(new Line2D.Double(100, 0, 100, 800));
		 ga.draw(new Line2D.Double(200, 0, 200, 800));
		 ga.draw(new Line2D.Double(300, 0, 300, 800));
		 
		 
		
		 
		
		
	}
	}
