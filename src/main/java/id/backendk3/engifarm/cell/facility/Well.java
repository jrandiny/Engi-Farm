package id.backendk3.engifarm.cell.facility;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

/**
 * Kelas riil turuan facility
 *
 * <p>Kelas untuk salah satu tipe {@link id.backendk3.engifarm.cell.facility facility}.
 * Tipe fasiltas ini berguna untuk {@link id.backendk3.engifarm.Player} mengambil air.
 *
 * @author backendk3
 * @see Facility
 */
public class Well extends Facility {
    /**
     * Konstuktor kelas Well
     *
     * @param x Lokasi x
     * @param y Lokasi y
     */
    public Well(int x, int y) {
        super(x, y, CellType.WellType);
    }

    /**
     * Mengembalikan sprite untuk Well
     *
     * @return Gambar sprite
     * @throws IOException jika gambar tidak tersedia atau tidak dapat dibuka
     */
    public Image getSprite() throws IOException {
        return ImageIO.read(getClass().getClassLoader().getResource("sprites/facility/well.png"));
    }

    /**
     * Mengembalikan warna background untuk tile {@link id.backendk3.engifarm.Farm}
     *
     * @return Warna background tile Well
     */
    public Color getBGColor() {
        return Color.WHITE;
    }
}