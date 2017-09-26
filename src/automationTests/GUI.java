package automationTests;

import java.awt.AWTException;
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

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.geom.Ellipse2D.Float;





public class GUI extends JFrame{

	

	private static int frameX; 
	private static int frameY; 
	
	double mouseXPOS;
	double mouseYPOS;
	
	public GUI(){
		
		setSize(400, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//			frameX = frame.getX();
//			frameY = frame.getY();
			 addMouseListener(new MouseAdapter() {
		     public void mouseClicked(MouseEvent e) {
		    	PointerInfo mouse = MouseInfo.getPointerInfo();
		 		Point currentPoint = mouse.getLocation();
		 		int mouseXPOS = (int) currentPoint.getX();
		 		int mouseYPOS = (int) currentPoint.getY();
		 		System.out.println(mouseXPOS+"    "+mouseYPOS);
		 		
		 		if(0 < mouseXPOS && mouseXPOS < 99){
		 			mouseXPOS = 0;
		 		}
		 		else if (100 < mouseXPOS && mouseXPOS < 199 ){
		 			mouseXPOS = 1;
		 		}
		 		else if (200 < mouseXPOS && mouseXPOS < 299 ){
		 			mouseXPOS = 2;
		 		}
		 		else {
		 			mouseXPOS = 3;
		 		}
		 		if(0 < mouseYPOS && mouseYPOS < 99){
		 			mouseYPOS = 0;
		 		}
		 		else if (100 < mouseYPOS && mouseYPOS < 199 ){
		 			mouseYPOS = 1;
		 		}
		 		else if (200 < mouseYPOS && mouseYPOS < 299 ){
		 			mouseYPOS = 2;
		 		}
		 		else {
		 			mouseYPOS =3;
		 		}
		 		
		 		
		 		GridPopulator.Replace(mouseXPOS,mouseYPOS);
		 		revalidate();
		 		repaint();
				
		 		
		 		
		     }
		  });
	}
	
	public void paint(Graphics g){
		
		

		
		
		//draw grid
		 g.drawLine(0, 100, 500, 100);
		 g.drawLine(0, 200, 500, 200);
		 g.drawLine(0, 300, 500, 300);
		 g.drawLine(100, 0, 100, 800);
		 g.drawLine(200, 0, 200, 800);
		 g.drawLine(300, 0, 300, 800);
		
		//populate grid with circles 
		 
		
		

		
		int xIncrement = 0;
		int yIncrement = 0;
		
		
		for (int i = 0; i < 4; i++){
			for(int j = 0; j < 4; j++){
				Color c = GridPopulator.getMultiDim().get(i).get(j).getColor();
				g.setColor(c);
				g.fillOval(xIncrement, yIncrement, 100, 100);
				yIncrement += 100;
				
			}
			yIncrement = 0; 
			xIncrement += 100; 
		}
		
		 
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
	
	public static int getFrameX() {
		return frameX;
	}

	public static void setFrameX(int frameX) {
		GUI.frameX = frameX;
	}

	public static int getFrameY() {
		return frameY;
	}

	public static void setFrameY(int frameY) {
		GUI.frameY = frameY;
	}
}