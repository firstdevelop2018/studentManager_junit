package com.student.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.student.entity.StudentInfoEntity;
import com.student.mapper.StudentInfoMapper;

public class StudentInfoDao {



	private JdbcTemplate jdbcTemplate;



	/**
	 * @param jdbcTemplate セットする jdbcTemplate
	 */
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public List<StudentInfoEntity> getStudentInfoEntityList(){
		List<StudentInfoEntity> studentInfoEntity = new ArrayList<>();

		String sql = "SELECT id, name, birthday,age, score FROM student";
		studentInfoEntity = jdbcTemplate.query(sql,new StudentInfoMapper());



		return studentInfoEntity;
	}

}
