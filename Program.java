package sprint2;

import java.util.*;
import javax.swing.*;

public class Program {
    
    private final List<IPerson> personer;

    public Program() {
        Databas load = new Databas();
        load.Databas();
        personer = load.getPersoner();
    }
    
    public void run(){
        while (true) {
            String input = JOptionPane.showInputDialog("skriv in ett namn eller personnummer(10 siffror)");
            if (input == null || input.equals("")) {
                System.exit(0);
            }
            boolean funnen = false;
            for (IPerson person : personer) {
                if (person.compareNamn(input)||person.comparePersonnummer(input)) {
                    person.printKund();
                    if (person instanceof isKund) {
                        person.addToFile();
                    }
                    funnen = true;
                }
            }
            if (!funnen) {
                System.out.println("Personen finns inte i systemet");
            }
        }
    }
}
