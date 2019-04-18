package id.backendk3.engifarm.FarmAnimal;

import id.backendk3.engifarm.Product.*;
import id.backendk3.engifarm.Product.FarmProduct.*;
import id.backendk3.engifarm.Cell.Cell;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Kelas riil turunan FarmAnimal
 * 
 * <p>Kelas untuk salah satu tipe {@link FarmAnimal}.
 * Merepresentasikan hewan kuda
 * 
 * @author backendk3
 * @see FarmAnimal
 */

public class Horse extends FarmAnimal{
    
    /** 
     * Konstruktor kelas Horse
     * 
     * @param _x Lokasi X
     * @param _y Lokasi Y
     */
    public Horse(int _x, int _y){
        super(_x,_y,20,Cell.CellType.BarnType);
    }

    /**
     * Mengembalikan suara Horse
     * 
     * @return String suara Horse
     */
    public String speak(){
        return "Nay nay!";
    }

    /**
     * Mengembalikan produk dari Horse
     * 
     * @return Product berupa HorseMeat
     * @see HorseMeat
     */
    public Product getProduct(){
        Product res = new HorseMeat();
        setHaveProduct(false);
        return res;    
    }

    /**
     * Mengembalikan sprite untuk Horse
     * 
     * @return Gambar sprite Horse
     */
    public Image getSprite() throws IOException{
        Image image = ImageIO.read(getClass().getClassLoader().getResource("sprites/animal/horse.png"));
        return image;
    }
}