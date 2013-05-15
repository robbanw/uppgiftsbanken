package ejb;
import javax.ejb.*;
import javax.persistence.*;
import java.util.List;
@Local(Student.class)
@Stateless(mappedName="StudentEJB")
public class StudentEJB implements Student {
    @PersistenceContext(unitName="StudentPU", name="em")
	private EntityManager em;
    
    public StudentEntity addStudent(String name, String email, String username, String password){
		StudentEntity se = new StudentEntity();
		se.setName(name);
		se.setEmail(email);
		se.setUsername(username);
		se.setPassword(password);
		se.setResume("");
		em.persist(se);
		em.close();
		return se;
    }

    public StudentEntity merge(StudentEntity s){
		StudentEntity se = em.merge(s);
		em.close();
		return se;
    }
	
	public void update(StudentEntity s){
		em.flush();
		em.close();
	}
    
    public StudentEntity findByPrimaryKey(long id){
		StudentEntity se = (StudentEntity)em.find(StudentEntity.class, id);
		em.close();
		return se;
    }
	
	public List<StudentEntity> validateLogin(String username, String password){
		Query query = em.createQuery("SELECT OBJECT(s) FROM StudentEntity s WHERE s.username LIKE ?1 AND s.password LIKE ?2");
		query.setParameter(1,username);
		query.setParameter(2,password);
		em.close();
		List<StudentEntity> a = query.getResultList();
		if(a.size()==0) return null;
		return a;
    }
	
	public boolean validateUsername(String username){
		Query query = em.createQuery("SELECT OBJECT(s) FROM StudentEntity s WHERE s.username LIKE ?1");
		query.setParameter(1,username);
		em.close();
		List<StudentEntity> a = query.getResultList();
		if(a.size()==0) return false;
		return true;
    }
}
