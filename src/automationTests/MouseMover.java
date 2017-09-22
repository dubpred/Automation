package automationTests;

import java.awt.Robot;
import java.util.Random; 
import java.awt.MouseInfo;



public class MouseMover {
	
	public static void main(String[] args) throws Exception{
		Robot robot = new Robot();
		Random randyMouse = new Random();
		
		int randomNumberx = randyMouse.nextInt(3)+1;
		int randomNumbery = randyMouse.nextInt(3)+1;
		
		int mouseCurrentY = MouseInfo.getPointerInfo().getLocation().y;
		int mouseCurrentX = MouseInfo.getPointerInfo().getLocation().x;
		
		GUI.drawFrame();
		
		
	}

}
