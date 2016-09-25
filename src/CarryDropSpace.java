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
}
