package ejb;
import javax.ejb.Local;
import java.util.List;
@Local public interface Student{
    
    public StudentEntity addStudent(String name, String email, String username, String password);

    public void update(StudentEntity s);
	
	public StudentEntity merge(StudentEntity s);

    public StudentEntity findByPrimaryKey(long id);
	
	public List<StudentEntity> validateLogin(String username, String password);
	
	public boolean validateUsername(String username);
}