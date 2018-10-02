package ejb.session.singleton;

import ejb.session.stateless.StudentSessionBeanLocal;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.ejb.Startup;
import jpa.entity.Student;



@Singleton
@LocalBean
@Startup

public class InitSessionBean 
{
    @EJB
    private StudentSessionBeanLocal studentSessionBeanLocal;
    
    

    @PostConstruct
    public void postConstruct()
    {
        loadTestData();
    }
    
    
    
    private void loadTestData()
    {
        studentSessionBeanLocal.createStudent(new Student("A0010001A", "Test Student 1"));
    }
}
