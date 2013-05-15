<%@ page import="java.util.List" %>
<% ejb.EmployerEntity ee;
String name = "";
if(request.getSession(false) == null){%>
	<jsp:forward page="/start.html" />
<%}
if(request.getSession().getAttribute("type").equals("Student")){%>
	<jsp:forward page="/main.jsp" />
<%}
else{
	ee = ((ejb.EmployerEntity)request.getSession().getAttribute("user"));
	if(ee.getOrganisation().equals("")){
		name = ee.getOrganisation();
	}
	else{
		name = ee.getName();
	}
}
%>
<html>
<head>
<title>Översikt - <%=name%></title>
</head>
<link href="TaskLayout.css" rel="stylesheet"/>
<body>
<h1><%=name%></h1>
<form action="/TaskController">
<input type="hidden" name="action" value="logOut"/>
<input class="topmenu" type="submit" value="Logga ut"/>
</form action="/TaskController">
<form class="topmenu" action="/TaskController">
<input type="hidden" name="action" value="newTask"/>
<input class="topmenu" type="submit" value="Skapa ny uppgift"/>
</form>
<p class="displayUser">Inloggad som: <%=name%></p>
<table>
<th>Dina uppgifter</th><th>Antal intresseanmälda studenter</th>
<%bean.TaskLogic t = ((bean.TaskLogic)pageContext.getServletContext().getAttribute("task"));
List<ejb.TaskEntity> tlist = t.findByEmployer(ee.getId());
ejb.TaskEntity task;
List<ejb.StudentToTaskEntity> tslist;
for(int i = 0; i < tlist.size(); i++){
	task = tlist.get(i);
	tslist = t.getNrOfApplicants(task.getId());
%>
<tr><td><a href="administerTask.jsp?tid=<%=task.getId()%>"><%=task.getTitle()%></a></td><td><%=tslist.size()%></tr>
<%}%>
</table>