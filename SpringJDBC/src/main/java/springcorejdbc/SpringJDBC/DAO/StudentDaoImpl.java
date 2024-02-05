package springcorejdbc.SpringJDBC.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import springcorejdbc.SpringJDBC.pojo.Student;

@Component("studentDao")
public class StudentDaoImpl implements StudentDAO {

	@Autowired
  private JdbcTemplate jdbcTemplate;
  
	public JdbcTemplate getJdbcTemplate() {
		
	return jdbcTemplate;
}
public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
	this.jdbcTemplate = jdbcTemplate;
}
	

   // insert query 
public int insert(Student student) {
				
		String query= "insert into student(id,name,city) values(?,?,?)";
		
		int result = this.jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
		
		return result;
	}

// update query 
public int update(Student student) {
	String query = "update student set name=?,city=? where id=?";
	
	int result  = this.jdbcTemplate.update(query,student.getName(),student.getCity(),student.getId());
	
	return result;
}




// Delete query 


public int delete(Student student) {
		String query="delete FROM student WHERE id=?";
		int result  = this.jdbcTemplate.update(query,student.getId());
		
		return result;
	}

// Select single row from the student table
public Student show(int id) {
  String query= "SELECT * FROM student WHERE id=?";
  
  RowMapper<Student> rowMapper = new RowMapperImpl();
  
  Student result  = this.jdbcTemplate.queryForObject(query,rowMapper,id);
  
	return result;
}

// Select the all students row 

	public List<Student> getAllStudents() {
		String query = "SELECT * FROM student";
    List<Student> students = this.jdbcTemplate.query(query,new RowMapperImpl());
		
			return students;
		}

	
	
	
}
