package id.backendk3.engifarm.FarmAnimal;

import id.backendk3.engifarm.Product.*;
import id.backendk3.engifarm.Product.FarmProduct.*;
import id.backendk3.engifarm.Cell.Cell;
import java.awt.Color;
import java.awt.Image;

/**
 * Kelas riil turunan FarmAnimal
 * 
 * <p>Kelas untuk salah satu tipe {@link FarmAnimal}.
 * Merepresentasikan hewan ayam
 * 
 * @author backendk3
 * @see FarmAnimal
 */

public class Chicken extends FarmAnimal{
    
    /** 
     * Konstruktor kelas Chicken
     * 
     * @param _x Lokasi X
     * @param _y Lokasi Y
     */
    public Chicken(int _x, int _y){
        super(_x,_y,20,Cell.CellType.CoopType);
    }

    /**
     * Mengembalikan suara Chicken
     * 
     * @return String suara Chicken
     */
    public String speak(){
        return "Cook-a-Doodle-Doo!";
    }

    /**
     * Mengembalikan produk dari Chicken
     * 
     * @return Product berupa ChickenEgg
     * @see ChickenEgg
     */
    public Product getProduct(){
        Product res = new ChickenEgg();
        setHaveProduct(false);
        return res;    
    }

    /**
    * Mengembalikan string render representasi Chicken
    * @return String render dari Chicken
    */
    public String render(){
        return "C";
    }
}