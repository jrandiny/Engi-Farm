package id.backendk3.engifarm.cell.land;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

/**
 * Kelas riil turuan land
 *
 * <p>Kelas untuk salah satu tipe {@link Land}.
 * Tipe tanah ini dapat ditinggali hewan yang menghasilkan daging
 *
 * @author backendk3
 * @see Land
 */
public class Barn extends Land {
    /**
     * Konstruktor kelas Barn
     *
     * @param _x Lokasi X
     * @param _y Lokasi Y
     */
    public Barn(int _x, int _y) {
        super(_x, _y, CellType.BarnType);
    }

    /**
     * Mengembalikan sprite untuk Barn
     *
     * @return Gambar sprite
     * @throws IOException jika gambar tidak tersedia atau tidak dapat dibuka
     */
    public Image getSprite() throws IOException {
        if (haveGrass()) {
            Image image = ImageIO.read(getClass().getClassLoader().getResource("sprites/grass.png"));
            return image;
        } else {
            return null;
        }
    }

    /**
     * Mengembalikan warna background untuk tile {@link id.backendk3.engifarm.Farm}
     *
     * @return Warna background tile Barn
     */
    public Color getBGColor() {
        return Color.RED;
    }
}