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
 * Merepresentasikan hewan kambing
 * 
 * @author backendk3
 * @see FarmAnimal
 */

public class Goat extends FarmAnimal{
    
    /** 
     * Konstruktor kelas Goat
     * 
     * @param _x Lokasi X
     * @param _y Lokasi Y
     */
    public Goat(int _x, int _y,Cell.CellType _type){
        super(_x,_y,20,_type);
    }

    /**
     * Mengembalikan suara Goat
     * 
     * @return String suara Goat
     */
    public String speak(){
        return "Blet blet..!";
    }

    /**
     * Mengembalikan produk dari Goat tergantung habitat
     * 
     * @return Product berupa GoatMeat jika habitatnya Barn
     * @return Product berupa GoatMilk jika habitatnya GrassLand
     * @see GoatMeat
     * @see GoatMilk
     */
    public Product getProduct(){
        Product res;
        if(habitat==Cell.CellType.BarnType){
            res=new GoatMeat();
        }else if(habitat==Cell.CellType.GrassLandType){
            res=new GoatMilk();
        }else{
            throw new RuntimeException("Error no matching habitat type");
        }    
        setHaveProduct(false);
        return res;
    }

    /**
    * Mengembalikan string render representasi Goat
    * @return String render dari Goat
    */
    public String render(){
        return "D";
    }
}