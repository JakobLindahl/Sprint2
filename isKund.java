package sprint2;

public class isKund extends Person {

    public isKund(String personnummer, String namn) {
        super(personnummer, namn);
    }

    @Override
    public void printKund() {
        System.out.println(getNamn() + " är en nuvarande kund hos oss");
    }

}
