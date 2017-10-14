package sprint2;

import java.io.*;
import java.nio.file.*;
import java.time.*;
import java.util.*;

public class Databas {

    private static final Path customers = Paths.get("src\\sprint2\\customers.txt");
    private static final LocalDate yearago = LocalDate.now().minusYears(1);

    private List<IPerson> personer = new ArrayList<>();

    public Databas(){

        try (BufferedReader br = Files.newBufferedReader(customers);){
            
            String firstline;
            String secondline;
            
            while ((firstline = br.readLine().trim()) != null && (secondline = br.readLine()) != null) {
                
                String[] personnummernamn = firstline.split(", ");
                LocalDate datum = LocalDate.parse(secondline.trim());
                
                Person person = makePerson(personnummernamn, datum);
                try {
                    addPerson(person);
                } catch (NullPointerException e) {
                    System.out.println("Personen " + personnummernamn[1] + " gick inte att skapa och blev ej tillaggd i listan");
                }
                
            }
        } catch (IOException e) {
            System.out.println("något gick fel");
        }

    }

    public List<IPerson> getPersoner() {
        return personer;
    }

    public void addPerson(Person person)throws NullPointerException{
        if (person != null) {
            personer.add(person);
        }else{
            throw new NullPointerException();
        }
    }

    public Person makePerson(String[] personnummerNamn, LocalDate datum) {
        Person person;
        String personnummmer = personnummerNamn[0].trim();
        String namn = personnummerNamn[1].trim();

        if (datum.isAfter(yearago)) {
            person = new isKund(personnummmer,namn);
        } else {
            person = new beenKund(personnummmer,namn);
        }
        return person;
    }
}
