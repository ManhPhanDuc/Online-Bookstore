<%-- 
    Document   : update
    Created on : Jun 10, 2021, 8:41:35 AM
    Author     : Admin
--%>

<%@page import="sample.user.UserDTO"%>
<%@page import="sample.user.UserError"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Page</title>
    </head>
    <body>
        <%
            UserError userError =(UserError)request.getAttribute("USER_ERROR");
            if (userError == null) {
                userError = new UserError();
            }
            UserDTO user = (UserDTO) session.getAttribute("LOGIN_USER");
            if (user == null || !user.getRoleID().equals("AD")) {
                    response.sendRedirect("login.html");
                    session.invalidate();
                }
        %>
        <form action="MainController">
            User ID<input type="text" name="userID" value="<%= request.getParameter("userID") %>" readonly=""/></br>
            Full Name<input type="text" name="fullName" value="<%= request.getParameter("fullName") %>" required=""/></br>
            <%= userError.getFullNameError()%></br>
            Role ID<input type="text" name="roleID" value="<%= request.getParameter("roleID") %>" required=""/>
            <%= userError.getRoleIDError()%></br
            Phone Number<input type="text" name="phoneNumber" value="<%= request.getParameter("phoneNumber") %>" required=""/>
            <%= userError.getPhoneNumberError()%></br
            Address<input type="text" name="address" value="<%= request.getParameter("address") %>" required=""/>
            <%= userError.getAddressError()%></br
            Status ID<input type="text" name="statusID" value="<%= request.getParameter("statusID") %>" required=""/>
            <%= userError.getStatusIDError()%></br
            <input type="submit" name="action" value="Confirm Update"/>
            <input type="reset" value="Reset"/>

        </form>
    </body>
</html>
