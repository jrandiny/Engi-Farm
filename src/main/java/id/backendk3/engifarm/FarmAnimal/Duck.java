package id.backendk3.engifarm.FarmAnimal;

import id.backendk3.engifarm.Product.*;
import id.backendk3.engifarm.Product.FarmProduct.*;
import id.backendk3.engifarm.Cell.Cell;
import java.awt.Color;
import java.awt.Image;


public class Duck extends FarmAnimal{
    
    public Duck(int _x, int _y){
        super(_x,_y,20,Cell.CellType.CoopType);
    }

    public String speak(){
        return "Quack quack..!";
    }

    public Product getProduct(){
        Product res = new DuckEgg();
        setHaveProduct(false);
        return res;    
    }

    public String render(){
        return "D";
    }
}