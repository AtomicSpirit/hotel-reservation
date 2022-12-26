package service;
import model.Customer; // alt + enter over Customer

// alt + enter over Collection, Map and HashMap
import java.util.*;
public class CustomerService {

    public static CustomerService customerService = null;

    //Constructor
    public static CustomerService getInstance(){
        if(customerService == null){
            CustomerService customerService = new CustomerService();
        }
        return customerService;
    }


    public  Set<Customer> customerSet = new HashSet<>();


    public void addCustomer(String email, String firstName, String lastName){
    Customer customer = new Customer(email, firstName, lastName) ;
    customer.createCustomer.add(customer);
    }



    public Customer getCustomer(String customerEmail){

        for(Customer customer : customerSet) {

            if (Objects.equals(customer.getEmail(), customerEmail)) return (Customer) customer;

        }
       return null;

    }

    public Set<Customer> getAllCustomers(){
    return customerSet;
}
}


