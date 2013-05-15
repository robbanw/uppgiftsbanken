package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.openejb.tomcat.installer.Installer;
import java.io.File;
import org.apache.openejb.tomcat.installer.Paths;
import java.util.List;
import java.util.ArrayList;

public final class installer_002dview_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


    private String safeGetAbsolutePath(File file) {
        if (file == null) return "";
        return file.getAbsolutePath();
    }

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

      out.write("<!--\n");
      out.write("\n");
      out.write("    Licensed to the Apache Software Foundation (ASF) under one or more\n");
      out.write("    contributor license agreements.  See the NOTICE file distributed with\n");
      out.write("    this work for additional information regarding copyright ownership.\n");
      out.write("    The ASF licenses this file to You under the Apache License, Version 2.0\n");
      out.write("    (the \"License\"); you may not use this file except in compliance with\n");
      out.write("    the License.  You may obtain a copy of the License at\n");
      out.write("\n");
      out.write("       http://www.apache.org/licenses/LICENSE-2.0\n");
      out.write("\n");
      out.write("    Unless required by applicable law or agreed to in writing, software\n");
      out.write("    distributed under the License is distributed on an \"AS IS\" BASIS,\n");
      out.write("    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\n");
      out.write("    See the License for the specific language governing permissions and\n");
      out.write("    limitations under the License.\n");
      out.write("\n");
      out.write("-->\n");
      out.write("\n");
      out.write("<!-- $Rev: 597221 $ $Date: 2007-11-21 22:51:05 +0100 (Wed, 21 Nov 2007) $ -->\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

    Installer installer = (Installer) request.getAttribute("installer");
    Paths paths = (Paths) request.getAttribute("paths");

      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <META http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("    <title>OpenEJB/Tomcat</title>\n");
      out.write("    <link href=\"default.css\" rel=\"stylesheet\">\n");
      out.write("</head>\n");
      out.write("<body marginwidth=\"0\" marginheight=\"0\" leftmargin=\"0\" bottommargin=\"0\" topmargin=\"0\" vlink=\"#6763a9\" link=\"#6763a9\" bgcolor=\"#ffffff\">\n");
      out.write("    <a name=\"top\"></a>\n");
      out.write("    <table width=\"712\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n");
      out.write("        <tr>\n");
      out.write("            <td bgcolor=\"#5A5CB8\" align=\"left\" valign=\"top\" width=\"7\"><img height=\"9\" width=\"1\" border=\"0\" src=\"images/dotTrans.gif\"></td>\n");
      out.write("            <td bgcolor=\"#5A5CB8\" align=\"left\" valign=\"top\" width=\"40\"><img border=\"0\" height=\"6\" width=\"40\" src=\"images/dotTrans.gif\"></td>\n");
      out.write("            <td bgcolor=\"#5A5CB8\" align=\"left\" valign=\"top\" height=\"2\" width=\"430\"><img border=\"0\" height=\"6\" width=\"430\" src=\"images/top_2.gif\"></td>\n");
      out.write("            <td bgcolor=\"#E24717\" align=\"left\" valign=\"top\" height=\"2\" width=\"120\"><img src=\"images/top_3.gif\" width=\"120\" height=\"6\" border=\"0\"></td>\n");
      out.write("        </tr>\n");
      out.write("        <tr>\n");
      out.write("            <td bgcolor=\"#5A5CB8\" align=\"left\" valign=\"top\" bgcolor=\"#ffffff\" width=\"13\"><img border=\"0\" height=\"15\" width=\"13\" src=\"images/dotTrans.gif\"></td>\n");
      out.write("            <td align=\"left\" valign=\"top\" width=\"40\"><img border=\"0\" height=\"1\" width=\"1\" src=\"images/dotTrans.gif\"></td>\n");
      out.write("            <td align=\"left\" valign=\"middle\" width=\"430\">\n");
      out.write("                <a href=\"http://openejb.apache.org\"><span class=\"menuTopOff\">OpenEJB</span></a>\n");
      out.write("                <img border=\"0\" height=\"2\" width=\"20\" src=\"images/dotTrans.gif\">\n");
      out.write("                <a href=\"index.jsp\"><span class=\"menuTopOff\">Index</span></a>\n");
      out.write("                <img border=\"0\" height=\"2\" width=\"20\" src=\"images/dotTrans.gif\">\n");
      out.write("                <a href=\"viewjndi.jsp\"><span class=\"menuTopOff\">JNDI</span></a>\n");
      out.write("                <img border=\"0\" height=\"2\" width=\"20\" src=\"images/dotTrans.gif\">\n");
      out.write("                <a href=\"viewejb.jsp\"><span class=\"menuTopOff\">EJB</span></a>\n");
      out.write("                <img border=\"0\" height=\"2\" width=\"20\" src=\"images/dotTrans.gif\">\n");
      out.write("                <a href=\"viewclass.jsp\"><span class=\"menuTopOff\">Class</span></a>\n");
      out.write("                <img border=\"0\" height=\"2\" width=\"20\" src=\"images/dotTrans.gif\">\n");
      out.write("                <a href=\"invokeobj.jsp\"><span class=\"menuTopOff\">Invoke</span></a>\n");
      out.write("                <img border=\"0\" height=\"2\" width=\"20\" src=\"images/dotTrans.gif\">\n");
      out.write("            </td>\n");
      out.write("            <td align=\"left\" valign=\"top\" height=\"20\" width=\"120\"><img border=\"0\" height=\"2\" width=\"10\" src=\"images/dotTrans.gif\"></td>\n");
      out.write("        </tr>\n");
      out.write("        <tr>\n");
      out.write("            <td align=\"left\" valign=\"top\" bgcolor=\"#a9a5de\" width=\"7\"><img border=\"0\" height=\"3\" width=\"7\" src=\"images/line_sm.gif\"></td>\n");
      out.write("            <td align=\"left\" valign=\"top\" height=\"3\" width=\"40\"><img border=\"0\" height=\"3\" width=\"40\" src=\"images/line_light.gif\"></td>\n");
      out.write("            <td align=\"left\" valign=\"top\" height=\"3\" width=\"430\"><img border=\"0\" height=\"3\" width=\"430\" src=\"images/line_light.gif\"></td>\n");
      out.write("            <td align=\"left\" valign=\"top\" height=\"3\" width=\"120\"><img height=\"1\" width=\"1\" border=\"0\" src=\"images/dotTrans.gif\"></td>\n");
      out.write("        </tr>\n");
      out.write("        <tr>\n");
      out.write("            <td align=\"left\" valign=\"top\" bgcolor=\"#a9a5de\" width=\"7\">&nbsp;</td>\n");
      out.write("            <td align=\"left\" valign=\"top\" width=\"40\">&nbsp;</td>\n");
      out.write("            <td valign=\"top\" width=\"430\" rowspan=\"4\">\n");
      out.write("                <table width=\"430\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" rows=\"2\" cols=\"1\">\n");
      out.write("                    <tr>\n");
      out.write("                        <td align=\"left\" valign=\"top\"><br>\n");
      out.write("                            <img width=\"200\" vspace=\"0\" src=\"./images/logo_ejb2.gif\" hspace=\"0\" height=\"55\" border=\"0\">\n");
      out.write("                            <br>\n");
      out.write("                            <img src=\"images/dotTrans.gif\" hspace=\"0\" height=\"7\" border=\"0\"><br>\n");
      out.write("                            <span class=\"pageTitle\">\n");
      out.write("                            OpenEJB Installer\n");
      out.write("                            </span>\n");
      out.write("                            <br>\n");
      out.write("                            <img src=\"images/dotTrans.gif\" hspace=\"0\" height=\"1\" border=\"0\"></td>\n");
      out.write("                    </tr>\n");
      out.write("                </table>\n");
      out.write("                <p>\n");

    if (installer != null) {
        if (installer.getStatus() == Installer.Status.REBOOT_REQUIRED) {

      out.write("\n");
      out.write("\n");
      out.write("            <FONT SIZE='2'>\n");
      out.write("                <img border='0' height='3' width='360' src='images/line_light.gif'><br>\n");
      out.write("                <table width='360' cellspacing='4' cellpadding='4' border='0'>\n");

    for (String info : installer.getAlerts().getInfos()) {

      out.write("\n");
      out.write("                    <tr>\n");
      out.write("                        <td><font size='2'>");
      out.print( info );
      out.write("</font></td>\n");
      out.write("                        <td><font size='2' color='green'><b>DONE</b></font></td>\n");
      out.write("                    </tr>\n");

        }

      out.write("\n");
      out.write("                </table>\n");
      out.write("                <img border='0' height='3' width='360' src='images/line_light.gif'>\n");
      out.write("                <br><br>\n");
      out.write("\n");
      out.write("            The installer has completed successfully. <br> \n");
      out.write("            Please, <b>restart Tomcat</b> and reload this page to verify installation.\n");

        } else {
            List<String> errors = new ArrayList<String>(paths.getErrors());
            errors.addAll(installer.getAlerts().getErrors());
            if (!errors.isEmpty()) {

      out.write("          Installation Failed<br><br>\n");
      out.write("            <FONT SIZE='2'>\n");
      out.write("                <img border='0' height='3' width='360' src='images/line_light.gif'><br>\n");
      out.write("                <table width='300' cellspacing='4' cellpadding='4' border='0'>\n");

                for (String error : errors) {

      out.write("\n");
      out.write("                    <tr>\n");
      out.write("                        <td><font size='2'>");
      out.print( error );
      out.write("</font></td>\n");
      out.write("                        <!--<td><font size='2' color='green'><b>DONE</b></font></td>-->\n");
      out.write("                    </tr>\n");

                }

      out.write("\n");
      out.write("                </table>\n");
      out.write("                <img border='0' height='3' width='360' src='images/line_light.gif'>\n");
      out.write("                <br><br>\n");

            } else {

      out.write("\n");
      out.write("            <FONT SIZE='2'>\n");
      out.write("                <img border='0' height='3' width='360' src='images/line_light.gif'><br>\n");
      out.write("                <table width='300' cellspacing='4' cellpadding='4' border='0'>\n");
      out.write("                    <tr>\n");
      out.write("                        <td><font size='2'>Tomcat Listener Installed</font></td>\n");
      out.write("                        ");
 if (installer.isListenerInstalled()) { 
      out.write("\n");
      out.write("                        <td><font size='2' color='green'><b>YES</b></font></td>\n");
      out.write("                        ");
 } else { 
      out.write("\n");
      out.write("                        <td><font size='2' color='red'><b>NO</b></font></td>\n");
      out.write("                        ");
 } 
      out.write("\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td><font size='2'>JavaAgent Installed</font></td>\n");
      out.write("                        ");
 if (installer.isAgentInstalled()) { 
      out.write("\n");
      out.write("                        <td><font size='2' color='green'><b>YES</b></font></td>\n");
      out.write("                        ");
 } else { 
      out.write("\n");
      out.write("                        <td><font size='2' color='red'><b>NO</b></font></td>\n");
      out.write("                        ");
 } 
      out.write("\n");
      out.write("                    </tr>\n");
      out.write("                </table>\n");
      out.write("                <img border='0' height='3' width='360' src='images/line_light.gif'>\n");
      out.write("                <br><br>\n");

            }

      out.write('\n');

            if (installer.getStatus() == Installer.Status.NONE) {
                if (errors.isEmpty()) {

      out.write("\n");
      out.write("                Please verify the file paths are correct and click the install button.\n");

            } else {

      out.write("\n");
      out.write("                Try again?\n");

            }

      out.write("\n");
      out.write("\n");
      out.write("                <br><br>\n");
      out.write("                <form action='/openejb/installer' method='post'>\n");
      out.write("                Catalina Home:\n");
      out.write("                <input type='text' size='100' name='catalinaHome' value='");
      out.print( safeGetAbsolutePath(paths.getCatalinaHomeDir()) );
      out.write("'>\n");
      out.write("                <br>\n");
      out.write("                Catalina Base:\n");
      out.write("                <input type='text' size='100' name='catalinaBase' value='");
      out.print( safeGetAbsolutePath(paths.getCatalinaBaseDir()) );
      out.write("'>\n");
      out.write("                <br>\n");
      out.write("                Catalina server.xml:\n");
      out.write("                <input type='text' size='100' name='serverXml' value='");
      out.print( safeGetAbsolutePath(paths.getServerXmlFile()) );
      out.write("'>\n");
      out.write("                <br><br>\n");
      out.write("                <input type='submit' name='action' value='Install'>\n");
      out.write("                </form>\n");

            } else {

      out.write("\n");
      out.write("                Installation Successful!\n");

            }
        }

      out.write("\n");
      out.write("                </FONT>\n");
      out.write("\n");
      out.write("                </p>\n");
      out.write("                <p>\n");
      out.write("                </p>\n");
      out.write("                <br>\n");
      out.write("                <br>\n");
 } 
      out.write("\n");
      out.write("            </td>\n");
      out.write("            <td align=\"left\" valign=\"top\" height=\"5\" width=\"120\">\n");
      out.write("\n");
      out.write("\n");
      out.write("                &nbsp;</td>\n");
      out.write("        </tr>\n");
      out.write("    </table>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
