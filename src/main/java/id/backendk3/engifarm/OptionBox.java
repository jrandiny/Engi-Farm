package id.backendk3.engifarm;

import java.util.Observable;

/**
 * Kelas riil OptionBox turunan Observable
 * 
 * <p>Kelas ini merepresentasikan kotak pilihan yang muncul sebagai opsi pilihan perintah dari user
 */
public class OptionBox extends Observable {
    private String[] param;
    private String type;

    /**
     * Method yang menetapkan pilihan opsinya
     * @param param parameter
     * @param type tipe opsi
     */
    public void setOptions(String[] param, String type) {
        this.param = param;
        this.type = type;
        setChanged();
        notifyObservers();
    }

    /**
     * Fungsi yang mengembalikan opsi pilihan-pilihan yang dapat dipilih
     * @return opsi pilihan-pilihan yang dapat dipilih
     */
    public String[] getOptions() {
        return param;
    }

    /**
     * Fungsi yang mengembalikan tipe pilihan yang ingin dipilih
     * @return tipe pilihan yang ingin dipilih
     */
    public String getType() {
        return type;
    }
}