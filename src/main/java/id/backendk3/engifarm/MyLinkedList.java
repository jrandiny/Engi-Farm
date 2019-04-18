package id.backendk3.engifarm;

import java.util.LinkedList;

/**
 * Kelas generik
 * 
 * <p>Merupakan container generik berbentuk LinkedList
 */
public class MyLinkedList<T>{
    private LinkedList<T> list;

    /**
     * Konstruktor tanpa parameter
     */
    public MyLinkedList(){
        list = new LinkedList<>();
    }

    /**
     * Menambahkan object di awal list
     * 
     * @param object Objek yang akan ditambahkan
     */
    public void addFirst(T object){
        list.addFirst(object);
    }

    /**
     * Mengambil element pada indeks ke-i
     * 
     * @param idx Indeks letak elemen yang akan diambil
     * @return Objek pada posisi idx atau null
     */
    public T get(int idx){
        return list.get(idx);
    }

    /**
     * Mengembalikan ukuran dari list sekarang
     * 
     * @return Ukuran list
     */
    public int size(){
        return list.size();
    }
}