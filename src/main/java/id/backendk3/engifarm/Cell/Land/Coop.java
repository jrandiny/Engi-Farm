package id.backendk3.engifarm.Cell.Land;

public class Coop extends Land{
    public Coop(int _x,int _y){
        super(_x,_y,CellType.CoopType);
    }

    public String render(){
        // yellow text
        String render = "\u001B[33m";
        if(haveGrass()){
            render += "*";
        }else{
            render += "o";
        }
        render += "\u001B[0m";
        return render;
    }

    // public short getFgColor(){
    //     return 1;//belum tahu
    // }
}