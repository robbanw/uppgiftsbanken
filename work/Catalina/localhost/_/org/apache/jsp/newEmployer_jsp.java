package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class newEmployer_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<title>Uppdragsgivare - ny profil</title>\r\n");
      out.write("</head>\r\n");
      out.write("<link href=\"TaskLayout.css\" rel=\"stylesheet\"></link>\r\n");
      out.write("<body>\r\n");
if(request.getParameter("errmsg") != null){
	String[] errmsges = request.getParameter("errmsg").split(",");
	for(String s : errmsges){
      out.write("\r\n");
      out.write("\t\t<p class=\"error\">");
      out.print(s);
      out.write("</p>\r\n");
	}
}

      out.write("\r\n");
      out.write("<form action=\"/LoginController\" method=\"post\">\r\n");
      out.write("<input type=\"hidden\" name=\"action\" value=\"newEmployer\"/>\r\n");
      out.write("<p><b>Fält markerade med (*) är obligatoriska<b></p>\r\n");
      out.write("Förnamn:(*)<br>\r\n");
      out.write("<input type=\"text\" name=\"firstname\"/><br>\r\n");
      out.write("Efternamn:(*)<br>\r\n");
      out.write("<input type=\"text\" name=\"lastname\"/><br>\r\n");
      out.write("Företagsnamn/Organisation:<br>\r\n");
      out.write("<input type=\"text\" name=\"organisation\"/><br>\r\n");
      out.write("E-mail:(*)<br>\r\n");
      out.write("<input type=\"text\" name=\"email\"/><br>\r\n");
      out.write("Användarnamn:(*)<br>\r\n");
      out.write("<input type=\"text\" name=\"user\"/><br>\r\n");
      out.write("Lösenord:(*)<br>\r\n");
      out.write("<input type=\"password\" name=\"pass\"/><br>\r\n");
      out.write("<input type=\"submit\" value=\"Skapa profil\"/><br>\r\n");
      out.write("</form>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
