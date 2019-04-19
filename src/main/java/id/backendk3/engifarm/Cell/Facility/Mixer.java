package id.backendk3.engifarm.Cell.Facility;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

/**
 * Kelas riil turuan Facility
 *
 * <p>Kelas untuk salah satu tipe {@link id.backendk3.engifarm.Cell.Facility Facility}.
 * Tipe fasiltas ini berguna untuk mencampurkan bahan-bahan
 * untuk menghasilkan suatu {@link id.backendk3.engifarm.Product.SideProduct}
 *
 * @author backendk3
 * @see Facility
 */
public class Mixer extends Facility {
    /**
     * Konstuktor kelas Mixer
     *
     * @param x Lokasi x
     * @param y Lokasi y
     */
    public Mixer(int x, int y) {
        super(x, y, CellType.MixerType);
    }

    /**
     * Mengembalikan sprite untuk Mixer
     *
     * @return Gambar sprite
     * @throws IOException jika gambar tidak tersedia atau tidak dapat dibuka
     */
    public Image getSprite() throws IOException {
        Image image = ImageIO.read(getClass().getClassLoader().getResource("sprites/facility/mixer.png"));
        return image;
    }

    /**
     * Mengembalikan warna background untuk tile {@link id.backendk3.engifarm.Farm}
     *
     * @return Warna background tile Mixer
     */
    public Color getBGColor() {
        return Color.WHITE;
    }
}