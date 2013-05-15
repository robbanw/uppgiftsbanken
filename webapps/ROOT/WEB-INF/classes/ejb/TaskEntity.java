package ejb;
import java.io.Serializable;
import javax.persistence.*;
import javax.annotation.*;

@Entity
@Table(name = "Task")
public class TaskEntity implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    long id;
	
	protected long employerID;
    protected String title;
	
	@Column(columnDefinition = "tinyint(1)")
	protected short open;
	
	@Column(columnDefinition = "varchar(1024)")
	protected String description; 

    public void setId(long id){
		this.id = id;
    }

    public long getId(){
		return id;
    }
	
	public void setEmployerID(long employerID){
		this.employerID = employerID;
    }

    public long getEmployerID(){
		return employerID;
    }

    public void setTitle(String title){
		this.title = title;
    }

    public String getTitle(){
		return title;
    }
	
	public void setDescription(String description){
		this.description = description;
    }

    public String getDescription(){
		return description;
    }
	
	public void setOpen(short open){
		this.open = open;
    }

    public short getOpen(){
		return open;
    }
}
