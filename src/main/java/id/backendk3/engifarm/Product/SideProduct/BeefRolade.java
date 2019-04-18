package id.backendk3.engifarm.Product.SideProduct;

// import java.util.LinkedList;
import id.backendk3.engifarm.MyLinkedList;
import id.backendk3.engifarm.Product.Product;
import id.backendk3.engifarm.Product.SideProduct.SideProduct;
import id.backendk3.engifarm.Product.FarmProduct.ChickenEgg;
import id.backendk3.engifarm.Product.FarmProduct.CowMeat;

/**
 * Kelas riil BeefRolade turunan SideProduct 
 * <p>BeefRolade dapat dibuat dari CowMeat dan ChickenEgg dari FarmProduct
 * 
 * @author backendk3
 * @see SideProduct
 * @see id.backendk3.engifarm.Product Product
 */
public class BeefRolade extends SideProduct{

    /**
     * Konstruktor kelas BeefRolade
     */
    public BeefRolade(){
        super(ProductType.BeefRoladeType, 400);
    }

    /**
     * Fungsi yang mengembalikan linkedlist produk yang berisi bahan pembuat BeefRolade
     * @return LinkedList produk yang berisi bahan-bahan untuk membuat BeefRolade
     */
    // public LinkedList<Product> getRecipe(){
    public MyLinkedList<Product> getRecipe(){
        // LinkedList<Product> recipe = new LinkedList<Product>();
        MyLinkedList<Product> recipe = new MyLinkedList<Product>();
        
        recipe.addFirst(new CowMeat());
        recipe.addFirst(new ChickenEgg());
        return recipe;
    }

    /**
     * Fungsi yang mengembalikan string untuk dirender yang merepresentasikan BeefRolade
     * @return String untuk dirender yang akan ditampilkan dan merepresentasikan BeefRolade
     */
    public String render(){
        return "Beef Rolade";
    }
}