package src;

import java.util.ArrayList;
import java.util.List;

public class Invoice {

    private Customer customer;
    private List<Service> serviceList;
    private double totalAmount;

    public Invoice(Customer customer) {//, List<Service> serviceList, double totalAmount) {
        this.customer = customer;
        this.serviceList = new ArrayList<>();//serviceList;
        this.totalAmount = 0;//totalAmount;
    }

    public void addService(Service service) {
        serviceList.add(service);
        totalAmount += service.getPrice();
    }

    //to print invoice
    public void printInvoive() {
        System.out.println("---------Invoice---------");
        System.out.println("Customer: " + customer.getName() + " | Phone: " + customer.getPhone() + " | Car: " + customer.getCar().getModel() + " | Number: " + customer.getCar().getCarNumber());
        System.out.println();
        System.out.println("Services: ");
        for (int i = 0; i < serviceList.size(); i++) {
            System.out.println((i + 1) + ". " + serviceList.get(i).getName() + " - rs" + serviceList.get(i).getPrice());
        }
        //for finding list of services v use loop
        /*for(Service service:serviceList){
            System.out.println("# "+service.getName()+": rs"+service.getPrice());
        }*/
        System.out.println("Total Amount: " + totalAmount);
        System.out.println();
        System.out.println("-------------THANK YOU VISIT AGAIN-------------");
    }
}
