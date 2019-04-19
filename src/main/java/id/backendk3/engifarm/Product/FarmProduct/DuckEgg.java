package id.backendk3.engifarm.Product.FarmProduct;

/**
 * Kelas riil DuckEgg turunan FarmProduct
 * <p>DuckEgg adalah Product yang dihasilkan oleh object animal Duck
 *
 * @author backendk3
 * @see FarmProduct
 * @see id.backendk3.engifarm.Product Product
 */
public class DuckEgg extends FarmProduct {

    /**
     * Konstruktor kelas DuckEgg
     */
    public DuckEgg() {
        super(ProductType.DuckEggType, 100);
    }

    /**
     * Fungsi yang mengembalikan string untuk dirender yang merepresentasikan DuckEgg
     *
     * @return String untuk dirender yang akan ditampilkan dan merepresentasikan DuckEgg
     */
    public String render() {
        return "Duck Egg";
    }
}