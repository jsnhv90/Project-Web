package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class LoginView_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Book Management</title>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <!--Navbar (sit on top)--> \n");
      out.write("        <div class=\"w3-top\">\n");
      out.write("            <div class=\"w3-bar w3-white w3-wide w3-padding w3-card-2\">\n");
      out.write("                <a href=\"\" class=\"w3-bar-item w3-button\"><b>FPT Library</b></a>\n");
      out.write("                <!--Float links to the right. Hide them on small screens--> \n");
      out.write("                <div class=\"w3-right w3-hide-small\">\n");
      out.write("                    <!--Login form-->\n");
      out.write("                    <form action=\"login\" method=\"POST\">\n");
      out.write("                        <input type=\"text\" placeholder=\"username\" required name=\"username\">\n");
      out.write("                        <input type=\"password\" placeholder=\"password\" required name=\"password\">\n");
      out.write("                        <input type=\"submit\" value=\"Login\" class=\"w3-button w3-gray\"/>\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <!--Header--> \n");
      out.write("        <header class=\"w3-display-container w3-content w3-wide\" style=\"max-width:1500px;\">\n");
      out.write("            <img class=\"w3-image\" src=\"images/FPTlibrary.jpg\" alt=\"Wall paper\" >\n");
      out.write("            <div class=\"w3-display-middle w3-margin-top w3-center\">\n");
      out.write("                <h1 class=\"w3-xxlarge w3-text-white\">\n");
      out.write("                    <span class=\"w3-padding w3-black w3-opacity-min\">\n");
      out.write("                        <b>FPT Library</b>\n");
      out.write("                    </span></h1>\n");
      out.write("            </div>\n");
      out.write("        </header>\n");
      out.write("\n");
      out.write("        <!--Page content--> \n");
      out.write("        <div class=\"w3-content w3-padding\" style=\"max-width:1564px\">\n");
      out.write("\n");
      out.write("            <!--About Section--> \n");
      out.write("            <div class=\"w3-container\">\n");
      out.write("                <h3 class=\"w3-border-bottom w3-border-light-grey w3-padding-16\">About</h3>\n");
      out.write("                <p>\n");
      out.write("                    Book management website provide tools for librarians to manage books easily, and for students\n");
      out.write("                    to get start with the latest titles and greatest books \n");
      out.write("                </p>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <!--Function Session--> \n");
      out.write("            <div class=\"w3-container\">\n");
      out.write("                <h3 class=\"w3-border-bottom w3-border-light-grey w3-padding-16\">Function</h3>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"w3-row-padding w3-grayscale\">\n");
      out.write("                <div class=\"w3-col l3 m6 w3-margin-bottom\">\n");
      out.write("                    <img src=\"images/search.png\" alt=\"Search\" style=\"width:30%\">\n");
      out.write("                    <h3>Find any book</h3>\n");
      out.write("                    <p class=\"w3-opacity\">With data larger than 10000 books with titles, authors and publishers,....\n");
      out.write("                        <br>We help you to search any books you want with keyword</p>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"w3-col l3 m6 w3-margin-bottom\">\n");
      out.write("                    <img src=\"images/ebook.png\" alt=\"Ebook\" style=\"width:30%\">\n");
      out.write("                    <h3>Read online</h3>\n");
      out.write("                    <p class=\"w3-opacity\">We help you to read books everywhere you want, with computer and internet.\n");
      out.write("                        <br>Remember we don't have permission with some books to public it online</p>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"w3-col l3 m6 w3-margin-bottom\">\n");
      out.write("                    <img src=\"images/borrow.png\" alt=\"Borrow\" style=\"width:30%\">\n");
      out.write("                    <h3>Borrow</h3>\n");
      out.write("                    <p class=\"w3-opacity\">You can make a schedule to borrow books that you like.\n");
      out.write("                        <br>And go to library to take them.</p>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"w3-col l3 m6 w3-margin-bottom\">\n");
      out.write("                    <img src=\"images/tools.png\" alt=\"Tool\" style=\"width:30%\">\n");
      out.write("                    <h3>Manage easily</h3>\n");
      out.write("                    <p class=\"w3-opacity\">You can view your history, edit your profile, add to favorite, \n");
      out.write("                        and extends book return date. It'll take some minutes, we promise you.</p>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <!--Contact Section--> \n");
      out.write("            <div class=\"w3-container w3-padding-32\">\n");
      out.write("                <h3 class=\"w3-border-bottom w3-border-light-grey\">Contact</h3>\n");
      out.write("                <p>You can contact us in some way below.</p>\n");
      out.write("                <div class=\"w3-col s4 w3-justify\">\n");
      out.write("                    <p><i class=\"fa fa-fw fa-map-marker\"></i> FPT library</p>\n");
      out.write("                    <p><i class=\"fa fa-fw fa-phone\"></i> 012345678</p>\n");
      out.write("                    <p><i class=\"fa fa-fw fa-envelope\"></i> example@fpt.edu.vn</p>\n");
      out.write("                    <br>\n");
      out.write("                    <i class=\"fa fa-facebook-official w3-hover-opacity w3-large\"></i>\n");
      out.write("                    <i class=\"fa fa-instagram w3-hover-opacity w3-large\"></i>\n");
      out.write("                    <i class=\"fa fa-snapchat w3-hover-opacity w3-large\"></i>\n");
      out.write("                    <i class=\"fa fa-pinterest-p w3-hover-opacity w3-large\"></i>\n");
      out.write("                    <i class=\"fa fa-twitter w3-hover-opacity w3-large\"></i>\n");
      out.write("                    <i class=\"fa fa-linkedin w3-hover-opacity w3-large\"></i>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <!--Footer--> \n");
      out.write("        <footer class=\"w3-center w3-black w3-padding-16\">\n");
      out.write("            <p>Powered by <a href=\"https://www.facebook.com/profile.php?id=100008405071772\" title=\"W3.CSS\" target=\"_blank\" class=\"w3-hover-text-green\">Phan Duy Vy</a></p>\n");
      out.write("        </footer>\n");
      out.write("\n");
      out.write("        <script>\n");
      out.write("\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>");
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
