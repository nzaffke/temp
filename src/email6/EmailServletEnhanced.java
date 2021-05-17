package email6;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import business.User;
import data.UserIO;

/********************************************************************
* This servlet gets initialization parameters from the web.xml file
********************************************************************/

public class EmailServletEnhanced extends HttpServlet{
    private String file;
    private String dbName;

    public void init() throws ServletException{

        ServletConfig config = getServletConfig();
        file = config.getInitParameter("filename");

        ServletContext context = config.getServletContext();
        dbName = context.getInitParameter("dbName");
        System.out.println("dbName: " + dbName);
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
                      throws IOException, ServletException{

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String emailAddress = request.getParameter("emailAddress");

        // if any required fields are missing,
        // display a JSP to get the missing fields
        if ((firstName.length()==0)    || (lastName.length()==0) ||
             (emailAddress.length()==0)){
             RequestDispatcher dispatcher =
                 getServletContext().getRequestDispatcher(
                    "get_missing_fields.jsp");
            dispatcher.forward(request, response);
        }

        // otherwise, write the data to a file and display the entry
        User user = new User(firstName, lastName, emailAddress);
        UserIO.addRecord(user, file);

        RequestDispatcher dispatcher =
            getServletContext().getRequestDispatcher(
                "show_email_entry.jsp");
        dispatcher.forward(request, response);
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
                       throws ServletException, IOException {
        doGet(request, response);
    }
}