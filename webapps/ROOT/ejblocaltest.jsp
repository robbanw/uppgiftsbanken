<%@page import="ejb.*,javax.naming.*,java.util.Properties"%>

<%
try{
	Properties p = new Properties();
	// F�r att f� tillg�ng till de JNDI-bindningar i openejb d�r v�ra EJB:er finns.
	p.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.openejb.client.LocalInitialContextFactory");
	Context ctx = new InitialContext(p);

	Hello h = (Hello)ctx.lookup("HelloEJBLocal");
	out.println("<p>EJB information: " + h);
	out.println("<p>Result of call: " + h.sayHello());

	// Interfacet c anv�nds f�r att skapa upp och s�ka reda p� EJB:er
	// Betrakta det som att c representerar hela tabellen.
	Car c = (Car)ctx.lookup("CarEJBLocal");
	out.println("<p>EJB information: " + c);
	c.addCar("Volvo");
	// ce �r en instans av CarEJBLocal
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
