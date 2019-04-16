package id.backendk3.engifarm.Product.FarmProduct;

import id.backendk3.engifarm.Product.FarmProduct.FarmProduct;

/**
 * Kelas riil ChickenEgg turunan FarmProduct
 * ChickenEgg adalah Product yang dihasilkan oleh object animal Chicken
 */
public class ChickenEgg extends FarmProduct{

    /**
     * Konstruktor kelas ChickenEgg
     */
    public ChickenEgg(){
        super(ProductType.ChickenEggType, 100);
    }

    /**
    * Fungsi yang mengembalikan string untuk dirender yang merepresentasikan ChickenEgg
    * @return String untuk dirender yang akan ditampilkan dan merepresentasikan ChickenEgg
    */
    public String render(){
        return "Chicken Egg";
    }
}