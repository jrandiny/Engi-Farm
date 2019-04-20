package id.backendk3.engifarm;

import id.backendk3.engifarm.cell.Cell;
import id.backendk3.engifarm.cell.facility.Facility;
import id.backendk3.engifarm.cell.facility.Mixer;
import id.backendk3.engifarm.cell.facility.Truck;
import id.backendk3.engifarm.cell.facility.Well;
import id.backendk3.engifarm.cell.land.Barn;
import id.backendk3.engifarm.cell.land.Coop;
import id.backendk3.engifarm.cell.land.GrassLand;
import id.backendk3.engifarm.cell.land.Land;
import id.backendk3.engifarm.farmanimal.*;

import java.util.*;

/**
 * Kelas riil Farm turunan Observable
 *
 * <p>Kelas Farm merupakan kelas yang menyimpan data peta permainan dan memanipulasinya
 *
 * @author backendk3
 * @see id.backendk3.engifarm.cell.Cell
 * @see id.backendk3.engifarm.cell.facility
 * @see id.backendk3.engifarm.cell.land
 * @see id.backendk3.engifarm.farmanimal.FarmAnimal
 */
public class Farm extends Observable {

    /**
     * Tipe-tipe perintah move yang mungkin
     */
    public enum MoveType {
        /**
         * Tipe perintah move yang bergerak ke atas
         */
        Up(0),
        /**
         * Tipe perintah move yang bergerak ke kanan
         */
        Right(1),
        /**
         * Tipe perintah move yang bergerak ke kiri
         */
        Down(2),
        /**
         * Tipe perintah move yang bergerak ke bawah
         */
        Left(3),
        /**
         * Tipe posisi yang menunjukan posisi player seblum bergerak
         */
        Center(4);

        private final int VALUE;

        MoveType(int VALUE) {
            this.VALUE = VALUE;
        }

        /**
         * Fungsi yang mengembalikan nilai yang merepresentasikan pilihan tipe move
         *
         * @return nilai yang merepresentasikan pilihan tipe move
         */
        public int getValue() {
            return VALUE;
        }
    }

    private final int WIDTH;
    private final int HEIGHT;
    private ArrayList<ArrayList<Cell>> map;
    private LinkedHashSet<Facility> facilities;
    private ArrayList<FarmAnimal> farmAnimals;

    private void setCellMap(int xFrom, int yFrom, int xTo, int yTo, Cell.CellType type) {
        for (int j = yFrom; j <= yTo; j++) {
            for (int i = xFrom; i <= xTo; i++) {
                switch (type) {
                    case CoopType:
                        map.get(j).set(i, new Coop(i, j));
                        break;
                    case BarnType:
                        map.get(j).set(i, new Barn(i, j));
                        break;
                    case GrassLandType:
                        map.get(j).set(i, new GrassLand(i, j));
                        break;
                    default:
                        break;
                }
            }
        }
    }

    private void setFacility(int jumlah, Cell.CellType type) {
        int y = map.size();
        int x = map.get(0).size();
        int count = 0;
        while (count < jumlah) {
            int i = (int) (Math.random() * x);
            int j = (int) (Math.random() * y);
            if (!map.get(j).get(i).isOccupied()) {
                if (type == Cell.CellType.TruckType) {
                    Cell temp = new Truck(i, j);
                    map.get(j).set(i, temp);
                    Truck ptrTruck = (Truck) (temp);
                    facilities.add(ptrTruck);
                } else if (type == Cell.CellType.WellType) {
                    Cell temp = new Well(i, j);
                    map.get(j).set(i, temp);
                    Well ptrWell = (Well) (temp);
                    facilities.add(ptrWell);
                } else if (type == Cell.CellType.MixerType) {
                    Cell temp = new Mixer(i, j);
                    map.get(j).set(i, temp);
                    Mixer ptrMixer = (Mixer) (temp);
                    facilities.add(ptrMixer);
                }
                count++;
            }
        }
    }

