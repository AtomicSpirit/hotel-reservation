package service;
import model.Customer; // alt + enter over Customer

// alt + enter over Collection, Map and HashMap
import java.util.*;
public class CustomerService {

    private static CustomerService customerService = null;

    //Constructor
    private static CustomerService getInstance(){
        if(customerService == null){
            CustomerService customerService = new CustomerService();
        }
        return customerService;
    }


    private  Set<Customer> customerSet = new HashSet<>();


    public void addCustomer(String email, String firstName, String lastName){
    Customer customer = new Customer(firstName, lastName, email);
    customerSet.add(customer);
    }



    public Customer getCustomer(String customerEmail){

        for(Customer customer : customerSet) {

            if (Objects.equals(customer.getEmail(), customerEmail)) return (Customer) customer;

        }
       return null;

    }

    public Collection<Customer> getAllCustomers(){
    return customerSet;
}
}


