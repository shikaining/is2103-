package jsf.managedbean;

import ejb.session.stateless.StudentSessionBeanLocal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import jpa.entity.Student;



@Named
@RequestScoped

public class StudentsManagedBean
{
    @EJB
    private StudentSessionBeanLocal studentSessionBeanLocal;
    
    private List<Student> students;

    
        
    public StudentsManagedBean() {
    }
    
    
    @PostConstruct
    public void postConstruct()
    {
        students = studentSessionBeanLocal.retrieveAllStudents();
    }

    
    
    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
