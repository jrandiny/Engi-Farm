package id.backendk3.engifarm.Cell.Land;

import id.backendk3.engifarm.Cell.Cell;

/**
 * Kelas abstrak turunan Cell
 *
 * <p>Kelas ini merepresentasikan Cell yang bertipe tanah.
 * Tanah secara <i>default</i> dapat dijalani kecuali di-<i>occupy</i>
 *
 * @author backendk3
 * @see Cell
 * @see Coop
 * @see GrassLand
 * @see Barn
 */
public abstract class Land extends Cell {
    private int timeToDry;
    private boolean grass;

    /**
     * Konstruktor kelas Land
     *
     * @param _x    Lokasi X
     * @param _y    Lokasi Y
     * @param _type Tipe tanah
     */
    public Land(int _x, int _y, CellType _type) {
        super(_x, _y, _type);
        grass = true;
        occupied = false;
        timeToDry = (int) (Math.random() * 120 + 20);
        setTimer(timeToDry);
        setTimerActive(true);
    }

    @Override
    public void callback() {
        removeGrass();
    }

    /**
     * Menempati sebuah Land
     *
     * <p>Membuat sebuah Land jadi <i>occupied</i>. Jika Land sudah
     * ter-<i>occupied</i>, tidak akan terjadi apa-apa
     */
    public void occupy() {
        occupied = true;
    }

    /**
     * Tidak menempati lagi sebuah Land
     *
     * <p>Membuat sebuah Land jadi tidak <i>occupied</i>. Jika Land sudah
     * tidak ter-<i>occupied</i>, tidak akan terjadi apa-apa
     */
    public void unoccupy() {
        occupied = false;
    }

    /**
     * Mengecek apakah tanah mempunyai rumput
     *
     * @return true jika tanah memiliki rumput
     */
    public boolean haveGrass() {
        return grass;
    }

    /**
     * Menghilangkan rumput pada tanah jika ada.
     * Jika tidak ada rumput, tidak terjadi apa-apa
     */
    public void removeGrass() {
        grass = false;
        setTimerActive(false);
    }

    /**
     * Menumbuhkan rumput pada tanah jika ada.
     * Jika sudah ada rumput, tidak terjadi apa-apa
     */
    public void addGrass() {
        grass = true;
        setTimer(timeToDry);
        setTimerActive(true);
    }


}