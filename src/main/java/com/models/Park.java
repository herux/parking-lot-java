package main.java.com.models;

import java.util.ArrayList;

public class Park {

    private Slot[] slots; 

    public Park(Slot[] slots) {
        this.slots  = slots; 
	}

    /**
     * @return the slots
     */
    public Slot[] getSlots() {
        return slots;
    }

    /**
     * @param slots the slots to set
     */
    public void setSlots(Slot[] slots) {
        this.slots = slots;
    }

}