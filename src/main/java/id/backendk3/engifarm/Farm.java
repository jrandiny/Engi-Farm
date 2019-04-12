package id.backendk3.engifarm;

import java.util.LinkedList;
import java.util.LinkedHashSet;
import java.util.ArrayList;
import id.backendk3.engifarm.Cell.Cell;
import id.backendk3.engifarm.Cell.Facility.*;
import id.backendk3.engifarm.Cell.Land.*;
// import id.backendk3.engifarm.Cell.Land.Land;
import id.backendk3.engifarm.FarmAnimal.*;

public class Farm{
    public enum MoveType{
        Up(0),Right(1),Down(2),Left(3),Center(4); 
    
        private final int VALUE;
        private MoveType(int VALUE) {
            this.VALUE = VALUE;
        }
    
        public int getValue() {
            return VALUE;
        }
    }

    private final int WIDTH;
    private final int HEIGHT;
    private LinkedList<LinkedList<Cell>> map;
    private LinkedHashSet<Facility> facilities;
    private ArrayList<FarmAnimal> farmAnimals;
    
    private void setCellMap(int xFrom, int yFrom, int xTo, int yTo, Cell.CellType type){
        for(int j=yFrom;j<=yTo;j++){
            for(int i=xFrom;i<=xTo;i++){
                switch(type){
                    case CoopType: 
                        map.get(j).set(i,new Coop(i,j));
                        break;
                    case BarnType:
                        map.get(j).set(i,new Barn(i,j));
                        break;
                    case GrassLandType:
                        map.get(j).set(i,new GrassLand(i,j));
                        break;
                    default:
                        break;
                }
                // Land temp = (Land) (map.get(j).get(i));
                // temp.addGrass();
            }
        }
    }
    private void setFacility(int jumlah, Cell.CellType type){
        int y = map.size();
        int x = map.get(0).size();
        int count = 0;
        while(count<jumlah){
            int i = (int) Math.random()*x;
            int j = (int) Math.random()*y;
            if(!map.get(j).get(i).isOccupied()){
                if(type==Cell.CellType.TruckType){
                    Cell temp = new Truck(i,j);
                    map.get(j).set(i,temp);
                    Truck ptrTruck = (Truck) (temp);
                    facilities.add(ptrTruck); 
                }else if(type==Cell.CellType.WellType){
                    Cell temp = new Well(i,j);
                    map.get(j).set(i,temp);
                    Well ptrWell = (Well) (temp);
                    facilities.add(ptrWell);
                }else if(type==Cell.CellType.MixerType){
                    Cell temp = new Mixer(i,j);
                    map.get(j).set(i,temp);
                    Mixer ptrMixer = (Mixer) (temp);
                    facilities.add(ptrMixer);
                }
                count++;
            }
        }
    }
    private void randomAnimalMap(int xFrom, int yFrom, int xTo, int yTo, Cell.CellType type, int jumlahHewan){
        int count = 0;

        while(count<jumlahHewan){
            int i = (int)(Math.random()*(xTo-xFrom+1)+xFrom);
            int j = (int)(Math.random()*(yTo-yFrom+1)+yFrom);
            int chance;
            if(!map.get(j).get(i).isOccupied()){
                switch(type){
                    case CoopType:
                        chance = (int) Math.random()*2;
                        if(chance==1){
                            farmAnimals.add(new Chicken(i,j));
                        }else{
                            farmAnimals.add(new Duck(i,j));
                        }
                        break;
                    case BarnType:
                        chance = (int) Math.random()*4;
                        if(chance==1){
                            farmAnimals.add(new Cow(i,j,type));
                        }else if(chance==2){
                            farmAnimals.add(new Goat(i,j,type));
                        }else if(chance==3){
                            farmAnimals.add(new Horse(i,j));
                        }else{
                            farmAnimals.add(new Rabbit(i,j));
                        }
                        break;
                    case GrassLandType:
                        chance = (int) Math.random()*2;
                        if(chance==1){
                            farmAnimals.add(new Cow(i,j,type));
                        }else{
                            farmAnimals.add(new Goat(i,j,type));
                        }
                        break;
                    default:
                        break;
                }
                // Land temp = (Land) (map.get(j).get(i));
                // temp.addGrass();
                count++;
            }
        }
    }
    private FarmAnimal findFarmAnimal(int x, int y){
        int i =0;
        while(i<farmAnimals.size()){
            if(farmAnimals.get(i).getX()==x && farmAnimals.get(i).getY()==y){
                return farmAnimals.get(i);
            } else {
                i++;
            }            
        }
        throw new RuntimeException("No Animal Found");
    }

