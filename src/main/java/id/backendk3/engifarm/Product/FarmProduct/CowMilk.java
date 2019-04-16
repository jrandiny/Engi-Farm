package id.backendk3.engifarm.Product.FarmProduct;

import id.backendk3.engifarm.Product.FarmProduct.FarmProduct;

/**
 * Kelas riil CowMilk turunan FarmProduct
 * CowMilk adalah Product yang dihasilkan oleh object animal Cow yang terletak pada GrassLand
 */
public class CowMilk extends FarmProduct{

    /**
     * Konstruktor kelas CowMilk
     */
    public CowMilk(){
        super(ProductType.CowMilkType, 100);
    }

    /**
    * Fungsi yang mengembalikan string untuk dirender yang merepresentasikan CowMilk
    * @return String untuk dirender yang akan ditampilkan dan merepresentasikan CowMilk
    */
    public String render(){
        return "Cow Milk";
    }
}