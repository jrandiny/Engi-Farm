package id.backendk3.engifarm;

import id.backendk3.engifarm.cell.facility.Mixer;
import id.backendk3.engifarm.cell.facility.Truck;
import id.backendk3.engifarm.cell.facility.Well;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FarmTest {
    @Test
    public void testConstructor() {
        Farm farm = new Farm(10, 9);
        assertEquals(10, farm.getMap().get(0).size(), "Wrong width");
        assertEquals(9, farm.getMap().size(), "Wrong height");
    }

    @Test
    public void testGetFacility() {
        Farm farm = new Farm(6, 6);
        boolean found = false;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                try {
                    Mixer mix = (Mixer) farm.getMap().get(i).get(j);
                    found = true;
                } catch (Exception e) {

                }
            }
        }
        assertTrue(found, "Mixer not found");

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                try {
                    Truck truck = (Truck) farm.getMap().get(i).get(j);
                    found = true;
                } catch (Exception e) {

                }
            }
        }
        assertTrue(found, "Truck not found");

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                try {
                    Well well = (Well) farm.getMap().get(i).get(j);
                    found = true;
                } catch (Exception e) {

                }
            }
        }
        assertTrue(found, "Well not found");


    }
}