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

	
	ArrayList <Circle> circleList = new ArrayList <Circle>();
	double mouseXPOS;
	double mouseYPOS;
	
	public static void drawFrame(){
		
		JFrame frame = new GUI();
		frame.setSize(400, 400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		frame.addMouseListener(new MouseAdapter() {
		     public void mouseClicked(MouseEvent e) {
		    	PointerInfo mouse = MouseInfo.getPointerInfo();
		 		Point currentPoint = mouse.getLocation();
		 		double mouseXPOS = currentPoint.getX();
		 		double mouseYPOS = currentPoint.getY();
		 		System.out.println(mouseXPOS+"    "+mouseYPOS);
		     }
		  });
	}
	
	public void paint(Graphics g){
		Graphics2D ga = (Graphics2D)g;
		
		int xIncrement = 0;
		int yIncrement = 0;
		
		
		
		
		
		//populate grid with circles 
		int [][] grid = new int[4][4];
		for (int i = 0; i< grid.length;i++){
			for(int j = 0; j<grid[i].length;j++){
				
				//Creates random Color
				Random random = new Random();
				int randomColor = random.nextInt(3)+1;
				Color currentColor = Color.ORANGE; 
				
				switch(randomColor){
				case 1: currentColor = Color.RED;
				break;
				case 2: currentColor = Color.BLUE;
				break;
				case 3: currentColor = Color.GREEN;
				break;
				}
				ga.setColor(currentColor);
				
				Ellipse2D circle = new Ellipse2D.Float(xIncrement, yIncrement, 100, 100);
				ga.fill(circle);
				ga.draw(circle);
				
				Circle circleS = new Circle(xIncrement,yIncrement,currentColor);
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

	public ArrayList<Circle> getCircleList() {
		return circleList;
	}

	public void setCircleList(ArrayList<Circle> circleList) {
		this.circleList = circleList;
	}

	public double getMouseXPOS() {
		return mouseXPOS;
	}

	public void setMouseXPOS(double mouseXPOS) {
		this.mouseXPOS = mouseXPOS;
	}

	public double getMouseYPOS() {
		return mouseYPOS;
	}

	public void setMouseYPOS(double mouseYPOS) {
		this.mouseYPOS = mouseYPOS;
	}
	
}