package id.backendk3.engifarm.Cell.Facility;

import java.awt.Color;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;
import id.backendk3.engifarm.Cell.Facility.Facility;

/**
 * Kelas riil turuan Facility
 * 
 * <p>Kelas untuk salah satu tipe {@link id.backendk3.engifarm.Cell.Facility Facility}.
 * Tipe fasiltas ini berguna untuk {@link id.backendk3.engifarm.Player} mengambil air.
 * 
 * @author backendk3
 * @see Facility
 */
public class Well extends Facility{
    /**
     * Konstuktor kelas Well
     * 
     * @param x Lokasi x
     * @param y Lokasi y
     */
    public Well(int x, int y){
        super(x,y,CellType.WellType);
    }

    /**
     * Mengembalikan sprite untuk Well
     * 
     * @return Gambar sprite
     * @throws IOException jika gambar tidak tersedia atau tidak dapat dibuka
     */
    public Image getSprite() throws IOException{
        Image image = ImageIO.read(getClass().getClassLoader().getResource("sprites/facility/well.png"));
        return image;
    }

    /**
     * Mengembalikan warna background untuk tile {@link id.backendk3.engifarm.Farm}
     * 
     * @return Warna background tile Well
     */
    public Color getBGColor(){
        return Color.WHITE;
    }
}