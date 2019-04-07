package com.student.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.student.entity.Student2Entity;
//映射数据库
public class Student2Mapper implements RowMapper<Student2Entity>{

	@Override
	public Student2Entity mapRow(ResultSet resultSet , int arg1) throws SQLException {

		Student2Entity student2Entity = new Student2Entity();

		student2Entity.setId(resultSet.getInt("id"));
		student2Entity.setName(resultSet.getString("name"));
		student2Entity.setBirthday(resultSet.getDate("birthday"));
		student2Entity.setAge(resultSet.getInt("age"));
		student2Entity.setScore(resultSet.getInt("score"));
		return student2Entity;
	}



}
