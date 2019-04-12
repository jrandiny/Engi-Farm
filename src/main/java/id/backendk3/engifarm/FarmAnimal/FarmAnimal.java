package id.backendk3.engifarm.FarmAnimal;

import java.util.Arrays;
import id.backendk3.engifarm.Product.Product;
import id.backendk3.engifarm.Cell.Cell;
import id.backendk3.engifarm.Cell.Land.*;
import id.backendk3.engifarm.Farm;

public abstract class FarmAnimal{
    protected final int timeToHungry;
    protected final int timeToDeath=5;
    protected int posX;
    protected int posY;
    protected boolean eatStatus;
    protected boolean deathStatus;
    protected Cell.CellType habitat;
    protected boolean haveProduct;

    public FarmAnimal(int x,int y,int time, Cell.CellType _type){
        posX=x;
        posY=y;
        habitat=_type;
        timeToHungry=time;
    }
    public void moveRandom(Cell[] surr){
        boolean found = false;
        Farm.MoveType way = null;
        boolean[] movement = {false,false,false,false};
        while(!found && Arrays.asList(movement).contains(false)){
            way = Farm.MoveType.values()[(int)(Math.random()*3)];
            if(surr[way.getValue()]!=null && !movement[way.getValue()]){
                if(!surr[way.getValue()].isOccupied() && surr[way.getValue()].getType()==habitat){
                    found=true;
                }else{
                    movement[way.getValue()]=true;    
                }
            }else{
                movement[way.getValue()]=true;
            }
        }

        Land now=(Land)surr[Farm.MoveType.Center.getValue()];

        if(found){
            now.unoccupy();
            ((Land)surr[way.getValue()]).occupy();
            switch(way){
                case Up:
                    posY--;
                    break;
                case Right:
                    posX++;
                    break;
                case Down:
                    posY++;
                    break;
                case Left:
                    posX--;
                    break;
                default:
                    break;
            }
        }
        
        if(!eatStatus && now.haveGrass()){
            setEatStatus(true);
            haveProduct = true;
            now.removeGrass();
        }
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

    public Cell.CellType getHabitat(){
        return habitat;
    }
    public boolean getHaveProduct(){
        return haveProduct;
    }

}