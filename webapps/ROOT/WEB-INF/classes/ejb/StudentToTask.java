package ejb;
import javax.ejb.Local;
import java.util.List;
@Local public interface StudentToTask{
    
    public StudentToTaskEntity addStudentToTask(long studentID, long taskID);

    public void update(StudentToTaskEntity s);
	
	public List<StudentToTaskEntity> findByTaskID(long taskID);
	
	public List<StudentToTaskEntity> findByStudentID(long studentID);
	
	public StudentToTaskEntity findEntry(long studentID, long taskID);
	
	public StudentToTaskEntity merge(StudentToTaskEntity s);
}