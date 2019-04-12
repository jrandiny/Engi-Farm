package id.backendk3.engifarm.Product.SideProduct;

import id.backendk3.engifarm.Product.Product;
import id.backendk3.engifarm.Product.SideProduct.SideProduct;
import id.backendk3.engifarm.Product.FarmProduct.ChickenEgg;
import id.backendk3.engifarm.Product.FarmProduct.CowMeat;
import java.util.LinkedList;

public class BeefRolade extends SideProduct{
    public BeefRolade(){
        super(ProductType.BeefRoladeType, 400);
    }

    public LinkedList<Product> getRecipe(){
        LinkedList<Product> recipe = new LinkedList<Product>();
        
        recipe.addFirst(new CowMeat());
        recipe.addFirst(new ChickenEgg());
        return recipe;
    }

    public String render(){
        return "Beef Rolade";
    }
}