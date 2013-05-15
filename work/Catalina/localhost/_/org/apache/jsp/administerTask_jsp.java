package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;

public final class administerTask_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\r');
      out.write('\n');
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
        _jspx_page_context.forward("/employer.jsp");
        return;
      }
      out.write('\r');
      out.write('\n');
}
if(request.getSession().getAttribute("type").equals("Student")){
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
bean.TaskLogic t = ((bean.TaskLogic)pageContext.getServletContext().getAttribute("task"));
ejb.TaskEntity te = t.getTask(Long.parseLong(request.getParameter("tid")));
if(te == null){
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
if(request.getSession().getAttribute("type").equals("Student")){
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
ejb.EmployerEntity ee = (ejb.EmployerEntity)request.getSession().getAttribute("user");
if(ee.getId() != te.getEmployerID()){
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
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<title>Administrera - ");
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
      out.write("<input type=\"hidden\" name=\"action\" value=\"backToMain\"/>\r\n");
      out.write("<input class=\"topmenu\" type=\"submit\" value=\"Tillbaka till översikt\"/>\r\n");
      out.write("</form>\r\n");
      out.write("<form action=\"/TaskController\">\r\n");
      out.write("<input type=\"hidden\" name=\"action\" value=\"editOpen\"/>\r\n");
      out.write("<input type=\"hidden\" name=\"tid\" value=");
      out.print(te.getId());
      out.write("></input>\r\n");
if(te.getOpen() == 1){
      out.write("\r\n");
      out.write("<input type=\"hidden\" name=\"open\" value=\"0\"/>\r\n");
      out.write("<input class=\"topmenu\" type=\"submit\" value=\"Stäng anmälan\"/>\r\n");
}
else{
      out.write("\r\n");
      out.write("<input type=\"hidden\" name=\"open\" value=\"1\"/>\r\n");
      out.write("<input class=\"topmenu\" type=\"submit\" value=\"Öppna anmälan\"/>\r\n");
}
      out.write("\r\n");
      out.write("</form>\r\n");
      out.write("<br>\r\n");
      out.write("<br>\r\n");
      out.write("<b>Klicka på namnet för att se studentens CV</b>\r\n");
      out.write("<table>\r\n");
      out.write("<th>Intresserade studenter</th><th>E-mail</th>\r\n");
ejb.StudentEntity se;
List<ejb.StudentToTaskEntity> tslist = t.getNrOfApplicants(te.getId());
for(int i = 0; i < tslist.size(); i++){
	se = t.getStudent(tslist.get(i).getStudentID());

      out.write("\r\n");
      out.write("<tr><td><a href=\"viewStudent.jsp?sid=");
      out.print(se.getId());
      out.write('"');
      out.write('>');
      out.print(se.getName());
      out.write("</a></td><td>");
      out.print(se.getEmail());
      out.write("</tr>\r\n");
}
      out.write("\r\n");
      out.write("</table>\r\n");
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
