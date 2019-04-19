package id.backendk3.engifarm.Product.FarmProduct;

import id.backendk3.engifarm.Product.Product;

/**
 * Kelas abstrak FarmProduct turunan Product
 * <p>FarmProduct adalah Product yang dapat dihasilkan dari FarmAnimal
 *
 * @author backendk3
 * @see FarmProduct
 * @see id.backendk3.engifarm.Product Product
 */
public abstract class FarmProduct extends Product {

    /**
     * Konstruktor kelas FarmProduct
     *
     * @param _type  tipe produk
     * @param _harga harga jual produk
     */
    public FarmProduct(ProductType _type, int _harga) {
        super(_type, _harga);
    }
}