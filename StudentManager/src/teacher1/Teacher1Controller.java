package teacher1;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class Teacher1Controller {

	@RequestMapping(value = "/dispalyteacher1")
	public String displayTeacherList(Model model) {
		Teacher1Dao teacher1Dao = getDao();
		List<Teacher1Entity> teacher1EntityList = teacher1Dao.search();
		model.addAttribute("teacher1EntityList",teacher1EntityList);

		return "teacherList";
	}

	private Teacher1Dao getDao() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Teacher1Dao teacher1Dao = (Teacher1Dao) context.getBean("teacher1Dao");
		return teacher1Dao;
	}
}
