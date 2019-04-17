package id.backendk3.engifarm.Cell.Facility;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import id.backendk3.engifarm.Cell.Facility.Facility;

/**
 * Kelas riil turuan Facility
 * 
 * <p>Kelas untuk salah satu tipe {@link Facility}.
 * Tipe fasiltas ini berguna untuk menjual berbagai {@link Product}
 * yang terdapat pada {@link Player} untuk uang.
 * 
 * <p>Setelah digunakan, Truck tidak dapat langsung digunakan kembali.
 * Harus menunggu selama beberapa waktu terlebih dahulu
 * 
 * @author backendk3
 * @see Facility
 */
public class Truck extends Facility{
    /**
     * Konstuktor kelas Truck
     * 
     * @param x Lokasi x
     * @param y Lokasi y
     */
    public Truck(int x, int y){
        super(x,y,CellType.TruckType);
        usable = true;
    }

    /**
     * Mengembalikan sprite untuk Truck
     * 
     * @return Gambar sprite
     * @throws IOException jika gambar tidak tersedia atau tidak dapat dibuka
     */
    public Image getSprite() throws IOException{
        Image image = ImageIO.read(new File("image.png"));
        return image;
    }
    
    /**
     * Mengembalikan warna background untuk tile {@link Farm}
     * 
     * @return Warna background tile Truck
     */
    public Color getBGColor(){
        return Color.WHITE;
    }

    /**
     * Menggunakan Truck
     * 
     * <p>Setelah prosedur ini dipanggil, Truck tidak akan dapat digunakan
     * selama beberapa waktu
     * 
     * @param time Lama waktu game hingga dapat digunakan kembali
     */
    public void use(int time){
        usable = false;
        //setAndActivate(time);
    }
}