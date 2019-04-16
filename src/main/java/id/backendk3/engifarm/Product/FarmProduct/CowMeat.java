package id.backendk3.engifarm.Product.FarmProduct;

import id.backendk3.engifarm.Product.FarmProduct.FarmProduct;

/**
 * Kelas riil CowMeat turunan FarmProduct
 * CowMeat adalah Product yang dihasilkan oleh object animal Cow yang terletak pada Barn
 */
public class CowMeat extends FarmProduct{
    /**
     * Konstruktor kelas CowMeat
     */
    public CowMeat(){
        super(ProductType.CowMeatType, 100);
    }

    /**
    * Fungsi yang mengembalikan string untuk dirender yang merepresentasikan CowMeat
    * @return String untuk dirender yang akan ditampilkan dan merepresentasikan CowMeat
    */
    public String render(){
        return "Cow Meat";
    }
}