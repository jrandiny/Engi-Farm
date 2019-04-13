package id.backendk3.engifarm.Cell.Facility;

import id.backendk3.engifarm.Cell.Facility.Facility;

public class Truck extends Facility{
    public Truck(int x, int y){
        super(x,y,CellType.TruckType);
        usable = true;
    }

    public String render(){
        // black text
        // white back
        return "\u001B[30m" + "\u001B[47m" + "T" +"\u001B[0m";
    }

    public void use(int time){
        usable = false;
        //setAndActivate(time);
    }
}