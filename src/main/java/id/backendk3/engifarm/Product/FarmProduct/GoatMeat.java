package id.backendk3.engifarm.Product.FarmProduct;

import id.backendk3.engifarm.Product.FarmProduct.FarmProduct;

/**
 * Kelas riil GoatMeat turunan FarmProduct
 * <p>GoatMeat adalah Product yang dihasilkan oleh object animal Goat yang terletak pada Barn
 * 
 * @author backendk3
 * @see FarmProduct
 * @see id.backendk3.engifarm.Product Product
 */
public class GoatMeat extends FarmProduct{

    /**
     * Konstruktor kelas GoatMeat
     */
    public GoatMeat(){
        super(ProductType.GoatMeatType, 100);
    }

    /**
    * Fungsi yang mengembalikan string untuk dirender yang merepresentasikan GoatMeat
    * @return String untuk dirender yang akan ditampilkan dan merepresentasikan GoatMeat
    */
    public String render(){
        return "Goat Meat";
    }
}