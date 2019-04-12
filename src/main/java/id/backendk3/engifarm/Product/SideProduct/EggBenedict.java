package id.backendk3.engifarm.Product.SideProduct;

import id.backendk3.engifarm.Product.Product;
import id.backendk3.engifarm.Product.SideProduct.SideProduct;
import id.backendk3.engifarm.Product.FarmProduct.DuckEgg;
import id.backendk3.engifarm.Product.FarmProduct.RabbitMeat;
import id.backendk3.engifarm.Product.FarmProduct.GoatMilk;
import java.util.LinkedList;

public class EggBenedict extends SideProduct{
    public EggBenedict(){
        super(ProductType.EggBenedictType, 600);
    }

    public LinkedList<Product> getRecipe(){
        LinkedList<Product> recipe = new LinkedList<Product>();
        
        recipe.addFirst(new DuckEgg());
        recipe.addFirst(new RabbitMeat());
        recipe.addFirst(new GoatMilk());
        return recipe;
    }

    public String render(){
        return "Egg Benedict";
    }
}