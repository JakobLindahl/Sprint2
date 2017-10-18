package sprint2;

import java.io.*;
import java.nio.file.*;
import static java.nio.file.StandardOpenOption.*;
import java.time.*;

public abstract class Person implements IPerson {

    private final Path log = Paths.get("src\\sprint2\\log.txt");

    private final String namn;
    private final String personnummer;

    public Person(String personnummer, String namn) {
        this.namn = namn;
        this.personnummer = personnummer;
    }

    protected String getNamn() {
        return namn;
    }

    protected String getPersonnummer() {
        return personnummer;
    }
    

    @Override
    public void addToFile() {
        try (PrintWriter output = new PrintWriter(Files.newBufferedWriter(log, CREATE, APPEND))) {
            output.append(toFile());

        } catch (IOException e) {
            System.out.println("Något gick med output strömmen till log filen");
        }

    }

    @Override
    public Boolean comparePersonnummer(String personnummer) {
        personnummer = personnummer.replace("-", "").trim();
        
        if (personnummer.length()==12) {
            personnummer= personnummer.substring(2);
        }
        return this.personnummer.equals(personnummer);
    }

    @Override
    public Boolean compareNamn(String namn) {
        return this.namn.equalsIgnoreCase(namn.trim());
    }

    private String toFile() {
        return getPersonnummer() + ", " + getNamn() + "\n" + LocalDate.now() + "\n";
    }
}
