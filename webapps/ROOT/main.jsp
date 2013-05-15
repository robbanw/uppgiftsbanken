<%@ page import="java.util.List" %>
<% String name = "";
if(request.getSession(false) == null){%>
	<jsp:forward page="/start.html" />
<%}
if(request.getSession().getAttribute("type").equals("Employer")){%>
	<jsp:forward page="/employer.jsp" />
<%}
else{
	name = ((ejb.StudentEntity)request.getSession().getAttribute("user")).getName();
%>
<html>
<head>
<title>Huvudsida - uppdrag</title>
</head>
<link href="TaskLayout.css" rel="stylesheet"/>
<body>
<h1>Uppgiftsbanken</h1>
<form action="/TaskController">
<input type="hidden" name="action" value="logOut"/>
<input class="topmenu" type="submit" value="Logga ut"/>
</form action="/TaskController">
<form class="topmenu" action="/TaskController">
<input type="hidden" name="action" value="myPage"/>
<input class="topmenu" type="submit" value="Min profil"/>
</form>
<p class="displayUser">Inloggad som: <%=name%></p>
<table>
<th>Uppgift</th><th>Uppdragsgivare</th>
<%bean.TaskLogic t = ((bean.TaskLogic)pageContext.getServletContext().getAttribute("task"));
List tlist = t.getTasks();
ejb.TaskEntity task;
ejb.EmployerEntity ee;
String employer = "";
for(int i = 0; i < tlist.size();i++){
	task = (ejb.TaskEntity)tlist.get(i);
	ee = t.getEmployer(task.getEmployerID());
	if(ee.getOrganisation().equals("")){
		employer = ee.getName();
	}
	else{
		employer = ee.getOrganisation();
	}
%>
<tr><td><a href="viewTask.jsp?tid=<%=task.getId()%>"><%=task.getTitle()%></a></td><td><%=employer%></td></tr>
<%}%>
</table>
</body>
</html>
<%}%>