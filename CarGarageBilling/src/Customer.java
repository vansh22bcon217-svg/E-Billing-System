package src;
public class Customer {

    private String name;
    private String phone;
    //jb car ka obj ho tb hi customer ka obj create ho
    private Car car; //this shows relationship between customer and car (ki customer owns a car )

    public Customer(String name, String phone, Car car) {
        this.name = name;
        this.phone = phone;
        this.car = car;
    }

    public String getName() {
        return this.name;
    }

    //remove setter method so that no one is able to change your details
    public String getPhone() {
        return this.phone;
    }

    public Car getCar() {
        return this.car;
    }

}
