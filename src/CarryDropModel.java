// CarryDropModel

// package demo;
import java.awt.Color;
import uchicago.src.sim.engine.Schedule;
import uchicago.src.sim.engine.SimInit;
import uchicago.src.sim.engine.SimModelImpl;
import uchicago.src.sim.gui.DisplaySurface;
import uchicago.src.sim.gui.ColorMap;
import uchicago.src.sim.gui.Value2DDisplay;



public class CarryDropModel extends SimModelImpl {

  private static final int NUMAGENTS = 100;
  private static final int WORLDXSIZE = 40;
  private static final int WORLDYSIZE = 40;
  private static final int TOTALMONEY = 1000;
 
  private Schedule schedule;
  private CarryDropSpace cdSpace;
  private DisplaySurface displaySurf;

  private int numAgents = NUMAGENTS;
  private int worldXSize = WORLDXSIZE;
  private int worldYSize = WORLDYSIZE;
  private int money = TOTALMONEY;

  public String getName(){
    return "Carry And Drop";
  }

  public void setup(){
	  System.out.println("Running setup");
	  if (displaySurf != null){
	      displaySurf.dispose();
	    }
	    displaySurf = null;

	    displaySurf = new DisplaySurface(this, "Carry Drop Model Window 1");

	    registerDisplaySurface("Carry Drop Model Window 1", displaySurf);
  }

  public void begin(){
    buildModel();
    buildSchedule();
    buildDisplay();
    
    displaySurf.display();
  }

  public void buildModel(){
	  System.out.println("Running BuildModel");
	  cdSpace = new CarryDropSpace(worldXSize, worldYSize);
	  cdSpace.spreadMoney(money);
  }

  public void buildSchedule(){
	  System.out.println("Running BuildSchedule");

  }

  public void buildDisplay(){
	  System.out.println("Running BuildDisplay");
	  ColorMap map = new ColorMap();
	  
	  for(int i = 1; i<16; i++){
		  map.mapColor(i, new Color((int)(i * 8 + 127), 0, 0));
	  }
	    
	  map.mapColor(0, Color.white);
	  Value2DDisplay displayMoney = new Value2DDisplay(cdSpace.getCurrentMoneySpace(), map);

	  displaySurf.addDisplayable(displayMoney, "Money");
  }

  public Schedule getSchedule(){
    return schedule;
  }

  public String[] getInitParam(){
	String[] initParams = { "NumAgents" , "WorldXSize", "WorldYSize"};
	
    return initParams;
  }

  public int getNumAgents(){
    return numAgents;
  }

  public void setNumAgents(int na){
    numAgents = na;
  }

  public int getWorldXSize(){
	  return worldXSize;
  }

  public void setWorldXSize(int wxs){
	  worldXSize = wxs;
  }
  
  public int getWorldYSize(){
	  return worldYSize;
  }
  
  public void setWorldYSize(int wys){
	  worldYSize = wys;
  }
  
  public int getMoney(){
	  return money;
  }
  
  public void setMoney(int i){
	  money = i;
  }
  public static void main(String[] args) {
	  SimInit init = new SimInit();
	  CarryDropModel model = new CarryDropModel();
	  init.loadModel(model, "", false);
  }

}