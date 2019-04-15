package id.backendk3.engifarm;

import java.awt.Color;
import java.awt.Image;
import java.io.IOException;

public interface Sprite{
    public Color getBGColor();
    public Image getSprite() throws IOException;
}