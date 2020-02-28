package test.java.com.testunit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import main.java.com.core.*;

public class ParkingLotTests {

    static CoreParkingLot coreParkingLot;

    @BeforeClass
    public static void initParkingLot () {
        coreParkingLot = new CoreParkingLot();
    }

    @Test 
    void createParkingLot() {
        String resp = coreParkingLot.createParkingLot(10);
        assertEquals("Created a parking lot with 10 slots", resp);
    }

    @Test 
    void park() {
        String resp = coreParkingLot.park("B-1234-CNN", "Black");
        assertEquals("Allocated slot number 1", resp);
    }

    @Test 
    void leave() {
        String resp = coreParkingLot.leave(1);
        assertEquals("Slot number 1 is free", resp);
    }

    @Test 
    void status() {
        String resp = coreParkingLot.status();
        assertNotEquals("null", resp);
    }

    @Test 
    void registrationNumbersforCarswithColour() {
        String resp = coreParkingLot.registrationNumbersforCarswithColour("Black");
        assertEquals("B-1234-CNN", resp);
    }

    @Test 
    void slotNumbersforCarswithColour() {
        String resp = coreParkingLot.slotNumbersforCarswithColour("Black");
        assertEquals("1", resp);
    }

    @Test
    void slotNumberforRegistrationNumber() {
        String resp = coreParkingLot.slotNumberforRegistrationNumber("B-1234-CNN");
        assertEquals("1", resp);
    }

}