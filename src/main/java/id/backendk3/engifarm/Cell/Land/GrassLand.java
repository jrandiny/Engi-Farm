package id.backendk3.engifarm.Cell.Land;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GrassLand extends Land {
    public GrassLand(int _x, int _y) {
        super(_x, _y, CellType.GrassLandType);
    }

    public Image getSprite() throws IOException {
        Image image = ImageIO.read(new File("image.png"));
        return image;
    }

    public Color getBGColor(){
        return Color.GREEN;
    }
}