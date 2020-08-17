<%-- 
    Document   : admin_hearder
    Created on : Jul 11, 2020, 2:30:55 PM
    Author     : saost
--%>

<%@page import="sample.account.dtos.UserDTO" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>


<h2>Welcome admin:
    <%
        UserDTO authUser = (UserDTO) session.getAttribute("AUTH_USER");
    %>
    <%= " " + authUser.getFullName()%>
</h2>
<button onclick="window.location.href='MainController?btnAction=Logout'">Logout</button>
<button onclick="window.location.href='MainController?btnAction=Creat admin account'">Creat Admin Account</button>
<button onclick="window.location.href='MainController?btnAction=ManageAccount'">Manage User Account</button>
<button onclick="window.location.href='MainController?btnAction=View admin not returned order'">View all orders</button>
<button onclick="window.location.href='MainController?btnAction=View admin returned order'">History</button>
<button onclick="window.location.href='MainController?btnAction=Manage book'">Manage book</button>
<button onclick="window.location.href='MainController?btnAction=View profile'">Edit profile</button>

</html>
