package id.backendk3.engifarm.Product.FarmProduct;

import id.backendk3.engifarm.Product.FarmProduct.FarmProduct;

public class GoatMilk extends FarmProduct{
    public GoatMilk(){
        super(ProductType.GoatMilkType, 100);
    }

    public String render(){
        return "Goat Milk";
    }
}