//package demo;

public class CarryDropAgent {
	 private int x;
	 private int y;
	 private int money;
	 private int stepsToLive;

	 public CarryDropAgent(int minLifespan, int maxLifespan){
	    x = -1;
	    y = -1;
	    money = 0;
	    stepsToLive = 
	        (int)((Math.random() * (maxLifespan - minLifespan)) + minLifespan);
	  }
}
