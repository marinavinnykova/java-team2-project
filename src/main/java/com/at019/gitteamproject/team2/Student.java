package com.at019.gitteamproject.team2;

import java.util.Comparator;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Student implements Comparable<Student>{
	
	String surname;
	String course;
	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public void setAge(int age) {
		this.age = age;
	}

	int age;
	
	@JsonCreator
	public Student(@JsonProperty("Surname") String surname, @JsonProperty("Course") String course, @JsonProperty("Age") int age) {
		super();
		this.surname = surname;
		this.course = course;
		this.age = age;
	}

	public String getSurname() {
		return surname;
	}

	public String getCourse() {
		return course;
	}

	public int getAge() {
		return age;
	}
	
	public void printAllInfo ()
	{
		System.out.println(getSurname() +" "+ getCourse() +" "+ getAge());
	}
	

	public int compareTo(Student st2) {
		if (this.surname.equals(st2.surname) && (this.course.equals(st2.course) && (this.age == st2.age)))
			return 0;
	else if ((this.surname.equals(st2.surname))){
		if ((this.course.compareTo(st2.course) == 1))
				return 1;
		else if ((this.course.compareTo(st2.course) == -1))
			return -1;
		else
		 return (this.age > st2.age)?1:-1;
	}
	else 
		return this.surname.compareTo(st2.surname);
	}
}
	



