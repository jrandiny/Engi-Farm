package id.backendk3.engifarm.farmanimal;

import id.backendk3.engifarm.cell.Cell;
import id.backendk3.engifarm.product.farmproduct.HorseMeat;
import id.backendk3.engifarm.product.Product;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

/**
 * Kelas riil turunan farmanimal
 *
 * <p>Kelas untuk salah satu tipe {@link FarmAnimal}.
 * Merepresentasikan hewan kuda
 *
 * @author backendk3
 * @see FarmAnimal
 */

public class Horse extends FarmAnimal {

    /**
     * Konstruktor kelas Horse
     *
     * @param _x Lokasi X
     * @param _y Lokasi Y
     */
    public Horse(int _x, int _y) {
        super(_x, _y, 20, Cell.CellType.BarnType);
    }

    /**
     * Mengembalikan suara Horse
     *
     * @return String suara Horse
     */
    public String speak() {
        return "Nay nay!";
    }

    /**
     * Mengembalikan produk dari Horse
     *
     * @return product berupa HorseMeat
     * @see HorseMeat
     */
    public Product getProduct() {
        Product res = new HorseMeat();
        setHaveProduct(false);
        return res;
    }

    /**
     * Mengembalikan sprite untuk Horse
     *
     * @return Gambar sprite Horse
     */
    public Image getSprite() throws IOException {
        Image image;
        if (getEatStatus()) {
            // sudah makan
            image = ImageIO.read(getClass().getClassLoader().getResource("sprites/animal/horse.png"));
        } else {
            image = ImageIO.read(getClass().getClassLoader().getResource("sprites/animal/horse-hungry.png"));
        }
        return image;
    }
}