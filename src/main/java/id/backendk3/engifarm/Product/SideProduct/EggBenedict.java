package id.backendk3.engifarm.Product.SideProduct;

import id.backendk3.engifarm.MyLinkedList;
import id.backendk3.engifarm.Product.FarmProduct.DuckEgg;
import id.backendk3.engifarm.Product.FarmProduct.GoatMilk;
import id.backendk3.engifarm.Product.FarmProduct.RabbitMeat;
import id.backendk3.engifarm.Product.Product;

/**
 * Kelas riil EggBenedict turunan SideProduct 
 * <p>EggBenedict dapat dibuat dari DuckEgg, GoatMilk, dan RabbirMeat dari FarmProduct
 * 
 * @author backendk3
 * @see SideProduct
 * @see id.backendk3.engifarm.Product Product
 */
public class EggBenedict extends SideProduct{
    
    /**
     * Konstruktor kelas EgBenedict
     */
    public EggBenedict(){
        super(ProductType.EggBenedictType, 600);
    }

    /**
     * Fungsi yang mengembalikan MyLinkedList produk yang berisi bahan pembuat EgBenedict
     * @return MyLinkedList produk yang berisi bahan-bahan untuk membuat EgBenedict
     */
    public MyLinkedList<Product> getRecipe(){
        MyLinkedList<Product> recipe = new MyLinkedList<Product>();
        
        recipe.addFirst(new DuckEgg());
        recipe.addFirst(new RabbitMeat());
        recipe.addFirst(new GoatMilk());
        return recipe;
    }

    /**
     * Fungsi yang mengembalikan string untuk dirender yang merepresentasikan EgBenedict
     * @return String untuk dirender yang akan ditampilkan dan merepresentasikan EgBenedict
     */
    public String render(){
        return "Egg Benedict";
    }
}