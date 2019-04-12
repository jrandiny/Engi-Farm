package id.backendk3.engifarm.Cell.Land;

public class Coop extends Land{
    public Coop(int _x,int _y){
        super(_x,_y,CellType.CoopType);
    }

    public String render(){
        if(haveGrass()){
            return "*";
        }else{
            return "o";
        }
    }

    // public short getFgColor(){
    //     return 1;//belum tahu
    // }
}