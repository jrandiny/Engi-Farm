package id.backendk3.engifarm.Cell.Facility;

import id.backendk3.engifarm.Cell.Facility.Facility;

public class Well extends Facility{
    public Well(int x, int y){
        super(x,y,CellType.WellType);
    }

    public String render(){
        // black text
        // white back
        return "\u001B[30m" + "\u001B[47m" + "W" +"\u001B[0m";
    }
}