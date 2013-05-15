import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginController extends HttpServlet{
    
	public static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
    public void doGet(HttpServletRequest request, HttpServletResponse response){
		RequestDispatcher rd;
		try{
			//We have a request to create a new profile, investigate what type of profile that is to be created
			if(request.getParameter("action").equals("newProfile")){
				if(request.getParameter("type").equals("Student")){
					rd = request.getRequestDispatcher("newStudent.jsp");
				}
				else{
					rd = request.getRequestDispatcher("newEmployer.jsp");
				}
			}
			//A user is coming from the start page, redirect to appropriate login
			else{
				rd = request.getRequestDispatcher("login.jsp?type=" + request.getParameter("action"));
			}
			rd.forward(request, response);
		}
		catch(ServletException e){
			System.out.print(e.getMessage());
		}
		catch(IOException e){
			System.out.print(e.getMessage());
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response){
		RequestDispatcher rd;
		Pattern pattern = null;
		Matcher matcher = null;
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		response.setDateHeader("Expires", 0); // Proxies.
		
		ServletContext sc = getServletContext();
		if(sc.getAttribute("task")==null){
			sc.setAttribute("task", new bean.TaskLogic());
		}
		
		try{
			bean.LoginValidator lv = new bean.LoginValidator();
			HttpSession session = request.getSession(true);
			
			//We have a login, investigate what type of login that is to be validated
			if(request.getParameter("action").equals("logIn")){
				//Student login
				if(request.getParameter("type").equals("Student")){
					ejb.StudentEntity se = ((ejb.StudentEntity)lv.validateStudent(request.getParameter("user"), request.getParameter("pass")));
					if(se == null){
						rd = request.getRequestDispatcher("login.jsp?status=failed");
					}
					else{
						session.setAttribute("user",se);
						session.setAttribute("type","Student");
						rd = request.getRequestDispatcher("main.jsp");
					}
				}
				//Employer login
				else{
					ejb.EmployerEntity ee = ((ejb.EmployerEntity)lv.validateEmployer(request.getParameter("user"), request.getParameter("pass")));
					if(ee == null){
						rd = request.getRequestDispatcher("login.jsp?status=failed");
					}
					else{
						session.setAttribute("user",ee);
						session.setAttribute("type","Employer");
						rd = request.getRequestDispatcher("employer.jsp");
					}
				}
			}
			//A new profile has been submitted
			else{
				String errmsg = ",";
				boolean success = true;
				//Validate username
				if(request.getParameter("user").length() < 1){
					errmsg += "Du måste ange ett användarnamn ,";
					success = false;
				}
				else if(request.getParameter("user").length() > 200){
					errmsg += "Användarnamnet får ej överskrida 200 tecken ,";
					success = false;
				}
				//Validate password
				if(request.getParameter("pass").length() < 6){
					errmsg += "Ditt lösenord måste innehålla minst 6 tecken ,";
					success = false;
				}
				else if(request.getParameter("pass").length() > 100){
					errmsg += "Användarnamnet får ej överskrida 100 tecken ,";
					success = false;
				}
				//Validate email
				if(request.getParameter("email").length() < 1){
					errmsg += "Du måste ange en e-mail adress ,";
					success = false;
				}
				else{
					pattern = pattern.compile(EMAIL_PATTERN);
					matcher = pattern.matcher(request.getParameter("email"));
					if(!matcher.matches() || request.getParameter("email").length() > 200){
						errmsg += "Du måste ange en giltig e-mail adress ,";
						success = false;
					}
				}
				//Validate name
				String name = "";
				if(request.getParameter("firstname").length() < 1 || request.getParameter("lastname").length() < 1){
					errmsg += "Du måste ange för- och efternamn ,";
					success = false;
				}
				else{
					name = request.getParameter("firstname") + " " + request.getParameter("lastname");
					if(name.length() > 200){
						name = name.substring(0,201);
					}
				}
				//We have a new student
				if(request.getParameter("action").equals("newStudent")){
					if(lv.duplicateStudentUName(request.getParameter("user"))){
						rd = request.getRequestDispatcher("newStudent.jsp?errmsg=Användarnamnet är upptaget. Välj ett annat!");
					}
					else if(success){
						session.setAttribute("user",lv.addStudent(name, request.getParameter("email"), request.getParameter("user"), request.getParameter("pass")));
						session.setAttribute("type","Student");
						rd = request.getRequestDispatcher("main.jsp");
					}
					else{
						rd = request.getRequestDispatcher("newStudent.jsp?errmsg=" + errmsg);
					}
				}
				//We have a new employer
				else{
					if(lv.duplicateEmployerUName(request.getParameter("user"))){
						rd = request.getRequestDispatcher("newStudent.jsp?errmsg=Användarnamnet är upptaget. Välj ett annat!");
					}
					else if(success){
						session.setAttribute("user",lv.addEmployer(name, request.getParameter("email"), request.getParameter("user"), request.getParameter("pass"), request.getParameter("organisation")));
						session.setAttribute("type","Employer");
						rd = request.getRequestDispatcher("employer.jsp");
					}	
					else{
						rd = request.getRequestDispatcher("newEmployer.jsp?errmsg=" + errmsg);
					}
				}
			}
			rd.forward(request, response);
		}
		catch(ServletException e){
			System.out.print(e.getMessage());
		}
		catch(IOException e){
			System.out.print(e.getMessage());
		}
	}
}