package springcorejdbc.SpringJDBC;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import springcorejdbc.SpringJDBC.DAO.StudentDAO;
import springcorejdbc.SpringJDBC.DAO.StudentDaoImpl;

@Configuration
@ComponentScan(basePackages={"springcorejdbc.SpringJDBC.DAO"})
public class JdbcConfig {
	@Bean("ds")
	public DataSource getDataSource() {

		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		ds.setUsername("nitin");
		ds.setPassword("nitin");

		return ds;

	}

	@Bean("jdbcTemplate")
	public JdbcTemplate getJdbcTemplate() {

		JdbcTemplate jdbcTemplate = new JdbcTemplate();

		jdbcTemplate.setDataSource(getDataSource());

		return jdbcTemplate;

	}
	
	// we can also use Autowired annotation to inject this class 
	
	/*
	 * @Bean("studentDao") public StudentDAO getStudentDao() {
	 * 
	 * StudentDaoImpl studentDao = new StudentDaoImpl();
	 * studentDao.setJdbcTemplate(getJdbcTemplate());
	 * 
	 * return studentDao;
	 * 
	 * }
	 */



}
