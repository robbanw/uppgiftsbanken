package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class viewTask_jsp extends org.apache.jasper.runtime.HttpJspBase
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
if(request.getParameter("tid") == null){
      out.write('\r');
      out.write('\n');
      out.write('	');
      if (true) {
        _jspx_page_context.forward("/main.jsp");
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
bean.TaskLogic t = ((bean.TaskLogic)pageContext.getServletContext().getAttribute("task"));
ejb.TaskEntity te = t.getTask(Long.parseLong(request.getParameter("tid")));
if(te == null){
      out.write('\r');
      out.write('\n');
      out.write('	');
      if (true) {
        _jspx_page_context.forward("/main.jsp");
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
ejb.StudentEntity se = (ejb.StudentEntity)request.getSession().getAttribute("user");
boolean applied = false;
if(t.findEntry(se.getId(),te.getId()) != null){
	applied = true;
}
String description = te.getDescription().replaceAll("\n", "<br/>\n");

      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<title>Uppgift - ");
      out.print(te.getTitle());
      out.write("</title>\r\n");
      out.write("</head>\r\n");
      out.write("<link href=\"TaskLayout.css\" rel=\"stylesheet\"/>\r\n");
      out.write("<body>\r\n");
      out.write("<h1>");
      out.print(te.getTitle());
      out.write("</h1>\r\n");
      out.write("<form action=\"/TaskController\">\r\n");
      out.write("<input type=\"hidden\" name=\"action\" value=\"logOut\"/>\r\n");
      out.write("<input class=\"topmenu\" type=\"submit\" value=\"Logga ut\"/>\r\n");
      out.write("</form action=\"/TaskController\">\r\n");
      out.write("<form class=\"topmenu\" action=\"/TaskController\">\r\n");
      out.write("<input type=\"hidden\" name=\"action\" value=\"main\"/>\r\n");
      out.write("<input class=\"topmenu\" type=\"submit\" value=\"Visa alla uppgifter\"/>\r\n");
      out.write("</form>\r\n");
      out.write("<p class=\"viewTextBlock\">");
      out.print(description);
      out.write("</p>\r\n");
if(te.getOpen() == 1 && !applied){
      out.write("\r\n");
      out.write("\t<form action=\"/TaskController\">\r\n");
      out.write("\t<input type=\"hidden\" name=\"action\" value=\"apply\"/>\r\n");
      out.write("\t<input type=\"hidden\" name=\"tid\" value=");
      out.print(te.getId());
      out.write("></input>\r\n");
      out.write("\t<input class=\"centeredButton\" type=\"submit\" value=\"Anmäl intresse!\"/>\r\n");
      out.write("\t</form>\r\n");
}
else if(applied){
      out.write("\r\n");
      out.write("\t<br>\r\n");
      out.write("\t<p class=\"viewTextBlock\"><b>Du har anmält ditt intresse för den här uppgiften.</b></p>\r\n");
}

      out.write("\r\n");
      out.write("</body>");
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
