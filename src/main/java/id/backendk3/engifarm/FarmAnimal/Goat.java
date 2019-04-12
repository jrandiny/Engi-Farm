package id.backendk3.engifarm.FarmAnimal;

import id.backendk3.engifarm.Product.*;
import id.backendk3.engifarm.Product.FarmProduct.*;
import id.backendk3.engifarm.Cell.Cell;

public class Goat extends FarmAnimal{
    
    public Goat(int _x, int _y,Cell.CellType _type){
        super(_x,_y,15,_type);
    }

    public String speak(){
        return "Blet blet..!";
    }

    public Product getProduct(){
        if(habitat==Cell.CellType.BarnType){
            Product res=new GoatMeat();
            return res;
        }else if(habitat==Cell.CellType.GrassLandType){
            Product res=new GoatMilk();
            return res;
        }else{
            throw new RuntimeException("Error no matching habitat type");
        }    
    }

    public String render(){
        return "D";
    }
}