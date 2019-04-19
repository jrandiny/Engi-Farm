package id.backendk3.engifarm;

import java.awt.*;
import java.io.IOException;

public interface Sprite{
    public Color getBGColor();
    public Image getSprite() throws IOException;
}