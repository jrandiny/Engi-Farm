package id.backendk3.engifarm.FarmAnimal;

import id.backendk3.engifarm.Product.*;
import id.backendk3.engifarm.Product.FarmProduct.*;
import id.backendk3.engifarm.Cell.Cell;
import java.awt.Color;
import java.awt.Image;


public class Rabbit extends FarmAnimal{
    
    public Rabbit(int _x, int _y){
        super(_x,_y,20,Cell.CellType.BarnType);
    }

    public String speak(){
        return "Purr purr..!";
    }

    public Product getProduct(){
        Product res = new RabbitMeat();
        setHaveProduct(false);
        return res;    
    }

    public String render(){
        return "R";
    }
}