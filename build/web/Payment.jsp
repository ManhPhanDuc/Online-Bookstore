<%-- 
    Document   : Payment
    Created on : Jul 9, 2021, 4:07:52 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Payment Page</title>
        <title>Enter your information</title>
    </head>
    <body>
        <%
            String total=request.getParameter("total");
        %>
       
        <form action="MainController" method="POST">
            Your UserID:    <input type="text" name="userID" value="${sessionScope.LOGIN_USER.getUserID()}" readonly/><br/>
            EMAIL      :          <input type="email" name="email" /><br/>
            Phone      :          <input type="text" name="phone"/><br/>
            ${requestScope.ORDER_ERROR.getPhoneNumberError()}
            ADDRESS    :     <input type="text" name="address" /><br/>
            ${requestScope.ORDER_ERROR.getAddressError()}
            TOTAL      :    <input type="text" name="total" value="<%=total%> " readonly/>VND<br/>
            <button type="submit" name="action" value="Order"  >Submit</button> 
            <input type="reset" value="RESET"/>
            
        </form>
    </body>
</html>
