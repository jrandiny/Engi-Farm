package id.backendk3.engifarm.FarmAnimal;

import id.backendk3.engifarm.Product.Product;
import id.backendk3.engifarm.Cell.Cell;
import java.util.ArrayList;

public abstract class FarmAnimal{
    protected final int timeToHungry;
    protected final int timeToDeath=5;
    protected int posX;
    protected int posY;
    protected boolean eatStatus;
    protected boolean deathStatus;
    protected Cell.CellType habitat;

    public FarmAnimal(int x,int y,int time, Cell.CellType _type){
        posX=x;
        posY=y;
        habitat=_type;
        timeToHungry=time;
    }
    public void moveRandom(ArrayList<Cell> surr){
        boolean found;
        
    }
    public abstract Product getProduct();
    public abstract String speak();
    public void setEatStatus(boolean status){
        eatStatus=status;
    }
    public void setDeathStatus(boolean status){
        deathStatus=status;
    }
    public boolean getEatStatus(){
        return eatStatus;
    }
    public boolean getDeathStatus(){
        return deathStatus;
    }
    // public void callback();
    public int getX(){
        return posX;
    }
    public int getY(){
        return posY;
    }
    // public short  

    public Cell.CellType getHabitat(){
        return habitat;
    }

}