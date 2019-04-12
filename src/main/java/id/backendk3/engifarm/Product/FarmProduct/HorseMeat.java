package id.backendk3.engifarm.Product.FarmProduct;

import id.backendk3.engifarm.Product.FarmProduct.FarmProduct;

public class HorseMeat extends FarmProduct{
    public HorseMeat(){
        super(ProductType.HorseMeatType, 100);
    }

    public String render(){
        return "Horse Meat";
    }
}