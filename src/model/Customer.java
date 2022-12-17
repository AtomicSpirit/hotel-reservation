package model;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class Customer {
    String firstName;
    String lastName;
    String email;

/*The method that checks to make sure an email is valid.

*/

private static boolean validEmail(String email){
    String emailRegex = "^(.+)@(.+).com$";
    Pattern pattern = Pattern.compile(emailRegex);
    Matcher matcher = pattern.matcher(email);
    return pattern.matcher(email).matches();
}

    public Customer(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        if(validEmail(email)) {
        this.email = email;
        }else{
            throw new IllegalArgumentException("Invalid Email Ssssssynnntttax");//I wrote this so it was easy to spot
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String toString(){
        return "Name " + firstName  + " " + lastName + " email: " + email ;
    }
}


//RegEx info can be found in Lesson5: CommonTypes