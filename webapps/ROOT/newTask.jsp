<%if(request.getSession(false) == null){%>
	<jsp:forward page="/start.html" />
<%}
if(request.getSession().getAttribute("type").equals("Student")){%>
	<jsp:forward page="/main.jsp" />
<%}%>
<html>
<head>
<title>Ny uppgift</title>
</head>
<link href="TaskLayout.css" rel="stylesheet"/>
<body>
<h1>Ny uppgift</h1>
<form action="/TaskController">
<input type="hidden" name="action" value="logOut"/>
<input class="topmenu" type="submit" value="Logga ut"/>
</form>
<form class="topmenu" action="/TaskController">
<form class="topmenu" action="/TaskController">
<input type="hidden" name="action" value="backToMain"/>
<input class="topmenu" type="submit" value="Tillbaka till översikt"/>
</form><br>
<br>
<br>
<form action="/TaskController" method="post">
<input type="hidden" name="action" value="createTask"/>
<input class="newTask" type="text" name="title" value="Titel på uppgiften..." />
<textarea class="newTask" name="description" rows="50">Skriv en kort beskrivning av uppgiften (max 1000 tecken)...</textarea>
<input class="centeredButton" type="submit" value="Skapa uppgift"/>
</form>
</body>
</html>