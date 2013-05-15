<!--

    Licensed to the Apache Software Foundation (ASF) under one or more
    contributor license agreements.  See the NOTICE file distributed with
    this work for additional information regarding copyright ownership.
    The ASF licenses this file to You under the Apache License, Version 2.0
    (the "License"); you may not use this file except in compliance with
    the License.  You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

-->

<!-- $Rev: 597221 $ $Date: 2007-11-21 22:51:05 +0100 (Wed, 21 Nov 2007) $ -->

<%@ page import="
javax.servlet.http.HttpServletRequest,
javax.servlet.jsp.JspWriter,
java.io.File
"%>
<%@ page import="org.apache.openejb.tomcat.common.TomcatVersion"%>
<html>
<head>
    <META http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>OpenEJB/Tomcat</title>
    <link href="default.css" rel="stylesheet">
</head>
<body marginwidth="0" marginheight="0" leftmargin="0" bottommargin="0" topmargin="0" vlink="#6763a9" link="#6763a9" bgcolor="#ffffff">
<a name="top"></a>
<table width="712" cellspacing="0" cellpadding="0" border="0">
    <tr>
        <td bgcolor="#5A5CB8" align="left" valign="top" width="7"><img height="9" width="1" border="0" src="images/dotTrans.gif"></td>
        <td bgcolor="#5A5CB8" align="left" valign="top" width="40"><img border="0" height="6" width="40" src="images/dotTrans.gif"></td>
        <td bgcolor="#5A5CB8" align="left" valign="top" height="2" width="530"><img border="0" height="6" width="530" src="images/top_2.gif"></td>
        <td bgcolor="#E24717" align="left" valign="top" height="2" width="120"><img src="images/top_3.gif" width="120" height="6" border="0"></td>
    </tr>
    <tr>
        <td bgcolor="#5A5CB8" align="left" valign="top" bgcolor="#ffffff" width="13"><img border="0" height="15" width="13" src="images/dotTrans.gif"></td>
        <td align="left" valign="top" width="40"><img border="0" height="1" width="1" src="images/dotTrans.gif"></td>
        <td align="left" valign="middle" width="530"><a href="http://openejb.apache.org"><span class="menuTopOff">OpenEJB</span></a><img border="0" height="2" width="20" src="images/dotTrans.gif"><a href="index.jsp"><span class="menuTopOff">Index</span></a><img border="0" height="2" width="20" src="images/dotTrans.gif"><a href="viewjndi.jsp"><span class="menuTopOff">JNDI</span></a><img border="0" height="2" width="20" src="images/dotTrans.gif"><a href="viewejb.jsp"><span class="menuTopOff">EJB</span></a><img border="0" height="2" width="20" src="images/dotTrans.gif"><a href="viewclass.jsp"><span class="menuTopOff">Class</span></a><img border="0" height="2" width="20" src="images/dotTrans.gif"><a href="invokeobj.jsp"><span class="menuTopOff">Invoke</span></a><img border="0" height="2" width="20" src="images/dotTrans.gif"></td>
        <td align="left" valign="top" height="20" width="120"><img border="0" height="2" width="10" src="images/dotTrans.gif"></td>
    </tr>
    <tr>
        <td align="left" valign="top" bgcolor="#a9a5de" width="7"><img border="0" height="3" width="7" src="images/line_sm.gif"></td>
        <td align="left" valign="top" height="3" width="40"><img border="0" height="3" width="40" src="images/line_light.gif"></td>
        <td align="left" valign="top" height="3" width="530"><img border="0" height="3" width="530" src="images/line_light.gif"></td>
        <td align="left" valign="top" height="3" width="120"><img height="1" width="1" border="0" src="images/dotTrans.gif"></td>
    </tr>
    <tr>
        <td align="left" valign="top" bgcolor="#a9a5de" width="7">&nbsp;</td>
        <td align="left" valign="top" width="40">&nbsp;</td>
        <td valign="top" width="530" rowspan="4">
            <table width="530" cellspacing="0" cellpadding="0" border="0" rows="2" cols="1">
                <tr>
                    <td align="left" valign="top"><br>
                        <img width="200" vspace="0" src="./images/logo_ejb2.gif" hspace="0" height="55" border="0">
                        <br>
                        <img src="images/dotTrans.gif" hspace="0" height="7" border="0"><br>
                            <span class="pageTitle">
                            Testing openejb.home validity
                            </span>
                        <br>
                        <img src="images/dotTrans.gif" hspace="0" height="1" border="0"></td>
                </tr>
            </table>
            <p>
            </p>
            <FONT SIZE="2">
                <%
    try{
        synchronized (this) {
            main(request, session, out);
        }
    } catch (Exception e){
        out.println("FAIL");
        //throw e;
        return;
    }
