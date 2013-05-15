<%@ page import="java.util.List" %>
<%if(request.getSession(false) == null){%>
	<jsp:forward page="/start.html" />
<%}
if(request.getParameter("tid") == null){%>
	<jsp:forward page="/employer.jsp" />
<%}
if(request.getSession().getAttribute("type").equals("Student")){%>
	<jsp:forward page="/main.jsp" />
<%}
bean.TaskLogic t = ((bean.TaskLogic)pageContext.getServletContext().getAttribute("task"));
ejb.TaskEntity te = t.getTask(Long.parseLong(request.getParameter("tid")));
if(te == null){%>
	<jsp:forward page="/employer.jsp" />
<%}
if(request.getSession().getAttribute("type").equals("Student")){%>
	<jsp:forward page="/main.jsp" />
<%}
ejb.EmployerEntity ee = (ejb.EmployerEntity)request.getSession().getAttribute("user");
if(ee.getId() != te.getEmployerID()){%>
	<jsp:forward page="/employer.jsp" />
<%}%>
<html>
<head>
<title>Administrera - <%=te.getTitle()%></title>
</head>
<link href="TaskLayout.css" rel="stylesheet"/>
<body>
<h1><%=te.getTitle()%></h1>
<form action="/TaskController">
<input type="hidden" name="action" value="logOut"/>
<input class="topmenu" type="submit" value="Logga ut"/>
</form action="/TaskController">
<form class="topmenu" action="/TaskController">
<input type="hidden" name="action" value="backToMain"/>
<input class="topmenu" type="submit" value="Tillbaka till översikt"/>
</form>
<form action="/TaskController">
<input type="hidden" name="action" value="editOpen"/>
<input type="hidden" name="tid" value=<%=te.getId()%>></input>
<%if(te.getOpen() == 1){%>
<input type="hidden" name="open" value="0"/>
<input class="topmenu" type="submit" value="Stäng anmälan"/>
<%}
else{%>
<input type="hidden" name="open" value="1"/>
<input class="topmenu" type="submit" value="Öppna anmälan"/>
<%}%>
</form>
<br>
<br>
<b>Klicka på namnet för att se studentens CV</b>
<table>
<th>Intresserade studenter</th><th>E-mail</th>
<%ejb.StudentEntity se;
List<ejb.StudentToTaskEntity> tslist = t.getNrOfApplicants(te.getId());
for(int i = 0; i < tslist.size(); i++){
	se = t.getStudent(tslist.get(i).getStudentID());
%>
<tr><td><a href="viewStudent.jsp?sid=<%=se.getId()%>"><%=se.getName()%></a></td><td><%=se.getEmail()%></tr>
<%}%>
</table>
</body>
</html>