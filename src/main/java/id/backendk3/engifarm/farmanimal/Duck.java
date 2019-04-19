package id.backendk3.engifarm.farmanimal;

import id.backendk3.engifarm.cell.Cell;
import id.backendk3.engifarm.product.farmproduct.DuckEgg;
import id.backendk3.engifarm.product.Product;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

/**
 * Kelas riil turunan farmanimal
 *
 * <p>Kelas untuk salah satu tipe {@link FarmAnimal}.
 * Merepresentasikan hewan bebek
 *
 * @author backendk3
 * @see FarmAnimal
 */

public class Duck extends FarmAnimal {

    /**
     * Konstruktor kelas Duck
     *
     * @param _x Lokasi X
     * @param _y Lokasi Y
     */
    public Duck(int _x, int _y) {
        super(_x, _y, 20, Cell.CellType.CoopType);
    }

    /**
     * Mengembalikan suara Duck
     *
     * @return String suara Duck
     */
    public String speak() {
        return "Quack quack..!";
    }

    /**
     * Mengembalikan produk dari Duck
     *
     * @return product berupa DuckEgg
     * @see DuckEgg
     */
    public Product getProduct() {
        Product res = new DuckEgg();
        setHaveProduct(false);
        return res;
    }

    /**
     * Mengembalikan sprite untuk Duck
     *
     * @return Gambar sprite Duck
     */
    public Image getSprite() throws IOException {
        Image image;
        if (getEatStatus()) {
            // sudah makan
            image = ImageIO.read(getClass().getClassLoader().getResource("sprites/animal/duck.png"));
        } else {
            image = ImageIO.read(getClass().getClassLoader().getResource("sprites/animal/duck-hungry.png"));
        }
        return image;
    }
}