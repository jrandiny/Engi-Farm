package id.backendk3.engifarm.Cell.Facility;

import id.backendk3.engifarm.Cell.Facility.Facility;

public class Mixer extends Facility{
    public Mixer(int x, int y){
        super(x,y,CellType.MixerType);
    }

    public String render(){
        return "M";
    }
}