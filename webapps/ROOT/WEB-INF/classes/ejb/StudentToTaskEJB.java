package ejb;
import javax.ejb.*;
import javax.persistence.*;
import java.util.List;
@Local(StudentToTask.class)
@Stateless(mappedName="StudentToTaskEJB")
public class StudentToTaskEJB implements StudentToTask {
    @PersistenceContext(unitName="StudentToTaskPU", name="em")
	private EntityManager em;
    
    public StudentToTaskEntity addStudentToTask(long studentID, long taskID){
		StudentToTaskEntity se = new StudentToTaskEntity();
		se.setStudentID(studentID);
		se.setTaskID(taskID);
		em.persist(se);
		em.close();
		return se;
    }

    public StudentToTaskEntity merge(StudentToTaskEntity s){
		StudentToTaskEntity se = em.merge(s);
		em.close();
		return se;
    }
	
	public void update(StudentToTaskEntity s){
		em.flush();
		em.close();
	}
	
	public List<StudentToTaskEntity> findByTaskID(long taskID){
		Query query = em.createQuery("SELECT OBJECT(st) FROM StudentToTaskEntity st WHERE st.taskID = " + taskID);
		em.close();
		return query.getResultList();
    }
	
	public List<StudentToTaskEntity> findByStudentID(long studentID){
		Query query = em.createQuery("SELECT OBJECT(st) FROM StudentToTaskEntity st WHERE st.studentID = " + studentID);
		em.close();
		return query.getResultList();
    }
	
	public StudentToTaskEntity findEntry(long studentID, long taskID){
		Query query = em.createQuery("SELECT OBJECT(st) FROM StudentToTaskEntity st WHERE st.studentID = " + studentID + " AND st.taskID = " + taskID);
		em.close();
		List<StudentToTaskEntity> list = query.getResultList();
		if(list.size() == 0) return null;
		return list.get(0);
    }
}
