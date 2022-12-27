package service;
import model.Customer; // alt + enter over Customer

// alt + enter over Collection, Map and HashMap
import java.util.*;
public class CustomerService {

    public  CustomerService customerService = null;

    //Constructor
    public CustomerService getInstance(){
        if(customerService == null){
            CustomerService customerService = new CustomerService();
        }
        return customerService;
    }


    public static Set<Customer> customerSet = new HashSet<>();


    public void addCustomer(String email, String firstName, String lastName){
    Customer customer = new Customer() ;
    if(customer.validEmail(email)){customer.setEmail(email);}
    else{System.out.println("Please use a valid Email.  Try Again");}
    customer.setFirstName(firstName);
    customer.setLastName(lastName);
    customerSet.add(customer);
    //System.out.println(this.getAllCustomers());


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


