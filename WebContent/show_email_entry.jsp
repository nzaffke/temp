<!doctype html public "-//W3C//DTD HTML 4.0 Transitional//EN">
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

<h1>Thanks for joining our email list</h1>

<p>Here is the information that you entered:</p>

  <table cellspacing="5" cellpadding="5" border="1">
    <tr>
      <td align="right">First name:</td>
      <td><%= firstName %></td>
    </tr>
    <tr>
      <td align="right">Last name:</td>
      <td><%= lastName %></td>
    </tr>
    <tr>
      <td align="right">Email address:</td>
      <td><%= emailAddress %></td>
    </tr>
    <tr>
      <td align="right">Salary:</td>
      <td><%= salary %></td>
    </tr>
  </table>

<p>To enter another email address, click on the Back <br>
button in your browser or the Return button shown <br>
below.</p>

<form action="join_email_list.html" method="post">
  <input type="submit" value="Return">
</form>
</body>
</html>
