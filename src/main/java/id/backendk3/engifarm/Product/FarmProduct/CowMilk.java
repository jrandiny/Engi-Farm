package id.backendk3.engifarm.Product.FarmProduct;

/**
 * Kelas riil CowMilk turunan FarmProduct
 * <p>CowMilk adalah Product yang dihasilkan oleh object animal Cow yang terletak pada GrassLand
 *
 * @author backendk3
 * @see FarmProduct
 * @see id.backendk3.engifarm.Product Product
 */
public class CowMilk extends FarmProduct {

    /**
     * Konstruktor kelas CowMilk
     */
    public CowMilk() {
        super(ProductType.CowMilkType, 100);
    }

    /**
     * Fungsi yang mengembalikan string untuk dirender yang merepresentasikan CowMilk
     *
     * @return String untuk dirender yang akan ditampilkan dan merepresentasikan CowMilk
     */
    public String render() {
        return "Cow Milk";
    }
}