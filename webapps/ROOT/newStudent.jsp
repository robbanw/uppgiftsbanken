<html>
<head>
<title>Student - ny profil</title>
</head>
<link href="TaskLayout.css" rel="stylesheet"></link>
<body>
<%if(request.getParameter("errmsg") != null){
	String[] errmsges = request.getParameter("errmsg").split(",");
	for(String s : errmsges){%>
		<p class="error"><%=s%></p>
<%	}
}
%>
<form action="/LoginController" method="post">
<input type="hidden" name="action" value="newStudent"/>
<p><b>Fält markerade med (*) är obligatoriska<b></p>
Förnamn:(*)<br>
<input type="text" name="firstname"/><br>
Efternamn:(*)<br>
<input type="text" name="lastname"/><br>
E-mail:(*)<br>
<input type="text" name="email"/><br>
Användarnamn:(*)<br>
<input type="text" name="user"/><br>
Lösenord:(*)<br>
<input type="password" name="pass"/><br>
<input type="submit" value="Skapa profil"/><br>
</form>
</body>
</html>