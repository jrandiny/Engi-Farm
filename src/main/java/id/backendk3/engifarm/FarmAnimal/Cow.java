package id.backendk3.engifarm.FarmAnimal;

import id.backendk3.engifarm.Product.*;
import id.backendk3.engifarm.Product.FarmProduct.*;
import id.backendk3.engifarm.Cell.Cell;

public class Cow extends FarmAnimal{
    
    public Cow(int _x, int _y, Cell.CellType _type){
        super(_x,_y,15,_type);
    }

    public String speak(){
        return "Moooooooo..!";
    }

    public Product getProduct(){
        if(habitat==Cell.CellType.BarnType){
            Product res = new CowMeat();
            return res;    
        }else if(habitat==Cell.CellType.GrassLandType){
            Product res = new CowMilk();
            return res;    
        }else{
            throw new RuntimeException("Ga mungkin bang");
        }


    }

    public String render(){
        return "O";
    }
}