    private void randomAnimalMap(int xFrom, int yFrom, int xTo, int yTo, Cell.CellType type, int jumlahHewan) {
        int count = 0;
        while (count < jumlahHewan) {
            int i = (int) (Math.random() * (xTo - xFrom + 1) + xFrom);
            int j = (int) (Math.random() * (yTo - yFrom + 1) + yFrom);
            int chance;
            if (!map.get(j).get(i).isOccupied()) {
                switch (type) {
                    case CoopType:
                        chance = (int) (Math.random() * 2);
                        if (chance == 1) {
                            farmAnimals.add(new Chicken(i, j));
                        } else {
                            farmAnimals.add(new Duck(i, j));
                        }
                        break;
                    case BarnType:
                        chance = (int) (Math.random() * 4);
                        if (chance == 1) {
                            farmAnimals.add(new Cow(i, j, type));
                        } else if (chance == 2) {
                            farmAnimals.add(new Goat(i, j, type));
                        } else if (chance == 3) {
                            farmAnimals.add(new Horse(i, j));
                        } else {
                            farmAnimals.add(new Rabbit(i, j));
                        }
                        break;
                    case GrassLandType:
                        chance = (int) (Math.random() * 2);
                        if (chance == 1) {
                            farmAnimals.add(new Cow(i, j, type));
                        } else {
                            farmAnimals.add(new Goat(i, j, type));
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

    private FarmAnimal findFarmAnimal(int x, int y) {
        int i = 0;
        while (i < farmAnimals.size()) {
            if (farmAnimals.get(i).getX() == x && farmAnimals.get(i).getY() == y) {
                return farmAnimals.get(i);
            } else {
                i++;
            }
        }
        return null;
    }

    /**
     * Konstruktor kelas Farm
     *
     * @param _WIDTH  lebar peta
     * @param _HEIGHT tinggi peta
     */
    public Farm(int _WIDTH, int _HEIGHT) {
        WIDTH = _WIDTH;
        HEIGHT = _HEIGHT;
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
        for (int j = 0; j < HEIGHT; j++) {
            map.add(new ArrayList<Cell>(WIDTH));
            for (int i = 0; i < WIDTH; i++) {
                map.get(j).add(null);
            }
        }

        x = (int) (Math.random() * (WIDTH / 4) + (WIDTH / 3));
        y = (int) (Math.random() * (HEIGHT / 4) + (HEIGHT / 3));
        Collections.shuffle(urutan);

        int luas;
        setCellMap(0, 0, x, y, urutan.get(0));
        luas = (x + 1) * (y + 1);
        randomAnimalMap(0, 0, x, y, urutan.get(0), (int) (Math.random() * (luas / DIVIDER) + MIN_ANIMAL));
        if (horizon) {
            setCellMap(0, y + 1, WIDTH - 1, HEIGHT - 1, urutan.get(1));
            setCellMap(x + 1, 0, WIDTH - 1, y, urutan.get(2));
            luas = (WIDTH) * (HEIGHT - y - 1);
            randomAnimalMap(0, y + 1, WIDTH - 1, HEIGHT - 1, urutan.get(1), (int) (Math.random() * (luas / DIVIDER) + MIN_ANIMAL));
            luas = (WIDTH - x - 1) * (y + 1);
            randomAnimalMap(x + 1, 0, WIDTH - 1, y, urutan.get(2), (int) (Math.random() * (luas / DIVIDER) + MIN_ANIMAL));
        } else {
            setCellMap(0, y + 1, x, HEIGHT - 1, urutan.get(1));
            setCellMap(x + 1, 0, WIDTH - 1, HEIGHT - 1, urutan.get(2));
            luas = (x + 1) * (HEIGHT - y - 1);
            randomAnimalMap(0, y + 1, x, HEIGHT - 1, urutan.get(1), (int) (Math.random() * (luas / DIVIDER) + MIN_ANIMAL));
            luas = (WIDTH - x - 1) * (HEIGHT);
            randomAnimalMap(x + 1, 0, WIDTH - 1, HEIGHT - 1, urutan.get(2), (int) (Math.random() * (luas / DIVIDER) + MIN_ANIMAL));
        }
        
        setFacility(1, Cell.CellType.TruckType);
        setFacility(1, Cell.CellType.WellType);
        setFacility(1, Cell.CellType.MixerType);

        setChanged();
        notifyObservers();
    }

    /**
     * Fungsi yang mengembalikan peta
     *
     * @return peta
     */
    public ArrayList<ArrayList<Cell>> getMap() {
        return map;
    }

    /**
     * Fungsi yang mengembalikan array yang berisi cell-cell di sekitar posisi player
     *
     * @param x Posisi X
     * @param y Posisi Y
     * @return array yang berisi cell-cell di sekitar posisi player
     */
    public Cell[] getSurrounding(int x, int y) {
        Cell[] result = new Cell[5];
        if (y > 0) { //up
            result[MoveType.Up.getValue()] = map.get(y - 1).get(x);
        } else {
            result[MoveType.Up.getValue()] = null;
        }

        if (x + 1 < WIDTH) { //right
            result[MoveType.Right.getValue()] = map.get(y).get(x + 1);
        } else {
            result[MoveType.Right.getValue()] = null;
        }

        if (y + 1 < HEIGHT) { //down
            result[MoveType.Down.getValue()] = map.get(y + 1).get(x);
        } else {
            result[MoveType.Down.getValue()] = null;
        }

        if (x > 0) { //left
            result[MoveType.Left.getValue()] = map.get(y).get(x - 1);
        } else {
            result[MoveType.Left.getValue()] = null;
        }

        //center
        result[MoveType.Center.getValue()] = map.get(y).get(x);

        return result;
    }

    /**
     * Fungsi yang mengembalikan objek Animal yang berada sesuai dengan perintah move yang diberikan
     *
     * @param x         posisi X
     * @param y         posisi Y
     * @param direction perintah move
     * @return Objek Animal jika ditemukan dan berada pada posisi yang sesuai dengan perintah move
     */
    public FarmAnimal getAnimals(int x, int y, MoveType direction) {
        Cell[] surr = getSurrounding(x, y);
        int[] deltaX = {0, 1, 0, -1};
        int[] deltaY = {-1, 0, 1, 0};
        if (surr[direction.getValue()].isOccupied()) {
            // mungkin hewan
            FarmAnimal temp = findFarmAnimal(x + deltaX[direction.getValue()], y + deltaY[direction.getValue()]);
            return temp;
        }
        return null;

    }

    /**
     * Fungsi yang mengembalikan objek facility yang berada sesuai dengan perintah move yang diberikan
     *
     * @param x         posisi X
     * @param y         posisi Y
     * @param direction perintah move
     * @return Objek facility jika ditemukan dan berada pada posisi yang sesuai dengan perintah move
     */
    public Facility getFacilities(int x, int y, MoveType direction) {
        Cell[] surr = getSurrounding(x, y);
        try {
            return (Facility) surr[direction.getValue()];
        } catch (ClassCastException e) {
            return null;
        }
    }

    /**
     * Fungsi yang mengembalikan suatu list yang berisi hewan yang ada pada peta
     *
     * @return list yang berisi hewan yang ada pada peta
     */
    public ArrayList<FarmAnimal> getFarmAnimals() {
        return farmAnimals;
    }

    /**
     * Method yang menghapus cell yang ditempati hewan yang sudah mati
     */
    public void cleanFarmAnimal() {
        Iterator<FarmAnimal> it = farmAnimals.iterator();

        while (it.hasNext()) {
            FarmAnimal el = it.next();
            if (el.getDeathStatus()) {
                ((Land) (map.get(el.getY()).get(el.getX()))).unoccupy();
                it.remove();
            }
        }
        setChanged();
        notifyObservers();
    }

    /**
     * Method pengecekan yang dilakukan per satu satuan tick
     */
    public void oneTick() {
        for (FarmAnimal el : farmAnimals) {
            boolean chance = Math.random() >= 0.7;
            if (chance || !el.getEatStatus()) {
                Cell[] surr = getSurrounding(el.getX(), el.getY());
                el.moveRandom(surr);
            }
            el.tick();
        }

        for (ArrayList<Cell> row : map) {
            for (Cell el : row) {
                el.tick();
            }
        }

        cleanFarmAnimal();

        setChanged();
        notifyObservers();
    }
}