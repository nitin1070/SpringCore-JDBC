package springcorejdbc.SpringJDBC.DAO;

import java.util.List;

import springcorejdbc.SpringJDBC.pojo.Student;

public interface StudentDAO {
	
	public int insert(Student student);
	public int update(Student student);
	public int delete(Student student);
	public Student show(int id);
	public List<Student> getAllStudents();
	

}
