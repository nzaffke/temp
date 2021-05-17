package email6;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import business.User;
import data.UserIO;

public class EmailServlet2 extends HttpServlet{

    private String file;

    public void init() throws ServletException{
        ServletConfig config = getServletConfig();
        file = config.getInitParameter("filename");
        if (file == null){
            file = "c:\\UserEmail.txt";
        }
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
                      throws IOException, ServletException{
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String emailAddress = request.getParameter("emailAddress");

        // if any required fields are missing,
        // display a JSP to get the missing fields
        if ((firstName.length()==0) ||(lastName.length()==0) ||
            (emailAddress.length()==0)){
             RequestDispatcher dispatcher =
                 getServletContext().getRequestDispatcher(
                    "/get_missing_fields2.jsp");
            dispatcher.forward(request, response);
        }
        //Now that all user entries are entered, check music selection:
        String[] selectedMusic = request.getParameterValues("musicChoices");

        if (selectedMusic == null){
            RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(
                "/no_music_option.jsp");
            dispatcher.forward(request, response);
        }

        // otherwise, write the data to a file and display the entry
        User user = new User(firstName, lastName, emailAddress);
        UserIO.addRecord(user, file);

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