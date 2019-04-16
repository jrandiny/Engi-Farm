package id.backendk3.engifarm.Product.FarmProduct;

import id.backendk3.engifarm.Product.FarmProduct.FarmProduct;

/**
 * Kelas riil RabbitMeat turunan FarmProduct
 * RabbitMeat adalah Product yang dihasilkan oleh object animal Rabbit
 */
public class RabbitMeat extends FarmProduct{

    /**
     * Konstruktor kelas RabbitMeat
     */
    public RabbitMeat(){
        super(ProductType.RabbitMeatType, 100);
    }

    /**
    * Fungsi yang mengembalikan string untuk dirender yang merepresentasikan RabbitMeat
    * @return String untuk dirender yang akan ditampilkan dan merepresentasikan RabbitMeat
    */
    public String render(){
        return "Rabbit Meat";
    }
}