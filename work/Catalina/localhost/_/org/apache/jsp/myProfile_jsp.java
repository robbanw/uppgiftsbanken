package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class myProfile_jsp extends org.apache.jasper.runtime.HttpJspBase
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

 String name = "";
String resume = "";
if(request.getSession(false) == null){
      out.write('\r');
      out.write('\n');
      out.write('	');
      if (true) {
        _jspx_page_context.forward("/start.html");
        return;
      }
      out.write('\r');
      out.write('\n');
}
if(request.getSession().getAttribute("type").equals("Employer")){
      out.write('\r');
      out.write('\n');
      out.write('	');
      if (true) {
        _jspx_page_context.forward("/employer.jsp");
        return;
      }
      out.write('\r');
      out.write('\n');
}
else{
	ejb.StudentEntity se = ((ejb.StudentEntity)request.getSession().getAttribute("user"));
	name = se.getName();
	resume = se.getResume();

      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<title>Min sida - ");
      out.print(name);
      out.write("</title>\r\n");
      out.write("</head>\r\n");
      out.write("<link href=\"TaskLayout.css\" rel=\"stylesheet\"/>\r\n");
      out.write("<body>\r\n");
      out.write("<h1>");
      out.print(name);
      out.write("</h1>\r\n");
      out.write("<form action=\"/TaskController\">\r\n");
      out.write("<input type=\"hidden\" name=\"action\" value=\"logOut\"/>\r\n");
      out.write("<input class=\"topmenu\" type=\"submit\" value=\"Logga ut\"/>\r\n");
      out.write("</form action=\"/TaskController\">\r\n");
      out.write("<form class=\"topmenu\" action=\"/TaskController\">\r\n");
      out.write("<input type=\"hidden\" name=\"action\" value=\"main\"/>\r\n");
      out.write("<input class=\"topmenu\" type=\"submit\" value=\"Visa uppdrag\"/>\r\n");
      out.write("</form>\r\n");
      out.write("<h2>Ditt CV:</h2>\r\n");
if(request.getParameter("tooLong") != null){
	if(request.getParameter("tooLong").equals("yes")){
      out.write("\r\n");
      out.write("\t<p class=\"error\">Ditt CV innehöll mer än 1000 tecken och klipptes därför av!</p>\r\n");
      out.write("\t");
}
}
      out.write("\r\n");
      out.write("<p>Ett CV får max vara 1000 tecken långt</p>\r\n");
      out.write("<form action=\"/TaskController\" method=\"post\">\r\n");
      out.write("<textarea name=\"cv\" rows=\"40\" cols=\"90\">");
      out.print(resume);
      out.write("</textarea>\r\n");
      out.write("<input type=\"hidden\" name=\"action\" value=\"updateCV\"/>\r\n");
      out.write("<input type=\"submit\" value=\"Uppdatera\"/>\r\n");
      out.write("</form>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
}
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
