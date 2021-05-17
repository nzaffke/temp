package data;

import java.io.*;
import java.util.*;
import business.User;


public class UserIO{
    public synchronized static void addRecord(User user, String fileName) throws IOException{
        //File file = new File(fileName);
        //PrintWriter out = new PrintWriter(new FileWriter(file));
    	PrintWriter out = new PrintWriter(
                new FileWriter(fileName, true));
        out.println(user.getEmailAddress()+ "|"
                    + user.getFirstName() + "|"
                    + user.getLastName()  + "|" 
                    + user.getSalary());

        out.close();
    }

    public static User getUser(String emailAddress, String fileName) throws IOException{
        File file = new File(fileName);
        BufferedReader in = new BufferedReader(
                        new FileReader(file));
        User user = new User();
        String line = in.readLine();
        while (line != null){
            StringTokenizer t = new StringTokenizer(line, "|");
            String email = t.nextToken();
            if (email.equalsIgnoreCase(emailAddress)){
                String firstName = t.nextToken();
                String lastName = t.nextToken();
                user.setEmailAddress(emailAddress);
                user.setFirstName(firstName);
                user.setLastName(lastName);
            }
            line = in.readLine();
        }
        in.close();
        return user;
    }
    public synchronized static Vector readRecords(String file) throws IOException{
        Vector users = new Vector();
        BufferedReader in = new BufferedReader(
                            new FileReader(file));
        String line = in.readLine();
        while (line != null){
            StringTokenizer t = new StringTokenizer(line, "|");
            String emailAddress = t.nextToken();
            String firstName = t.nextToken();
            String lastName = t.nextToken();
           // User user = new User(firstName, lastName, emailAddress,salary;
           // users.add(user);
            line = in.readLine();
        }
        in.close();
        return users;
    }
}
