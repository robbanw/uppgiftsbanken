<%if(request.getSession(false) == null){%>
	<jsp:forward page="/start.html" />
<%}
if(request.getParameter("tid") == null){%>
	<jsp:forward page="/main.jsp" />
<%}
if(request.getSession().getAttribute("type").equals("Employer")){%>
	<jsp:forward page="/employer.jsp" />
<%}
bean.TaskLogic t = ((bean.TaskLogic)pageContext.getServletContext().getAttribute("task"));
ejb.TaskEntity te = t.getTask(Long.parseLong(request.getParameter("tid")));
if(te == null){%>
	<jsp:forward page="/main.jsp" />
<%}
if(request.getSession().getAttribute("type").equals("Employer")){%>
	<jsp:forward page="/employer.jsp" />
<%}
ejb.StudentEntity se = (ejb.StudentEntity)request.getSession().getAttribute("user");
boolean applied = false;
if(t.findEntry(se.getId(),te.getId()) != null){
	applied = true;
}
String description = te.getDescription().replaceAll("\n", "<br/>\n");
%>
<html>
<head>
<title>Uppgift - <%=te.getTitle()%></title>
</head>
<link href="TaskLayout.css" rel="stylesheet"/>
<body>
<h1><%=te.getTitle()%></h1>
<form action="/TaskController">
<input type="hidden" name="action" value="logOut"/>
<input class="topmenu" type="submit" value="Logga ut"/>
</form action="/TaskController">
<form class="topmenu" action="/TaskController">
<input type="hidden" name="action" value="main"/>
<input class="topmenu" type="submit" value="Visa alla uppgifter"/>
</form>
<p class="viewTextBlock"><%=description%></p>
<%if(te.getOpen() == 1 && !applied){%>
	<form action="/TaskController">
	<input type="hidden" name="action" value="apply"/>
	<input type="hidden" name="tid" value=<%=te.getId()%>></input>
	<input class="centeredButton" type="submit" value="Anmäl intresse!"/>
	</form>
<%}
else if(applied){%>
	<br>
	<p class="viewTextBlock"><b>Du har anmält ditt intresse för den här uppgiften.</b></p>
<%}
%>
</body>