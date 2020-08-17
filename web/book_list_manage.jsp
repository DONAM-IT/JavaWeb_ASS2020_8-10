<%@ page import="sample.book.dtos.BookDTO" %>
<%@ page import="java.util.List" %>
<%--
    Document   : book_list_manage
    Created on : Jul 11, 2020, 9:15:36 PM
    Author     : saost
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Book Management</title>
</head>
<body>
<h1>Book Management</h1>
<%@include file="admin_hearder.jsp" %>

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
    if (bookList != null && !bookList.isEmpty()) {
%>
<table border="1">
    <thead>
    <style>
        input[type=number] {
            width: 100px;
        }
    </style>
    <tr>
        <th>No</th>
        <th>Book ID</th>
        <th>Book Name</th>
        <th>Author</th>
        <th>Publisher</th>
        <th>Publish Year</th>
        <th>Total</th>
        <th>Available</th>
        <th></th>
        <th>Import</th>
        <th>Export</th>

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
                <input type="text" name="name" value="<%= dto.getName()%>" required>
            </td>
            <td>
                <input type="text" name="author" value="<%= dto.getAuthor()%>" required>
            </td>
            <td>
                <input type="text" name="publisher" value="<%= dto.getPublisher()%>" required>
            </td>
            <td>
                <input id="datefield<%= count%>" type="date" name="publishYear" min="1975-01-01"
                       value="<%= dto.getPublishYear()%>" placeholder="publish year" required>
                <script>
                    var today = new Date();
                    var dd = today.getDate();
                    var mm = today.getMonth() + 1; //January is 0!
                    var yyyy = today.getFullYear();
                    if (dd < 10) {
                        dd = '0' + dd
                    }
                    if (mm < 10) {
                        mm = '0' + mm
                    }

                    today = yyyy + '-' + mm + '-' + dd;
                    document.getElementById("datefield<%=count%>").setAttribute("max", today);
                </script>
            </td>
            <td>
                <%= dto.getTotal()%>
            </td>
            <td>
                <%= dto.getAvailable()%>
            </td>

            <td>
                <input type="submit" name="btnAction" value="Update book">
            </td>
            <td>
                <input type="number" name="import" min="1" placeholder="amount">
                <input type="submit" name="btnAction" value="Import">
            </td>
            <td>
                <input type="number" name="export" min="1" max="<%= dto.getAvailable()%>" placeholder="amount">
                <input type="submit" name="btnAction" value="Export">
            </td>
            <td>
                <input type="submit" name="btnAction" value="Delete book">
            </td>
        </tr>
    </form>
    <%
        }
    %>
    <form action="MainController">
        <tr>
            <td>
                <b>+</b>
            </td>
            <td>
                <b>New</b>
            </td>
            <td>
                <input type="text" name="name" value="" placeholder="book name" required>
            </td>
            <td>
                <input type="text" name="author" value="" placeholder="author name" required>
            </td>
            <td>
                <input type="text" name="publisher" value="" placeholder="publisher name" required>
            </td>
            <td>
                <input id="datefield" type="date" name="publishYear" min="1975-01-01" placeholder="publish year"
                       required>
                <script>
                    var today = new Date();
                    var dd = today.getDate();
                    var mm = today.getMonth() + 1; //January is 0!
                    var yyyy = today.getFullYear();
                    if (dd < 10) {
                        dd = '0' + dd
                    }
                    if (mm < 10) {
                        mm = '0' + mm
                    }

                    today = yyyy + '-' + mm + '-' + dd;
                    document.getElementById("datefield").setAttribute("max", today);
                </script>
            </td>
            <td>
                <input type="number" name="total" min="0" placeholder="total book">
            </td>
            <td>

            </td>
            <td>
                <input type="submit" name="btnAction" value="Creat book">
            </td>
        </tr>
    </form>
    </tbody>
</table>
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
