package id.backendk3.engifarm;

import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.LinkedList;
import java.lang.RuntimeException;
import id.backendk3.engifarm.Farm;
import id.backendk3.engifarm.Product.*;
import id.backendk3.engifarm.Product.SideProduct.*;
import id.backendk3.engifarm.Cell.*;
import id.backendk3.engifarm.Cell.Land.*;
import id.backendk3.engifarm.Cell.Facility.*;
import id.backendk3.engifarm.FarmAnimal.*;

public class Player{
    private static class Resep{
        public static SideProduct getRecipe(Product.ProductType id){
            if (id == Product.ProductType.EggBenedictType){
                return new EggBenedict();
            } else if (id == Product.ProductType.MeatzaType){
                return new Meatza();
            } else if(id == Product.ProductType.BeefRoladeType){
                return new BeefRolade();
            } else {
                throw new RuntimeException("Enum Not Found");
            }
        }
    }
    private final int MAX_WATER = 50;
    private final int MAX_ITEM_BAG = 10;
    private int itemCount;
    private java.util.Map<Product,Integer> bag;
    private int water;
    private int money;
    private int posX;
    private int posY;

    public Player(){
        water = MAX_WATER;
        money = posX = posY = itemCount = 0;
        bag = new HashMap<Product,Integer>();
    }
    public Player(int water, int money, int posX,int posY){
        this.water = water;
        this.money = money;
        this.posX = posX;
        this.posY = posY;
        itemCount = 0;
        bag = new HashMap<Product,Integer>();
    }
    public java.util.Map<Product,Integer> getBag(){
        return bag;
    }
    public void addBag(Product p) {
        if (itemCount<MAX_ITEM_BAG){
            Integer tempCount = bag.get(p);
            if(tempCount!=null){
                tempCount++;
            }else{
                bag.put(p,1);
            }
            itemCount++;
        } else {
            throw new RuntimeException("Bag is full");
        }
    }
    public int getWater(){
        return water;
    }
    public int getMoney(){
        return money;
    }
    public int getX(){
        return posX;
    }
    public int getY(){
        return posY;
    }
    public void move(Farm.MoveType arah, ArrayList<Cell> surr){
        boolean move = false;
        switch (arah)
        {
            case Up:
                if(surr.get(Farm.MoveType.Up.getValue())!=null && !surr.get(Farm.MoveType.Up.getValue()).isOccupied()){
                    posY--;
                    move = true;
                    ((Land) surr.get(Farm.MoveType.Up.getValue())).occupy();
                }
                break;
            case Right:
                if(surr.get(Farm.MoveType.Right.getValue())!=null && !surr.get(Farm.MoveType.Right.getValue()).isOccupied()){
                    posX++;
                    move = true;
                    ((Land)surr.get(Farm.MoveType.Right.getValue())).occupy();
                }
                break;
            case Down:
                if(surr.get(Farm.MoveType.Down.getValue())!=null && !surr.get(Farm.MoveType.Down.getValue()).isOccupied()){
                    posY++;
                    move = true;
                    ((Land)surr.get(Farm.MoveType.Down.getValue())).occupy();
                }
                break;
            case Left:
                if(surr.get(Farm.MoveType.Left.getValue())!=null && !surr.get(Farm.MoveType.Left.getValue()).isOccupied()){
                    posX--;
                    move = true;
                    ((Land)surr.get(Farm.MoveType.Left.getValue())).occupy();
                }
                break;
            default:
                break;
        }
        if(!move){
            throw new RuntimeException("You can't move any further");
        } else {
            ((Land)surr.get(Farm.MoveType.Center.getValue())).unoccupy();
        }
    }
    public String talk(FarmAnimal hewan){
        return hewan.speak();
    }
    public void interact(FarmAnimal hewan){
        if (hewan.getEatStatus() && hewan.getHabitat()!=Cell.CellType.BarnType){
            addBag(hewan.getProduct());
            hewan.setEatStatus(false);
        } else {
            throw new RuntimeException("Can't interact with animal");
        }
    }
    public void interact(Well w){
        if(water<MAX_WATER)
            water = MAX_WATER;
        else
            throw new RuntimeException("Watering can is full");
    }
    public void interact(Truck truck){
        if(truck.isUsable()){
            if(itemCount>0){
                // for (std::map<std::shared_ptr<Product>,int>::iterator it = bag.begin();it!=bag.end();it++){
                //     money+= it->second * (it->first)->getHarga();
                // }
                for (Map.Entry<Product,Integer> entry : bag.entrySet()){
                    money += entry.getValue() * (entry.getKey().getHarga());
                }
                bag.clear();
    
                truck.use(15);
                itemCount=0;
            } else {
                throw new RuntimeException("No Product to sell");
            }
        }else{
            throw new RuntimeException("Truck is currently unusable");
        }
    }
    public void kill(FarmAnimal hewan){
        if (hewan.getHabitat()==Cell.CellType.BarnType && !hewan.getDeathStatus()){
            addBag(hewan.getProduct());
            hewan.setDeathStatus(true);
        } else {
            throw new RuntimeException("Can't kill animal");
        }
    }
    public void grow(Land l){
        if(water>0){
            if(!l.haveGrass()){
                l.addGrass();
                water--;
            } else {
                throw new RuntimeException("Land already have grass");
            }
        } else {
            throw new RuntimeException("Watering can is empty");
        }
    }
    public void mix(Product.ProductType id){
        if (itemCount<MAX_ITEM_BAG){
            SideProduct sp;
            try{
                sp = Resep.getRecipe(id);
            } catch (RuntimeException e){
                throw e;
            }
            LinkedList<Product> resep = sp.getRecipe();
            int i=0;
            boolean same = true;
            while(same && i <resep.size()){
                same = bag.containsKey(resep.get(i));
                i++;
            }
    
            if (same){
                for (int j=0;j<i;j++){
                    // std::map<std::shared_ptr<Product>,int>::iterator iter = bag.find(std::shared_ptr<Product>(resep.get(j)));
                    Product tempProduct = resep.get(j);
                    int count = bag.get(tempProduct);
                    if(count==1){
                        bag.remove(tempProduct);
                    }else{
                        bag.replace(tempProduct,count-1);
                    }
                }
                addBag(sp);
            } else {
                // throw new RuntimeException("Item in bag are not enough to make "+sp.render());
            }
        } else {
            throw new RuntimeException("Bag is full");
        }
    }
    // public String render(){
    //     return "P";
    // }

    
}