package id.backendk3.engifarm.farmanimal;

import id.backendk3.engifarm.cell.Cell;
import id.backendk3.engifarm.cell.land.Land;
import id.backendk3.engifarm.Farm;
import id.backendk3.engifarm.product.Product;
import id.backendk3.engifarm.Sprite;
import id.backendk3.engifarm.TimerObj;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Kelas abstrak farmanimal turunan TimerObj
 *
 * <p>Kelas merepresantasikan hewan tertentu.
 *
 * @author backendk3
 * @see Chicken
 * @see Cow
 * @see Duck
 * @see Goat
 * @see Horse
 * @see Rabbit
 */

public abstract class FarmAnimal extends TimerObj implements Sprite {
    /**
     * Waktu hewan hingga lapar
     */
    protected final int TIME_TO_HUNGRY;
    /**
     * Waktu hewan hingga mati
     */
    protected final int TIME_TO_DEATH = 10;
    /**
     * Lokasi X
     */
    protected int posX;
    /**
     * Lokasi Y
     */
    protected int posY;
    /**
     * Status apakah hewan sudah makan atau belum
     */
    protected boolean eatStatus;
    /**
     * Status apakah hewan sudah mati atau belum
     */
    protected boolean deathStatus;
    /**
     * Tipe habitat dari hewan
     */
    protected Cell.CellType habitat;
    /**
     * Status apakah hewan sudah punya produk atau belum
     */
    protected boolean haveProduct;

    /**
     * Konstruktor kelas farmanimal
     *
     * @param x     Lokasi X
     * @param y     Lokasi Y
     * @param time  Waktu lapar hewan
     * @param _type Tipe habitat
     */
    public FarmAnimal(int x, int y, int time, Cell.CellType _type) {
        posX = x;
        posY = y;
        habitat = _type;
        TIME_TO_HUNGRY = time;
        setEatStatus(true);
        setDeathStatus(false);
    }

    /**
     * <p>Membuat hewan bergerak secara random ke sekitarnya.
     * Jika lapar dan bergerak ke tempat yang ada rumputnya,
     * hewan akan memakan rumput
     *
     * @param surr cell di sekitar hewan (atas, kanan, bawah, kiri, tengah)
     */
    public void moveRandom(Cell[] surr) {
        boolean found = false;
        int i = 0;
        Farm.MoveType way = null;
        ArrayList<Farm.MoveType> movement = new ArrayList<>(
                Arrays.asList(
                        Farm.MoveType.Up,
                        Farm.MoveType.Right,
                        Farm.MoveType.Down,
                        Farm.MoveType.Left));
        Collections.shuffle(movement);
        while (!found && i < movement.size()) {
            way = movement.get(i);
            if (surr[way.getValue()] != null) {
                if (!surr[way.getValue()].isOccupied() && surr[way.getValue()].getType() == habitat) {
                    found = true;
                } else {
                    i++;
                }
            } else {
                i++;
            }
        }

        Land now = (Land) surr[Farm.MoveType.Center.getValue()];

        if (found) {
            now.unoccupy();
            ((Land) surr[way.getValue()]).occupy();
            switch (way) {
                case Up:
                    posY--;
                    break;
                case Right:
                    posX++;
                    break;
                case Down:
                    posY++;
                    break;
                case Left:
                    posX--;
                    break;
                default:
                    break;
            }
        }

        if (!eatStatus && now.haveGrass()) {
            setEatStatus(true);
            now.removeGrass();
        }
    }

    /**
     * Fungsi abstrak yang akan diimplementasikan hewan tertentu
     * untuk mendapatkan produk hewan tersebut
     *
     * @return product hewan tertentu
     */
    public abstract Product getProduct();

    /**
     * Fungsi abstrak yang akan diimplementasikan hewan tertentu
     * untuk mendapatkan suara hewan tersebut
     *
     * @return String suara hewan tertentu
     */
    public abstract String speak();

    /**
     * Setter status makan dari hewan
     *
     * @param status Status makan
     */
    public void setEatStatus(boolean status) {
        eatStatus = status;
        haveProduct = true;
        if (eatStatus) {
            setTimer(TIME_TO_HUNGRY);
            setTimerActive(true);
        } else {
            setTimer(TIME_TO_DEATH);
            setTimerActive(true);
        }
    }

    /**
     * Setter status kematian dari hewan
     *
     * @param status Status kematian
     */
    public void setDeathStatus(boolean status) {
        deathStatus = status;
        if (deathStatus) {
            setTimerActive(false);
        } else {
            setEatStatus(true);
        }
    }

    /**
     * Getter status makan dari hewan
     *
     * @return Boolean status makan hewan
     */
    public boolean getEatStatus() {
        return eatStatus;
    }

    /**
     * Getter status kematian dari hewan
     *
     * @return Boolean status kematian hewan
     */
    public boolean getDeathStatus() {
        return deathStatus;
    }

    /**
     * Menyatakan hewan dalam kondisi lapar jika timer objek hewan dengan waktu kelaparan sudah habis
     * <p>Menyatakan hewan dalam kondisi mati jika timer objek hewan dengan waktu kematian sudah habis
     */
    public void callback() {
        if (eatStatus) {
            setEatStatus(false);
        } else {
            setDeathStatus(true);
        }
    }

    /**
     * Mengembalikan lokasi X
     *
     * @return Lokasi X
     */
    public int getX() {
        return posX;
    }

    /**
     * Mengembalikan lokasi Y
     *
     * @return Lokasi Y
     */
    public int getY() {
        return posY;
    }

    /**
     * Mengembalikan tipe habitat hewan
     *
     * @return CellType habitat hewan
     */
    public Cell.CellType getHabitat() {
        return habitat;
    }

    /**
     * Getter status produk dari hewan
     *
     * @return Boolean status produk hewan
     */
    public boolean getHaveProduct() {
        return haveProduct;
    }

    /**
     * Setter status produk dari hewan
     *
     * @param flag Status produk hewan
     */
    public void setHaveProduct(boolean flag) {
        this.haveProduct = flag;
    }

    /**
     * Mengembalikan warna background untuk farmanimal
     *
     * @return null karena mengikuti BG land yang ada
     */
    public Color getBGColor() {
        // return Color.BLACK;
        return null;
    }

    /**
     * Mengembalikan sprite untuk farmanimal
     *
     * @return Gambar sprite tergantung kelas turunannya
     */
    public abstract Image getSprite() throws IOException;
}