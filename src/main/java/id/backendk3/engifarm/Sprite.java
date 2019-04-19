package id.backendk3.engifarm;

import java.awt.*;
import java.io.IOException;

public interface Sprite {
    Color getBGColor();

    Image getSprite() throws IOException;
}