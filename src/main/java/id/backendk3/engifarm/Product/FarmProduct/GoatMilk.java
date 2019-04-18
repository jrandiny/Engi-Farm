package id.backendk3.engifarm.Product.FarmProduct;

import id.backendk3.engifarm.Product.FarmProduct.FarmProduct;


/**
 * Kelas riil GoatMilk turunan FarmProduct
 * <p>GoatMilk adalah Product yang dihasilkan oleh object animal Goat yang terletak pada GrassLand
 * 
 * @author backendk3
 * @see FarmProduct
 * @see id.backendk3.engifarm.Product Product
 */
public class GoatMilk extends FarmProduct{

    /**
     * Konstruktor kelas GoatMilk
     */
    public GoatMilk(){
        super(ProductType.GoatMilkType, 100);
    }

    /**
    * Fungsi yang mengembalikan string untuk dirender yang merepresentasikan GoatMilk
    * @return String untuk dirender yang akan ditampilkan dan merepresentasikan GoatMilk
    */
    public String render(){
        return "Goat Milk";
    }
}