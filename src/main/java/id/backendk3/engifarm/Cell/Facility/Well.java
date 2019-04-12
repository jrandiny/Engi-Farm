package id.backendk3.engifarm.Cell.Facility;

import id.backendk3.engifarm.Cell.Facility.Facility;

public class Well extends Facility{
    public Well(int x, int y){
        super(x,y,CellType.WellType);
    }

    public String render(){
        return "W";
    }
}