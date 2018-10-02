package ejb.session.stateless;

import java.util.List;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import jpa.entity.Student;



@Stateless
@Local(StudentSessionBeanLocal.class)
@Remote(StudentSessionBeanRemote.class)

public class StudentSessionBean implements StudentSessionBeanLocal, StudentSessionBeanRemote 
{
    @PersistenceContext(unitName = "EnterpriseApplication1-ejbPU")
    private EntityManager em;

    
    
    @Override
    public Long createStudent(Student student)
    {
        em.persist(student);
        em.flush();
        
        return student.getId();
    }
    
    
    
    @Override
    public List<Student> retrieveAllStudents()
    {
        Query query = em.createQuery("SELECT s FROM Student s");
        return query.getResultList();
    }
}
