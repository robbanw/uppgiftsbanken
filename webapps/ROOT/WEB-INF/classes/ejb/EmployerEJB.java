package ejb;
import javax.ejb.*;
import javax.persistence.*;
import java.util.List;
@Local(Employer.class)
@Stateless(mappedName="EmployerEJB")
public class EmployerEJB implements Employer {
    @PersistenceContext(unitName="EmployerPU", name="em")
	private EntityManager em;
    
    public EmployerEntity addEmployer(String name, String email, String username, String password, String organisation){
		EmployerEntity ee = new EmployerEntity();
		ee.setName(name);
		ee.setEmail(email);
		ee.setUsername(username);
		ee.setPassword(password);
		ee.setOrganisation(organisation);
		em.persist(ee);
		em.close();
		return ee;
    }

    public EmployerEntity merge(EmployerEntity e){
		EmployerEntity ee = em.merge(e);
		em.close();
		return ee;
    }
	
	public void update(EmployerEntity e){
		em.flush();
		em.close();
	}
    
    public EmployerEntity findByPrimaryKey(long id){
		EmployerEntity ee = (EmployerEntity)em.find(EmployerEntity.class, id);
		em.close();
		return ee;
    }
	
	public List<EmployerEntity> validateLogin(String username, String password){
		Query query = em.createQuery("SELECT OBJECT(e) FROM EmployerEntity e WHERE e.username LIKE ?1 AND e.password LIKE ?2");
		query.setParameter(1,username);
		query.setParameter(2,password);
		em.close();
		List<EmployerEntity> a = query.getResultList();
		if(a.size()==0) return null;
		return a;
    }
	
	public boolean validateUsername(String username){
		Query query = em.createQuery("SELECT OBJECT(e) FROM EmployerEntity e WHERE e.username LIKE ?1");
		query.setParameter(1,username);
		em.close();
		List<StudentEntity> a = query.getResultList();
		if(a.size()==0) return false;
		return true;
    }
}
