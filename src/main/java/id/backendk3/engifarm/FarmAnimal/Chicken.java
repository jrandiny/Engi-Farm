package id.backendk3.engifarm.FarmAnimal;

import id.backendk3.engifarm.Product.*;
import id.backendk3.engifarm.Product.FarmProduct.*;
import id.backendk3.engifarm.Cell.Cell;

public class Chicken extends FarmAnimal{
    
    public Chicken(int _x, int _y){
        super(_x,_y,15,Cell.CellType.CoopType);
    }

    public String speak(){
        return "Cook-a-Doodle-Doo!";
    }

    public Product getProduct(){
        Product res = new ChickenEgg();
        return res;    
    }

    public String render(){
        return "C";
    }
}