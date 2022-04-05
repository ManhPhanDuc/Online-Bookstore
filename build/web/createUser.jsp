<%-- 
    Document   : createUser
    Created on : Jun 13, 2021, 10:53:15 PM
    Author     : Admin
--%>

<%@page import="sample.user.UserError"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create User page</title>
    </head>
    <body>
        <%

            UserError userError = (UserError) request.getAttribute("USER_ERROR");
            if (userError == null) {
                userError = new UserError();
            }

        %>
        <h1>Create NEW user</h1>
        <form action="MainController" method="post" >
            UserID      <input type="text" name="userID" required=""/> 
            <%=userError.getUserIDError()%> </br>
            FullName    <input type="text" name="fullName" required=""/>
            </br><%=userError.getFullNameError()%> </br>

            Phone Number <input type="text" name="phoneNumber" required=""/>
            </br><%=userError.getPhoneNumberError()%> </br>
            Address     <input type="text" name="address" required=""/>
            </br><%=userError.getAddressError()%> </br>
            Password    <input type="password" name="password" required=""/>
            </br><%=userError.getPasswordError()%> </br>
            Confirm     <input type="password" name="confirm" required=""/>
            <%=userError.getConfirmPasswordError()%> </br>
            <input type="submit" name="action" value="Create" />
            <input type="reset" value="Reset" />  
            
        </form>
            <a href="login.html"><button >Cancel</button></a>
    </body>
</html>
