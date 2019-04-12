package id.backendk3.engifarm.Cell.Land;

import id.backendk3.engifarm.Cell.Cell;

public abstract class Land extends Cell{
    private boolean grass;

    public Land(int _x, int _y, CellType _type){
        super(_x,_y,_type);
        grass = true;
        occupied = false;
    }

    public void occupy(){
        occupied = true;
    }

    public void unoccupy(){
        occupied = false;
    }

    public boolean haveGrass(){
        return grass;
    }

    public void removeGrass(){
        grass = false;
    }

    public void addGrass(){
        grass = true;
    }


}