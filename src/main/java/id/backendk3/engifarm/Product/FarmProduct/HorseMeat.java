package id.backendk3.engifarm.Product.FarmProduct;

/**
 * Kelas riil HorseMeat turunan FarmProduct
 * <p>HorseMeat adalah Product yang dihasilkan oleh object animal Horse
 * 
 * @author backendk3
 * @see FarmProduct
 * @see id.backendk3.engifarm.Product Product
 */
public class HorseMeat extends FarmProduct{

    /**
     * Konstruktor kelas HorseMeat
     */
    public HorseMeat(){
        super(ProductType.HorseMeatType, 100);
    }

    /**
    * Fungsi yang mengembalikan string untuk dirender yang merepresentasikan HorseMeat
    * @return String untuk dirender yang akan ditampilkan dan merepresentasikan HorseMeat
    */
    public String render(){
        return "Horse Meat";
    }
}