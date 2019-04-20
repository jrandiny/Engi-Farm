package id.backendk3.engifarm;

import java.util.Observable;

/**
 * Kelas riil Tooltip turunan Obeservable
 * 
 * <p>Kelas ini merepresentasikan pesan berupa keterangan mengenai permainan yang akan membantu user
 *
 * @author backendk3
 */
public class Tooltip extends Observable {
    private String msg;

    /**
     * Konstruktor kelas Tooltip
     */
    public Tooltip() {
        msg = "";
    }

    /**
     * Method yang mengembalikan isi pesan yang akan dituliskan ke layar
     * 
     * @return isi pesan yang akan dituliskan ke layar
     */
    public String getMsg() {
        return msg;
    }

    /**
     * Method yang menetapkan isi pesan yang akan dituliskan ke layar
     * 
     * @param msg isi pesan yang akan dituliskan ke layar
     */
    public void setMsg(String msg) {
        this.msg = msg;
        setChanged();
        notifyObservers();
    }
}