    public Farm(int _WIDTH, int _HEIGHT){
        WIDTH=_WIDTH;
        HEIGHT=_HEIGHT;
    }

    // public void setMap(LinkedList<LinkedList<Cell>> in){

    // }

    // public LinkedList<LinkedList<Cell>> getMap(){ //will iyahh ?

    // }

    public Cell[] getSurrounding(int x, int y){
        Cell[] result = new Cell[5];
        if(y>0){ //up
            result[MoveType.Up.getValue()]=map.get(y-1).get(x);
        }else{
            result[MoveType.Up.getValue()]=null;
        }

        if(x+1<WIDTH){ //right
            result[MoveType.Right.getValue()]=map.get(y).get(x+1);
        }else{
            result[MoveType.Right.getValue()]=null;
        }

        if(y+1<HEIGHT){ //down
            result[MoveType.Down.getValue()]=map.get(y+1).get(x);
        }else{
            result[MoveType.Down.getValue()]=null;
        }

        if(x>0){ //left
            result[MoveType.Left.getValue()]=map.get(y).get(x-1);
        }else{
            result[MoveType.Left.getValue()]=null;
        }

        //center
        result[MoveType.Center.getValue()] = map.get(y).get(x);
 
        return result;
    }

    // public Mixer getMixer(int x, int y){
    //     boolean found=false;
    //     Mixer result=null;
    //     Iterator<Facility> iter=facilities.iterator();
    //     while(iter.hasNext() && !found){
    //         Facility temp=iter.next();
    //         if(temp.getX()==x && temp.getY()==y && temp.getType()==Cell.CellType.MixerType){
    //             found=true;
    //             result=(Mixer) temp;
    //         }
    //     }
    //     if(found){
    //         return result;
    //     }else{
    //         throw new RuntimeException("No MixerFound");
    //     }
    // }

    // public Truck getTruck(int x, int y){
    //     boolean found=false;
    //     Truck result=null;
    //     Iterator<Facility> iter=facilities.iterator();
    //     while(iter.hasNext() && !found){
    //         Facility temp=iter.next();
    //         if(temp.getX()==x && temp.getY()==y && temp.getType()==Cell.CellType.TruckType){
    //             found=true;
    //             result=(Mixer) temp;
    //         }
    //     }
    //     if(found){
    //         return result;
    //     }else{
    //         throw new RuntimeException("No MixerFound");
    //     }
    // }

    // public Well getWell(int x, int y){
    //     boolean found=false;
    //     Mixer result=null;
    //     Iterator<Facility> iter=facilities.iterator();
    //     while(iter.hasNext() && !found){
    //         Facility temp=iter.next();
    //         if(temp.getX()==x && temp.getY()==y && temp.getType()==Cell.CellType.MixerType){
    //             found=true;
    //             result=(Mixer) temp;
    //         }
    //     }
    //     if(found){
    //         return result;
    //     }else{
    //         throw new RuntimeException("No MixerFound");
    //     }
    // }

    // public FarmAnimal getFarmAnimal(int x, int y){}

    // public FarmAnimal[] getSurroundAnimals(int x, int y){

    // }
    public FarmAnimal getAnimals(int x, int y, MoveType direction){
        Cell[] surr = getSurrounding(x, y);
        if(surr[direction.getValue()].isOccupied()){
            // mungkin hewan
            FarmAnimal temp = findFarmAnimal(x, y);
            if(temp!= null){
                return temp;
            } else {
                throw new RuntimeException("No Animal Found");
            }
        } else {
            throw new RuntimeException("No Animal Found");
        }

    }

    // public Facility[] getSurroundFacilities(int x, int y, Cell.CellType type){

    // }

    public Facility getFacilities(int x, int y, MoveType direction){
        Cell[] surr = getSurrounding(x, y);
        try{
            return (Facility) surr[direction.getValue()];
        } catch (ClassCastException e){
            throw new RuntimeException("No Facility Found");
        }
    }

    public ArrayList<FarmAnimal> getFarmAnimals(){
        return farmAnimals;
    }

    // public void oneTick(){}
}