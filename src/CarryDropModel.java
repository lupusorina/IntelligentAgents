// CarryDropModel

// package demo;

import uchicago.src.sim.engine.Schedule;
import uchicago.src.sim.engine.SimInit;
import uchicago.src.sim.engine.SimModelImpl;

public class CarryDropModel extends SimModelImpl {

 private static final int NUMAGENTS = 100;
 private static final int WORLDXSIZE = 40;
 private static final int WORLDYSIZE = 40;
 private static final int TOTALMONEY = 1000;
 
  private Schedule schedule;
  private int numAgents = NUMAGENTS;
  private int worldXSize = WORLDXSIZE;
  private int worldYSize = WORLDYSIZE;
  private int money = TOTALMONEY;

  public String getName(){
    return "Carry And Drop";
  }

  public void setup(){
	  System.out.println("Running setup");
  }

  public void begin(){
    buildModel();
    buildSchedule();
    buildDisplay();
  }

  public void buildModel(){
	  System.out.println("Running BuildModel");
  }

  public void buildSchedule(){
	  System.out.println("Running BuildSchedule");

  }

  public void buildDisplay(){
	  System.out.println("Running BuildDisplay");

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