<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">

<html>
<head>
  <title>Chapter 6 - Email List application</title>
</head>

<body>

<%
  String firstName = request.getParameter("firstName");
  String lastName = request.getParameter("lastName");
  String emailAddress = request.getParameter("emailAddress");
  String salary = request.getParameter("salary");
%>

<h1>Join our email list</h1>
<p>To join our email list, enter your name and
email address below. <br>
Then, click on the Submit button.</p>
<p><i>Please fill out all three text boxes.</i></p>

<form action="EmailServlet" method="get">
<table cellspacing="5" border="0">
  <tr>
    <td align="right">First name:</td>
    <td><input type="text" name="firstName" value="<%= firstName %>"></td>
  </tr>
  <tr>
    <td align="right">Last name:</td>
    <td><input type="text" name="lastName" value="<%= lastName %>"></td>
  </tr>
  <tr>
    <td align="right">Email address:</td>
    <td><input type="text" name="emailAddress" 
         value="<%= emailAddress %>"></td>
  </tr>
  <tr>
    <td align="right">Salary:</td>
    <td><input type="text" name="salary" 
         value="<%= salary %>"></td>
  </tr>
  <tr>
    <td></td>
    <td><input type="submit" value="Submit"></td>
  </tr>
</table>
</form>

</body>
</html>
