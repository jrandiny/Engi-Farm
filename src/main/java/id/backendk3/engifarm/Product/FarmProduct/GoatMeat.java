package id.backendk3.engifarm.Product.FarmProduct;

import id.backendk3.engifarm.Product.FarmProduct.FarmProduct;

public class GoatMeat extends FarmProduct{
    public GoatMeat(){
        super(ProductType.GoatMeatType, 100);
    }

    public String render(){
        return "Goat Meat";
    }
}