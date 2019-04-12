package id.backendk3.engifarm.Product.FarmProduct;

import id.backendk3.engifarm.Product.FarmProduct.FarmProduct;

public class ChickenEgg extends FarmProduct{
    public ChickenEgg(){
        super(ProductType.ChickenEggType, 100);
    }

    public String render(){
        return "Chicken Egg";
    }
}