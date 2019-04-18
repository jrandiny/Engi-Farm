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
     * Mengembalikan sprite untuk Rabbit
     * 
     * @return Gambar sprite Rabbit
     */
    public Image getSprite() throws IOException{
        Image image;
        if(getEatStatus()){
            // sudah makan
            image = ImageIO.read(getClass().getClassLoader().getResource("sprites/animal/rabbit.png"));
        } else {
            image = ImageIO.read(getClass().getClassLoader().getResource("sprites/animal/rabbit-hungry.png"));
        }
        return image;
    }
}