<%@page import="ejb.*,javax.naming.*,java.util.Properties"%>

<%
try{
	Properties p = new Properties();
	// För att få tillgång till de JNDI-bindningar i openejb där våra EJB:er finns.
	p.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.openejb.client.LocalInitialContextFactory");
	Context ctx = new InitialContext(p);

	Hello h = (Hello)ctx.lookup("HelloEJBLocal");
	out.println("<p>EJB information: " + h);
	out.println("<p>Result of call: " + h.sayHello());

	// Interfacet c används för att skapa upp och söka reda på EJB:er
	// Betrakta det som att c representerar hela tabellen.
	Car c = (Car)ctx.lookup("CarEJBLocal");
	out.println("<p>EJB information: " + c);
	c.addCar("Volvo");
	// ce är en instans av CarEJBLocal
	CarEntity ce = (CarEntity)c.findByPrimaryKey(1);
	out.println("<p>Brand: " + ce.getName());
	ce.setName("Saab");
	c.update(ce);
	out.println("<p>Brand: " + ce.getName());
	java.util.List li = c.findAll();
	out.println("<p>Iteration");
	for(int i = 0; i < li.size(); i++){
   	    	ce = (CarEntity)li.get(i);
		out.println("<p>Brand: " + ce.getName());
	}
}
	catch(NamingException e){
		out.println(e.getMessage());
}
%>
