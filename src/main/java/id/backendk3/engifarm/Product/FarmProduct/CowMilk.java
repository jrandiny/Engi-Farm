package id.backendk3.engifarm.Product.FarmProduct;

import id.backendk3.engifarm.Product.FarmProduct.FarmProduct;

public class CowMilk extends FarmProduct{
    public CowMilk(){
        super(ProductType.CowMilkType, 100);
    }

    public String render(){
        return "Cow Milk";
    }
}