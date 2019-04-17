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
 * Merepresentasikan hewan kelinci
 * 
 * @author backendk3
 * @see FarmAnimal
 */

public class Rabbit extends FarmAnimal{
    
    /** 
     * Konstruktor kelas Rabbit
     * 
     * @param _x Lokasi X
     * @param _y Lokasi Y
     */
    public Rabbit(int _x, int _y){
        super(_x,_y,20,Cell.CellType.BarnType);
    }

    /**
     * Mengembalikan suara Rabbit
     * 
     * @return String suara Rabbit
     */
    public String speak(){
        return "Purr purr..!";
    }

    /**
     * Mengembalikan produk dari Rabbit
     * 
     * @return Product berupa RabbitMeat
     * @see RabbitMeat
     */
    public Product getProduct(){
        Product res = new RabbitMeat();
        setHaveProduct(false);
        return res;    
    }

    /**
    * Mengembalikan string render representasi Rabbit
    * @return String render dari Rabbit
    */
    public String render(){
        return "R";
    }
}