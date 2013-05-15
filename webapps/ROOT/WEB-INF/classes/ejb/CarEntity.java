package ejb;
import java.io.Serializable;
import javax.persistence.*;
import javax.annotation.*;

@Entity
@Table(name = "Car")
public class CarEntity implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    long id;

    String name;

    public void setId(long id){
	this.id = id;
    }

    public long getId(){
	return id;
    }

    public void setName(String name){
	this.name = name;
    }

    public String getName(){
	return name;
    }
}
