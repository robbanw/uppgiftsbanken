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
org.apache.openejb.BeanType,
org.apache.openejb.DeploymentInfo,
org.apache.openejb.loader.SystemInstance,
org.apache.openejb.spi.ContainerSystem,
javax.naming.Context,
javax.naming.InitialContext
"%>
<%@ page import="javax.servlet.http.HttpServletRequest" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="java.io.IOException" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Properties" %>
<%@ page import="java.lang.reflect.Field" %>
<%@ page import="java.lang.reflect.Method" %>
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
        <td bgcolor="#5A5CB8" align="left" valign="top" height="2" width="430"><img border="0" height="6" width="430" src="images/top_2.gif"></td>
        <td bgcolor="#E24717" align="left" valign="top" height="2" width="120"><img src="images/top_3.gif" width="120" height="6" border="0"></td>
    </tr>
    <tr>
        <td bgcolor="#5A5CB8" align="left" valign="top" bgcolor="#ffffff" width="13"><img border="0" height="15" width="13" src="images/dotTrans.gif"></td>
        <td align="left" valign="top" width="40"><img border="0" height="1" width="1" src="images/dotTrans.gif"></td>
        <td align="left" valign="middle" width="430"><a href="http://openejb.apache.org"><span class="menuTopOff">OpenEJB</span></a><img border="0" height="2" width="20" src="images/dotTrans.gif"><a href="index.jsp"><span class="menuTopOff">Index</span></a><img border="0" height="2" width="20" src="images/dotTrans.gif"><a href="viewjndi.jsp"><span class="menuTopOff">JNDI</span></a><img border="0" height="2" width="20" src="images/dotTrans.gif"><a href="viewejb.jsp"><span class="menuTopOff">EJB</span></a><img border="0" height="2" width="20" src="images/dotTrans.gif"><a href="viewclass.jsp"><span class="menuTopOff">Class</span></a><img border="0" height="2" width="20" src="images/dotTrans.gif"><a href="invokeobj.jsp"><span class="menuTopOff">Invoke</span></a><img border="0" height="2" width="20" src="images/dotTrans.gif"></td>
        <td align="left" valign="top" height="20" width="120"><img border="0" height="2" width="10" src="images/dotTrans.gif"></td>
    </tr>
    <tr>
        <td align="left" valign="top" bgcolor="#a9a5de" width="7"><img border="0" height="3" width="7" src="images/line_sm.gif"></td>
        <td align="left" valign="top" height="3" width="40"><img border="0" height="3" width="40" src="images/line_light.gif"></td>
        <td align="left" valign="top" height="3" width="430"><img border="0" height="3" width="430" src="images/line_light.gif"></td>
        <td align="left" valign="top" height="3" width="120"><img height="1" width="1" border="0" src="images/dotTrans.gif"></td>
    </tr>
    <tr>
        <td align="left" valign="top" bgcolor="#a9a5de" width="7">&nbsp;</td>
        <td align="left" valign="top" width="40">&nbsp;</td>
        <td valign="top" width="430" rowspan="4">
            <table width="430" cellspacing="0" cellpadding="0" border="0" rows="2" cols="1">
                <tr>
                    <td align="left" valign="top"><br>
                        <img width="200" vspace="0" src="./images/logo_ejb2.gif" hspace="0" height="55" border="0">
                        <br>
                        <img src="images/dotTrans.gif" hspace="0" height="7" border="0"><br>
                            <span class="pageTitle">
                            OpenEJB Enterprise JavaBeans Viewer
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
        String ejb = request.getParameter("ejb");
        String jndiName = request.getParameter("jndiName");
        String contextID = request.getParameter("ctxID");
        if (ejb == null) {
            out.print("No EJB specified");
        } else {
            printEjb(ejb,jndiName,contextID,out, session);
        }
    } catch (Exception e){
        
        out.println("FAIL: ");
        out.print(e.getMessage());
        throw e;
        //return;
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
    private DeploymentInfo getDeployment(String deploymentID) {
        try {
            ContainerSystem containerSystem = SystemInstance.get().getComponent(ContainerSystem.class);
            DeploymentInfo ejb = containerSystem.getDeploymentInfo(deploymentID);
            return ejb;
        } catch (Exception e) {
            return null;
        }
    }

    String tab = "&nbsp;&nbsp;&nbsp;&nbsp;";

    public void printEjb(String name,String jndiName, String contextID, javax.servlet.jsp.JspWriter out, HttpSession session) throws Exception {
        String id = (name.startsWith("/")) ? name.substring(1, name.length()) : name;
        DeploymentInfo ejb = getDeployment(id);

        if (ejb == null) {
            out.print("No such EJB: " + id);
            return;
        }
        String type = null;

        switch (ejb.getComponentType()) {
            case CMP_ENTITY:
                type = "EntityBean with Container-Managed Persistence";
                break;
            case BMP_ENTITY:
                type = "EntityBean with Bean-Managed Persistence";
                break;
            case STATEFUL:
                type = "Stateful SessionBean";
                break;
            case STATELESS:
                type = "Stateless SessionBean";
                break;
            case SINGLETON:
                type = "Singleton SessionBean";
                break;
            case MANAGED:
                type = "Managed SessionBean";
                break;
            default:
                type = "Unkown Bean Type";
                break;
        }
        out.print("<b>" + type + "</b><br>");
        out.print("<table>");
        printRow("JNDI Name", jndiName, out);
        if(ejb.getRemoteInterface() != null)
        printRow("Remote Interface", getClassRef(ejb.getRemoteInterface(),session), out);
        if(ejb.getHomeInterface() != null)
        printRow("Home Interface", getClassRef(ejb.getHomeInterface(),session), out);
        if(ejb.getBeanClass() != null)
        printRow("Bean Class", getClassRef(ejb.getBeanClass(),session), out);
        if(ejb.getBusinessLocalInterfaces().size() > 0)
        printRow("Business Local Interfaces", getClassRefs(ejb.getBusinessLocalInterfaces(),session), out);
        if(ejb.getBusinessRemoteInterfaces().size() > 0)
        printRow("Business Remote Interfaces", getClassRefs(ejb.getBusinessRemoteInterfaces(),session), out);        
        if (ejb.getComponentType() == BeanType.BMP_ENTITY || ejb.getComponentType() == BeanType.CMP_ENTITY) {
            printRow("Primary Key", getClassRef(ejb.getPrimaryKeyClass(),session), out);
        }
        String pepperImg = "<img src='images/pepper.gif' border='0'>";
        out.print("</table>");
        out.print("<br><br><b>Actions:</b><br>");
        out.print("<table>");

        // Browse JNDI with this ejb
        //javax.servlet.http.HttpSession session = this.session;
        //noinspection unchecked
        Map<String, Object> objects = (Map<String, Object>) session.getAttribute("objects");
        if (objects == null) {
            objects = new HashMap<String, Object>();
            session.setAttribute("objects", objects);
        }
        
        
        Context ctx;
        if(contextID == null){
        Properties p = new Properties();

        p.put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.openejb.client.LocalInitialContextFactory");
        p.put("openejb.loader", "embed");

        ctx = new InitialContext(p);
        }else{
          ctx = (Context)session.getAttribute(contextID);
        }
        Object obj = ctx.lookup(jndiName);
 //       String objID = ejb.getHomeInterface().getName() + "@" + obj.hashCode(); 
        String objID = ""+obj.hashCode(); //TODO: Not the best of the ID's, more meaningful ID would be better. Right now hashcode would suffice
        objects.put(objID, obj);
        String invokerURL = "<a href='invokeobj.jsp?obj=" + objID + "'>Invoke this EJB</a>";
        printRow(pepperImg, invokerURL, out);

        Context enc = ejb.getJndiEnc();
        String ctxID = "enc" + enc.hashCode();
        session.setAttribute(ctxID, enc);
        String jndiURL = "<a href='viewjndi.jsp?ctxID=" + ctxID + "'>Browse this EJB's private JNDI namespace</a>";
        printRow(pepperImg, jndiURL, out);
        out.print("</table>");

    }

    protected void printRow(String col1, String col2, javax.servlet.jsp.JspWriter out) throws IOException {
        out.print("<tr><td><font size='2'>");
        out.print(col1);
        out.print("</font></td><td><font size='2'>");
        out.print(col2);
        out.print("</font></td></tr>");
    }

    public String getClassRef(Class clazz, HttpSession session) throws Exception {
        String name = clazz.getName();
        session.setAttribute(name,clazz);
        return "<a href='viewclass.jsp?class=" + name + "'>" + name + "</a>";
    }
    public String getClassRefs(List<Class> classes, HttpSession session) throws Exception{
        String refs = "";
        for(Class clazz: classes){
           refs += getClassRef(clazz,session)+"<br/>";
        }
        return refs;
    }
    public String getShortClassRef(Class clazz) throws Exception {
        if (clazz.isPrimitive()) {
            return "<font color='gray'>" + clazz.getName() + "</font>";
        } else if (clazz.isArray() && clazz.getComponentType().isPrimitive()) {
            return "<font color='gray'>" + clazz.getComponentType() + "[]</font>";
        } else if (clazz.isArray()) {
            String name = clazz.getComponentType().getName();
            int dot = name.lastIndexOf(".") + 1;
            String shortName = name.substring(dot, name.length());
            return "<a href='viewclass.jsp?class=" + name + "'>" + shortName + "[]</a>";
        } else {
            String name = clazz.getName();
            int dot = name.lastIndexOf(".") + 1;
            String shortName = name.substring(dot, name.length());
            return "<a href='viewclass.jsp?class=" + name + "'>" + shortName + "</a>";
        }
    }

%>

