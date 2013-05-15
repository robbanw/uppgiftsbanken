package ejb;
import java.io.Serializable;
import javax.persistence.*;
import javax.annotation.*;

@Entity
@Table(name = "StudentToTask")
public class StudentToTaskEntity implements Serializable {
	
    protected long studentID, taskID;	

    public void setStudentID(long studentID){
		this.studentID = studentID;
    }

    public long getStudentID(){
		return studentID;
    }
	
	public void setTaskID(long taskID){
		this.taskID = taskID;
    }

    public long getTaskID(){
		return taskID;
    }
}
