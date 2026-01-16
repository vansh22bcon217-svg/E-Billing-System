package src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class GarageService {

    private Map<String, Customer> customerMap;
    private List<Service> availableService;

    public GarageService() {//Map<String,Customer> customers, List<Service> availableService) {
        //initialisation of hashmap and arraylist so that inventory also made so that it can add new new and available services
        this.customerMap = new HashMap<>();
        this.availableService = new ArrayList<>();
        loadServices();
    }

    public void loadServices() {
        availableService.add(new Service("Car Wash", 500));
        availableService.add(new Service("Oil Change", 700));
        availableService.add(new Service("Wheel Alignment", 300));
        availableService.add(new Service("Tyre Replacement", 3000));
        availableService.add(new Service("Puncture", 50));
    }

    //adding customer to your service center
    public void addCustomer(String name, String phone, String carNumber, String model) {
        //customer is dpendent on car
        Car car = new Car(carNumber, model);
        //one to one dependxency
        Customer customer = new Customer(name, phone, car);
        //putting customer in map
        customerMap.put(carNumber, customer);
        System.out.println("Customer added successfully!!");
    }

    public void createInvoice(String carNumber) {
        if (!customerMap.containsKey(carNumber)) {
            System.out.println("No customer found with car number: " + carNumber);
            return;
        }
        Scanner sc = new Scanner(System.in);
        Customer customer = customerMap.get(carNumber);
        Invoice invoice = new Invoice(customer);
        System.out.println("Available services: ");
        for (int i = 0; i < availableService.size(); i++) {
            System.out.println((i + 1) + ". " + availableService.get(i).getName() + " - rs" + availableService.get(i).getPrice());
        }
        while (true) {
            System.out.println("Enter service number to add (or 0 to finish): ");
            int choice = sc.nextInt();
            if (choice == 0) {
                break;
            }
            if (choice > 0 && choice <= availableService.size()) {
                invoice.addService(availableService.get(choice - 1));
                System.out.println("Service done!!");
            } else {
                System.out.println("invalid choice!!");
            }
        }
        invoice.printInvoive();
    }
}
