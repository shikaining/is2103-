/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.session.stateless;

import java.io.File;
import java.util.List;
import java.util.Properties;
import javax.ejb.embeddable.EJBContainer;
import jpa.entity.Student;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
 *
 * @author tanwk
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class StudentSessionBeanTest 
{
    //private static final String LOOKUP_NAME = "java:global/classes/StudentSessionBean!ejb.session.stateless.StudentSessionBeanLocal";
    private static final String LOOKUP_NAME = "java:global/EnterpriseApplication1-ejb/StudentSessionBean!ejb.session.stateless.StudentSessionBeanLocal";
    
    private static EJBContainer container;
    
    
    
    public StudentSessionBeanTest() {
    }
    
    @BeforeClass
    public static void setUpClass() 
    {
        Properties properties = new Properties();        
        
//        properties.put("jdbc/enterpriseApplication1", "new://Resource?type=DataSource&classpath=C:\\JavaLibraries\\mysql-connector-java-8.0.12\\mysql-connector-java-8.0.12.jar");
//        properties.put("jdbc/enterpriseApplication1.JdbcDriver", "com.mysql.cj.jdbc.MysqlDataSource");
//        properties.put("jdbc/enterpriseApplication1.JdbcUrl", "jdbc:mysql://localhost:3306/enterpriseApplication1?zeroDateTimeBehavior=CONVERT_TO_NULL");
//        properties.put("jdbc/enterpriseApplication1.UserName", "root");
//        properties.put("jdbc/enterpriseApplication1.Password", "password");
//        properties.put("jdbc/enterpriseApplication1.JtaManaged", "true");
//        properties.put("jdbc/enterpriseApplication1.useSSL", "false");

        properties.put("DataSource.ds1.name", "env/jdbc/enterpriseApplication1");
        properties.put("DataSource.ds1.dataSourceClass", "com.mysql.cj.jdbc.MysqlDataSource");
        properties.put("DataSource.ds1.url", "jdbc:mysql://localhost:3306/enterpriseApplication1?zeroDateTimeBehavior=CONVERT_TO_NULL");
        properties.put("DataSource.ds1.databaseName", "enterpriseApplication1");
        properties.put("DataSource.ds1.user", "root");
        properties.put("DataSource.ds1.password", "password");
        properties.put("DataSource.ds1.JtaManaged", "true");
        properties.put("DataSource.ds1.useSSL", "false");
        
        properties.put(EJBContainer.MODULES, new File("C:\\Jenkins\\workspace\\EnterpriseApplication1\\EnterpriseApplication1-ejb\\dist\\EnterpriseApplication1-ejb.jar"));       
        
        container = javax.ejb.embeddable.EJBContainer.createEJBContainer(properties);
    }
    
    @AfterClass
    public static void tearDownClass() 
    {
        if(container != null)
        {
            container.close();
        }
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testCreateStudent() throws Exception {
        System.out.println("createStudent");
        Student student = new Student("A0010003C", "Test Student 3");
        
        StudentSessionBeanLocal instance = (StudentSessionBeanLocal)container.getContext().lookup(LOOKUP_NAME);
        Long result = instance.createStudent(student);
        assertNotNull(result);        
    }

    @Test
    public void testRetrieveAllStudents() throws Exception {
        System.out.println("retrieveAllStudents");        
        StudentSessionBeanLocal instance = (StudentSessionBeanLocal)container.getContext().lookup(LOOKUP_NAME);
        List<Student> result = instance.retrieveAllStudents();
        assertNotNull(result);
        assertFalse(result.isEmpty());
    }
    
}
