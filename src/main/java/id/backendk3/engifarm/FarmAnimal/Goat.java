package id.backendk3.engifarm.FarmAnimal;

import id.backendk3.engifarm.Product.*;
import id.backendk3.engifarm.Product.FarmProduct.*;
import id.backendk3.engifarm.Cell.Cell;

public class Goat extends FarmAnimal{
    
    public Goat(int _x, int _y,Cell.CellType _type){
        super(_x,_y,20,_type);
    }

    public String speak(){
        return "Blet blet..!";
    }

    public Product getProduct(){
        Product res;
        if(habitat==Cell.CellType.BarnType){
            res=new GoatMeat();
        }else if(habitat==Cell.CellType.GrassLandType){
            res=new GoatMilk();
        }else{
            throw new RuntimeException("Error no matching habitat type");
        }    
        setHaveProduct(false);
        return res;
    }

    public String render(){
        return "D";
    }
}