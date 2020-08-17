<%-- 
    Document   : user_hearder
    Created on : Jul 11, 2020, 10:11:04 PM
    Author     : saost
--%>

<%@page import="sample.account.dtos.UserDTO" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<h2>Welcome:
    <%
        UserDTO authUser = (UserDTO) session.getAttribute("AUTH_USER");
    %>
    <%= " " + authUser.getFullName()%>
</h2>
<button onclick="window.location.href='MainController?btnAction=Logout'">Logout</button>
<button onclick="window.location.href='MainController?btnAction=View library'">Library</button>
<button onclick="window.location.href='MainController?btnAction=View cart'">View Cart</button>
<button onclick="window.location.href='MainController?btnAction=View user not returned order'">Borrowed</button>
<button onclick="window.location.href='MainController?btnAction=View user returned order'">History</button>
<button onclick="window.location.href='MainController?btnAction=View profile'">Edit profile</button>

</html>
