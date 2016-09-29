// RabbitsGrassAgent


import java.awt.Color;

import uchicago.src.sim.gui.Drawable;
import uchicago.src.sim.gui.SimGraphics;
import uchicago.src.sim.space.Object2DGrid;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class RabbitsGrassAgent implements Drawable{
  private int x;
  private int y;
  private int vX;
  private int vY;
  private int money;
  private int stepsToLive;
  private static int IDNumber = 0;
  private int ID;
  private RabbitsGrassSpace cdSpace;

  public RabbitsGrassAgent(int minLifespan, int maxLifespan){
    x = -1;
    y = -1;
    money = 0;
    setVxVy();
    stepsToLive = 
        (int)((Math.random() * (maxLifespan - minLifespan)) + minLifespan);
    IDNumber++;
    ID = IDNumber;
  }

  private void setVxVy(){
    vX = 0;
    vY = 0;
    while((vX == 0) && ( vY == 0)){
      vX = (int)Math.floor(Math.random() * 3) - 1;
      vY = (int)Math.floor(Math.random() * 3) - 1;
    }
  }

  public void setXY(int newX, int newY){
    x = newX;
    y = newY;
  }

  public void setRabbitsGrassSpace(RabbitsGrassSpace cds){
    cdSpace = cds;
  }

  public String getID(){
    return "A-" + ID;
  }

  public int getMoney(){
    return money;
  }

  public int getStepsToLive(){
    return stepsToLive;
  }

  public void report(){
    System.out.println(getID() + 
                       " at " + 
                       x + ", " + y + 
                       " has " + 
                       getMoney() + " dollars" + 
                       " and " + 
                       getStepsToLive() + " steps to live.");
  }

  public int getX(){
    return x;
  }

  public int getY(){
    return y;
  }

  public void draw(SimGraphics G){
	BufferedImage rabbitsImg = null; 
	String rabbitIcon;
	if(stepsToLive > 10)
		rabbitIcon = "images/rabbitAlive.png";
	else
		rabbitIcon = "images/rabbitDead.jpg";
	
	try {
		rabbitsImg = ImageIO.read(new File(rabbitIcon));
	} catch (IOException e) {
		System.out.println(e);
	}
	
    G.drawImageToFit(rabbitsImg);
  }

  public void step(){
    int newX = x + vX;
    int newY = y + vY;

    Object2DGrid grid = cdSpace.getCurrentAgentSpace();
    newX = (newX + grid.getSizeX()) % grid.getSizeX();
    newY = (newY + grid.getSizeY()) % grid.getSizeY();

    if(tryMove(newX, newY)){
      money += cdSpace.takeMoneyAt(x, y);
    }
    else{
      RabbitsGrassAgent cda = cdSpace.getAgentAt(newX, newY);
      if (cda!= null){
        if(money > 0){
          cda.receiveMoney(1);
          money--;
        }
      }
      setVxVy();
    }
    stepsToLive--;
  }

  private boolean tryMove(int newX, int newY){
    return cdSpace.moveAgentAt(x, y, newX, newY);
  }

  public void receiveMoney(int amount){
    money += amount;
  }
}