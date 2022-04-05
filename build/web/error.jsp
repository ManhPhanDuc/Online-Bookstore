<%-- 
    Document   : error
    Created on : Jun 1, 2021, 1:22:24 PM
    Author     : NHULT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ERROR Page</title>
    </head>
    <body>
        <h1>ERROR: <%= session.getAttribute("ERROR_MESSAGE")%> </h1>
    </body>
</html>
