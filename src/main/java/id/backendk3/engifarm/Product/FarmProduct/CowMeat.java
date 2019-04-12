package id.backendk3.engifarm.Product.FarmProduct;

import id.backendk3.engifarm.Product.FarmProduct.FarmProduct;

public class CowMeat extends FarmProduct{
    public CowMeat(){
        super(ProductType.CowMeatType, 100);
    }

    public String render(){
        return "Cow Meat";
    }
}