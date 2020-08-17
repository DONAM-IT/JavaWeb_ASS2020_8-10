<%--    Document   : login
    Created on : Jul 6, 2020, 11:14:17 AM
    Author     : saost
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <!--ten bat dau bang chu thuong-->
    <title>Welcome to online library</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<form action="MainController" method="POST">
    <%
        String errorMessage = (String) session.getAttribute("ERROR_MESSAGE");
        if (errorMessage != null) {
    %>
    <h2><b><%= errorMessage%>
    </b></h2><br>
    <%
            session.setAttribute("ERROR_MESSAGE", null);
        }
    %>

    Username<input type="text" name="userID" required/></br>
    Password<input type="password" name="password" required/></br>
    <input type="submit" value="Login" name="btnAction"/>
    <input type="reset" value="Reset"/>
</form>
<button onclick="window.location.href='creat_user_account.jsp'">Register</button>


</body>
</html>
