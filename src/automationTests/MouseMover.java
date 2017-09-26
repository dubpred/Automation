package automationTests;

import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.awt.AWTException;
import java.awt.Color;
import java.awt.MouseInfo;



public class MouseMover {
	
	private static Color huntedColor = Color.red;
	

	public static void main(String[] args) throws Exception{
		new GUI();
		runBot();
		TimeUnit.SECONDS.sleep(2);
	
	}
	public static void runBot() throws AWTException, InterruptedException{	
		
		
		Robot robot = new Robot();
		GridPopulator.Populate();
		
		
		Random randyMouse = new Random();
		int randomNumberx = randyMouse.nextInt(400)+1;
		int randomNumbery = randyMouse.nextInt(400)+1;
		
		    for(int i = 80; i < 400; i+=30){
		    	
		    	for (int j = 30; j < 400; j+=20){
		    		int mouseCurrentY = MouseInfo.getPointerInfo().getLocation().y;
		    		int mouseCurrentX = MouseInfo.getPointerInfo().getLocation().x;
		    		robot.mouseMove((GUI.getFrameX()+j),GUI.getFrameY()+i);
		    		Color currentColor = robot.getPixelColor(mouseCurrentX, mouseCurrentY);
		    		System.out.println(robot.getPixelColor(mouseCurrentX, mouseCurrentY));
		    		
		    		
		    		
		    		if(huntedColor.equals(robot.getPixelColor(mouseCurrentX, mouseCurrentY))){
		    			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		    			robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		    		}
		    	
		    		
		    	}
		    	
		    }
		    
		    Random nextRandomColor = new Random();
		    int nextColor = nextRandomColor.nextInt(2)+1;
		    if(huntedColor.equals(Color.RED)){
		    	switch(nextColor){
		    	case 1: huntedColor = Color.BLUE;
		    	case 2: huntedColor = Color.GREEN;
		    	}
		    	runBot();
		    }
		    if(huntedColor.equals(Color.BLUE)){
		    	switch(nextColor){
		    	case 1: huntedColor = Color.GREEN;
		    	case 2: huntedColor = Color.RED;
		    	}
		    	runBot();
		    }
		    if(huntedColor.equals(Color.GREEN)){
		    	switch(nextColor){
		    	case 1: huntedColor = Color.RED;
		    	case 2: huntedColor = Color.BLUE;
		    	}
		    	runBot();
		    }
		    	
		
		
		}
		
}
	
	

	

