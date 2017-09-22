package automationTests;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Shape;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Random;
import java.awt.geom.Ellipse2D.Float;

import javax.swing.JFrame;


public class GUI extends JFrame {

	static int [][] grid = new int[4][4];
	ArrayList <Circle> circleList = new ArrayList <Circle>();
	
	public static void drawFrame(){
		JFrame frame = new GUI();
		frame.setSize(400, 400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		frame.addMouseListener(new MouseAdapter() {
		     public void mouseClicked(MouseEvent e) {
		    	PointerInfo mouse = MouseInfo.getPointerInfo();
		 		Point currentPoint = mouse.getLocation();
		 		double x = currentPoint.getX();
		 		double y = currentPoint.getY();
		 		System.out.println("x"+x+"y"+y);
		     }
		  });
	}
	
	public void paint(Graphics g){
		Graphics2D ga = (Graphics2D)g;
		
		int xIncrement = 0;
		int yIncrement = 0;
		
		Random random = new Random();
		
		//populate grid with circles 	
		for (int i = 0; i< grid.length;i++){
			for(int j = 0; j<grid[i].length;j++){
				
				//Creates random Color
				int randR = random.nextInt(255)+1;
				int randG = random.nextInt(255)+1;
				int randB = random.nextInt(255)+1;
				Color color = new Color(randR, randG, randB);
				
				
				Ellipse2D circle = new Ellipse2D.Float(xIncrement, yIncrement, 100, 100);
				ga.draw(circle);
				ga.fill(circle);
				ga.setColor(color);
				
				
				Circle circleS = new Circle(xIncrement,yIncrement,color);
				circleList.add(circleS);
				yIncrement +=100;
				 
				
			}
			yIncrement = 0; 
			xIncrement += 100; 
		}
		
		 System.out.println(circleList.size());
		 
		 
		
		
		//draw grid
		 ga.setColor(Color.black);
		 ga.draw(new Line2D.Double(0, 100, 500, 100));
		 ga.draw(new Line2D.Double(0, 200, 500, 200));
		 ga.draw(new Line2D.Double(0, 300, 500, 300));
		 ga.draw(new Line2D.Double(100, 0, 100, 800));
		 ga.draw(new Line2D.Double(200, 0, 200, 800));
		 ga.draw(new Line2D.Double(300, 0, 300, 800));
		 
		
	}
	
}