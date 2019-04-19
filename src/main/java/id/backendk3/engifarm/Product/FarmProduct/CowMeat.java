package id.backendk3.engifarm.Product.FarmProduct;

/**
 * Kelas riil CowMeat turunan FarmProduct
 * <p>CowMeat adalah Product yang dihasilkan oleh object animal Cow yang terletak pada Barn
 *
 * @author backendk3
 * @see FarmProduct
 * @see id.backendk3.engifarm.Product Product
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