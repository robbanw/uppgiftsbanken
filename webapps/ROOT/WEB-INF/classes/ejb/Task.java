package ejb;
import javax.ejb.Local;
import java.util.List;
@Local public interface Task{
    
    public TaskEntity addTask(long employerID, String title, String description);

    public void update(TaskEntity t);
	
	public TaskEntity merge(TaskEntity t);

    public TaskEntity findByPrimaryKey(long id);
	
	public List<TaskEntity> findByEmployer(long id);
	
	public List<TaskEntity> findAllOpen();
}