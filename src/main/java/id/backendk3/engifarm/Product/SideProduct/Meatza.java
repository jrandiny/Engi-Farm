package id.backendk3.engifarm.Product.SideProduct;

import id.backendk3.engifarm.Product.Product;
import id.backendk3.engifarm.Product.SideProduct.SideProduct;
import id.backendk3.engifarm.Product.FarmProduct.GoatMeat;
import id.backendk3.engifarm.Product.FarmProduct.HorseMeat;
import id.backendk3.engifarm.Product.FarmProduct.RabbitMeat;
import java.util.LinkedList;

/**
 * Kelas riil Meatza turunan SideProduct 
 * <p>Meatza dapat dibuat dari GoatMeat, HorseMeat, dan RabbitMeat dari FarmProduct
 * 
 * @author backendk3
 * @see SideProduct
 * @see id.backendk3.engifarm.Product Product
 */
public class Meatza extends SideProduct{
    
    /**
     * Konstruktor kelas Meatza
     */
    public Meatza(){
        super(ProductType.MeatzaType, 600);
    }

    /**
     * Fungsi yang mengembalikan linkedlist produk yang berisi bahan pembuat Meatza
     * @return LinkedList produk yang berisi bahan-bahan untuk membuat Meatza
     */
    public LinkedList<Product> getRecipe(){
        LinkedList<Product> recipe = new LinkedList<Product>();
        
        recipe.addFirst(new GoatMeat());
        recipe.addFirst(new HorseMeat());
        recipe.addFirst(new RabbitMeat());
        return recipe;
    }

    /**
     * Fungsi yang mengembalikan string untuk dirender yang merepresentasikan Meatza
     * @return String untuk dirender yang akan ditampilkan dan merepresentasikan Meatza
     */
    public String render(){
        return "Meatza";
    }
}