package id.backendk3.engifarm.Cell.Land;

import java.awt.Color;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Kelas riil turuan Land
 * 
 * <p>Kelas untuk salah satu tipe {@link Land}.
 * Tipe tanah ini dapat ditinggali hewan yang menghasilkan telur
 * 
 * @author backendk3
 * @see Land
 */
public class Coop extends Land{

    /**
     * Konstruktor kelas Coop
     * 
     * @param _x Lokasi X
     * @param _y Lokasi Y
     */
    public Coop(int _x,int _y){
        super(_x,_y,CellType.CoopType);
    }

    /**
     * Mengembalikan sprite untuk Coop
     * 
     * @return Gambar sprite
     * @throws IOException jika gambar tidak tersedia atau tidak dapat dibuka
     */
    public Image getSprite() throws IOException {
        Image image = ImageIO.read(getClass().getClassLoader().getResource("sprites/test.png"));
        return image;
    }

    /**
     * Mengembalikan warna background untuk tile {@link id.backendk3.engifarm.Farm}
     * 
     * @return Warna background tile Coop
     */
    public Color getBGColor(){
        return Color.YELLOW;
    }
}