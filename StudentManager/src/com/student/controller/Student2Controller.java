package com.student.controller;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.student.dao.Student2Dao;
import com.student.entity.Student2Entity;

@Controller
public class Student2Controller {

	@RequestMapping(value="/displayStudentList2")
	public String displayStudentList(Model model) {
		Student2Dao student2Dao = getDao();
		List<Student2Entity> student2EntityList = student2Dao.search();
		model.addAttribute("student2EntityList",student2EntityList);

		return "studentList2";
	}
	private Student2Dao getDao() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Student2Dao student2Dao = (Student2Dao) context.getBean("student2Dao");
		return student2Dao;
	}
}
