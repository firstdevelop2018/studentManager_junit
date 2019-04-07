package com.student.controller;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.student.dao.StudentInfoDao;
import com.student.entity.StudentInfoEntity;
/**springMVC框架中 控制层所在位置， 用于处理网页发起的服务请求
 *
 * @author Administrator
 *
 */
@Controller
public class StudentController1 {
//对请求进行一一关联定位
	@RequestMapping(value = "/displayStudentInfoList")

	public String displayStudentInfoList (Model model) {

		StudentInfoDao studentInfoDao = getDao();
		//创建集合，用于存储从dao层获取到的数据库查询结果；
		List<StudentInfoEntity> studentInfoEntity = studentInfoDao.getStudentInfoEntityList();
		//括号内的两个分数，第一个为，第二个为要返回的数据
		model.addAttribute("studentInfoList",studentInfoEntity);
		return "studentList";
	}

	private StudentInfoDao getDao() {
		//用ApplicationContext方法，获取applicationContext.xml配置文件
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		//链接dao层类文件
		StudentInfoDao studentInfoDao = (StudentInfoDao) context.getBean("studentInfoDao");
		//此处的返回值，定位的是，将处理结果返回到WEB_INF下的jsp文件
		return studentInfoDao;
	}
}
