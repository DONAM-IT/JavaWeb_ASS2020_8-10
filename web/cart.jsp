<%@ page import="sample.cart.dtos.CartDTO" %>
<%@ page import="sample.order.dtos.OrderDetailDTO" %>
<%--
    Document   : cart
    Created on : Jul 10, 2020, 12:07:47 AM
    Author     : saost
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Cart</title>
</head>
<body>
<h1>Cart</h1>
<%@include file="user_header.jsp" %>

<%
    CartDTO cart = (CartDTO) session.getAttribute("CART");
    if (cart != null && !cart.getCart().isEmpty()) {
%>
<table border="1">
    <thead>
    <tr>
        <th>No</th>
        <th>Book ID</th>
        <th>Book Name</th>
        <th>Author</th>
        <th>Publisher</th>
        <th>Available</th>
        <th>Publish Year</th>
        <th>Quantity</th>
        <th>Note</th>
    </tr>
    </thead>
    <tbody>
    <%
        int count = 1;
        for (OrderDetailDTO dto : cart.getCart().values()) {
    %>
    <form action="MainController" id="form<%=count%>">
        <tr>
            <td>
                <%= count++%>
            </td>
            <td>
                <%= dto.getBook().getId()%>
            </td>
            <input type="hidden" name="id" value=<%= dto.getBook().getId()%>>
            <td>
                <%= dto.getBook().getName()%>
            </td>
            <td>
                <%= dto.getBook().getAuthor()%>
            </td>
            <td>
                <%= dto.getBook().getPublisher()%>
            </td>
            <td>
                <%= dto.getBook().getAvailable()%>
            </td>
            <td>
                <%= dto.getBook().getPublishYear()%>
            </td>
            <td>
                <input type="number" value="<%= dto.getQuantity()%>" min="1" max="<%= dto.getBook().getAvailable()%>"
                       name="quantity" required>
            </td>
            <td>
                <input type="text" value="<%= dto.getNote()%>" name="note">
            </td>
            <td>
                <input type="submit" name="btnAction" value="Delete book from cart">
                <input type="submit" name="btnAction" value="Update book from cart">
            </td>
        </tr>
    </form>
    <%
        }
    %>
    </tbody>
</table>
<button onclick="window.location.href='MainController?btnAction=Check out'">Check Out</button>
<%
} else {
%>
<p>Empty!</p>
<%
    }
%>
<%@include file="message_footer.jsp" %>
</body>
</html>
