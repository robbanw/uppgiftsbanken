<%if(request.getSession(false) == null){%>
	<jsp:forward page="/start.html" />
<%}
if(request.getParameter("sid") == null){%>
	<jsp:forward page="/employer.jsp" />
<%}
if(request.getSession().getAttribute("type").equals("Student")){%>
	<jsp:forward page="/main.jsp" />
<%}
bean.TaskLogic t = ((bean.TaskLogic)pageContext.getServletContext().getAttribute("task"));
ejb.StudentEntity se = t.getStudent(Long.parseLong(request.getParameter("sid")));
if(se == null){%>
	<jsp:forward page="/employer.jsp" />
<%}
String resume = se.getResume().replaceAll("\n", "<br/>\n");
%>
<html>
<head>
<title>Student - <%=se.getName()%></title>
</head>
<link href="TaskLayout.css" rel="stylesheet"/>
<body>
<h1><%=se.getName()%></h1>
<form action="/TaskController">
<input type="hidden" name="action" value="logOut"/>
<input class="topmenu" type="submit" value="Logga ut"/>
</form action="/TaskController">
<form class="topmenu" action="/TaskController">
<input type="hidden" name="action" value="backToMain"/>
<input class="topmenu" type="submit" value="Tillbaka till översikt"/>
</form>
<p class="viewTextBlock"><%=resume%></p>
<br>
<p class="viewTextBlock"><b>Kontakta <%=se.getName()%> på adressen:</b> <%=se.getEmail()%></p>
</body>