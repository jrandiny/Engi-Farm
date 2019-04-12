package id.backendk3.engifarm.Product.SideProduct;

import id.backendk3.engifarm.Product.Product;
import java.util.LinkedList;

public abstract class SideProduct extends Product{
    public SideProduct(ProductType _type, int _harga){
        super(_type,_harga);
    }   

    public abstract LinkedList<Product> getRecipe();
}