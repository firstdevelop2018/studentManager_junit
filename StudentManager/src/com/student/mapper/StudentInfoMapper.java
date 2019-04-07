package com.student.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.student.entity.StudentInfoEntity;

public class StudentInfoMapper implements RowMapper<StudentInfoEntity>{

	@Override
	public StudentInfoEntity mapRow(ResultSet sesultSet, int num) throws SQLException {
		StudentInfoEntity studentInfoEntity = new StudentInfoEntity();
		studentInfoEntity.setId(sesultSet.getInt("id"));
		studentInfoEntity.setName(sesultSet.getString("name"));
		studentInfoEntity.setBirthday(sesultSet.getDate("birthday"));
		studentInfoEntity.setAge(sesultSet.getInt("age"));
		studentInfoEntity.setScore(sesultSet.getInt("score"));

		return studentInfoEntity;
	}

}
