package id.backendk3.engifarm.Cell;

public abstract class Cell implements Comparable<Cell>{
    public enum CellType{
        MixerType,TruckType,WellType,BarnType,CoopType,GrassLandType
    }

    protected final int x;
    protected final int y;
    protected final CellType type; 
    protected boolean occupied;

    public Cell(int _x,int _y,CellType _type){
        x=_x;
        y=_y;
        type=_type;
    }

    public void setOccupied(boolean _occupied){
        occupied=_occupied;
    }

    public boolean isOccupied(){
        return occupied;
    }

    public CellType getType(){
        return type;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    @Override
    public int compareTo(Cell otherCell){
        if(type==otherCell.type){
            return 1;
        }else{
            return 0;
        }
    }
}