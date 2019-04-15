package id.backendk3.engifarm.Cell;

import id.backendk3.engifarm.Sprite;

public abstract class Cell implements Comparable<Cell>, Sprite{
    public enum CellType{
        MixerType,TruckType,WellType,BarnType,CoopType,GrassLandType
    }

    protected final int X;
    protected final int Y;
    protected final CellType TYPE; 
    protected boolean occupied;

    public Cell(int _x,int _y,CellType _type){
        X=_x;
        Y=_y;
        TYPE=_type;
    }

    public boolean isOccupied(){
        return occupied;
    }

    public CellType getType(){
        return TYPE;
    }

    public int getX(){
        return X;
    }

    public int getY(){
        return Y;
    }

    @Override
    public int compareTo(Cell otherCell){
        if(TYPE==otherCell.TYPE){
            return 1;
        }else{
            return 0;
        }
    }
}