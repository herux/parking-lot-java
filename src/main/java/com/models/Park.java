package main.java.com.models;

import java.util.ArrayList;

public class Park {

    private int maxLot;
    private ArrayList<Slot> slots; 

    public void Park(int maxLot, ArrayList<Slot> slots) {
        this.maxLot = maxLot;
        this.slots  = slots; 
    }

    /**
     * @return the slots
     */
    public ArrayList<Slot> getSlots() {
        return slots;
    }

    /**
     * @param slots the slots to set
     */
    public void setSlots(ArrayList<Slot> slots) {
        this.slots = slots;
    }

    /**
     * @return the maxLot
     */
    public int getMaxLot() {
        return maxLot;
    }

    /**
     * @param maxLot the maxLot to set
     */
    public void setMaxLot(int maxLot) {
        this.maxLot = maxLot;
    }

}