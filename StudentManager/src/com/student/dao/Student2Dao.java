package com.student.dao;

import java.sql.Types;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.student.entity.Student2Entity;
import com.student.mapper.Student2Mapper;



public class Student2Dao {
	//生成JdbcTemplate变量，用于数据库操作
	private JdbcTemplate jdbcTemplate;



	/** 生成 set 方法
	 * @param jdbcTemplate セットする jdbcTemplate
	 */
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}



/**
 * 查询所有信息
 * @return
 */
	public List<Student2Entity> search(){

		String sql = "SELECT id, name, birthday,age, score FROM student order by id asc";
//生成集合 用于接收数据表中查询到的信息；
		List<Student2Entity> student2EntityList =jdbcTemplate.query(sql,new Student2Mapper());

		return student2EntityList;
	}

	public void delete() {
		String sql = "DELETE FROM student ";
		jdbcTemplate.execute(sql);
	}


	public void insert(Student2Entity entity) {
		String sql = "INSERT INTO student(name,birthday,age,score)values (?,?,?,?)";
	  jdbcTemplate.update(sql,
				new Object[] { entity.getName(),entity.getBirthday(),entity.getAge(),entity.getScore()},
				new int[] { Types.VARCHAR,Types.DATE,Types.INTEGER,Types.INTEGER});
			}


	public void update(Student2Entity entity) {
		String sql = "UPDATE student set name = ?,set birthday=?,set age = ?,set score = ? WHERE id = ?";
		jdbcTemplate.update(sql,
				new Object[] { entity.getName(),entity.getBirthday(),entity.getAge(),entity.getScore(),entity.getId()},
				new int[] { Types.VARCHAR,Types.DATE,Types.INTEGER,Types.INTEGER,Types.INTEGER});
	}
}