%>
<BR><BR>
<BR>
</FONT>

            </td>
            <td align="left" valign="top" height="5" width="120">


                &nbsp;</td>
        </tr>
    </table>
    </body>
</html>

<%!
    String tab = "&nbsp;&nbsp;&nbsp;&nbsp;";

    static String invLock = "lock";
    static int invCount;

    HttpSession session;
    HttpServletRequest request;
    JspWriter out;

    String OK = "<td><font size='2' color='green'><b>OK</b></font></td></tr>";
    String FAIL = "<td><font size='2' color='red'><b>FAIL</b></font></td></tr>";
    String HR = "<img border='0' height='3' width='340' src='images/line_light.gif'><br>";
    String pepperImg = "<img src='images/pepper.gif' border='0'>";

    /**
     * The main method of this JSP
     */
    public void main(HttpServletRequest request, HttpSession session, JspWriter out) throws Exception {
        this.request = request;
        this.session = session;
        this.out = out;

//        out.print("<b>openejb.home = " + System.getProperty("openejb.home") + "</b><br><br>");
        try {
            out.print(HR);
            out.print("<table width='300' cellspacing='4' cellpadding='4' border='0'>");
            // The openejb.home must be set
            out.print("<tr><td><font size='2'>openejb.home is set</font></td> ");
            String homePath = System.getProperty("openejb.home");
            if (homePath == null) handleError(NO_HOME, INSTRUCTIONS);
            out.print(OK);

            // The openejb.home must exist
            out.print("<tr><td><font size='2'>openejb.home exists</font></td> ");
            File openejbHome = new File(homePath);
            if (!openejbHome.exists()) handleError(BAD_HOME + homePath, NOT_THERE, INSTRUCTIONS);
            out.print(OK);

            // The openejb.home must be a directory
            out.print("<tr><td><font size='2'>openejb.home is a directory</font></td> ");
            if (!openejbHome.isDirectory()) handleError(BAD_HOME + homePath, NOT_DIRECTORY, INSTRUCTIONS);
            out.print(OK);

            // The openejb.home must contain a 'lib' directory
            out.print("<tr><td><font size='2'>has lib directory</font></td> ");

            File openejbHomeLib;
            if (TomcatVersion.v6.isTheVersion()) {
                openejbHomeLib = new File(openejbHome, "lib");
            } else {
                File common = new File(openejbHome, "common");
                openejbHomeLib = new File(common, "lib");
            }
            if (!openejbHomeLib.exists()) handleError(BAD_HOME + homePath, NO_LIB, INSTRUCTIONS);
            out.print(OK);

//            // The openejb.home there must be openejb*.jar files in the 'lib' directory
//            out.print("<tr><td><font size='2'>has openejb* libraries</font></td> ");
//            String[] libs = openejbHomeLib.list();
//            boolean found = false;
//            for (int i = 0; i < libs.length && !found; i++) {
//                found = (libs[i].startsWith("openejb-") && libs[i].endsWith(".jar"));
//            }
//            if (!found) handleError(BAD_HOME + homePath, NO_LIBS, INSTRUCTIONS);
//            out.print(OK);
            out.print("</table>");
            out.print(HR);

            out.print("<br><table><tr><td>" + pepperImg + "</td><td><font size='2'>");
            out.print("<a href='testint.jsp'>Continue tests</a>");
            out.print("</font></td></tr></table>");

        } catch (Exception e) {
            out.print(FAIL);
            out.print("</table>");
            out.print(HR);

            out.print(e.getMessage());
        }
    }

    String NO_HOME = "The openejb.home is not set.";
    String BAD_HOME = "Invalid openejb.home: ";
    String NOT_THERE = "The path specified does not exist.";
    String NOT_DIRECTORY = "The path specified is not a directory.";
    String NO_LIB = "The path specified is not correct, it does not contain a 'lib' directory.";
    String NO_LIBS = "The path specified is not correct, it does not contain any OpenEJB libraries.";
    String INSTRUCTIONS = "Please edit the web.xml of the openejb_loader webapp and set the openejb.home init-param to the full path where OpenEJB is installed.";

    private void handleError(String m1, String m2, String m3) throws Exception {
        String msg = "<br><b>Please Fix:</b><br><br>";
        msg += m1 + "<br><br>";
        msg += m2 + "<br><br>";
        msg += m3 + "<br>";
        throw new Exception(msg);
    }

    private void handleError(String m1, String m2) throws Exception {
        String msg = "<br><b>Please Fix:</b><br><br>";
        msg += m1 + "<br><br>";
        msg += m2 + "<br>";
        throw new Exception(msg);
    }


%>

