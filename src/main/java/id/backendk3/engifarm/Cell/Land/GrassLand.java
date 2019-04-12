package id.backendk3.engifarm.Cell.Land;

public class GrassLand extends Land{
    public GrassLand(int _x,int _y){
        super(_x,_y,CellType.GrassLandType);
    }

    public String render(){
        if(haveGrass()){
            return "#";
        }else{
            return "-";
        }
    }

    // public short getFgColor(){
    //     return 1;//belum tahu
    // }
}