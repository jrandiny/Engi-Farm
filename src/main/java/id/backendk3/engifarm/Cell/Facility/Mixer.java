package id.backendk3.engifarm.Cell.Facility;

import id.backendk3.engifarm.Cell.Facility.Facility;

public class Mixer extends Facility{
    public Mixer(int x, int y){
        super(x,y,CellType.MixerType);
    }

    public String render(){
        // black text
        // white back
        return "\u001B[30m" + "\u001B[47m" + "M" +"\u001B[0m";
    }
}