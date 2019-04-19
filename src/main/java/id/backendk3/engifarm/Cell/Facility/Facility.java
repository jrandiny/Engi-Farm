package id.backendk3.engifarm.Cell.Facility;

import id.backendk3.engifarm.Cell.Cell;

/**
 * Kelas abstrak Facility turunan Cell
 *
 * <p>Kelas ini merepresentasikan Cell yang bertipe fasilitas.
 * Karena berupa fasilitas, fasilitas akan selalu ter-<i>occupied</i>
 * Fasilitas secara <i>default</i> dapat digunakan (<i>usable</i>), tetapi
 * bisa juga tidak dapat digunakan
 *
 * @author backendk3
 * @see Cell
 * @see Mixer
 * @see Truck
 * @see Well
 */
public abstract class Facility extends Cell {
    /**
     * Apakah suatu fasilitas dapat digunakan
     *
     * <p>Akan bernilai true jika bisa digunakan
     */
    protected boolean usable;

    /**
     * Konstuktor kelas Facility
     *
     * @param _x    Lokasi X
     * @param _y    Lokasi Y
     * @param _type Tipe fasilitas
     */
    protected Facility(int _x, int _y, CellType _type) {
        super(_x, _y, _type);
        occupied = true;
        usable = true;
    }

    /**
     * Mengecek apakah sebuah fasilitas dapat digunakan
     *
     * @return true jika dapat digunakan
     */
    public boolean isUsable() {
        return usable;
    }
}
