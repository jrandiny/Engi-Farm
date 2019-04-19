package id.backendk3.engifarm.product.sideproduct;

import id.backendk3.engifarm.MyLinkedList;
import id.backendk3.engifarm.product.farmproduct.ChickenEgg;
import id.backendk3.engifarm.product.farmproduct.CowMeat;
import id.backendk3.engifarm.product.Product;

/**
 * Kelas riil BeefRolade turunan sideproduct
 * <p>BeefRolade dapat dibuat dari CowMeat dan ChickenEgg dari farmproduct
 *
 * @author backendk3
 * @see SideProduct
 * @see id.backendk3.engifarm.product product
 */
public class BeefRolade extends SideProduct {

    /**
     * Konstruktor kelas BeefRolade
     */
    public BeefRolade() {
        super(ProductType.BeefRoladeType, 400);
    }

    /**
     * Fungsi yang mengembalikan MyLinkedList produk yang berisi bahan pembuat BeefRolade
     *
     * @return MyLinkedList produk yang berisi bahan-bahan untuk membuat BeefRolade
     */
    public MyLinkedList<Product> getRecipe() {
        MyLinkedList<Product> recipe = new MyLinkedList<Product>();

        recipe.addFirst(new CowMeat());
        recipe.addFirst(new ChickenEgg());
        return recipe;
    }

    /**
     * Fungsi yang mengembalikan string untuk dirender yang merepresentasikan BeefRolade
     *
     * @return String untuk dirender yang akan ditampilkan dan merepresentasikan BeefRolade
     */
    public String render() {
        return "Beef Rolade";
    }
}