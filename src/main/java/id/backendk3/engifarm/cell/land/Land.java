package id.backendk3.engifarm.cell.land;

import id.backendk3.engifarm.cell.Cell;

/**
 * Kelas abstrak turunan cell
 *
 * <p>Kelas ini merepresentasikan cell yang bertipe tanah.
 * Tanah secara <i>default</i> dapat dijalani kecuali di-<i>occupy</i>
 *
 * @author backendk3
 * @see Cell
 * @see Coop
 * @see GrassLand
 * @see Barn
 */
public abstract class Land extends Cell {
    private final int timeToDry;
    private boolean grass;

    /**
     * Konstruktor kelas land
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

    /**
     * Method overide callback yang berisi perintah jika waktu dari timer objek habis
     */
    @Override
    protected void callback() {
        removeGrass();
    }

    /**
     * Menempati sebuah land
     *
     * <p>Membuat sebuah land jadi <i>occupied</i>. Jika land sudah
     * ter-<i>occupied</i>, tidak akan terjadi apa-apa
     */
    public void occupy() {
        occupied = true;
    }

    /**
     * Tidak menempati lagi sebuah land
     *
     * <p>Membuat sebuah land jadi tidak <i>occupied</i>. Jika land sudah
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