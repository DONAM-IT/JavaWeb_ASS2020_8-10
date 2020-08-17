<%-- 
    Document   : user_profile
    Created on : Jul 12, 2020, 10:21:58 AM
    Author     : saost
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Edit profile</title>
    <script src="main.js"></script>
</head>
<body>
<%@include file="user_header.jsp" %>

<%

    if (authUser != null) {

%>

<table border="1">
    <thead>
    <tr>
        <th>User ID</th>
        <th>Full Name</th>
        <th>Gender</th>
        <th>Phone</th>
        <th>Address</th>
    </tr>
    </thead>
    <tbody>

    <form action="MainController">
        <tr>
            <td>
                <%= authUser.getId()%>
            </td>
            <input type="hidden" name="id" value=<%= authUser.getId()%>>
            <td>
                <input type="text" name="fullName" value='<%= authUser.getFullName()%>' required>
            </td>

            <td>
                <select name="gender" id="gender" required>
                    <option value="male">Male</option>
                    <option value="female">Female</option>
                    <option value="LGBT">LGBT</option>
                </select>
                <script>
                    setSelectGender('', '<%=authUser.getGender()%>');
                </script>

            </td>
            <td>
                <input type="text" name="phone" value='<%= authUser.getPhone()%>'>
            </td>
            <td>
                <input type="text" name="address" value='<%= authUser.getAddress()%>'>
            </td>
            <td>
                <input type="submit" name="btnAction" value="Update user profile">
            </td>
        </tr>
    </form>
    </tbody>
</table>

<h3><b>Change password</b></h3>
<form action="MainController" id="repassword">
    <input type="password" name="oldPassword" placeholder="old password" required>
    <input type="password" name="newPassword" placeholder="new password" required>
    <input type="password" name="rePassword" placeholder="new password" required>
    <input type="submit" name="btnAction" value="Change password">
</form>
<%--        <button type="submit" name="btnAction" form="repassword" value="Change password">Change password</button>--%>

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

