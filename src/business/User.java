package business;

import java.io.*;

public class User{
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String salary;

    public User(){}

    public User(String first, String last, String email,String sal){
        firstName = first;
        lastName = last;
        emailAddress = email;
        salary= sal;
    }

    public void setSalary(String f){
        salary = f;
    }
    public String getSalary(){ return salary; }

    public void setFirstName(String f){
        firstName = f;
    }
    public String getFirstName(){ return firstName; }

    public void setLastName(String l){
        lastName = l;
    }
    public String getLastName(){ return lastName; }

    public void setEmailAddress(String e){
        emailAddress = e;
    }
    public String getEmailAddress(){ return emailAddress; }
}
