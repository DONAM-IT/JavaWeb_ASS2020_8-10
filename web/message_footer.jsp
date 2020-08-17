<%-- 
    Document   : message_footer
    Created on : Jul 12, 2020, 11:38:30 AM
    Author     : saost
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
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
</html>
