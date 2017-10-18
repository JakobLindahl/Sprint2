package sprint2;

public class beenKund extends Person {

    public beenKund(String personnummer, String namn) {
        super(personnummer, namn);
    }

    @Override
    public void printKund() {
        System.out.println(getNamn() + " har varit kund hos oss");
    }

}
