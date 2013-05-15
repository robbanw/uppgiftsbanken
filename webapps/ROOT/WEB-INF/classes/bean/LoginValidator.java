package bean;
import javax.ejb.*;
import javax.naming.*;
import java.util.Properties;
import java.util.List;
import java.security.*;

public class LoginValidator{

	private Properties p;
	private Context ctx;
	private MessageDigest md;

	public LoginValidator(){
		p = new Properties();
		// För att få tillgång till de JNDI-bindningar i openejb där våra EJB:er finns.
		p.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.openejb.client.LocalInitialContextFactory");
		try{
			ctx = new InitialContext(p);
			md = MessageDigest.getInstance("SHA-256");
		}
		catch(NoSuchAlgorithmException ne){
			System.out.print(ne.getMessage());
		}
		catch(NamingException ne){
			System.out.print(ne.getMessage());
		}		
	}
	
	public ejb.StudentEntity validateStudent(String username, String password){
		ejb.Student s = null;
		try{
			s = (ejb.Student)ctx.lookup("StudentEJBLocal");
		}
		catch(NamingException e){
			System.out.print(e.getMessage());
		}
		//Hashing the supplied password
		md.update(password.getBytes());
		byte[] hashedPass = md.digest();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < hashedPass.length; i++) {
			sb.append(Integer.toString((hashedPass[i] & 0xff) + 0x100, 16).substring(1));
		}
		List<ejb.StudentEntity> list = s.validateLogin(username, sb.toString());
		if(list == null){
			return null;
		}
		return list.get(0);
	}
	
	public ejb.EmployerEntity validateEmployer(String username, String password){
		ejb.Employer e = null;
		try{
			e = (ejb.Employer)ctx.lookup("EmployerEJBLocal");
		}
		catch(NamingException ne){
			System.out.print(ne.getMessage());
		}
		//Hashing the supplied password
		md.update(password.getBytes());
		byte[] hashedPass = md.digest();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < hashedPass.length; i++) {
			sb.append(Integer.toString((hashedPass[i] & 0xff) + 0x100, 16).substring(1));
		}		
		List<ejb.EmployerEntity> list = e.validateLogin(username, sb.toString());
		if(list == null){
			return null;
		}
		return list.get(0);
	}
	
	public ejb.StudentEntity addStudent(String name, String email, String username, String password){
		ejb.Student s = null;
		try{
			s = (ejb.Student)ctx.lookup("StudentEJBLocal");
		}
		catch(NamingException e){
			System.out.print(e.getMessage());
		}
		//Hashing the supplied password
		md.update(password.getBytes());
		byte[] hashedPass = md.digest();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < hashedPass.length; i++) {
			sb.append(Integer.toString((hashedPass[i] & 0xff) + 0x100, 16).substring(1));
		}
		return s.addStudent(name, email, username, sb.toString());
	}
	
	public ejb.EmployerEntity addEmployer(String name, String email, String username, String password, String organisation){
		ejb.Employer e = null;
		try{
			e = (ejb.Employer)ctx.lookup("EmployerEJBLocal");
		}
		catch(NamingException ne){
			System.out.print(ne.getMessage());
		}
		//Hashing the supplied password
		md.update(password.getBytes());
		byte[] hashedPass = md.digest();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < hashedPass.length; i++) {
			sb.append(Integer.toString((hashedPass[i] & 0xff) + 0x100, 16).substring(1));
		}
		return e.addEmployer(name, email, username, sb.toString(), organisation);
	}
	
	public boolean duplicateStudentUName(String username){
		ejb.Student s = null;
		try{
			s = (ejb.Student)ctx.lookup("StudentEJBLocal");
		}
		catch(NamingException e){
			System.out.print(e.getMessage());
		}
		return s.validateUsername(username);
	}
	
	public boolean duplicateEmployerUName(String username){
		ejb.Employer e = null;
		try{
			e = (ejb.Employer)ctx.lookup("EmployerEJBLocal");
		}
		catch(NamingException ne){
			System.out.print(ne.getMessage());
		}
		return e.validateUsername(username);
	}
}