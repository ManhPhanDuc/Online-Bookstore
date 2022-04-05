<%-- 
    Document   : shopping
    Created on : Jun 17, 2021, 3:11:43 PM
    Author     : Admin
--%>

<%@page import="sample.user.ProductDAO"%>
<%@page import="sample.user.ProductDTO"%>
<%@page import="java.util.List"%>
<%@page import="java.lang.String"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reading book for life</title>
        
    </head>
    <body>
        <h1>Welcome to my bookshop: ${sessionScope.LOGIN_USER.getFullName()}</h1>

        <%
            String search = (String)request.getParameter("search");
            if (search == null) {
                search = "";
            }
        %>

        <form action="MainController">
            <input type="submit" name="action" value="Logout"/>
        </form>

        <form action="MainController">
            Search:<input type="text" name="search" value="<%= search%>"/>
            <input type="submit" name="action" value="SearchProduct"/>
            <input type="submit" name="action" value="View Cart"/>
            
            
        </form>

        <%
            List<ProductDTO> list = (List<ProductDTO>) request.getAttribute("LIST_PRODUCT");
            ProductDAO dao=new ProductDAO();
            
            if (list == null) {
                list = dao.getListProduct("");
            } 
        %>



        <table border="1">
            <thead>
                <tr>
                    <th>STT</th>
                    <th>ID</th>
                    <th>productName</th>
                    <th>description</th>
                    <th>categoryName</th>
                    <th>price</th>
                    <th>quantity</th>
                    <th>statusID</th>

                    <th>image</th>
                    <th>Add to cart</th>

                </tr>
            </thead>
            <tbody>
                <%
                    int count = 1;
                    
                    for (ProductDTO dto : list) {
                %>
                <tr>
                    <td><%=count++%></td>
                    <td><%=dto.getProductID()%></td>
                    <td><%=dto.getProductName()%></td>
                    <td><%=dto.getDescription()%></td>
                    <td><%=dao.getCategoryNameByID(dto.getCategoryID().trim())%></td>    
                    <td><%=dto.getPrice()%></td>
                    <td><%=dto.getQuantity()%></td>
                    <td><%=dto.getStatusID()%></td>

                    <td><img src="<%=dto.getImage()%>" width="300" height="300"></td>
                    <td>
                        <form action="MainController">
                            <input type="hidden" name="product" value="<%=dto.getProductID()%>"/>
                            <input type="number" name="quantity" value="1" min="1" max="<%=dto.getQuantity()%>"/>
                            <button 
                                type="submit" name="action" value="Add">
                                ADD
                            </button>
                        </form>

                    </td>
                </tr>
                <%
                    
                    }
                %>
            </tbody>
        </table>

        <%
            
            
        %>

        <%
            String message = (String) request.getAttribute("SHOPPING_MASSAGE");
            if (message == null) {
                message = "";
            }
        %>
        <%= message%> 
    </body>
</html>
