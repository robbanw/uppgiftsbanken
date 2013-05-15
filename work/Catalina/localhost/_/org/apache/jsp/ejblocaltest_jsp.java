package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import ejb.*;
import javax.naming.*;
import java.util.Properties;

public final class ejblocaltest_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\n');
      out.write('\n');

try{
	Properties p = new Properties();
	// För att få tillgång till de JNDI-bindningar i openejb där våra EJB:er finns.
	p.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.openejb.client.LocalInitialContextFactory");
	Context ctx = new InitialContext(p);

	Hello h = (Hello)ctx.lookup("HelloEJBLocal");
	out.println("<p>EJB information: " + h);
	out.println("<p>Result of call: " + h.sayHello());

	// Interfacet c används för att skapa upp och söka reda på EJB:er
	// Betrakta det som att c representerar hela tabellen.
	Car c = (Car)ctx.lookup("CarEJBLocal");
	out.println("<p>EJB information: " + c);
	c.addCar("Volvo");
	// ce är en instans av CarEJBLocal
	CarEntity ce = (CarEntity)c.findByPrimaryKey(1);
	out.println("<p>Brand: " + ce.getName());
	ce.setName("Saab");
	c.update(ce);
	out.println("<p>Brand: " + ce.getName());
	java.util.List li = c.findAll();
	out.println("<p>Iteration");
	for(int i = 0; i < li.size(); i++){
   	    	ce = (CarEntity)li.get(i);
		out.println("<p>Brand: " + ce.getName());
	}
}
	catch(NamingException e){
		out.println(e.getMessage());
}

      out.write('\n');
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
