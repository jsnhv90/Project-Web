package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class StudentBorrowView_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
    _jspx_tagPool_c_if_test.release();
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Borrow</title>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Raleway\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>\n");
      out.write("        <style>\n");
      out.write("            html,body,h1,h2,h3,h4,h5 {font-family: \"Raleway\", sans-serif}\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body class=\"w3-light-grey\">\n");
      out.write("\n");
      out.write("        <!-- Top container -->\n");
      out.write("        <div class=\"w3-bar w3-top w3-black w3-large\" style=\"z-index:4\">\n");
      out.write("            <button class=\"w3-bar-item w3-button w3-hide-large w3-hover-none w3-hover-text-light-grey\" onclick=\"w3_open();\"><i class=\"fa fa-bars\"></i> Menu</button>\n");
      out.write("            <span class=\"w3-bar-item w3-right\">Book Management</span>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <!-- Sidebar/menu -->\n");
      out.write("        <nav class=\"w3-sidebar w3-collapse w3-white w3-animate-left\" style=\"z-index:3;width:300px;\" id=\"mySidebar\"><br>\n");
      out.write("            <div class=\"w3-container w3-row\">\n");
      out.write("                <div class=\"w3-col s4\">\n");
      out.write("                    <img src=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope[\"account\"].male eq true ? \n                               \"/BookManagement/images/avatar_male.png\" : \"/BookManagement/images/avatar_female.png\"}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(" \n");
      out.write("                         class=\"w3-circle w3-margin-right\" style=\"width:50px\" />\n");
      out.write("                </div>\n");
      out.write("                <div class=\"w3-col s8 w3-bar\">\n");
      out.write("                    <span>Welcome,<br><strong>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope[\"account\"].firstName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(' ');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope[\"account\"].lastName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</strong></span>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <hr>\n");
      out.write("            <div class=\"w3-container\">\n");
      out.write("                <h5>Options</h5>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"w3-bar-block\">\n");
      out.write("                <a href=\"#\" class=\"w3-bar-item w3-button w3-padding-16 w3-hide-large w3-dark-grey w3-hover-black\" onclick=\"w3_close()\" title=\"close menu\"><i class=\"fa fa-remove fa-fw\"></i>  Close Menu</a>\n");
      out.write("                <a href=\"/BookManagement/student/search\" class=\"w3-bar-item w3-button w3-padding\"><i class=\"fa fa-search fa-fw\"></i> Search</a>\n");
      out.write("                <a href=\"\" class=\"w3-bar-item w3-button w3-padding w3-blue\"><i class=\"fa fa-eye fa-fw\"></i> View Your Chosen & Borrow</a>\n");
      out.write("                <a href=\"/BookManagement/student/news\" class=\"w3-bar-item w3-button w3-padding\"><i class=\"fa fa-bell fa-fw\"></i> Notification</a>\n");
      out.write("                <a href=\"/BookManagement/student/profile\" class=\"w3-bar-item w3-button w3-padding\"><i class=\"fa fa-bank fa-fw\"></i> Profile</a>\n");
      out.write("                <a href=\"/BookManagement/student/history\" class=\"w3-bar-item w3-button w3-padding\"><i class=\"fa fa-history fa-fw\"></i> History</a>\n");
      out.write("                <a href=\"/BookManagement/logout\" class=\"w3-bar-item w3-button w3-padding\"><i class=\"fa fa-sign-out fa-fw\"></i> Log out</a><br><br>\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <!-- Overlay effect when opening sidebar on small screens -->\n");
      out.write("        <div class=\"w3-overlay w3-hide-large w3-animate-opacity\" onclick=\"w3_close()\" style=\"cursor:pointer\" title=\"close side menu\" id=\"myOverlay\"></div>\n");
      out.write("\n");
      out.write("        <!-- !PAGE CONTENT! -->\n");
      out.write("        <div class=\"w3-main\" style=\"margin-left:300px;margin-top:43px;\">\n");
      out.write("            ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("            ");
      if (_jspx_meth_c_if_1(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\n");
      out.write("            <!-- Footer -->\n");
      out.write("            <footer style=\"bottom: 0; position:fixed\" class=\"w3-container w3-padding-16 w3-light-grey\">\n");
      out.write("                <p>Powered  by  <a href=\"https://www.facebook.com/profile.php?id=100008405071772\" target=\"_blank\">Phan Duy VY</a></p>\n");
      out.write("            </footer>\n");
      out.write("\n");
      out.write("            <!-- End page content  --> \n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <script>\n");
      out.write("            // Get the Sidebar\n");
      out.write("            var mySidebar = document.getElementById(\"mySidebar\");\n");
      out.write("            // Get the DIV with overlay effect\n");
      out.write("            var overlayBg = document.getElementById(\"myOverlay\");\n");
      out.write("            // Toggle between showing and hiding the sidebar, and add overlay effect\n");
      out.write("            function  w3_open() {\n");
      out.write("                if (mySidebar.style.display === 'block') {\n");
      out.write("                    mySidebar.style.display = 'none';\n");
      out.write("                    overlayBg.style.display = \"none\";\n");
      out.write("                } else {\n");
      out.write("                    mySidebar.style.display = 'block';\n");
      out.write("                    overlayBg.style.display = \"block\";\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            // Close the sidebar with  the close button\n");
      out.write("            function  w3_close() {\n");
      out.write("                mySidebar.style.display = \"none\";\n");
      out.write("                overlayBg.style.display = \"none\";\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            function remove(isbn, btn) {\n");
      out.write("                $.ajax({\n");
      out.write("                    type: \"POST\",\n");
      out.write("                    url: \"cart\",\n");
      out.write("                    data: ({\n");
      out.write("                        isbn: isbn\n");
      out.write("                    }),\n");
      out.write("                    success: function (result) {\n");
      out.write("                        alert(result);\n");
      out.write("                        //remove from table\n");
      out.write("                        var row = btn.parentNode.parentNode;\n");
      out.write("                        row.parentNode.removeChild(row);\n");
      out.write("                    }\n");
      out.write("                });\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
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

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${empty requestScope.books}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                <h2>No Chosen Books</h2> \n");
        out.write("            ");
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
    return false;
  }

  private boolean _jspx_meth_c_if_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_1.setPageContext(_jspx_page_context);
    _jspx_th_c_if_1.setParent(null);
    _jspx_th_c_if_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${not empty requestScope.books}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_1 = _jspx_th_c_if_1.doStartTag();
    if (_jspx_eval_c_if_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                <div class=\"w3-container w3-white\">\n");
        out.write("                    <h2>Your Chosen Books</h2>\n");
        out.write("                    <hr>\n");
        out.write("                    <table class=\"w3-table\">\n");
        out.write("                        <tr>\n");
        out.write("                            <th>ISBN</th>\n");
        out.write("                            <th>Title</th>\n");
        out.write("                            <th></th>\n");
        out.write("                            <th></th>\n");
        out.write("                        </tr>\n");
        out.write("                        ");
        if (_jspx_meth_c_forEach_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_1, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("                    </table>\n");
        out.write("                </div>\n");
        out.write("\n");
        out.write("                <div class=\"w3-container w3-white\">\n");
        out.write("\n");
        out.write("                    <form action=\"borrow\" method=\"POST\">\n");
        out.write("                        <hr><span style=\"margin-left: 40%\"></span>\n");
        out.write("                        <input type=\"submit\" class=\"w3-button w3-dark-grey\" value=\"Borrow\">\n");
        out.write("                    </form>\n");
        out.write("\n");
        out.write("                </div>\n");
        out.write("            ");
        int evalDoAfterBody = _jspx_th_c_if_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
    return false;
  }

  private boolean _jspx_meth_c_forEach_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_1);
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.books}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_0.setVar("b");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                            <tr>\n");
          out.write("                                <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${b.isbn}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${b.title}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                <td><a href=\"bookinfo?isbn=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${b.isbn}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" class=\"w3-button\"><i class=\"fa fa-eye\"></i> View</a></td>\n");
          out.write("                                <td><button class=\"w3-button\" onclick=\"remove(");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${b.isbn}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write(", this)\"><i class=\"fa fa-remove\"></i> Remove</button></td>\n");
          out.write("                            </tr>\n");
          out.write("                        ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }
}
