package id.backendk3.engifarm.Cell.Facility;

import id.backendk3.engifarm.Cell.Facility.Facility;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Mixer extends Facility{
    public Mixer(int x, int y){
        super(x,y,CellType.MixerType);
    }

    public Image getSprite() throws IOException {
        Image image = ImageIO.read(new File("image.png"));
        return image;
    }

    public Color getBGColor(){
        return Color.WHITE;
    }
}