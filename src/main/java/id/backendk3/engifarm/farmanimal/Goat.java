package id.backendk3.engifarm.farmanimal;

import id.backendk3.engifarm.cell.Cell;
import id.backendk3.engifarm.product.farmproduct.GoatMeat;
import id.backendk3.engifarm.product.farmproduct.GoatMilk;
import id.backendk3.engifarm.product.Product;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

/**
 * Kelas riil turunan farmanimal
 *
 * <p>Kelas untuk salah satu tipe {@link FarmAnimal}.
 * Merepresentasikan hewan kambing
 *
 * @author backendk3
 * @see FarmAnimal
 */

public class Goat extends FarmAnimal {

    /**
     * Konstruktor kelas Goat
     *
     * @param _x Lokasi X
     * @param _y Lokasi Y
     */
    public Goat(int _x, int _y, Cell.CellType _type) {
        super(_x, _y, 20, _type);
    }

    /**
     * Mengembalikan suara Goat
     *
     * @return String suara Goat
     */
    public String speak() {
        return "Blet blet..!";
    }

    /**
     * Mengembalikan produk dari Goat tergantung habitat
     *
     * @return product berupa GoatMeat jika habitatnya Barn, GoatMilk jika habitatnya GrassLand
     * @see GoatMeat
     * @see GoatMilk
     */
    public Product getProduct() {
        Product res;
        if (habitat == Cell.CellType.BarnType) {
            res = new GoatMeat();
        } else if (habitat == Cell.CellType.GrassLandType) {
            res = new GoatMilk();
        } else {
            throw new RuntimeException("Error no matching habitat type");
        }
        setHaveProduct(false);
        return res;
    }

    /**
     * Mengembalikan sprite untuk Goat
     *
     * @return Gambar sprite Goat
     */
    public Image getSprite() throws IOException {
        Image image;
        if (getEatStatus()) {
            // sudah makan
            image = ImageIO.read(getClass().getClassLoader().getResource("sprites/animal/goat.png"));
        } else {
            image = ImageIO.read(getClass().getClassLoader().getResource("sprites/animal/goat-hungry.png"));
        }
        return image;
    }
}