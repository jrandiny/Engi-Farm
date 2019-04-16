package id.backendk3.engifarm.Product.FarmProduct;

import id.backendk3.engifarm.Product.FarmProduct.FarmProduct;

/**
 * Kelas riil DuckEgg turunan FarmProduct
 * DuckEgg adalah Product yang dihasilkan oleh object animal Duck
 */
public class DuckEgg extends FarmProduct{

    /**
     * Konstruktor kelas DuckEgg
     */
    public DuckEgg(){
        super(ProductType.DuckEggType, 100);
    }

    /**
    * Fungsi yang mengembalikan string untuk dirender yang merepresentasikan DuckEgg
    * @return String untuk dirender yang akan ditampilkan dan merepresentasikan DuckEgg
    */
    public String render(){
        return "Duck Egg";
    }
}