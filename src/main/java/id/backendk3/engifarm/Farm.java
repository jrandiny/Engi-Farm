package id.backendk3.engifarm;

// import java.util.LinkedList;
import java.util.Observable;
import java.util.LinkedHashSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
import id.backendk3.engifarm.Cell.Cell;
import id.backendk3.engifarm.Cell.Facility.*;
import id.backendk3.engifarm.Cell.Land.*;
// import id.backendk3.engifarm.Cell.Land.Land;
import id.backendk3.engifarm.FarmAnimal.*;

public class Farm extends Observable{
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

    public void testObs(){
        setChanged();
        notifyObservers();
    }

    private final int WIDTH;
    private final int HEIGHT;
    private ArrayList<ArrayList<Cell>> map;
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
        // System.out.println("in");
        while(count<jumlah){
            // System.out.println(count);
            int i = (int) (Math.random()*x);
            int j = (int) (Math.random()*y);
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
                        chance = (int) (Math.random()*2);
                        if(chance==1){
                            farmAnimals.add(new Chicken(i,j));
                        }else{
                            farmAnimals.add(new Duck(i,j));
                        }
                        break;
                    case BarnType:
                        chance = (int) (Math.random()*4);
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
                        chance = (int) (Math.random()*2);
                        if(chance==1){
                            farmAnimals.add(new Cow(i,j,type));
                        }else{
                            farmAnimals.add(new Goat(i,j,type));
                        }
                        break;
                    default:
                        break;
                }
                Land temp = (Land) (map.get(j).get(i));
                temp.occupy();
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
        return null;
    }

    public Farm(int _WIDTH, int _HEIGHT){
        WIDTH=_WIDTH;
        HEIGHT=_HEIGHT;
        farmAnimals = new ArrayList<>();
        facilities = new LinkedHashSet<>();

        int x, y;
        boolean horizon = Math.random() < 0.5;
        final int DIVIDER = 4;
        final int MIN_ANIMAL = 2;
        ArrayList<Cell.CellType> urutan = new ArrayList<Cell.CellType>(
            Arrays.asList(
                Cell.CellType.BarnType,
                Cell.CellType.CoopType,
                Cell.CellType.GrassLandType
            )
        );
        map = new ArrayList<ArrayList<Cell>>(HEIGHT);
        for(int j=0;j<HEIGHT;j++){
            map.add(new ArrayList<Cell>(WIDTH));
            for(int i=0;i<WIDTH;i++){
                map.get(j).add(null);
            }
        }

        x = (int)(Math.random()*(WIDTH/4)+(WIDTH/3));
        y = (int)(Math.random()*(HEIGHT/4)+(HEIGHT/3));
        Collections.shuffle(urutan);

        int luas;
        setCellMap(0,0,x,y,urutan.get(0));
        luas = (x+1)*(y+1);
        randomAnimalMap(0,0,x,y,urutan.get(0),(int) (Math.random()*(luas/DIVIDER)+MIN_ANIMAL));
        if(horizon){
            setCellMap(0,y+1,WIDTH-1,HEIGHT-1,urutan.get(1));
            setCellMap(x+1,0,WIDTH-1,y,urutan.get(2));
            luas = (WIDTH)*(HEIGHT-y-1);
            randomAnimalMap(0,y+1,WIDTH-1,HEIGHT-1,urutan.get(1),(int) (Math.random()*(luas/DIVIDER)+MIN_ANIMAL));
            luas = (WIDTH-x-1)*(y+1);
            randomAnimalMap(x+1,0,WIDTH-1,y,urutan.get(2),(int) (Math.random()*(luas/DIVIDER)+MIN_ANIMAL));
        } else {
            setCellMap(0,y+1,x,HEIGHT-1,urutan.get(1));
            setCellMap(x+1,0,WIDTH-1,HEIGHT-1,urutan.get(2));
            luas = (x+1)*(HEIGHT-y-1);
            randomAnimalMap(0,y+1,x,HEIGHT-1,urutan.get(1),(int) (Math.random()*(luas/DIVIDER)+MIN_ANIMAL));
            luas = (WIDTH-x-1)*(HEIGHT);
            randomAnimalMap(x+1,0,WIDTH-1,HEIGHT-1,urutan.get(2),(int) (Math.random()*(luas/DIVIDER)+MIN_ANIMAL));
        }
        // System.out.println("init cell");
        setFacility(1,Cell.CellType.TruckType);
        setFacility(1,Cell.CellType.WellType);
        setFacility(1,Cell.CellType.MixerType);
        // System.out.println("init facility");

        notifyObservers();
    }

    // public void setMap(LinkedList<LinkedList<Cell>> in){

    // }

    public ArrayList<ArrayList<Cell>> getMap(){
        return map;
    }

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
        int[] deltaX = {0,1,0,-1};
        int[] deltaY = {-1,0,1,0};
        if(surr[direction.getValue()].isOccupied()){
            // mungkin hewan
            FarmAnimal temp = findFarmAnimal(x + deltaX[direction.getValue()],y+deltaY[direction.getValue()]);
            return temp;
        }
        return null;

    }

    // public Facility[] getSurroundFacilities(int x, int y, Cell.CellType type){

    // }

    public Facility getFacilities(int x, int y, MoveType direction){
        Cell[] surr = getSurrounding(x, y);
        try{
            return (Facility) surr[direction.getValue()];
        } catch (ClassCastException e){
            return null;
        }
    }

    public ArrayList<FarmAnimal> getFarmAnimals(){
        return farmAnimals;
    }

    public void oneTick(){
        for(int i=0;i<farmAnimals.size();i++){
            if(farmAnimals.get(i).getDeathStatus()){
                ((Land) (map.get(farmAnimals.get(i).getY()).get(farmAnimals.get(i).getX()))).unoccupy();
                farmAnimals.remove(i);
            } else {
                boolean chance = Math.random() >= 0.6;
                if(chance || !farmAnimals.get(i).getEatStatus()){
                    Cell[] surr = getSurrounding(farmAnimals.get(i).getX(),farmAnimals.get(i).getY());
                    farmAnimals.get(i).moveRandom(surr);
                }
                // farmAnimals[i].tick();
            }
        }
        // for(int i=0;i<(int)truck.size();i++){
        //     truck[i]->tick();
        // }
    }
}