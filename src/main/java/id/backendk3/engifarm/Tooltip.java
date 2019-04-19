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
    private String Msg;
    private boolean exit;

    /**
     * Konstruktor kelas Tooltip
     */
    public Tooltip() {
        Msg = "";
        exit = false;
    }

    /**
     * Method yang mengembalikan isi pesan yang akan dituliskan ke layar
     * 
     * @return isi pesan yang akan dituliskan ke layar
     */
    public String getMsg() {
        return Msg;
    }

    /**
     * Method yang mengembalikan kondisi yang menyatakan permainan sedang berjalan
     * @return True jika menyatakan kondisi permainan akan keluar
     */
    public boolean getExit() {
        return exit;
    }

    /**
     * Method yang menetapkan isi pesan yang akan dituliskan ke layar
     * 
     * @param msg isi pesan yang akan dituliskan ke layar
     */
    public void setMsg(String msg) {
        this.Msg = msg;
        setChanged();
        notifyObservers();
    }

    /**
     * Method yang menetapkan kondisi yang menyatakan permainan sedang berjalan
     * 
     * @param flag kondisi yang menyatakan permainan sedang berjalan
     */
    public void setExit(boolean flag) {
        this.exit = flag;
    }
}