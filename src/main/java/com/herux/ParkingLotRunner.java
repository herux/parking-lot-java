package main.java.com.herux;

import java.io.BufferedReader;
import java.io.Console;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ParkingLotRunner {

    public void run(String[] args) {

        Console console = System.console(); 
        if(console == null)  { 
            System.out.print("Console unavailable"); 
            return; 
        } 

        String command = "";
        if (args.length > 0) {
            String filename = args[0];
            BufferedReader reader;
            try {
                reader = new BufferedReader(new FileReader(filename));
                command = reader.readLine();
                while (command != null) {
                    console.printf("command: %s\n", command);
                    command = reader.readLine();
                }
                reader.close();
            } catch (IOException e) {
                console.printf("%s file not found.", filename);
            } 
        } else {
            console.printf("=======================  \n");
            console.printf("PARKING LOT \n");
            console.printf("Author: heruxi@gmail.com \n");
            console.printf("------------------------  \n");
            while (true) {
                command = console.readLine("ParkingLot# ");
                if (command.equals("exit")) {
                    break;
                }
                
                String response = "";//responseCommand(command);
                console.printf(response + "\n");
            }
        }

    }

}