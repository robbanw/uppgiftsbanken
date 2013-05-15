package ejb;
import javax.ejb.*;
import javax.persistence.*;
import java.util.List;
@Local(Task.class)
@Stateless(mappedName="TaskEJB")
public class TaskEJB implements Task {
    @PersistenceContext(unitName="TaskPU", name="em")
	private EntityManager em;
    
    public TaskEntity addTask(long employerID, String title, String description){
		TaskEntity te = new TaskEntity();
		te.setEmployerID(employerID);
		te.setTitle(title);
		te.setDescription(description);
		te.setOpen((short)1);
		em.persist(te);
		em.close();
		return te;
    }

    public TaskEntity merge(TaskEntity t){
		TaskEntity te = em.merge(t);
		em.close();
		return te;
    }
	
	public void update(TaskEntity t){
		em.flush();
		em.close();
	}
    
    public TaskEntity findByPrimaryKey(long id){
		TaskEntity se = (TaskEntity)em.find(TaskEntity.class, id);
		em.close();
		return se;
    }
	
	public List<TaskEntity> findByEmployer(long id){
		Query query = em.createQuery("SELECT OBJECT(t) FROM TaskEntity t WHERE t.employerID = " + id);
		em.close();
        return query.getResultList();
    }
	
    public List<TaskEntity> findAllOpen(){
		Query query = em.createQuery("SELECT OBJECT(t) FROM TaskEntity t WHERE t.open = 1");
		em.close();
        return query.getResultList();
    }
}
