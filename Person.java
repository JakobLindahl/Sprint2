package sprint2;

import java.io.*;
import java.nio.file.*;
import java.nio.file.StandardOpenOption;
import java.time.*;

public abstract class Person implements IPerson {

    public Path log = Paths.get("src\\sprint2\\log.txt");

    private final String namn;
    private final String personnummer;

    public Person(String personnummer, String namn) {
        this.namn = namn;
        this.personnummer = personnummer;
    }

    private void addToFile() {
        try (PrintWriter output = new PrintWriter(Files.newBufferedWriter(log, StandardOpenOption.CREATE, StandardOpenOption.APPEND))) {
            output.append(toFile());

        } catch (IOException e) {
            System.out.println("Något gick fel vid inläsningen av filen");
        }

    }
    @Override
    public Boolean compare(String namnorpers){
        if (comparePersonnummer(namnorpers)||compareNamn(namnorpers)) {
            addToFile();
            return true;
        }
        return false;
    }

    public Boolean comparePersonnummer(String personnummer) {
        return this.personnummer.equals(personnummer.trim().replace("-", ""));
    }

    public Boolean compareNamn(String namn) {
        return this.namn.equalsIgnoreCase(namn.trim());
    }

    private String toFile() {
        return namn + ", " + personnummer + "\n" + LocalDate.now() + "\n";
    }
}
