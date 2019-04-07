package teacher1;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

public class Teacher1Dao {
	private JdbcTemplate JdbcTemplate;


	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		JdbcTemplate = jdbcTemplate;
	}



	public List<Teacher1Entity> search(){

		String sql = "SELECT id, name, birthday,age, score FROM teacher";

		List<Teacher1Entity> teacher1EntityList =JdbcTemplate.query(sql,new Teacher1Mapper());

		return teacher1EntityList;
	}
}
