/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enterpriseapplication1client;

import ejb.session.stateless.StudentSessionBeanRemote;
import javax.ejb.EJB;
import jpa.entity.Student;

/**
 *
 * @author tanwk
 */
public class Main {

    @EJB
    private static StudentSessionBeanRemote studentSessionBeanRemote;
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {        
        System.err.println("********** EnterpriseApplication1Client.main: Start");
        
        studentSessionBeanRemote.createStudent(new Student("A0010002B", "Test Student 2"));
        
        System.err.println("********** EnterpriseApplication1Client.main: End");
    }
    
}
