package ejb.session.stateless;

import java.util.List;
import jpa.entity.Student;



public interface StudentSessionBeanRemote 
{    
    public Long createStudent(Student student);
    
    public List<Student> retrieveAllStudents();
}
