package id.backendk3.engifarm;

import java.awt.*;
import java.io.IOException;

/**
 * Interface Sprite
 * 
 * <p>Interface ini merepresentasikan gambar tampilan yang akan dimunculkan kelayar
 */
public interface Sprite {
    /**
     * Method yang mengembalikan warna background untuk tile {@link id.backendk3.engifarm.Farm}
     * @return warna background tile dengan tipe tertentu
     */
    Color getBGColor();

    /**
     * Method yang mengembalikan sprite untuk tile dengan tipe tertentu
     * @return Gambar sprite untuk tile dengan tipe tertentu
     * @throws IOException jika gambar tidak tersedia atau tidak dapat dibuka
     */
    Image getSprite() throws IOException;
}