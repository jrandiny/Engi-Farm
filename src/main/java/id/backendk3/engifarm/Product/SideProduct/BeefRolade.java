package id.backendk3.engifarm.Product.SideProduct;

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
     * Fungsi yang mengembalikan MyLinkedList produk yang berisi bahan pembuat BeefRolade
     * @return MyLinkedList produk yang berisi bahan-bahan untuk membuat BeefRolade
     */
    public MyLinkedList<Product> getRecipe(){
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