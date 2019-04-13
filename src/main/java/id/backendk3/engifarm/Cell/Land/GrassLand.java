package id.backendk3.engifarm.Cell.Land;

public class GrassLand extends Land{
    public GrassLand(int _x,int _y){
        super(_x,_y,CellType.GrassLandType);
    }

    public String render(){
        // Green text
        String render = "\u001B[32m";
        if(haveGrass()){
            render += "#";
        }else{
            render += "-";
        }
        render += "\u001B[0m";
        return render;
    }

    // public short getFgColor(){
    //     return 1;//belum tahu
    // }
}