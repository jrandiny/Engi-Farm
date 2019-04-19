package id.backendk3.engifarm;

import id.backendk3.engifarm.cell.Cell;
import id.backendk3.engifarm.cell.facility.Truck;
import id.backendk3.engifarm.cell.facility.Well;
import id.backendk3.engifarm.cell.land.Coop;
import id.backendk3.engifarm.cell.land.Land;
import id.backendk3.engifarm.Farm.MoveType;
import id.backendk3.engifarm.farmanimal.Chicken;
import id.backendk3.engifarm.farmanimal.Cow;
import id.backendk3.engifarm.farmanimal.Duck;
import id.backendk3.engifarm.product.farmproduct.ChickenEgg;
import id.backendk3.engifarm.product.farmproduct.CowMilk;
import id.backendk3.engifarm.product.farmproduct.DuckEgg;
import id.backendk3.engifarm.product.Product;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    @Test
    public void testConstructor() {
        Player p = new Player(10, 5, 0, 0, MoveType.Up);
        assertEquals(10, p.getWater(), "Wrong water amount");
        assertEquals(5, p.getMoney(), "Wrong money count");
        assertEquals(0, p.getX(), "Wrong position X");
        assertEquals(0, p.getY(), "Wrong position Y");
    }

    @Test
    public void testMove() {
        Player p = new Player(0, 0, 5, 5, MoveType.Up);
        Farm map = new Farm(10, 10);
        Cell[] surr = map.getSurrounding(p.getX(), p.getY());

        int posX = p.getX();
        int posY = p.getY();

        int[] dirX = {0, 1, 0, -1};
        int[] dirY = {-1, 0, 1, 0};
        ArrayList<MoveType> move = new ArrayList<>(Arrays.asList(
                MoveType.Up, MoveType.Right, MoveType.Down, MoveType.Left));
        Collections.shuffle(move);
        MoveType arah = move.get(0);

        if (surr[arah.getValue()].isOccupied()) {
            if (p.getDirection() == arah) {
                assertThrows(RuntimeException.class, () -> p.move(arah, surr), "Wrong move");
            } else {
                p.move(arah, surr);
            }
            assertEquals(posX, p.getX(), "Wrong position X");
            assertEquals(posY, p.getY(), "Wrong position Y");
        } else {
            p.move(arah, surr);
            posX += dirX[arah.getValue()];
            posY += dirY[arah.getValue()];
            assertEquals(posX, p.getX(), "Wrong position X");
            assertEquals(posY, p.getY(), "Wrong position Y");
        }
        assertEquals(arah, p.getDirection(), "Wrong player direction");
    }

    @Test
    public void testTalk() {
        Player p = new Player(0, 0, 0, 0, MoveType.Up);
        Chicken chick = new Chicken(0, 0);
        assertEquals("Cook-a-Doodle-Doo!", p.talk(chick), "Wrong talk prosedure");
    }

    @Test
    public void testAddBag() {
        Player p = new Player(0, 0, 0, 0, MoveType.Up);
        int count = 0;

        p.addBag(new ChickenEgg());
        p.addBag(new ChickenEgg());
        p.addBag(new CowMilk());
        Map<Product, Integer> bag = p.getBag();
        assertEquals(2, bag.size(), "Wrong item kind");
        for (Map.Entry<Product, Integer> it : bag.entrySet()) {
            count += it.getValue();
        }
        assertEquals(3, count, "Wrong count");
    }

    @Test
    public void testMaxBagItem() {
        Player p = new Player(0, 0, 0, 0, MoveType.Up);
        int count = 0;

        for (int i = 0; i < 3; i++) { // 9 item
            p.addBag(new ChickenEgg());
            p.addBag(new DuckEgg());
            p.addBag(new CowMilk());
        }
        p.addBag(new ChickenEgg()); // item ke 10

        assertThrows(RuntimeException.class, () -> p.addBag(new CowMilk()), "Wrong add bag CowMilk");
        Map<Product, Integer> bag = p.getBag();
        assertEquals(3, bag.size(), "Wrong item kind");
        for (Map.Entry<Product, Integer> it : bag.entrySet()) {
            count += it.getValue();
        }
        assertEquals(10, count, "Wrong count");
    }

    @Test
    public void testBagItemCheck() {
        Player p = new Player(0, 0, 0, 0, MoveType.Up);
        int count = 0;
        for (int i = 0; i < 3; i++) {
            p.addBag(new ChickenEgg());
            p.addBag(new DuckEgg());
            p.addBag(new CowMilk());
        }
        Map<Product, Integer> bag = p.getBag();
        assertEquals(3, bag.size(), "Wrong item kind");

        for (Map.Entry<Product, Integer> it : bag.entrySet()) {
            String temp = "";
            switch (count) {
                case 0:
                    temp = "Chicken Egg";
                    break;
                case 1:
                    temp = "Cow Milk";
                    break;
                case 2:
                    temp = "Duck Egg";
                    break;
            }
            count++;
            assertEquals(temp, it.getKey().render(), "Wrong item render");
            assertEquals(3, it.getValue(), "Wrong item value");
        }
    }

    @Test
    public void testInteractAnimal() {
        Player p = new Player(0, 0, 0, 0, MoveType.Up);
        Chicken chick = new Chicken(0, 0);
        Cow tank = new Cow(0, 1, Cell.CellType.GrassLandType);
        Cow tanky = new Cow(0, 1, Cell.CellType.BarnType);
        Duck donald = new Duck(1, 0);
        int count = 0;

        p.interact(chick);
        p.interact(tank);
        assertThrows(RuntimeException.class, () -> p.interact(tanky), "Wrong interact cow");
        p.interact(donald);
        chick.setHaveProduct(true);
        tank.setHaveProduct(true);
        tanky.setHaveProduct(true);
        donald.setHaveProduct(true);
        p.interact(chick);
        p.interact(tank);
        assertThrows(RuntimeException.class, () -> p.interact(tanky), "Wrong interact cow");
        p.interact(donald);
        Map<Product, Integer> bag = p.getBag();
        assertEquals(3, bag.size(), "Wrong item kind");
        for (Map.Entry<Product, Integer> it : bag.entrySet()) {
            count += it.getValue();
        }
        assertEquals(6, count, "Wrong count");
    }

    @Test
    public void testInteractWell() {
        Player p = new Player(20, 0, 0, 0, MoveType.Up);
        Well w = new Well(0, 1);

        assertEquals(20, p.getWater(), "Wrong water amount");
        p.interact(w);
        assertEquals(50, p.getWater(), "Wrong water amount");
    }

    @Test
    public void testInteractTruck() {
        Player p = new Player(0, 0, 0, 0, MoveType.Up);
        Truck t = new Truck(0, 1);
        Truck t2 = new Truck(1, 0);
        Chicken chick = new Chicken(0, 2);

        for (int i = 0; i < 3; i++) {
            p.interact(chick);
            chick.setHaveProduct(true);
        }
        assertTrue(t.isUsable(), "Wrong usable truck");
        p.interact(t);
        assertEquals(300, p.getMoney(), "Wrong money count");
        assertFalse(t.isUsable(), "Wrong usable truck");
        assertThrows(RuntimeException.class, () -> p.interact(t), "Wrong interact");

        assertThrows(RuntimeException.class, () -> p.interact(t2), "Wrong interact");
    }

    @Test
    public void testKill() {
        Player p = new Player(0, 0, 0, 0, MoveType.Up);
        Cow desk = new Cow(0, 1, Cell.CellType.GrassLandType);
        Cow top = new Cow(0, 1, Cell.CellType.BarnType);
        Truck t = new Truck(0, 1);

        assertThrows(RuntimeException.class, () -> p.kill(desk), "Wrong kill");
        p.kill(top);
        assertThrows(RuntimeException.class, () -> p.kill(top), "Wrong kill");
        p.interact(t);
        assertEquals(100, p.getMoney(), "Wrong money amount");
        assertFalse(desk.getDeathStatus(), "Wrong deathStatus");
        assertTrue(top.getDeathStatus(), "Wrong deathStatus");
    }

    @Test
    public void testGrow() {
        Player p = new Player(10, 0, 0, 0, MoveType.Up);
        Land land = new Coop(2, 0);

        land.removeGrass();
        assertFalse(land.haveGrass(), "Wrong grass status");
        p.grow(land);
        assertTrue(land.haveGrass(), "Wrong grass status");
    }

    @Test
    public void testMix() {
        Player p = new Player(0, 0, 0, 0, MoveType.Up);
        Truck t = new Truck(0, 1);
        Cow tank = new Cow(0, 1, Cell.CellType.BarnType);
        Chicken chick = new Chicken(1, 0);

        p.interact(chick);
        p.kill(tank);

        p.mix(Product.ProductType.BeefRoladeType);
        p.interact(t);
        assertEquals(400, p.getMoney(), "Wrong money amount");

        try {
            p.mix(Product.ProductType.BeefRoladeType);
        } catch (RuntimeException e) {
            assertEquals("Item in bag are not enough to make Beef Rolade", e.getMessage(), "Wrong render product");
        }

        for (int i = 0; i < 10; i++) {
            chick.setEatStatus(true);
            p.interact(chick);
        }
        try {
            p.mix(Product.ProductType.EggBenedictType);
        } catch (RuntimeException e) {
            assertEquals("Bag is full", e.getMessage(), "Wrong condition bag full");
        }
    }
}
