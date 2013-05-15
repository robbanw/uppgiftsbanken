package bean;
import javax.ejb.*;
import javax.naming.*;
import java.util.Properties;
import java.util.List;

public class TaskLogic{

	private Properties p;
	private Context ctx;

	public TaskLogic(){
		p = new Properties();
		// För att få tillgång till de JNDI-bindningar i openejb där våra EJB:er finns.
		p.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.openejb.client.LocalInitialContextFactory");
		try{
			ctx = new InitialContext(p);
		}
		catch(NamingException ne){
			System.out.print(ne.getMessage());
		}	
	}

	public ejb.StudentEntity updateResume(String resume, ejb.StudentEntity se){
		try{
			ejb.Student s = (ejb.Student)ctx.lookup("StudentEJBLocal");
			se.setResume(resume);
			return s.merge(se);
		}
		catch(NamingException ne){
			System.out.print(ne.getMessage());
		}
		return null;
	}
	
	public void updateOpen(short status, long taskID){
		try{
			ejb.Task t = (ejb.Task)ctx.lookup("TaskEJBLocal");
			ejb.TaskEntity te = getTask(taskID);
			te.setOpen(status);
			t.merge(te);
		}
		catch(NamingException ne){
			System.out.print(ne.getMessage());
		}
	}
	
	public List<ejb.TaskEntity> getTasks(){
		ejb.Task t = null;
		try{
			t = (ejb.Task)ctx.lookup("TaskEJBLocal");
		}
		catch(NamingException e){
			System.out.print(e.getMessage());
		}
		return t.findAllOpen();
	}
	
		
	public List<ejb.TaskEntity> findByEmployer(long id){
		ejb.Task t = null;
		try{
			t = (ejb.Task)ctx.lookup("TaskEJBLocal");
		}
		catch(NamingException e){
			System.out.print(e.getMessage());
		}
		return t.findByEmployer(id);
	}
	
	public void createTask(long employerID, String title, String description){
		ejb.Task t = null;
		try{
			t = (ejb.Task)ctx.lookup("TaskEJBLocal");
		}
		catch(NamingException e){
			System.out.print(e.getMessage());
		}
		t.addTask(employerID, title, description);
	}
	
	public ejb.EmployerEntity getEmployer(long id){
		ejb.Employer em = null;
		try{
			em = (ejb.Employer)ctx.lookup("EmployerEJBLocal");
		}
		catch(NamingException e){
			System.out.print(e.getMessage());
		}
		return em.findByPrimaryKey(id);
	}
	
	public ejb.TaskEntity getTask(long id){
		ejb.Task t = null;
		try{
			t = (ejb.Task)ctx.lookup("TaskEJBLocal");
		}
		catch(NamingException e){
			System.out.print(e.getMessage());
		}
		return t.findByPrimaryKey(id);
	}
	
	public ejb.StudentEntity getStudent(long id){
		ejb.Student s = null;
		try{
			s = (ejb.Student)ctx.lookup("StudentEJBLocal");
		}
		catch(NamingException e){
			System.out.print(e.getMessage());
		}
		return s.findByPrimaryKey(id);
	}
	
	public void applyForTask(long studentID, long taskID){
		ejb.StudentToTask st = null;
		try{
			st = (ejb.StudentToTask)ctx.lookup("StudentToTaskEJBLocal");
		}
		catch(NamingException e){
			System.out.print(e.getMessage());
		}
		st.addStudentToTask(studentID, taskID);
	}
	
	public ejb.StudentToTaskEntity findEntry(long studentID, long taskID){
		ejb.StudentToTask st = null;
		try{
			st = (ejb.StudentToTask)ctx.lookup("StudentToTaskEJBLocal");
		}
		catch(NamingException e){
			System.out.print(e.getMessage());
		}
		return st.findEntry(studentID, taskID);
	}
	
	public List<ejb.StudentToTaskEntity> getNrOfApplicants(long taskID){
		ejb.StudentToTask st = null;
		try{
			st = (ejb.StudentToTask)ctx.lookup("StudentToTaskEJBLocal");
		}
		catch(NamingException e){
			System.out.print(e.getMessage());
		}
		return st.findByTaskID(taskID);
	}
}