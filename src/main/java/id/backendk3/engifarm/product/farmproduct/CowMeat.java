package id.backendk3.engifarm.product.farmproduct;

/**
 * Kelas riil CowMeat turunan farmproduct
 * <p>CowMeat adalah product yang dihasilkan oleh object animal Cow yang terletak pada Barn
 *
 * @author backendk3
 * @see FarmProduct
 * @see id.backendk3.engifarm.product product
 */
public class CowMeat extends FarmProduct {
    /**
     * Konstruktor kelas CowMeat
     */
    public CowMeat() {
        super(ProductType.CowMeatType, 100);
    }

    /**
     * Fungsi yang mengembalikan string untuk dirender yang merepresentasikan CowMeat
     *
     * @return String untuk dirender yang akan ditampilkan dan merepresentasikan CowMeat
     */
    public String render() {
        return "Cow Meat";
    }
}