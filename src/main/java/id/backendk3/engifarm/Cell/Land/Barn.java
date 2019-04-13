package id.backendk3.engifarm.Cell.Land;

public class Barn extends Land{
    public Barn(int _x,int _y){
        super(_x,_y,CellType.BarnType);
    }

    public String render(){
        // Red text
        String render = "\u001B[31m";
        if(haveGrass()){
            render += "@";
        }else{
            render += "x";
        }
        render += "\u001B[0m";
        return render;
    }

    // public short getFgColor(){
    //     return 1;//belum tahu
    // }
}