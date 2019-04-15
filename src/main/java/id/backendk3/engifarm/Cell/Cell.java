package id.backendk3.engifarm.Cell;

public abstract class Cell implements Comparable<Cell>{
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

    // public void setOccupied(boolean _occupied){
    //     occupied=_occupied;
    // }

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

    public abstract String render();

    @Override
    public int compareTo(Cell otherCell){
        if(TYPE==otherCell.TYPE){
            return 1;
        }else{
            return 0;
        }
    }
}