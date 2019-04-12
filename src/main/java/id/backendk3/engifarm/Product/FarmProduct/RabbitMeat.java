package id.backendk3.engifarm.Product.FarmProduct;

import id.backendk3.engifarm.Product.FarmProduct.FarmProduct;

public class RabbitMeat extends FarmProduct{
    public RabbitMeat(){
        super(ProductType.RabbitMeatType, 100);
    }

    public String render(){
        return "Rabbit Meat";
    }
}