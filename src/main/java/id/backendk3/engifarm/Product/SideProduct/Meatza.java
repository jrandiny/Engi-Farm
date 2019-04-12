package id.backendk3.engifarm.Product.SideProduct;

import id.backendk3.engifarm.Product.Product;
import id.backendk3.engifarm.Product.SideProduct.SideProduct;
import id.backendk3.engifarm.Product.FarmProduct.GoatMeat;
import id.backendk3.engifarm.Product.FarmProduct.HorseMeat;
import id.backendk3.engifarm.Product.FarmProduct.RabbitMeat;
import java.util.LinkedList;

public class Meatza extends SideProduct{
    public Meatza(){
        super(ProductType.MeatzaType, 600);
    }

    public LinkedList<Product> getRecipe(){
        LinkedList<Product> recipe = new LinkedList<Product>();
        
        recipe.addFirst(new GoatMeat());
        recipe.addFirst(new HorseMeat());
        recipe.addFirst(new RabbitMeat());
        return recipe;
    }

    public String render(){
        return "Meatza";
    }
}