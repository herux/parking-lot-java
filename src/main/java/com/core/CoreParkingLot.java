package main.java.com.core;

import java.util.ArrayList;

import main.java.com.models.Park;
import main.java.com.models.Slot;

public class CoreParkingLot {

    private Park park;

    /**
     * @return the park
     */
    public Park getPark() {
        return park;
    }

    public String responseCommand(String cmdArgs) {
        String result = "";
        String[] argsArr = cmdArgs.split(" "); 

        Command command;
        try{
            command = Command.valueOf(argsArr[0].toUpperCase());
        } catch (IllegalArgumentException e) {
            return "Command not found";  
        } 

        try {
            switch (command) {
                case CREATE_PARKING_LOT:
                    int count = Integer.parseInt(argsArr[1]);
                    result = createParkingLot(count);
                    break;
                case LEAVE:
                    int slotNum = Integer.parseInt(argsArr[1]);
                    result = leave(slotNum);
                    break;
                case PARK:
                    String plateNumber = argsArr[1];
                    String color = argsArr[2];
                    result = park(plateNumber, color);
                    break;
                case REGISTRATION_NUMBERS_FOR_CARS_WITH_COLOUR:
                    result = registrationNumbersforCarswithColour();
                    break;
                case STATUS:
                    result = status();
                    break;
                case SLOT_NUMBERS_FOR_CARS_WITH_COLOUR:
                    result = slotNumbersforCarswithColour();
                    break;
                case SLOT_NUMBER_FOR_REGISTRATION_NUMBER: 
                    result = slotNumberforRegistrationNumber();
                    break;
                default:
                    break;
            }    
        } catch (Exception e) {
            return e.getMessage();
        }

        return result;
    }

    private String createParkingLot (int count) {
        Slot[] slots = new Slot[count];
        for (int i = 0; i < slots.length; i++) {
            slots[i] = new Slot();
        }
        park = new Park(slots);
        return "Created a parking lot with " + park.getSlots().length + " slots";
    }

    private String leave(int slotNum) {
        Slot slot = park.getSlots()[slotNum - 1];
        slot.setPlateNumber(null);
        slot.setColor(null);
        return "Slot number "+slotNum+" is free";
    }

    private String park(String plateNumber, String color) {
        for (int i = 0; i < park.getSlots().length; i++) {
            Slot slot = park.getSlots()[i]; 
            if (slot.getPlateNumber() == null) {
                slot.setPlateNumber(plateNumber);
                slot.setColor(color);
                return "Allocated slot number " + (i + 1);
            }
        }
        return "Sorry, parking lot is full ";
    }

    private String registrationNumbersforCarswithColour() {
        return "";
    }

    private String status() {
        String result = "Slot No.   Registration No   Colour \n";
        for (int i = 0; i < park.getSlots().length; i++) {
            Slot slot = park.getSlots()[i]; 
            if (slot.getPlateNumber() != null) { 
                String sTmp = Integer.toString(i + 1) + "           " + slot.getPlateNumber() +
                 "                  " + slot.getColor(); 
                result = result + sTmp + "\n";
            }
        }
        return result;
    }

    private String slotNumbersforCarswithColour() {
        return "";
    }

    private String slotNumberforRegistrationNumber() {
        return "";
    }

}