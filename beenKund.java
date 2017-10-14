package sprint2;


public class beenKund extends Person{

    public beenKund(String personnummer, String namn) {
        super(personnummer, namn);
    }

    @Override
    public void printKund() {
        System.out.println("Personen har varit kund hos oss");
    }

}
