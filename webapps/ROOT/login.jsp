<html>
<head>
<%
if(request.getParameter("status") != null){
	if(request.getParameter("status").equals("failed")){%>
	<p class="error">Felaktigt användarnamn eller lösenord</p>
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
Användarnamn:<br>
<input type="text" name="user"><br>
Lösenord:<br>
<input type="password" name="pass"/><br>
<input type="submit" value="Logga in"/><br>
</form>
<form>
<input type="hidden" name="type" value=<%=type%>></input>
<input type="hidden" name="action" value="newProfile"/>
<p><b>Ny användare? Det är bara att klicka på knappen nedan och skriva in dina uppgifter för att registrera dig!</b></p>
<input type="submit" value="Skapa ett konto!"/><br>
</form>
</body>
</html>