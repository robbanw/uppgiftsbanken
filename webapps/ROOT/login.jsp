<html>
<head>
<%
if(request.getParameter("status") != null){
	if(request.getParameter("status").equals("failed")){%>
	<p class="error">Felaktigt anv�ndarnamn eller l�senord</p>
	<%}
}
String type = request.getParameter("type");
%>
<title><%=type%> - inloggning</title>
</head>
<link href="TaskLayout.css" rel="stylesheet"/>
<body>
<h2>Inloggning</h2>
<form action="/LoginController" method="post">
<input type="hidden" name="type" value=<%=type%>></input>
<input type="hidden" name="action" value="logIn"/>
Anv�ndarnamn:<br>
<input type="text" name="user"><br>
L�senord:<br>
<input type="password" name="pass"/><br>
<input type="submit" value="Logga in"/><br>
</form>
<form>
<input type="hidden" name="type" value=<%=type%>></input>
<input type="hidden" name="action" value="newProfile"/>
<p><b>Ny anv�ndare? Det �r bara att klicka p� knappen nedan och skriva in dina uppgifter f�r att registrera dig!</b></p>
<input type="submit" value="Skapa ett konto!"/><br>
</form>
</body>
</html>