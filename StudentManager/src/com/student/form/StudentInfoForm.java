package com.student.form;

import java.io.Serializable;

public class StudentInfoForm implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = -6489396044443182262L;

	/**
	 * ID.
	 */
	private String id;

	/**
	 * 名前.
	 */
	private String name;

	/**
	 * 生年月日.
	 */
	private String birthday;

	/**
	 * 年齢.
	 */
	private String age;

	/**
	 * 成績.
	 */
	private String score;

	/**
	 * @return id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id セットする id
	 */
	public void setId(String id) {
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
	public String getBirthday() {
		return birthday;
	}

	/**
	 * @param birthday セットする birthday
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	/**
	 * @return age
	 */
	public String getAge() {
		return age;
	}

	/**
	 * @param age セットする age
	 */
	public void setAge(String age) {
		this.age = age;
	}

	/**
	 * @return score
	 */
	public String getScore() {
		return score;
	}

	/**
	 * @param score セットする score
	 */
	public void setScore(String score) {
		this.score = score;
	}

	/**
	 * @return serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
