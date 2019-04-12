package id.backendk3.engifarm.FarmAnimal;

import id.backendk3.engifarm.Product.*;
import id.backendk3.engifarm.Product.FarmProduct.*;
import id.backendk3.engifarm.Cell.Cell;

public class Duck extends FarmAnimal{
    
    public Duck(int _x, int _y){
        super(_x,_y,15,Cell.CellType.CoopType);
    }

    public String speak(){
        return "Quack quack..!";
    }

    public Product getProduct(){
        Product res = new DuckEgg();
        return res;    
    }

    public String render(){
        return "D";
    }
}