<%-- 
    Document   : viewcart
    Created on : Jun 17, 2021, 3:34:58 PM
    Author     : quan2
--%>


<%@page import="sample.shopping.Book"%>
<%@page import="sample.shopping.Cart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart Information</title>
    </head>
    <body>
        <%
            Cart cart = (Cart) session.getAttribute("CART");
            if (cart == null) {
        %>
        <h1>Ban chua chon san pham gi</h1>
        <a href="shopping.jsp">Add more</a>
        <%
            return;
        } else {
        %>
        <h1>Your select: </h1>

        <table border="1">
            <thead>
                <tr>

                    <th>NO</th>
                    <th>Image</th>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Quantity</th>
                    <th>Price</th>
                    <th>Total</th>
                    <th>Remove</th>
                    <th>Update</th>

                </tr>
            </thead>
            <tbody>
                <%
                    int count = 1;
                    double total = 0;
                    for (Book book : cart.getCart().values()) {
                        total += book.getPrice() * book.getQuantityCART();
                %>
            <form action="MainController">

                <tr>
                    <td><%= count++%></td>
                    <td><img src="<%= book.getImage()%>" width="200" height="200"</td> 

                    <td>  
                        <input type="text" name="id" value="<%= book.getProductID()%>" readonly=""/>
                    </td> 
                    <td><%= book.getProductName()%></td>

                    <td>

                        <input type="number" name="quantity" value="<%= book.getQuantityCART()%>" required="" min="1"/>
                    </td>
                    <td><%= book.getPrice()%></td>
                    <td><%= book.getPrice() * book.getQuantityCART()%></td>
                    <td>
                        <input type="submit" name="action" value="Remove"/>
                    </td>
                    <td>
                        <input type="submit" name="action" value="Edit"/>
                    </td>
                </tr>
            </form>

            <%
                }
            %>
        </tbody>
    </table>
    <h1>Total: <%= total%></h1>
    <form action="MainController">
        <input type="hidden" value="<%= total %>" name="total"/>
        <input type="submit" value="Payment" name="action" />
    </form>
    
    <%
        }
    %>
    
    <a href="shopping.jsp">Add more</a>
    
</body>
</html>