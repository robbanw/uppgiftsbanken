package ejb;
import java.io.Serializable;
import javax.persistence.*;
import javax.annotation.*;

@Entity
@Table(name = "Employer")
public class EmployerEntity implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    long id;
	
    protected String name, password, organisation; 
	
	@Column(name = "email")
	protected String email;
	
	@Column(unique = true, name = "username")
	protected String username;

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
	
	public void setEmail(String email){
		this.email = email;
    }

    public String getEmail(){
		return email;
    }
	
	public void setUsername(String username){
		this.username = username;
    }

    public String getUsername(){
		return username;
    }
	
	public void setPassword(String password){
		this.password = password;
    }

    public String getPassword(){
		return password;
    }
	
	public void setOrganisation(String organisation){
		this.organisation = organisation;
    }

    public String getOrganisation(){
		return organisation;
    }
}
