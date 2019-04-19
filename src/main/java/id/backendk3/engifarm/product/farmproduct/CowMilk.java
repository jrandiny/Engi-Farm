package id.backendk3.engifarm.product.farmproduct;

/**
 * Kelas riil CowMilk turunan farmproduct
 * <p>CowMilk adalah product yang dihasilkan oleh object animal Cow yang terletak pada GrassLand
 *
 * @author backendk3
 * @see FarmProduct
 * @see id.backendk3.engifarm.product product
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