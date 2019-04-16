package id.backendk3.engifarm.Product.SideProduct;

import id.backendk3.engifarm.Product.Product;
import java.util.LinkedList;

/**
 * Kelas abstrak SideProduct turunan Product
 * SideProduct adalah produk hasil pengolahan dari 2 FarmProduct atau lebih
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
    public abstract LinkedList<Product> getRecipe();
}