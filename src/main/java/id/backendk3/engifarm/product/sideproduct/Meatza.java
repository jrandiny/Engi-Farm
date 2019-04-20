package id.backendk3.engifarm.product.sideproduct;

import id.backendk3.engifarm.MyLinkedList;
import id.backendk3.engifarm.product.farmproduct.GoatMeat;
import id.backendk3.engifarm.product.farmproduct.HorseMeat;
import id.backendk3.engifarm.product.farmproduct.RabbitMeat;
import id.backendk3.engifarm.product.Product;

/**
 * Kelas riil Meatza turunan sideproduct
 * <p>Meatza dapat dibuat dari GoatMeat, HorseMeat, dan RabbitMeat dari farmproduct
 *
 * @author backendk3
 * @see SideProduct
 * @see id.backendk3.engifarm.product product
 */
public class Meatza extends SideProduct {

    /**
     * Konstruktor kelas Meatza
     */
    public Meatza() {
        super(ProductType.MeatzaType, 600);
    }

    /**
     * Fungsi yang mengembalikan MyLinkedList produk yang berisi bahan pembuat Meatza
     *
     * @return MyLinkedList produk yang berisi bahan-bahan untuk membuat Meatza
     */
    public MyLinkedList<Product> getRecipe() {
        MyLinkedList<Product> recipe = new MyLinkedList<>();

        recipe.addFirst(new GoatMeat());
        recipe.addFirst(new HorseMeat());
        recipe.addFirst(new RabbitMeat());
        return recipe;
    }

    /**
     * Fungsi yang mengembalikan string untuk dirender yang merepresentasikan Meatza
     *
     * @return String untuk dirender yang akan ditampilkan dan merepresentasikan Meatza
     */
    public String render() {
        return "Meatza";
    }
}