/**
 *
 */
package com.student.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.student.entity.Student2Entity;
import com.student.entity.StudentEntity;
import com.student.util.DateUtil;

/**
 * @author Administrator
 *
 */
class Student2DaoTest {

	private static Student2Dao student2Dao;
	private String format = "yyyy/MM/dd";

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		student2Dao = (Student2Dao) context.getBean("student2Dao");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {

	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		student2Dao.delete();

	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testSeach1() {

		List<Student2Entity> entityList = student2Dao.search();
		int expectedCount = 0;
		int actualCount = entityList.size();
		assertEquals(expectedCount, actualCount);



	}

	@Test
	void testSeach2() throws Exception {
		Student2Entity entity = new Student2Entity();
		entity.setName("zhao 1");
		String birthday = "1985/5/6";
		entity.setBirthday(DateUtil.stringToDate(birthday, format));
		entity.setAge(34);
		entity.setScore(90);
		student2Dao.insert(entity);

		List<Student2Entity> entityList = student2Dao.search();
		int expectedCount = 1;
		int actualCount = entityList.size();
		assertEquals(expectedCount, actualCount);


		Student2Entity expectedEntity = new Student2Entity();
		expectedEntity.setName("zhao 1");
		expectedEntity.setBirthday(DateUtil.stringToDate(birthday, format));
		expectedEntity.setAge(34);
		expectedEntity.setScore(90);
		Student2Entity actualEntity = entityList.get(0);

		assertTrue( equals(expectedEntity,actualEntity));
	}

	//   4/7hao
	@Test
	public void testInsert() throws Exception {
		student2Dao.delete();

		Student2Entity entity = new Student2Entity();
		entity.setName("wang 5");
		entity.setBirthday(DateUtil.stringToDate("1998/01/01","yyyy/MM/dd"));
		entity.setAge(21);
		entity.setScore(89);

		student2Dao.insert(entity);
		List<Student2Entity> entityList = student2Dao.search();
		assertEquals(1, entityList.size());

		Student2Entity entityExpected = new Student2Entity();
		entityExpected.setName("wang 5");
		entityExpected.setBirthday(DateUtil.stringToDate("1998/01/01","yyyy/MM/dd"));
		entityExpected.setAge(21);
		entityExpected.setScore(89);

		assertTrue(equals(entityExpected,entityList.get(0)));

	}

	@Test
	public void testUpdate () throws Exception {
		student2Dao.delete();

		Student2Entity entity = new Student2Entity();
		entity.setName("wang 5");
		entity.setBirthday(DateUtil.stringToDate("1998/01/01","yyyy/MM/dd"));
		entity.setAge(21);
		entity.setScore(89);
		student2Dao.insert(entity);

		List<Student2Entity> entityList = student2Dao.search();

		Student2Entity entityUpdate = entityList.get(0);
		entityUpdate.setName("wang 6");
		entityUpdate.setBirthday(DateUtil.stringToDate("1999/01/01","yyyy/MM/dd"));
		entityUpdate.setAge(22);
		entityUpdate.setScore(90);

		student2Dao.update(entityUpdate);
		entityList = student2Dao.search();
		assertEquals(1, entityList.size());

		Student2Entity entityExpected = new Student2Entity();
		entityExpected.setName("wang 6");
		entityExpected.setBirthday(DateUtil.stringToDate("1999/01/01","yyyy/MM/dd"));
		entityExpected.setAge(22);
		entityExpected.setScore(90);

		assertTrue(equals(entityExpected,entityList.get(0)));

	}
	private boolean equals(Student2Entity entity1, Student2Entity entity2) {

		if (entity1.getName().equals(entity2.getName()) && entity1.getBirthday().equals(entity2.getBirthday())
				&& entity1.getAge() == entity2.getAge() && entity1.getScore() == entity2.getScore()) {
			return true;

		} else {
			return false;
		}
	}


	@Test
	void testSeach3() throws Exception {
		Student2Entity entity = new Student2Entity();
		entity.setName("zhao 1");
		String birthday1 = "1985/5/1";
		entity.setBirthday(DateUtil.stringToDate(birthday1, format));
		entity.setAge(34);
		entity.setScore(90);
		student2Dao.insert(entity);

		entity = new Student2Entity();
		entity.setName("zhao 2");
		String birthday2 = "1985/5/2";
		entity.setBirthday(DateUtil.stringToDate(birthday2, format));
		entity.setAge(34);
		entity.setScore(80);
		student2Dao.insert(entity);

		entity = new Student2Entity();
		entity.setName("zhao 3");
		String birthday3 = "1985/5/3";
		entity.setBirthday(DateUtil.stringToDate(birthday3, format));
		entity.setAge(34);
		entity.setScore(70);
		student2Dao.insert(entity);


		List<Student2Entity> entityList = student2Dao.search();
		int expectedCount = 3;
		int actualCount = entityList.size();
		assertEquals(expectedCount, actualCount);

		List<Student2Entity> expectedEntityList = new ArrayList<>();
		Student2Entity expectedEntity = new Student2Entity();
		expectedEntity.setName("zhao 1");

		expectedEntity.setBirthday(DateUtil.stringToDate(birthday1, format));
		expectedEntity.setAge(34);
		expectedEntity.setScore(90);
		student2Dao.insert(expectedEntity);

		expectedEntity = new Student2Entity();
		expectedEntity.setName("zhao 2");

		expectedEntity.setBirthday(DateUtil.stringToDate(birthday2, format));
		expectedEntity.setAge(34);
		expectedEntity.setScore(80);
		student2Dao.insert(expectedEntity);

		expectedEntity = new Student2Entity();
		expectedEntity.setName("zhao 3");

		expectedEntity.setBirthday(DateUtil.stringToDate(birthday3, format));
		expectedEntity.setAge(34);
		expectedEntity.setScore(70);
		student2Dao.insert(expectedEntity);

		assertTrue(equals(expectedEntityList,entityList));



	}
	//顺序不一样的比较方法
	public boolean equalsIngoreSort(List<Student2Entity> list1 , List<Student2Entity> list2) {
		boolean sameFlag = true;
		for (Student2Entity entity1 : list1 ) {

			boolean existFlag = false;
			for (Student2Entity entity2 : list2  ) {
				if (equals(entity1, entity2)) {
					existFlag = true;
					break;
				}
			}
			if (!existFlag) {
				sameFlag = false;
				break;
			}
		}
		return sameFlag;
	}
//顺序一样大的判断相同方法；
	private boolean equals(List<Student2Entity> list1 , List<Student2Entity> list2) {

		int size = list1.size();
		boolean sameFlag = true;
		for(int i = 0; i< size ; i++) {
			Student2Entity entity1 = list1.get(i);
			Student2Entity entity2 = list1.get(i);
			boolean flag = equals(entity1,entity2);
			if(!flag) {
				sameFlag = flag;
				break;
			}


		}
		return sameFlag;
	}

}
