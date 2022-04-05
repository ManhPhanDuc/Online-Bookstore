package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import sample.user.UserDTO;

public final class admin_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Admin Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>  \n");
      out.write("        ");

            UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");
            if (loginUser == null || !"1".equals(loginUser.getRoleID().trim())) {
                response.sendRedirect("login.html");
                return;
            }
            String search = (String) request.getParameter("search");
            if (search == null) {
                search = "";
            }

        
      out.write("\n");
      out.write("        <h1>Hello ADmin: ");
      out.print( loginUser.getFullName());
      out.write("</h1>\n");
      out.write("        <form action=\"MainController\">\n");
      out.write("            <input type=\"submit\" name=\"action\" value=\"Logout\" />\n");
      out.write("        </form>\n");
      out.write("        <form action=\"MainController\">\n");
      out.write("            Search<input type=\"text\" name=\"search\" value=\"");
      out.print( search);
      out.write("\"/>\n");
      out.write("            <input type=\"submit\" name=\"action\" value=\"Search\"/>\n");
      out.write("        </form>\n");
      out.write("\n");
      out.write("        ");

            List<UserDTO> list = (List<UserDTO>) request.getAttribute("LIST_USER");
            if (list != null) {
                if (!list.isEmpty()) {


        
      out.write("\n");
      out.write("\n");
      out.write("        <table border=\"1\">\n");
      out.write("            <thead>\n");
      out.write("                <tr>\n");
      out.write("                    <th>NO</th>\n");
      out.write("                    <th>User ID</th>\n");
      out.write("                    <th>Full Name</th>\n");
      out.write("                    <th>Role ID</th>\n");
      out.write("                    <th>Password</th>\n");
      out.write("                    <th>Phone Number</th>\n");
      out.write("                    <th>Address</th>\n");
      out.write("                    <th>Status ID</th>\n");
      out.write("                    <th>Create date</th>     \n");
      out.write("                    <th>Delete</th>\n");
      out.write("                    <th>Update</th>\n");
      out.write("                </tr>\n");
      out.write("            </thead>\n");
      out.write("            <tbody>\n");
      out.write("                ");
   int count = 1;
                    for (UserDTO dto : list) {
                
      out.write("\n");
      out.write("                <tr>\n");
      out.write("            <form action=\"MainController\">\n");
      out.write("\n");
      out.write("                <td>");
      out.print(count++);
      out.write("</td>\n");
      out.write("                <td>\n");
      out.write("                    <input type=\"text\" name=\"userID\" value=\" ");
      out.print(dto.getUserID());
      out.write("\" readonly/>\n");
      out.write("                </td>\n");
      out.write("                <td><input type=\"text\" name=\"fullName\" value=\"");
      out.print(dto.getFullName());
      out.write("\"/></td>\n");
      out.write("                <td><input type=\"text\" name=\"roleID\" value=\"");
      out.print(dto.getRoleID());
      out.write("\"/></td>\n");
      out.write("                <td>");
      out.print(dto.getPassword());
      out.write("</td>\n");
      out.write("                <td>\n");
      out.write("                    <input type=\"text\" name=\"phoneNumber\" value=\"");
      out.print(dto.getPhoneNumber());
      out.write("\"/>\n");
      out.write("\n");
      out.write("                </td>\n");
      out.write("                <td>\n");
      out.write("                    <input type=\"text\" name=\"address\" value=\"");
      out.print(dto.getAddress());
      out.write("\"/>\n");
      out.write("\n");
      out.write("                </td>\n");
      out.write("                <td>\n");
      out.write("                    <input type=\"text\" name=\"statusID\" value=\"");
      out.print(dto.getStatusID());
      out.write("\"/>\n");
      out.write("\n");
      out.write("                </td>\n");
      out.write("                <td>");
      out.print(dto.getCreateDate());
      out.write("</td>\n");
      out.write("\n");
      out.write("                <td>\n");
      out.write("\n");
      out.write("                    <a href=\"MainController?action=Delete&userID=");
      out.print( dto.getUserID());
      out.write("\n");
      out.write("                       &search=");
      out.print( search);
      out.write("\" >Delete</a>\n");
      out.write("\n");
      out.write("                </td>\n");
      out.write("\n");
      out.write("\n");
      out.write("                <td>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                    <input type=\"hidden\" name=\"search\" value=\"");
      out.print( search);
      out.write("\"/>\n");
      out.write("                    <input type=\"submit\" name=\"action\" value=\"Confirm Update\"/>\n");
      out.write("            </form>\n");
      out.write("        </td>   \n");
      out.write("    </tr>\n");
      out.write("    ");

        }
    
      out.write("\n");
      out.write("</tbody>\n");
      out.write("</table>\n");
      out.write("\n");

        }
    }

      out.write("\n");
      out.write("\n");
      out.write("</body>\n");
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
