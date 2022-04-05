package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import sample.user.ProductDAO;
import sample.user.ProductDTO;
import java.util.List;
import java.lang.String;

public final class shopping_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Reading book for life</title>\n");
      out.write("        \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Welcome to my bookshop: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.LOGIN_USER.getFullName()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h1>\n");
      out.write("\n");
      out.write("        ");

            String search = (String)request.getParameter("search");
            if (search == null) {
                search = "";
            }
        
      out.write("\n");
      out.write("\n");
      out.write("        <form action=\"MainController\">\n");
      out.write("            <input type=\"submit\" name=\"action\" value=\"Logout\"/>\n");
      out.write("        </form>\n");
      out.write("\n");
      out.write("        <form action=\"MainController\">\n");
      out.write("            Search:<input type=\"text\" name=\"search\" value=\"");
      out.print( search);
      out.write("\"/>\n");
      out.write("            <input type=\"submit\" name=\"action\" value=\"SearchProduct\"/>\n");
      out.write("            <input type=\"submit\" name=\"action\" value=\"View Cart\"/>\n");
      out.write("            \n");
      out.write("            \n");
      out.write("        </form>\n");
      out.write("\n");
      out.write("        ");

            List<ProductDTO> list = (List<ProductDTO>) request.getAttribute("LIST_PRODUCT");
            ProductDAO dao=new ProductDAO();
            
            if (list == null) {
                list = dao.getListProduct("");
            } 
        
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <table border=\"1\">\n");
      out.write("            <thead>\n");
      out.write("                <tr>\n");
      out.write("                    <th>STT</th>\n");
      out.write("                    <th>ID</th>\n");
      out.write("                    <th>productName</th>\n");
      out.write("                    <th>description</th>\n");
      out.write("                    <th>categoryName</th>\n");
      out.write("                    <th>price</th>\n");
      out.write("                    <th>quantity</th>\n");
      out.write("                    <th>statusID</th>\n");
      out.write("\n");
      out.write("                    <th>image</th>\n");
      out.write("                    <th>Add to cart</th>\n");
      out.write("\n");
      out.write("                </tr>\n");
      out.write("            </thead>\n");
      out.write("            <tbody>\n");
      out.write("                ");

                    int count = 1;
                    
                    for (ProductDTO dto : list) {
                
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td>");
      out.print(count++);
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(dto.getProductID());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(dto.getProductName());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(dto.getDescription());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(dao.getCategoryNameByID(dto.getCategoryID().trim()));
      out.write("</td>    \n");
      out.write("                    <td>");
      out.print(dto.getPrice());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(dto.getQuantity());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(dto.getStatusID());
      out.write("</td>\n");
      out.write("\n");
      out.write("                    <td><img src=\"");
      out.print(dto.getImage());
      out.write("\" width=\"300\" height=\"300\"></td>\n");
      out.write("                    <td>\n");
      out.write("                        <form action=\"MainController\">\n");
      out.write("                            <input type=\"hidden\" name=\"product\" value=\"");
      out.print(dto.getProductID());
      out.write("\"/>\n");
      out.write("                            <input type=\"number\" name=\"quantity\" value=\"1\" min=\"1\" max=\"");
      out.print(dto.getQuantity());
      out.write("\"/>\n");
      out.write("                            <button \n");
      out.write("                                type=\"submit\" name=\"action\" value=\"Add\">\n");
      out.write("                                ADD\n");
      out.write("                            </button>\n");
      out.write("                        </form>\n");
      out.write("\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                ");

                    
                    }
                
      out.write("\n");
      out.write("            </tbody>\n");
      out.write("        </table>\n");
      out.write("\n");
      out.write("        ");

            
            
        
      out.write("\n");
      out.write("\n");
      out.write("        ");

            String message = (String) request.getAttribute("SHOPPING_MASSAGE");
            if (message == null) {
                message = "";
            }
        
      out.write("\n");
      out.write("        ");
      out.print( message);
      out.write(" \n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
