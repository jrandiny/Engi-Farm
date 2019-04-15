package id.backendk3.engifarm.Cell.Facility;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import id.backendk3.engifarm.Cell.Facility.Facility;

public class Truck extends Facility{
    public Truck(int x, int y){
        super(x,y,CellType.TruckType);
        usable = true;
    }

    public Image getSprite() throws IOException{
        Image image = ImageIO.read(new File("image.png"));
        return image;
    }
    
    public Color getBGColor(){
        return Color.WHITE;
    }

    public void use(int time){
        usable = false;
        //setAndActivate(time);
    }
}