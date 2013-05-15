package ejb;
import javax.ejb.Local;
@Local public interface Car{
    
    public void addCar(String name);

    public void update(CarEntity c);

    public CarEntity findByPrimaryKey(int id);

    public java.util.List findAll();
}
