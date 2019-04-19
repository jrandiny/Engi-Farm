package id.backendk3.engifarm.Cell.Facility;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

/**
 * Kelas riil turuan Facility
 * 
 * <p>Kelas untuk salah satu tipe {@link id.backendk3.engifarm.Cell.Facility Facility}.
 * Tipe fasiltas ini berguna untuk menjual berbagai {@link id.backendk3.engifarm.Product}
 * yang terdapat pada {@link id.backendk3.engifarm.Player} untuk uang.
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
        Image image = ImageIO.read(getClass().getClassLoader().getResource("sprites/facility/truck.png"));
        return image;
    }
    
    /**
     * Mengembalikan warna background untuk tile {@link id.backendk3.engifarm.Farm}
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
        setTimer(time);
        setTimerActive(true);
    }

    /**
     * Menyatakan truck sudah dapat dipakai kembali
     * 
     * <p>Setelah prosedur ini dipanggil, Truck dapat digunakan kembali
     * 
     * Method yang dipanggil jika timer untuk objek truk sudah habis
     */
    public void callback(){
        if(!usable){
            usable = true;
            setTimerActive(false);
        }
    }
}