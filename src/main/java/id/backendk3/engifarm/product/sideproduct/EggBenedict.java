package id.backendk3.engifarm.product.sideproduct;

import id.backendk3.engifarm.MyLinkedList;
import id.backendk3.engifarm.product.farmproduct.DuckEgg;
import id.backendk3.engifarm.product.farmproduct.GoatMilk;
import id.backendk3.engifarm.product.farmproduct.RabbitMeat;
import id.backendk3.engifarm.product.Product;

/**
 * Kelas riil EggBenedict turunan sideproduct
 * <p>EggBenedict dapat dibuat dari DuckEgg, GoatMilk, dan RabbirMeat dari farmproduct
 *
 * @author backendk3
 * @see SideProduct
 * @see id.backendk3.engifarm.product product
 */
public class EggBenedict extends SideProduct {

    /**
     * Konstruktor kelas EgBenedict
     */
    public EggBenedict() {
        super(ProductType.EggBenedictType, 600);
    }

    /**
     * Fungsi yang mengembalikan MyLinkedList produk yang berisi bahan pembuat EgBenedict
     *
     * @return MyLinkedList produk yang berisi bahan-bahan untuk membuat EgBenedict
     */
    public MyLinkedList<Product> getRecipe() {
        MyLinkedList<Product> recipe = new MyLinkedList<>();

        recipe.addFirst(new DuckEgg());
        recipe.addFirst(new RabbitMeat());
        recipe.addFirst(new GoatMilk());
        return recipe;
    }

    /**
     * Fungsi yang mengembalikan string untuk dirender yang merepresentasikan EgBenedict
     *
     * @return String untuk dirender yang akan ditampilkan dan merepresentasikan EgBenedict
     */
    public String render() {
        return "Egg Benedict";
    }
}