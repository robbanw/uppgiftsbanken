<% String name = "";
String resume = "";
if(request.getSession(false) == null){%>
	<jsp:forward page="/start.html" />
<%}
if(request.getSession().getAttribute("type").equals("Employer")){%>
	<jsp:forward page="/employer.jsp" />
<%}
else{
	ejb.StudentEntity se = ((ejb.StudentEntity)request.getSession().getAttribute("user"));
	name = se.getName();
	resume = se.getResume();
%>
<html>
<head>
<title>Min sida - <%=name%></title>
</head>
<link href="TaskLayout.css" rel="stylesheet"/>
<body>
<h1><%=name%></h1>
<form action="/TaskController">
<input type="hidden" name="action" value="logOut"/>
<input class="topmenu" type="submit" value="Logga ut"/>
</form action="/TaskController">
<form class="topmenu" action="/TaskController">
<input type="hidden" name="action" value="main"/>
<input class="topmenu" type="submit" value="Visa uppdrag"/>
</form>
<h2>Ditt CV:</h2>
<%if(request.getParameter("tooLong") != null){
	if(request.getParameter("tooLong").equals("yes")){%>
	<p class="error">Ditt CV inneh�ll mer �n 1000 tecken och klipptes d�rf�r av!</p>
	<%}
}%>
<p>Ett CV f�r max vara 1000 tecken l�ngt</p>
<form action="/TaskController" method="post">
<textarea name="cv" rows="40" cols="90"><%=resume%></textarea>
<input type="hidden" name="action" value="updateCV"/>
<input type="submit" value="Uppdatera"/>
</form>
</body>
</html>
<%}%>