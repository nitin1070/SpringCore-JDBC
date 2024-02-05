package springcorejdbc.SpringJDBC;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import springcorejdbc.SpringJDBC.DAO.StudentDAO;
import springcorejdbc.SpringJDBC.pojo.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {	
    	ApplicationContext context = new ClassPathXmlApplicationContext("springcorejdbc/SpringJDBC/config.xml");
    	
    // We can also used java class to connect Oracle without using config.xml file 
    	
    	ApplicationContext context2 = new AnnotationConfigApplicationContext(JdbcConfig.class);
    	
    	
    	StudentDAO studentDAO = context2.getBean("studentDao",StudentDAO.class);  	
    	
    	Student student = new Student();
    
    	
    	// Insert data into student table 
    	
    	
		
		  Student s1 = new Student();
		  
		  s1.setId(105); s1.setName("Khusi"); s1.setCity("Bhopal");
		  
		  int result = studentDAO.insert(s1);
		  
		  System.out.println("Record Added..."+result);
		 
		  
		 
   // Update data into student table 
	/*
	 * Student student = new Student();
	 * 
	 * student.setId(103); student.setName("Pawan"); student.setCity("Sarni"); int
	 * result = studentDAO.update(student);
	 * System.out.println("Record Updated..."+result);
	 */
    

 // Delete data into student table 
	
	/*
	 * student.setId(103); int result = studentDAO.delete(student);
	 * System.out.println("Record Deleted..."+result);
	 */
    
      

   // Show single student 
  	

	/*
	 * Student result = studentDAO.show(101);
	 * 
	 * System.out.println("Show Data "+ result);
	 */
  	
    	// Show All students 
      
      List<Student> students= studentDAO.getAllStudents();
      
      for(Student s:students) {
    	  
    	  System.out.println(s);
    	  
    	     	  
      }
      
    
    
    }
  
}
