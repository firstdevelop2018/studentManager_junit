package teacher1;

import java.io.Serializable;
import java.sql.Date;

public class Teacher1Entity implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = -4891738980386746009L;

	/**
	   * Id
	   */

		private int id;
		/**
		 * name
		 */
		private String name;
		/**
		 * birthday
		 */
		private Date birthday;
		/**
		 * age
		 */
		private int age;
		/**
		 * score
		 */
		private int score;
		/**
		 * @return id
		 */
		public int getId() {
			return id;
		}
		/**
		 * @param id セットする id
		 */
		public void setId(int id) {
			this.id = id;
		}
		/**
		 * @return name
		 */
		public String getName() {
			return name;
		}
		/**
		 * @param name セットする name
		 */
		public void setName(String name) {
			this.name = name;
		}
		/**
		 * @return birthday
		 */
		public Date getBirthday() {
			return birthday;
		}
		/**
		 * @param birthday セットする birthday
		 */
		public void setBirthday(Date birthday) {
			this.birthday = birthday;
		}
		/**
		 * @return age
		 */
		public int getAge() {
			return age;
		}
		/**
		 * @param age セットする age
		 */
		public void setAge(int age) {
			this.age = age;
		}
		/**
		 * @return score
		 */
		public int getScore() {
			return score;
		}
		/**
		 * @param score セットする score
		 */
		public void setScore(int score) {
			this.score = score;
		}



}
