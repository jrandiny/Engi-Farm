package id.backendk3.engifarm;

import id.backendk3.engifarm.cell.Cell;
import id.backendk3.engifarm.cell.facility.Mixer;
import id.backendk3.engifarm.cell.facility.Truck;
import id.backendk3.engifarm.cell.facility.Well;
import id.backendk3.engifarm.Farm.MoveType;
import id.backendk3.engifarm.farmanimal.Cow;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FacilityTest {
    @Test
    void testConstructor() {
        Mixer a = new Mixer(0, 0);
        Truck b = new Truck(1, 1);
        Well c = new Well(2, 2);

        assertEquals(0, a.getX(), "PositionX of Mixer Failed");
        assertEquals(0, a.getY(), "PosiitionY of Mixer Failed");
        assertTrue(a.isOccupied(), "Mixer must be occupied");
        assertEquals(Cell.CellType.MixerType, a.getType(), "Mixer Type Failed");

        assertEquals(1, b.getX(), "PositionX of Truck Failed");
        assertEquals(1, b.getY(), "PositionY of Truck Failed");
        assertTrue(b.isOccupied(), "Truck must be occupied");
        assertEquals(Cell.CellType.TruckType, b.getType(), "Truck Type Failed");

        assertEquals(2, c.getX(), "PositionX of Well Failed");
        assertEquals(2, c.getY(), "PosiitionY of Well Failed");
        assertTrue(c.isOccupied(), "Well must be occupied");
        assertEquals(Cell.CellType.WellType, c.getType(), "Well Type Failed");
    }

    @Test
    void testIsUsable() {
        Mixer a = new Mixer(0, 0);
        Truck b = new Truck(1, 1);
        Well c = new Well(2, 2);

        assertTrue(a.isUsable(), "Mixer must be usable");
        assertTrue(b.isUsable(), "Truck must be usable");
        assertTrue(c.isUsable(), "Well must be usable");

        Player d = new Player(10, 5, 0, 1, MoveType.Up);
        Cow e = new Cow(0, 2, Cell.CellType.BarnType);

        d.kill(e);
        d.interact(b);
        assertFalse(b.isUsable(), "Truck must be unable to use");
    }
}