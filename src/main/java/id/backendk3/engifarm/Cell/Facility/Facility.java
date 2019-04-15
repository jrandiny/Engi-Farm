package id.backendk3.engifarm.Cell.Facility;

import id.backendk3.engifarm.Cell.Cell;

public abstract class Facility extends Cell{
    protected boolean usable;

    protected Facility(int _x, int _y, CellType _type){
        super(_x,_y,_type);
        occupied = true;
        usable = true;
    }

    public boolean isUsable(){
        return usable;
    }
}
