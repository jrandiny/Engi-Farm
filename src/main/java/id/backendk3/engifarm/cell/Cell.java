package id.backendk3.engifarm.cell;

import id.backendk3.engifarm.Sprite;
import id.backendk3.engifarm.TimerObj;

/**
 * Kelas abstrak cell turunan TimerObj
 *
 * <p>Kelas ini merepresentasikan cell yaitu sebuah kotak pada peta.
 * cell dapat berupa tanah atau fasilitas yang direpresentasikan dengan kelas
 * {@link id.backendk3.engifarm.cell.land land} dan {@link id.backendk3.engifarm.cell.facility facility}.
 *
 * @author backendk3
 * @see id.backendk3.engifarm.cell.facility facility
 * @see id.backendk3.engifarm.cell.land land
 */
public abstract class Cell extends TimerObj implements Comparable<Cell>, Sprite {
    /**
     * Tipe-tipe cell yang mungkin
     */
    public enum CellType {
        /**
         * Tipe {@link id.backendk3.engifarm.cell.facility.Mixer}
         */
        MixerType,
        /**
         * Tipe {@link id.backendk3.engifarm.cell.facility.Truck}
         */
        TruckType,
        /**
         * Tipe {@link id.backendk3.engifarm.cell.facility.Well}
         */
        WellType,
        /**
         * Tipe {@link id.backendk3.engifarm.cell.land.Barn}
         */
        BarnType,
        /**
         * Tipe {@link id.backendk3.engifarm.cell.land.Coop}
         */
        CoopType,
        /**
         * Tipe {@link id.backendk3.engifarm.cell.land.GrassLand}
         */
        GrassLandType
    }

    /**
     * Lokasi X
     */
    private final int X;
    /**
     * Lokasi Y
     */
    private final int Y;
    /**
     * Tipe cell
     */
    private final CellType TYPE;
    /**
     * Apakah cell terisi
     *
     * <p>Akan bernilai true jika terisi.
     * Jika terisi maka artinya tidak dapat dilewati, karena
     * satu cell hanya boleh diisi satu objek
     */
    protected boolean occupied;

    /**
     * Konstruktor kelas cell
     *
     * @param _x    Lokasi X
     * @param _y    Lokasi Y
     * @param _type Tipe cell
     */
    protected Cell(int _x, int _y, CellType _type) {
        X = _x;
        Y = _y;
        TYPE = _type;
    }

    /**
     * Mengecek apakah sebuah cell terisi
     *
     * @return True jika terisi
     */
    public boolean isOccupied() {
        return occupied;
    }

    /**
     * Mengembalikan Tipe cell
     *
     * @return Tipe cell
     */
    public CellType getType() {
        return TYPE;
    }

    /**
     * Mengembalikan lokasi X
     *
     * @return Lokasi X
     */
    public int getX() {
        return X;
    }

    /**
     * Mengembalikan lokasi Y
     *
     * @return Lokasi Y
     */
    public int getY() {
        return Y;
    }

    /**
     * Membandingkan suatu cell dengan cell lain
     *
     * @param otherCell cell untuk dibandingkan
     * @return 1 jika sama
     */
    @Override
    public int compareTo(Cell otherCell) {
        if (TYPE == otherCell.TYPE) {
            return 1;
        } else {
            return 0;
        }
    }
}