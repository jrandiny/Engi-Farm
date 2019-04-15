package id.backendk3.engifarm.Cell.Land;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import id.backendk3.engifarm.App;

public class Coop extends Land{
    public Coop(int _x,int _y){
        super(_x,_y,CellType.CoopType);
    }

    public Image getSprite() throws IOException {
        Image image = ImageIO.read(getClass().getClassLoader().getResource("sprites/test.png"));
        return image;
    }

    public Color getBGColor(){
        return Color.YELLOW;
    }
}