import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import javax.ejb.*;
import javax.naming.*;
import java.util.Properties;
import java.util.List;

public class TaskController extends HttpServlet{
	
    public void doGet(HttpServletRequest request, HttpServletResponse response){
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		response.setDateHeader("Expires", 0); // Proxies.	
		HttpSession session = request.getSession();
		bean.TaskLogic tl = new bean.TaskLogic();
		RequestDispatcher rd = null;
		try{
			//Handle log out request
			if(request.getParameter("action").equals("logOut")){
				session.invalidate();
				rd = request.getRequestDispatcher("start.html");
			}
			//Handle go to my page request
			else if(request.getParameter("action").equals("myPage")){
				rd = request.getRequestDispatcher("myProfile.jsp");
			}
			//Handle go to main page request
			else if(request.getParameter("action").equals("main")){
				rd = request.getRequestDispatcher("main.jsp");
			}
			//Handle create new task request
			else if(request.getParameter("action").equals("newTask")){
				rd = request.getRequestDispatcher("newTask.jsp");
			}
			//Handle go back to employer overview
			else if(request.getParameter("action").equals("backToMain")){
				rd = request.getRequestDispatcher("employer.jsp");
			}
			//Handle application for assignment
			else if(request.getParameter("action").equals("apply")){
				long taskID = Long.parseLong(request.getParameter("tid"));
				ejb.StudentEntity se = (ejb.StudentEntity)session.getAttribute("user");
				tl.applyForTask(se.getId(), taskID);
				rd = request.getRequestDispatcher("viewTask.jsp?tid=" + taskID);
			}
			//Handle change of task open status
			else if(request.getParameter("action").equals("editOpen")){
				long taskID = Long.parseLong(request.getParameter("tid"));
				short open = Short.parseShort(request.getParameter("open"));
				tl.updateOpen(open, taskID);
				rd = request.getRequestDispatcher("administerTask.jsp?tid=" + taskID);
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
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		response.setDateHeader("Expires", 0); // Proxies.
		try{
			RequestDispatcher rd;
			bean.TaskLogic tl = new bean.TaskLogic();
			HttpSession session = request.getSession();
			//If session is null, redirect to start page
			if(session.getAttribute("user") == null){
				rd = request.getRequestDispatcher("start.html");
			}
			//Handle an update of the resume
			else if(request.getParameter("action").equals("updateCV")){
				String resume;
				if(request.getParameter("cv").length() > 1000){
					resume = request.getParameter("cv").substring(0,1001);
					rd = request.getRequestDispatcher("myProfile.jsp?tooLong=yes");
				}
				else{
					resume = request.getParameter("cv");
					rd = request.getRequestDispatcher("myProfile.jsp");
				}
				ejb.StudentEntity se = tl.updateResume(resume, ((ejb.StudentEntity)session.getAttribute("user")));
				session.setAttribute("user",se);
			}
			//Handle creation of new task
			else if(request.getParameter("action").equals("createTask")){
				String description;
				String title;
				//Handle too large data
				if(request.getParameter("description").length() > 1000){
					description = request.getParameter("description").substring(0,1001);
				}
				else{
					description = request.getParameter("description");
				}
				if(request.getParameter("title").length() > 200){
					title = request.getParameter("title").substring(0,201);
				}
				else{
					title = request.getParameter("title");
				}
				ejb.EmployerEntity ee = (ejb.EmployerEntity)session.getAttribute("user");
				tl.createTask(ee.getId() ,title , description);
				rd = request.getRequestDispatcher("employer.jsp");
			}
			else{
				rd = null;
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