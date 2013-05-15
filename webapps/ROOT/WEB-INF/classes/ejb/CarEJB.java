package ejb;
import javax.ejb.*;
import javax.persistence.*;
@Local(Car.class)
@Stateless
public class CarEJB implements Car {
    @PersistenceContext(unitName="CarPU", name="em")
	private EntityManager em;
    
    public void addCar(String name){
	CarEntity ce = new CarEntity();
	ce.setName(name);
	em.persist(ce);
	em.close();
    }

    public void update(CarEntity c){
	em.flush();
	em.close();
    }
    
    public CarEntity findByPrimaryKey(int id){
	CarEntity ce = (CarEntity)em.find(CarEntity.class, id);
	em.close();
	return ce;
    }

    public java.util.List findAll(){
	Query query = em.createQuery("SELECT c from CarEntity as c");
	em.close();
        return query.getResultList();
    }
}
