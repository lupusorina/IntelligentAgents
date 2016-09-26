// CarryDropModel


import java.awt.Color;
import java.util.ArrayList;

import uchicago.src.sim.engine.Schedule;
import uchicago.src.sim.engine.SimInit;
import uchicago.src.sim.engine.SimModelImpl;
import uchicago.src.sim.gui.DisplaySurface;
import uchicago.src.sim.gui.ColorMap;
import uchicago.src.sim.gui.Object2DDisplay;
import uchicago.src.sim.gui.Value2DDisplay;

public class CarryDropModel extends SimModelImpl {
  // Default Values
  private static final int NUMAGENTS = 100;
  private static final int WORLDXSIZE = 40;
  private static final int WORLDYSIZE = 40;
  private static final int TOTALMONEY = 1000;
  private static final int AGENT_MIN_LIFESPAN = 30;
  private static final int AGENT_MAX_LIFESPAN = 50;

  private int numAgents = NUMAGENTS;
  private int worldXSize = WORLDXSIZE;
  private int worldYSize = WORLDYSIZE;
  private int money = TOTALMONEY;
  private int agentMinLifespan = AGENT_MIN_LIFESPAN;
  private int agentMaxLifespan = AGENT_MAX_LIFESPAN;

  private Schedule schedule;

  private CarryDropSpace cdSpace;

  private ArrayList agentList;

  private DisplaySurface displaySurf;

  public String getName(){
    return "Carry And Drop";
  }

  public void setup(){
    System.out.println("Running setup");
    cdSpace = null;
    agentList = new ArrayList();

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

    for(int i = 0; i < numAgents; i++){
      addNewAgent();
    }
    for(int i = 0; i < agentList.size(); i++){
      CarryDropAgent cda = (CarryDropAgent)agentList.get(i);
      cda.report();
    }
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

    Value2DDisplay displayMoney = 
        new Value2DDisplay(cdSpace.getCurrentMoneySpace(), map);

    Object2DDisplay displayAgents = new Object2DDisplay(cdSpace.getCurrentAgentSpace());
    displayAgents.setObjectList(agentList);

    displaySurf.addDisplayable(displayMoney, "Money");
    displaySurf.addDisplayable(displayAgents, "Agents");

  }

  private void addNewAgent(){
    CarryDropAgent a = new CarryDropAgent(agentMinLifespan, agentMaxLifespan);
    agentList.add(a);
    cdSpace.addAgent(a);
  } 
  public Schedule getSchedule(){
    return schedule;
  }

  public String[] getInitParam(){
    String[] initParams = { "NumAgents", "WorldXSize", "WorldYSize", "Money", "AgentMinLifespan", "AgentMaxLifespan"};
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

  public int getMoney() {
    return money;
  }

  public void setMoney(int i) {
    money = i;
  }

  public int getAgentMaxLifespan() {
    return agentMaxLifespan;
  }

  public int getAgentMinLifespan() {
    return agentMinLifespan;
  }

  public void setAgentMaxLifespan(int i) {
    agentMaxLifespan = i;
  }

  public void setAgentMinLifespan(int i) {
    agentMinLifespan = i;
  }

  public static void main(String[] args) {
    SimInit init = new SimInit();
    CarryDropModel model = new CarryDropModel();
    init.loadModel(model, "", false);
  }

}