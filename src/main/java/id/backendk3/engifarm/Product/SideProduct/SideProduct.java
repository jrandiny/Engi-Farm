package id.backendk3.engifarm.Product.SideProduct;

// import java.util.LinkedList;
import id.backendk3.engifarm.MyLinkedList;
import id.backendk3.engifarm.Product.Product;

/**
 * Kelas abstrak SideProduct turunan Product
 * <p>SideProduct adalah produk hasil pengolahan dari 2 FarmProduct atau lebih
 * 
 * @author backendk3
 * @see SideProduct
 * @see id.backendk3.engifarm.Product Product
 */
public abstract class SideProduct extends Product{

    /**
     * Konstruktor kelas SideProduct
     * @param _type tipe produk
     * @param _harga harga jual produk
     */
    public SideProduct(ProductType _type, int _harga){
        super(_type,_harga);
    }   

    /**
     * Fungsi abstrak yang mengembalikan linkedlist produk yang berisi bahan-bahan pembentuk SideProduct
     * @return LinkedList dari produk yang berisi bahan-bahan pembentuk SideProduct
     */
    // public abstract LinkedList<Product> getRecipe();
    public abstract MyLinkedList<Product> getRecipe();
}