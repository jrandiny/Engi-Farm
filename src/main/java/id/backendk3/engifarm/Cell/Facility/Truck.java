package id.backendk3.engifarm.Cell.Facility;

import id.backendk3.engifarm.Cell.Facility.Facility;

public class Truck extends Facility{
    public Truck(int x, int y){
        super(x,y,CellType.TruckType);
    }

    public String render(){
        return "T";
    }

    public void use(int time){
        usable = false;
        //setAndActivate(time);
    }
}