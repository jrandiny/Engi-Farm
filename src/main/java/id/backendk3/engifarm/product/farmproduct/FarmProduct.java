package id.backendk3.engifarm.product.farmproduct;

import id.backendk3.engifarm.product.Product;

/**
 * Kelas abstrak farmproduct turunan product
 * <p>farmproduct adalah product yang dapat dihasilkan dari farmanimal
 *
 * @author backendk3
 * @see FarmProduct
 * @see id.backendk3.engifarm.product product
 */
public abstract class FarmProduct extends Product {

    /**
     * Konstruktor kelas farmproduct
     *
     * @param _type  tipe produk
     * @param _harga harga jual produk
     */
    public FarmProduct(ProductType _type, int _harga) {
        super(_type, _harga);
    }
}