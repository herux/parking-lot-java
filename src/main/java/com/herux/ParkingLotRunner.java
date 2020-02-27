package main.java.com.herux;

import java.io.BufferedReader;
import java.io.Console;
import java.io.FileReader;
import java.io.IOException;
import main.java.com.core.*;

public class ParkingLotRunner {

    public void run(String[] args) {

        Console console = System.console(); 
        if(console == null)  { 
            System.out.print("Console unavailable"); 
            return; 
        } 

        String cmdArgs = "";
        CoreParkingLot corepl = new CoreParkingLot();
        console.printf("=======================  \n");
        console.printf("PARKING LOT \n");
        console.printf("Author: heruxi@gmail.com \n");
        console.printf("------------------------  \n");
        if (args.length > 0) {
            String filename = args[0];
            BufferedReader reader;
            try {
                reader = new BufferedReader(new FileReader(filename));
                cmdArgs = reader.readLine();
                while (cmdArgs != null) {
                    String response = corepl.responseCommand(cmdArgs);
                    console.printf(response + "\n");
                    cmdArgs = reader.readLine();
                }
                reader.close();
            } catch (IOException e) {
                console.printf("%s file not found.", filename);
            } 
        } else {
            while (true) {
                cmdArgs = console.readLine("ParkingLot# ");
                if (cmdArgs.equals("exit")) {
                    break;
                }
                
                String response = corepl.responseCommand(cmdArgs);
                console.printf(response + "\n");
            }
        }

    }

}