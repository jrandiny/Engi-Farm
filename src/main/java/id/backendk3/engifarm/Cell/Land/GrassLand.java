package id.backendk3.engifarm.Cell.Land;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Kelas riil turuan Land
 * 
 * <p>Kelas untuk salah satu tipe {@link Land}.
 * Tipe tanah ini dapat ditinggali hewan yang menghasilkan susu
 * 
 * @author backendk3
 * @see Land
 */
public class GrassLand extends Land {

    /**
     * Konstruktor kelas GrassLand
     * 
     * @param _x Lokasi X
     * @param _y Lokasi Y
     */
    public GrassLand(int _x, int _y) {
        super(_x, _y, CellType.GrassLandType);
    }

    /**
     * Mengembalikan sprite untuk GrassLand
     * 
     * @return Gambar sprite
     * @throws IOException jika gambar tidak tersedia atau tidak dapat dibuka
     */
    public Image getSprite() throws IOException {
        Image image = ImageIO.read(new File("image.png"));
        return image;
    }

    /**
     * Mengembalikan warna background untuk tile {@link Farm}
     * 
     * @return Warna background tile GrassLand
     */
    public Color getBGColor(){
        return Color.GREEN;
    }
}