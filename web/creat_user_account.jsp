<%@ page import="sample.account.dtos.UserErrorDTO" %><%--
    Document   : creat_user_account
    Created on : Jul 9, 2020, 10:51:47 AM
    Author     : saost
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="main.js"></script>
    <style>
        body {
            font-family: Arial, Helvetica, sans-serif;
            background-color: black;
        }

        * {
            box-sizing: border-box;
        }

        /* Add padding to containers */
        .container {
            padding: 16px;
            background-color: white;
        }

        /* Full-width input fields */
        input[type=text], input[type=password], select, input[type=number] {
            width: 100%;
            padding: 15px;
            margin: 5px 0 22px 0;
            display: inline-block;
            border: none;
            background: #f1f1f1;
        }

        input[type=text]:focus, input[type=password]:focus, select, input[type=number] {
            background-color: #ddd;
            outline: none;
        }

        /* Overwrite default styles of hr */
        hr {
            border: 1px solid #f1f1f1;
            margin-bottom: 25px;
        }

        /* Set a style for the submit button */
        .registerbtn {
            background-color: #4CAF50;
            color: white;
            padding: 16px 20px;
            margin: 8px 0;
            border: none;
            cursor: pointer;
            width: 100%;
            opacity: 0.9;
        }

        .registerbtn:hover {
            opacity: 1;
        }

        /* Add a blue text color to links */
        a {
            color: dodgerblue;
        }

        /* Set a grey background color and center the text of the "sign in" section */
        .signin {
            background-color: #f1f1f1;
            text-align: center;
        }
    </style>
    <title>User Register</title>
</head>
<body>

<form action="MainController">
    <div class="container">
        <h1>User Register</h1>
        <p>Please fill in this form to create an account.</p>
        <%
            UserErrorDTO userError = (UserErrorDTO) request.getAttribute("USER_ERROR");
            boolean isError = false;

            if (userError != null) isError = true;
        %>
        <hr>

        <%--        userID--%>
        <label for="id"><b>User name</b></label>
        <%
            if (isError) {
        %><%="   " + userError.getUserIDError()%><%
        }
    %>
        <input type="text" placeholder="Enter user name" name="id"
               value="<%if (request.getParameter("id") != null)%><%=request.getParameter("id")%><%;%>" required>

        <%--        password--%>
        <label for="password"><b>Password</b></label>
        <%
            if (isError) {
        %><%="   " + userError.getPasswordError()%><%
        }
    %>
        <input type="password" placeholder="Enter Password" name="password" id="psw"
               value="<%if (request.getParameter("password") != null)%><%=request.getParameter("password")%><%;%>"
               required>
        <%--         passwordRepeat--%>
        <label for="passwordRepeat"><b>Repeat Password</b></label>
        <%
            if (isError) {
        %><%="   " + userError.getPasswordRepeatError()%><%
        }
    %>
        <input type="password" placeholder="Repeat Password" name="passwordRepeat" id="psw-repeat"
               value="<%if (request.getParameter("passwordRepeat") != null)%><%=request.getParameter("passwordRepeat")%><%;%>"
               required>
        <%--        fullName--%>
        <label for="fullName"><b>Full Name</b></label>
        <%
            if (isError) {
        %><%="   " + userError.getFullNameError()%><%
        }
    %>
        <input type="text" placeholder="Full Name" name="fullName"
               value="<%if (request.getParameter("fullName") != null)%><%=request.getParameter("fullName")%><%;%>"
               required>

        <%--        gender--%>
        <label for="gender"><b>Gender</b></label>
        <select name="gender" id="gender">
            <option value="male">Male</option>
            <option value="female">Female</option>
            <option value="LGBT">LGBT</option>
        </select>
        <%if (request.getParameter("gender") != null) {%>
        <script>
            setSelectGenderInRegister('<%=request.getParameter("gender")%>')
        </script>
        <%}%>
        <%--        phone--%>
        <label for="phone"><b>Phone Number</b></label>
        <%
            if (isError) {
        %><%="   " + userError.getPhoneError()%><%
        }
    %>
        <input type="number" placeholder="Phone number" name="phone"
               value="<%if (request.getParameter("phone") != null)%><%=request.getParameter("phone")%><%;%>">

        <%--        address--%>
        <label for="address"><b>Address</b></label>
        <%
            if (isError) {
        %><%="   " + userError.getAddressError()%><%
        }
    %>
        <input type="text" placeholder="Address" name="address"
               value="<%if (request.getParameter("address") != null)%><%=request.getParameter("address")%><%;%>">

        <hr>


        <button type="submit" name="btnAction" value="Creat user account" class="registerbtn">Register</button>
    </div>

    <div class="container signin">
        <p>Already have an account? <a href="login.jsp">Sign in</a>.</p>
    </div>
</form>

</body>
</html>
