//package demo;
import uchicago.src.sim.space.Object2DGrid;


public class CarryDropSpace {
	private Object2DGrid moneySpace;
	
	public CarryDropSpace(int xSize, int ySize){
		moneySpace = new Object2DGrid(xSize, ySize);
		for(int i = 0; i < xSize; i++){
			for(int j = 0; j < ySize; j++){
		        moneySpace.putObjectAt(i,j,new Integer(0));
		    }
		}
	}
	
	public void spreadMoney(int money){
	    // Randomly place money in moneySpace
	    for(int i = 0; i < money; i++){

	      // Choose coordinates
	      int x = (int)(Math.random()*(moneySpace.getSizeX()));
	      int y = (int)(Math.random()*(moneySpace.getSizeY()));
	      System.out.print("X = " + x + "Y = " + y + " ");
	      
	      // Get the value of the object at those coordinates
	      int currentValue = getMoneyAt(x, y);
	      System.out.println();
	      // Replace the Integer object with another one with the new value
	      moneySpace.putObjectAt(x,y,new Integer(currentValue + 1));
	    }
	  }
	
	public int getMoneyAt(int x, int y){
		int i;
	    if(moneySpace.getObjectAt(x,y)!= null){
	      i = ((Integer)moneySpace.getObjectAt(x,y)).intValue();
	    }
	    else{
	      i = 0;
	    }
	    return i;
	}
	
	public Object2DGrid getCurrentMoneySpace(){
	    return moneySpace;
	  }
}
