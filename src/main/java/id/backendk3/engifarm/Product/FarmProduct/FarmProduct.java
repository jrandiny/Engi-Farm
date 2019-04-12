package id.backendk3.engifarm.Product.FarmProduct;

import id.backendk3.engifarm.Product.Product;

public abstract class FarmProduct extends Product{
    public FarmProduct(ProductType _type, int _harga){
        super(_type,_harga);
    }
}