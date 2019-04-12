package id.backendk3.engifarm.Product.FarmProduct;

import id.backendk3.engifarm.Product.FarmProduct.FarmProduct;

public class DuckEgg extends FarmProduct{
    public DuckEgg(){
        super(ProductType.DuckEggType, 100);
    }

    public String render(){
        return "Duck Egg";
    }
}