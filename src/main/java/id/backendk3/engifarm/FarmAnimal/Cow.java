package id.backendk3.engifarm.FarmAnimal;

import id.backendk3.engifarm.Product.*;
import id.backendk3.engifarm.Product.FarmProduct.*;
import id.backendk3.engifarm.Cell.Cell;
import java.awt.Color;
import java.awt.Image;

public class Cow extends FarmAnimal{
    
    public Cow(int _x, int _y, Cell.CellType _type){
        super(_x,_y,20,_type);
    }

    public String speak(){
        return "Moooooooo..!";
    }

    public Product getProduct(){
        Product res;
        if(habitat==Cell.CellType.BarnType){
            res = new CowMeat();
        }else if(habitat==Cell.CellType.GrassLandType){
            res = new CowMilk();
        }else{
            throw new RuntimeException("Ga mungkin bang");
        }
        setHaveProduct(false);
        return res;    


    }

    public String render(){
        return "O";
    }
}