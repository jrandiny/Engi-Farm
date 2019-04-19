package id.backendk3.engifarm.product.sideproduct;

import id.backendk3.engifarm.MyLinkedList;
import id.backendk3.engifarm.product.Product;

/**
 * Kelas abstrak sideproduct turunan product
 * <p>sideproduct adalah produk hasil pengolahan dari 2 farmproduct atau lebih
 *
 * @author backendk3
 * @see SideProduct
 * @see id.backendk3.engifarm.product product
 */
public abstract class SideProduct extends Product {

    /**
     * Konstruktor kelas sideproduct
     *
     * @param _type  tipe produk
     * @param _harga harga jual produk
     */
    public SideProduct(ProductType _type, int _harga) {
        super(_type, _harga);
    }

    /**
     * Fungsi abstrak yang mengembalikan MyLinkedList produk yang berisi bahan-bahan pembentuk sideproduct
     *
     * @return MyLinkedList dari produk yang berisi bahan-bahan pembentuk sideproduct
     */
    public abstract MyLinkedList<Product> getRecipe();
}