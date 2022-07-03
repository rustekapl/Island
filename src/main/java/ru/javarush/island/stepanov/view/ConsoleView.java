package ru.javarush.island.stepanov.view;

import ru.javarush.island.stepanov.controllers.SimulationController;

import java.util.Scanner;

public class ConsoleView {

    public static final String EXIT_MESSAGE = "\nExit due to user input.\n";
    private final SimulationController simulationController = new SimulationController();
    private String settingsFileName = "stepanov/Settings.json";
    private String loggingLevel = "GENERALIZED";

    public void run(){
        Scanner scanner = new Scanner(System.in);
        this.printWelcome();

        String action;
        do {
            action = this.getActionParam(scanner);
        } while(!(this.translateAction(action, scanner)));

    }

    private boolean translateAction(String action, Scanner scanner){
        if (action.equals("exit")){
            System.out.println(EXIT_MESSAGE);
            return true;
        } else if (action.equals("setsettings")){
            this.setSettingsFileName(scanner);
            return false;
        } else if (action.equals("logs")) {
            this.setLoggingLevel(scanner);
            return false;
        } else if (action.equals("run")) {
            simulationController.startSimulation(this.settingsFileName, this.loggingLevel);
            return true;
        } else {
            System.out.println();
            System.out.println("Unknown command! Follow instructions");
            System.out.println();
            return false;
        }
    }

    private void printWelcome(){
        System.out.println();
        System.out.println("********************************************************");
        System.out.println("* Welcome to Island Simulation - Console Runner!       *");
        System.out.println("* Please fill the following parameters to run the app  *");
        System.out.println("*            Print 'exit' to exit the app              *");
        System.out.println("********************************************************");
        System.out.println();
        System.out.println("Default settings are stored in Settings.json file.");
        System.out.println("Default output stored in logs folder in file with current date.");
    }

    private String getActionParam(Scanner scanner){
        System.out.println("! Select work mode (run, settings, logs, exit). Exit by Default : ");
        System.out.println();
        String action = scanner.nextLine();
        if (action.equals("")){
            action="exit";
        }
        return action.toLowerCase();
    }

    private boolean setLoggingLevel(Scanner scanner){
        do {
            System.out.println("Please enter new logging level.");
            System.out.println("The default log level is GENERALIZED");
            System.out.println("The options are: GENERALIZED for logging to file and writing to console only totals.");
            System.out.println("The options are: EVENT for logging to file each event (WARNING: big log file may be generated).");
            System.out.println();
            this.loggingLevel = scanner.nextLine().toUpperCase();

        } while (!(this.checkLoggingLevel(this.loggingLevel)));

        System.out.println("New logging level is " + this.loggingLevel + ".");
        System.out.println();

        return true;
    }

    private boolean setSettingsFileName(Scanner scanner){

        do {
            System.out.println("Please enter new settings file name.");
            System.out.println("Make sure that file is in RESOURCES folder.");
            System.out.println();
            this.settingsFileName = scanner.nextLine();

        } while (!(this.checkFileExistsInResources(this.settingsFileName)));

        System.out.println("Now settings will be read from " + settingsFileName + " file.");
        System.out.println();

        return true;
    }

    private boolean checkLoggingLevel(String levelName){
        if (
                !(levelName.toUpperCase().equals("GENERALIZED")) &&
                !(levelName.toUpperCase().equals("EVENT"))
        ){
            System.out.println("No such logging level. Follow the instructions!");
            System.out.println();
            return false;
        }
        return true;
    }

    private boolean checkFileExistsInResources(String fileName){
        if (ConsoleView.class.getResource("/" + fileName) == null){
            System.out.println("No such file is in resources!");
            System.out.println();
            return false;
        }
        return true;
    }
}
