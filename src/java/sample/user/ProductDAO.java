/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sample.shopping.Order;
import sample.shopping.OrderDetail;
import sample.utils.DBUtils;

/**
 *
 * @author Admin
 */
public class ProductDAO {
    
    public List<ProductDTO> getListProduct(String search) throws SQLException {
        List<ProductDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn=DBUtils.getConnection();
            if(conn!=null)
            {
                String sql="SELECT productID, productName, description, categoryID, price, quantity, statusID, createDate, image FROM tblProducts WHERE productName like ? and statusID=?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, "%" + search + "%");
                stm.setString(2, "1");
                rs = stm.executeQuery();
                while(rs.next())
                {
                    String productID= rs.getString("productID");
                    String productName= rs.getString("productName");
                    String description= rs.getString("description");
                    String categoryID= rs.getString("categoryID");
                    double price= Double.parseDouble(rs.getString("price"));
                    int quantity= Integer.parseInt(rs.getString("quantity"));
                    String statusID= rs.getString("statusID");
                    String createDate= rs.getString("createDate");
                    String image= rs.getString("image");
                    list.add(new ProductDTO(productID, productName, description, categoryID, price, quantity, statusID, createDate, image));
                }
            }
        } catch(Exception e)  {

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
        
    }
    public List<ProductDTO> getListProductByType(String search) throws SQLException {
        List<ProductDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn=DBUtils.getConnection();
            if(conn!=null)
            {
                String sql="SELECT productID, productName, description, categoryID, price, quantity, statusID, createDate, image FROM tblProducts WHERE categoryID like ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, "%" + search + "%");
                rs = stm.executeQuery();
                while(rs.next())
                {
                    String productID= rs.getString("productID");
                    String productName= rs.getString("productName");
                    String description= rs.getString("description");
                    String categoryID= rs.getString("categoryID");
                    double price= Double.parseDouble(rs.getString("price"));
                    int quantity= Integer.parseInt(rs.getString("quantity"));
                    String statusID= rs.getString("statusID");
                    String createDate= rs.getString("createDate");
                    String image= rs.getString("image");
                    list.add(new ProductDTO(productID, productName, description, categoryID, price, quantity, statusID, createDate, image));
                }
            }
        } catch(Exception e)  {

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }
     public String getCategoryNameByID(String categoryID) throws SQLException {
        String categoryName ="";
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
                conn=DBUtils.getConnection();
            if(conn!=null)
            {
                String sql="SELECT categoryName FROM tblCategory WHERE categoryID =? ";
                stm = conn.prepareStatement(sql);
                stm.setString(1, categoryID);
               
                rs = stm.executeQuery();
                if(rs.next())
                {
                     categoryName=rs.getString("categoryName");
                }
            }
        } catch(Exception e)  {

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return categoryName;
        
    }
     public ProductDTO getProductByID(String search) throws SQLException {
        ProductDTO product =new ProductDTO();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn=DBUtils.getConnection();
            if(conn!=null)
            {
                String sql="SELECT productID, productName, description, categoryID, price, quantity, statusID, createDate, image FROM tblProducts WHERE productID like ? and statusID=?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, "%" + search + "%");
                stm.setString(2, "1");
                rs = stm.executeQuery();
                while(rs.next())
                {
                    String productID= rs.getString("productID");
                    String productName= rs.getString("productName");
                    String description= rs.getString("description");
                    String categoryID= rs.getString("categoryID");
                    double price= Double.parseDouble(rs.getString("price"));
                    int quantity= Integer.parseInt(rs.getString("quantity"));
                    String statusID= rs.getString("statusID");
                    String createDate= rs.getString("createDate");
                    String image= rs.getString("image");
                    product=new ProductDTO(productID, productName, description, categoryID, price, quantity, statusID, createDate, image);
                }
            }
        } catch(Exception e)  {

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return product;
    }
    public boolean insertProduct(Order order) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = " INSERT INTO tblOrders(email, userID, address, phone, totalMoney, orderDate, statusID, paymentStatus)"
                        + " VALUES(?,?,?,?,?,?,?,?)";
                stm = conn.prepareStatement(sql);
                stm.setString(1, order.getEmail());
                stm.setString(2, order.getUserID());
                stm.setString(3, order.getAddress());
                stm.setString(4, order.getPhone());
                stm.setString(5, order.getTotalMoney());
                stm.setString(6, order.getOrderDate());
                stm.setString(7, order.getStatusID());
                stm.setString(8, order.getPaymentStatus());
                check = stm.executeUpdate() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }

        }
        return check;
    }
    public String getOrderID() throws SQLException {
        String orderID ="";
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
                conn=DBUtils.getConnection();
            if(conn!=null)
            {
                String sql="SELECT IDENT_CURRENT('tblOrders') as LastID";
                stm = conn.prepareStatement(sql);
               
                rs = stm.executeQuery();
                if(rs.next())
                {
                     orderID=String.valueOf(rs.getInt("LastID"));
                }
            }
        } catch(Exception e)  {

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return orderID;
        
    }
    public boolean writeDetail(OrderDetail order) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "INSERT INTO tblOrderDetail(orderID, orderDetailID, productID, quantity, price, statusID)"
                        + " VALUES(?,?,?,?,?,?)";
                stm = conn.prepareStatement(sql);
                stm.setString(1, order.getOrderID());
                stm.setString(2, order.getOrderDetailID());
                stm.setString(3, order.getProductID());
                stm.setInt(4, order.getQuantity());
                stm.setDouble(5, order.getPrice());
                stm.setString(6, order.getStatusID());
                
                check = stm.executeUpdate() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }

        }
        return check;
    }
     public boolean updateQuantity (int quantity,String productID) throws SQLException {
        boolean check=false;
        
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
                conn=DBUtils.getConnection();
            if(conn!=null)
            {
                String sql="UPDATE tblProducts SET quantity=? WHERE productID=?";
                stm = conn.prepareStatement(sql);
                stm.setInt(1, quantity);
                stm.setString(2, productID);
                rs = stm.executeQuery();
                
            }
        } catch(Exception e)  {

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
        
    }
}
