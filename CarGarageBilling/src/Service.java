package src;

public class Service {

    private String name;
    private double price;

//agr constructor nhi hoga to value restrict kaise hogi
    public Service(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {

        return price;
    }

}
