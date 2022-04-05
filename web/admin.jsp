<%-- 
    Document   : admin
    Created on : Jun 1, 2021, 1:34:33 PM
   
--%>


<%@page import="java.util.List"%>
<%@page import="sample.user.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
    </head>
    <body>  
        <%
            UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");
            if (loginUser == null || !"1".equals(loginUser.getRoleID().trim())) {
                response.sendRedirect("login.html");
                return;
            }
            String search = (String) request.getParameter("search");
            if (search == null) {
                search = "";
            }

        %>
        <h1>Hello ADmin: <%= loginUser.getFullName()%></h1>
        <form action="MainController">
            <input type="submit" name="action" value="Logout" />
        </form>
        <form action="MainController">
            Search<input type="text" name="search" value="<%= search%>"/>
            <input type="submit" name="action" value="Search"/>
        </form>

        <%
            List<UserDTO> list = (List<UserDTO>) request.getAttribute("LIST_USER");
            if (list != null) {
                if (!list.isEmpty()) {


        %>

        <table border="1">
            <thead>
                <tr>
                    <th>NO</th>
                    <th>User ID</th>
                    <th>Full Name</th>
                    <th>Role ID</th>
                    <th>Password</th>
                    <th>Phone Number</th>
                    <th>Address</th>
                    <th>Status ID</th>
                    <th>Create date</th>     
                    <th>Delete</th>
                    <th>Update</th>
                </tr>
            </thead>
            <tbody>
                <%   int count = 1;
                    for (UserDTO dto : list) {
                %>
                <tr>
            <form action="MainController">

                <td><%=count++%></td>
                <td>
                    <input type="text" name="userID" value=" <%=dto.getUserID()%>" readonly/>
                </td>
                <td><input type="text" name="fullName" value="<%=dto.getFullName()%>"/></td>
                <td><input type="text" name="roleID" value="<%=dto.getRoleID()%>"/></td>
                <td><%=dto.getPassword()%></td>
                <td>
                    <input type="text" name="phoneNumber" value="<%=dto.getPhoneNumber()%>"/>

                </td>
                <td>
                    <input type="text" name="address" value="<%=dto.getAddress()%>"/>

                </td>
                <td>
                    <input type="text" name="statusID" value="<%=dto.getStatusID()%>"/>

                </td>
                <td><%=dto.getCreateDate()%></td>

                <td>

                    <a href="MainController?action=Delete&userID=<%= dto.getUserID()%>
                       &search=<%= search%>" >Delete</a>

                </td>


                <td>
                    <input type="hidden" name="search" value="<%= search%>"/>
                    <input type="submit" name="action" value="Confirm Update"/>
            </form>
        </td>   
    </tr>
    <%
        }
    %>
</tbody>
</table>

<%
        }
    }
%>

</body>
</html>
