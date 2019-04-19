package id.backendk3.engifarm.product.farmproduct;

/**
 * Kelas riil GoatMeat turunan farmproduct
 * <p>GoatMeat adalah product yang dihasilkan oleh object animal Goat yang terletak pada Barn
 *
 * @author backendk3
 * @see FarmProduct
 * @see id.backendk3.engifarm.product product
 */
public class GoatMeat extends FarmProduct {

    /**
     * Konstruktor kelas GoatMeat
     */
    public GoatMeat() {
        super(ProductType.GoatMeatType, 100);
    }

    /**
     * Fungsi yang mengembalikan string untuk dirender yang merepresentasikan GoatMeat
     *
     * @return String untuk dirender yang akan ditampilkan dan merepresentasikan GoatMeat
     */
    public String render() {
        return "Goat Meat";
    }
}