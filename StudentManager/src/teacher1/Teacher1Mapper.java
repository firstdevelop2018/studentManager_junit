package teacher1;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class Teacher1Mapper implements RowMapper<Teacher1Entity>{

	@Override
	public Teacher1Entity mapRow(ResultSet resultSet, int arg1) throws SQLException {
		// TODO 自動生成されたメソッド・スタブ



		Teacher1Entity teacher1Entity = new Teacher1Entity();

		teacher1Entity.setId(resultSet.getInt("id"));
		teacher1Entity.setName(resultSet.getString("name"));
		teacher1Entity.setBirthday(resultSet.getDate("birthday"));
		teacher1Entity.setAge(resultSet.getInt("age"));
		teacher1Entity.setScore(resultSet.getInt("score"));
		return teacher1Entity;
	}


}
