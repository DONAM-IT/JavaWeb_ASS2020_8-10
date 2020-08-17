<%--
    Document   : library
    Created on : Jul 9, 2020, 4:35:13 PM
    Author     : saost
--%>

<%@page import="sample.book.dtos.BookDTO" %>
<%@page import="sample.cart.dtos.CartDTO" %>
<%@ page import="java.util.List" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Welcome to Online Library</title>
</head>
<body>
<h1>Library</h1>
<%@include file="user_header.jsp" %>

<%
    String searchText = request.getParameter("searchText");
    if (searchText == null) searchText = "";
%>
<br>
<form action="MainController">
    <input type="text" name="searchText" value="<%= searchText%>" placeholder="search book by name">
    <input type="submit" value="Search book" name="btnAction">
</form>
<br>
<%
    List<BookDTO> bookList = (List<BookDTO>) request.getAttribute("LIST_AVAILABLE_BOOK");
    CartDTO cart = (CartDTO) session.getAttribute("CART");
    if (bookList != null && !bookList.isEmpty()) {
%>
<table border="1">
    <thead>
    <tr>
        <th>No</th>
        <th>Book ID</th>
        <th>Book Name</th>
        <th>Author</th>
        <th>Publisher</th>
        <th>Total</th>
        <th>Available</th>
        <th>Publish Year</th>
        <th>Add to cart</th>
        <th>Your cart</th>

    </tr>
    </thead>
    <tbody>
    <%
        int count = 1;
        for (BookDTO dto : bookList) {
    %>
    <form action="MainController" id="form<%=count%>">
        <tr>
            <td>
                <%= count++%>
            </td>
            <td>
                <%= dto.getId()%>
            </td>
            <input type="hidden" name="id" value=<%= dto.getId()%>>
            <td>
                <%= dto.getName()%>
            </td>
            <td>
                <%= dto.getAuthor()%>
            </td>
            <td>
                <%= dto.getPublisher()%>
            </td>
            <td>
                <%= dto.getTotal()%>
            </td>
            <td>
                <%= dto.getAvailable()%>
            </td>
            <td>
                <%= dto.getPublishYear()%>
            </td>
            <td>
                <input type="submit" name="btnAction" value="Add to cart">
            </td>
            <td>
                <%
                    if (cart == null) {%>
                <%= 0%>
                <%
                } else {
                %>
                <%= cart.getQuantity(dto.getId() + "")%>
                <%
                    }
                %>
            </td>
        </tr>
    </form>
    <%
        }
    %>
    </tbody>
</table>
<%
} else {
%>
<p>Empty!</p>
<%
    }
%>

<%
    String errorMessage = (String) request.getAttribute("ERROR_MESSAGE");
    String successMessage = (String) request.getAttribute("SUCCESS_MESSAGE");
%>
<%
    if (errorMessage != null) {
%>
<h2><%= errorMessage%>
</h2>
<%
    }
%>
<%
    if (successMessage != null) {
%>
<h2><%= successMessage%>
</h2>
<%
    }
%>


</body>
</html>
