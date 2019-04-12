package id.backendk3.engifarm.FarmAnimal;

import id.backendk3.engifarm.Product.*;
import id.backendk3.engifarm.Product.FarmProduct.*;
import id.backendk3.engifarm.Cell.Cell;

public class Horse extends FarmAnimal{
    
    public Horse(int _x, int _y){
        super(_x,_y,20,Cell.CellType.BarnType);
    }

    public String speak(){
        return "Nay nay!";
    }

    public Product getProduct(){
        Product res = new HorseMeat();
        setHaveProduct(false);
        return res;    
    }

    public String render(){
        return "H";
    }
}