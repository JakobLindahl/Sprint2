package sprint2;

import java.io.*;
import java.nio.file.*;
import java.time.*;
import java.util.*;

public class Databas{

    private final Path customers = Paths.get("src\\sprint2\\customers.txt");
    private final LocalDate yearago = LocalDate.now().minusYears(1);
    private final LocalDate future = LocalDate.now().plusDays(1);

    private final List<IPerson> personer = new ArrayList<>();

    public void Databas(){

        try (BufferedReader br = Files.newBufferedReader(customers);) {

            String firstline;
            String secondline;
            while ((firstline = br.readLine()) != null && (secondline = br.readLine()) != null) {
                firstline = firstline.trim();
                String[] personnummernamn = firstline.split(", ");
                LocalDate datum = LocalDate.parse(secondline.trim());

                Person person = makePerson(personnummernamn, datum);
                try {
                    addPerson(person);
                } catch (NullPointerException e) {
                    System.out.println(e.getMessage());
                }

            }
        } catch (FileNotFoundException e) {
            System.out.println("det gick inte att hitta filen");
        } catch (IOException ex) {
            System.out.println("Något gick fel med input strömmen som läser customer filen");
        }
    }

    public List<IPerson> getPersoner() {
        return personer;
    }

    public void addPerson(Person person) throws NullPointerException {
        if (person != null) {
            personer.add(person);
        } else {
            throw new NullPointerException("En person gick inte att skapa och blev ej tillaggd i listan");
        }
    }

    public Person makePerson(String[] personnummerNamn, LocalDate datum) {
        Person person = null;
        String personnummmer = personnummerNamn[0].trim();
        String namn = personnummerNamn[1].trim();

        if (datum.isAfter(yearago) && datum.isBefore(future)) {
            person = new isKund(personnummmer, namn);
        } else if (datum.isBefore(yearago) || datum.isEqual(yearago)) {
            person = new beenKund(personnummmer, namn);
        }
        return person;
    }
}
