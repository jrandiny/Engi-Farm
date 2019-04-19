package id.backendk3.engifarm.product.farmproduct;

/**
 * Kelas riil GoatMilk turunan farmproduct
 * <p>GoatMilk adalah product yang dihasilkan oleh object animal Goat yang terletak pada GrassLand
 *
 * @author backendk3
 * @see FarmProduct
 * @see id.backendk3.engifarm.product product
 */
public class GoatMilk extends FarmProduct {

    /**
     * Konstruktor kelas GoatMilk
     */
    public GoatMilk() {
        super(ProductType.GoatMilkType, 100);
    }

    /**
     * Fungsi yang mengembalikan string untuk dirender yang merepresentasikan GoatMilk
     *
     * @return String untuk dirender yang akan ditampilkan dan merepresentasikan GoatMilk
     */
    public String render() {
        return "Goat Milk";
    }
}