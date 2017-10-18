package sprint2;

public interface IPerson {

    public Boolean compareNamn(String namnorpers);
    public Boolean comparePersonnummer(String namnorpers);

    public abstract void printKund();
    
    public void addToFile();

}
