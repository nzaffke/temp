package email6;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import business.User;
import data.UserIO;

public class EmailServlet extends HttpServlet{

    private String file;

    public void init() throws ServletException{
        
            file = "C:\\temp\\UserEmail.txt";
        }
    

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
                      throws IOException, ServletException{
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String emailAddress = request.getParameter("emailAddress");
        String salary = request.getParameter("salary");

        // if any required fields are missing,
        // display a JSP to get the missing fields
        if ((firstName.length()==0) || (lastName.length()==0) || (salary.length() ==0)
        	|| (emailAddress.length()==0)){
             RequestDispatcher dispatcher =
                 getServletContext().getRequestDispatcher(
                    "/get_missing_fields.jsp");
            dispatcher.forward(request, response);
        }

        // otherwise, write the data to a file and display the entry
        User user = new User(firstName, lastName, emailAddress,salary);
        UserIO.addRecord( user , file);

        RequestDispatcher dispatcher =
            getServletContext().getRequestDispatcher(
                "/show_email_entry.jsp");
        dispatcher.forward(request, response);
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
                       throws ServletException, IOException {
        doGet(request, response);
    }
}