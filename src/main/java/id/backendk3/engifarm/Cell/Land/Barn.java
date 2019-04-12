package id.backendk3.engifarm.Cell.Land;

public class Barn extends Land{
    public Barn(int _x,int _y){
        super(_x,_y,CellType.BarnType);
    }

    public String render(){
        if(haveGrass()){
            return "@";
        }else{
            return "x";
        }
    }

    // public short getFgColor(){
    //     return 1;//belum tahu
    // }
}