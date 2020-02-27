package main.java.com.core;

public class Corepl {

    public String responseCommand(String strCommand) {
        Command command;
        try{
            command = Command.valueOf(strCommand);
        } catch (IllegalArgumentException e) {
            return "Command not found";  
        } 

        return command.toString();
    }

}