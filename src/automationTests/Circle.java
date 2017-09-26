package automationTests;

import java.awt.Color;

public class Circle {
	int xPos;
	int yPos; 
	Color color;
	public Circle(int xPos, int yPos, Color color) {
		super();
		this.yPos = yPos;
		this.xPos = xPos;
		this.color = color;
	}
	public int getXPos() {
		return xPos;
	}
	public void setXPos(int xPos) {
		this.xPos = xPos;
	}
	public int getYPos() {
		return yPos;
	}
	public void setYPos(int yPos) {
		this.yPos = yPos;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "Circle [xPos=" + xPos + ", yPos=" + yPos + ", color=" + color + "]";
	} 
	
	
	

}
