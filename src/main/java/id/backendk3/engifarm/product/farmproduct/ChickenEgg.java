package id.backendk3.engifarm.product.farmproduct;

/**
 * Kelas riil ChickenEgg turunan farmproduct
 * <p>ChickenEgg adalah product yang dihasilkan oleh object animal Chicken
 *
 * @author backendk3
 * @see FarmProduct
 * @see id.backendk3.engifarm.product product
 */
public class ChickenEgg extends FarmProduct {

    /**
     * Konstruktor kelas ChickenEgg
     */
    public ChickenEgg() {
        super(ProductType.ChickenEggType, 100);
    }

    /**
     * Fungsi yang mengembalikan string untuk dirender yang merepresentasikan ChickenEgg
     *
     * @return String untuk dirender yang akan ditampilkan dan merepresentasikan ChickenEgg
     */
    public String render() {
        return "Chicken Egg";
    }
}