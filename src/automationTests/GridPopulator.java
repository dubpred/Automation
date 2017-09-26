package automationTests;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

public class GridPopulator {
	public static ArrayList <ArrayList<Circle>> multiDim = new ArrayList <ArrayList<Circle>>();
	
	public static void Populate()
	{
		Random R = new Random();

		for(int i = 0; i<4 ; i++){
			ArrayList <Circle> arrayOfCircles = new ArrayList <Circle>(); 

			
			
			for (int j = 0; j<4; j++){
				
				Color currentColor = null;
				int randomColor = R.nextInt(3)+1;
				
				switch(randomColor){
				case 1: currentColor = Color.RED;
				break;
				case 2: currentColor = Color.GREEN;
				break;
				case 3: currentColor = Color.BLUE;
				break;
				default: currentColor = Color.ORANGE;
				}
				Circle currentCircle = new Circle(i,j,currentColor);
				arrayOfCircles.add(currentCircle);
				
				}
			multiDim.add(arrayOfCircles);
			
		}
		

		
	}
	
	public static void Replace(int x, int y){
		
		
		Random R = new Random();
		int randomColor = R.nextInt(3)+1;
		Color currentColor = null;
		
		switch(randomColor){
		case 1: currentColor = Color.RED;
		break;
		case 2: currentColor = Color.GREEN;
		break;
		case 3: currentColor = Color.BLUE;
		break;
		default: currentColor = Color.ORANGE;
		}
		
		Circle replaceCircle = new Circle(x,y,currentColor);
		
		multiDim.get(x).set(y,replaceCircle);
	}

	public static ArrayList<ArrayList<Circle>> getMultiDim() {
		return multiDim;
	}

	public static void setMultiDim(ArrayList<ArrayList<Circle>> multiDim) {
		GridPopulator.multiDim = multiDim;
	}

}
