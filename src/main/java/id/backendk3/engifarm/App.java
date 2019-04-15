package id.backendk3.engifarm;

import java.util.ArrayList;
import java.util.Map;
import id.backendk3.engifarm.View.AppView;
import id.backendk3.engifarm.View.MapView;
// import id.backendk3.engifarm.*;
import id.backendk3.engifarm.Cell.*;
import id.backendk3.engifarm.Cell.Facility.*;
import id.backendk3.engifarm.Cell.Land.*;
import id.backendk3.engifarm.FarmAnimal.*;
// import id.backendk3.engifarm.Product.*;
// import id.backendk3.engifarm.Product.FarmProduct.*;
// import id.backendk3.engifarm.Product.SideProduct.*;
import id.backendk3.engifarm.Product.Product;
import id.backendk3.engifarm.Product.FarmProduct.ChickenEgg;

/**
 * Hello world!
 *
 */
public class App 
{   
    public static void main( String[] args )
    {
        AppView myAppView;
        myAppView = new AppView();

        MapView mv = myAppView.getMap();
        
        Farm myFarm = new Farm(8,8);

        myFarm.addObserver(mv);

        myFarm.testObs();

        // myFarm.



        while(true){}
        // Farm map = new Farm(8,8);
        // Player p = initPlayer(map);

        // printHelp();
        // while(true){
        //     updateFarm(map, p);
        //     updateStatusPlayer(p);
        //     String error = "";
        //     String out = "";
        //     String input;
        //     Scanner in = new Scanner(System.in);
        //     boolean action = false;
        //     System.out.print("input: ");
        //     input = in.nextLine().toLowerCase();
        //     // System.out.println(input);
        //     Cell[] surr = map.getSurrounding(p.getX(),p.getY());
        //     try {
        //         if(input.equals("exit") || input.equals("q")){
        //             break;
        //         } else if(input.equals("w")){
        //             p.move(Farm.MoveType.Up,surr);
        //             action = true;
        //         } else if(input.equals("d")){
        //             p.move(Farm.MoveType.Right,surr);
        //             action = true;
        //         } else if(input.equals("s")){
        //             p.move(Farm.MoveType.Down,surr);
        //             action = true;
        //         } else if(input.equals("a")){
        //             p.move(Farm.MoveType.Left,surr);
        //             action = true;
        //         } else if(input.equals("e")){
        //             p.grow((Land)(map.getMap().get(p.getY()).get(p.getX())));
        //             action = true;
        //         } else if(input.equals("h")){
        //             printHelp();
        //         } else if(input.equals("f")){
        //             FarmAnimal animal = map.getAnimals(p.getX(), p.getY(), p.getDirection());
        //             if(animal!=null){
        //                 //ada animal di arahnya
        //                 System.out.println("1. Talk");
        //                 System.out.println("2. Interract");
        //                 System.out.println("3. Kill");
        //                 int choose;
        //                 do{
        //                     System.out.print("Choose action: ");
        //                     choose = in.nextInt();
        //                 }while(choose<=0 || choose>3);
        //                 switch (choose) {
        //                     case 1:
        //                         out = p.talk(animal);
        //                         break;
        //                     case 2:
        //                         p.interact(animal);
        //                         break;
        //                     case 3:
        //                         p.kill(animal);
        //                         break;
        //                     default:
        //                         break;
        //                 }
        //                 action = true;
        //             } else {
        //                 //tidak ada animal
        //                 Facility facility = map.getFacilities(p.getX(), p.getY(),p.getDirection());
        //                 if(facility != null){
        //                     // ada facility
        //                     switch (facility.getType()){
        //                         case MixerType:
        //                             System.out.println("1. Beef Rolade");
        //                             System.out.println("2. Egg Benedict");
        //                             System.out.println("3. Meatza");
        //                             int choose;
        //                             do{
        //                                 System.out.print("Choose side product: ");
        //                                 choose = in.nextInt();
        //                             }while(choose<=0 || choose>3);
        //                             switch (choose) {
        //                                 case 1:
        //                                     p.mix(Product.ProductType.BeefRoladeType);
        //                                     break;
        //                                 case 2:
        //                                     p.mix(Product.ProductType.EggBenedictType);
        //                                     break;
        //                                 case 3:
        //                                     p.mix(Product.ProductType.MeatzaType);
        //                                     break;
        //                                 default:
        //                                     break;
        //                             }
        //                             break;
        //                         case TruckType:
        //                             p.interact((Truck)facility);
        //                             break;
        //                         case WellType:
        //                             p.interact((Well) facility);
        //                             break;
        //                         default:
        //                             break;
        //                     }
        //                     action = true;
        //                 }
        //             }
        //         } else {
        //             error = "wrong command";
        //         }
        //     } catch (Exception e) {
        //         error = e.getMessage();
        //     }
            
        //     if(error.length()>0){
        //         System.out.println("Error: "+error);
        //     }
        //     if(out.length()>0){
        //         System.out.println("Out: "+out);
        //     }
        //     if(action){
        //         map.oneTick();
        //     }
        // }
    }

    
    public static Player initPlayer(Farm map){
        ArrayList<ArrayList<Cell>> temp = map.getMap();
        final int INIT_WATER = 50;
        final int INIT_MONEY = 0;
        int initX, initY;
        do {
            initX = (int) (Math.random()*temp.get(0).size());
            initY = (int) (Math.random()*temp.size());
        } while (temp.get(initY).get(initX).isOccupied());
        return  new Player(INIT_WATER,INIT_MONEY,initX,initY,Farm.MoveType.Up);
    }

    public static void updateStatusPlayer(Player p){
        Map<Product,Integer> bag = p.getBag();
        System.out.println("Water: "+p.getWater());
        System.out.println("Money: "+p.getMoney());
        if(bag.isEmpty()){
            System.out.println("Bag emtpy");
        } else {
            int count=1;
            System.out.println("Item in Bag:");
            for(Map.Entry<Product,Integer> el : bag.entrySet()){
                System.out.println(count +". "+el.getKey().render()+ " @ "+ el.getValue());
                count++;
            }
        }
    }

    public static void printHelp(){
        System.out.println("INFO:");
        System.out.println("q = exit");
        System.out.println("w = up");
        System.out.println("d = right");
        System.out.println("s = down");
        System.out.println("a = left");
        System.out.println("e = grow");
        System.out.println("f = action");
        System.out.println("h = help");
    }
}
