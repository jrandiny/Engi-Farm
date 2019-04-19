package id.backendk3.engifarm;

import id.backendk3.engifarm.cell.Cell;
import id.backendk3.engifarm.farmanimal.*;
import id.backendk3.engifarm.product.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FarmAnimalTest {
    @Test
    public void testTalk() {
        Chicken ayam = new Chicken(0, 0);
        Duck bebek = new Duck(0, 0);
        Horse kuda = new Horse(0, 0);
        Rabbit kelinci = new Rabbit(0, 0);
        Cow sapi = new Cow(0, 0, Cell.CellType.BarnType);
        Goat kambing = new Goat(0, 0, Cell.CellType.BarnType);
        assertEquals("Cook-a-Doodle-Doo!", ayam.speak(), "Wrong chicken voice");
        assertEquals("Quack quack..!", bebek.speak(), "Wrong duck voice");
        assertEquals("Nay nay!", kuda.speak(), "Wrong horse voice");
        assertEquals("Purr purr..!", kelinci.speak(), "Wrong rabbit voice");
        assertEquals("Moooooooo..!", sapi.speak(), "Wrong cow voice");
        assertEquals("Blet blet..!", kambing.speak(), "Wrong goat voice");
    }

    @Test
    public void testProduct() {
        Chicken ayam = new Chicken(0, 0);
        Duck bebek = new Duck(0, 0);
        Horse kuda = new Horse(0, 0);
        Rabbit kelinci = new Rabbit(0, 0);
        Cow sapibarn = new Cow(0, 0, Cell.CellType.BarnType);
        Cow sapigrass = new Cow(0, 0, Cell.CellType.GrassLandType);
        Goat kambingbarn = new Goat(0, 0, Cell.CellType.BarnType);
        Goat kambinggrass = new Goat(0, 0, Cell.CellType.GrassLandType);
        assertEquals(Product.ProductType.ChickenEggType, ayam.getProduct().getType(), "Wrong chicken product");
        assertEquals(Product.ProductType.DuckEggType, bebek.getProduct().getType(), "Wrong duck product");
        assertEquals(Product.ProductType.HorseMeatType, kuda.getProduct().getType(), "Wrong horse product");
        assertEquals(Product.ProductType.RabbitMeatType, kelinci.getProduct().getType(), "Wrong rabbit product");
        assertEquals(Product.ProductType.CowMeatType, sapibarn.getProduct().getType(), "Wrong grass-cow product");
        assertEquals(Product.ProductType.CowMilkType, sapigrass.getProduct().getType(), "Wrong barn-cow product");
        assertEquals(Product.ProductType.GoatMeatType, kambingbarn.getProduct().getType(), "Wrong grass-goat product");
        assertEquals(Product.ProductType.GoatMilkType, kambinggrass.getProduct().getType(), "Wrong barn-goat product");
    }

    @Test
    public void testLocation() {
        Chicken ayam = new Chicken(1, 2);
        Duck bebek = new Duck(3, 4);
        Horse kuda = new Horse(5, 6);
        Rabbit kelinci = new Rabbit(7, 8);
        Cow sapi = new Cow(9, 10, Cell.CellType.BarnType);
        Goat kambing = new Goat(11, 12, Cell.CellType.BarnType);
        assertEquals(1, ayam.getX(), "Wrong x position of chicken");
        assertEquals(2, ayam.getY(), "Wrong y position of chicken");
        assertEquals(3, bebek.getX(), "Wrong x position of duck");
        assertEquals(4, bebek.getY(), "Wrong y position of duck");
        assertEquals(5, kuda.getX(), "Wrong x position of horse");
        assertEquals(6, kuda.getY(), "Wrong y position of horse");
        assertEquals(7, kelinci.getX(), "Wrong x position of rabbit");
        assertEquals(8, kelinci.getY(), "Wrong y position of rabbit");
        assertEquals(9, sapi.getX(), "Wrong x position of cow");
        assertEquals(10, sapi.getY(), "Wrong y position of cow");
        assertEquals(11, kambing.getX(), "Wrong x position of goat");
        assertEquals(12, kambing.getY(), "Wrong y position of goat");
    }
}
