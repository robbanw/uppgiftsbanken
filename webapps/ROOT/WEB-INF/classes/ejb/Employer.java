package ejb;
import javax.ejb.Local;
import java.util.List;
@Local public interface Employer{
    
    public EmployerEntity addEmployer(String name, String email, String username, String password, String organisation);

    public void update(EmployerEntity e);
	
	public EmployerEntity merge(EmployerEntity e);

    public EmployerEntity findByPrimaryKey(long id);
	
	public List<EmployerEntity> validateLogin(String username, String password);
	
	public boolean validateUsername(String username);
}