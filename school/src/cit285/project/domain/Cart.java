package cit285.project.domain;

import java.util.HashSet;
import java.util.Set;

public class Cart {
	private Student student;
	private Set<Course> courses; // No duplicate courses in the set.
	
	public Cart() {
		student = new Student();
		courses = new HashSet<>();
	}
	
	public void setStudent(Student student) {
		this.student = student;
	}
	
	public Student getStudent() {
		return student;
	}
	
	public void addCourse(Course course) {
		courses.add(course);
	}
	
	public void removeCourse(Course course) {
		courses.remove(course);
	}
	
	public Set<Course> getCourses(){
		return courses;
	}
	
	public Course findCourse(String courseCode) {
		Course c = null;
		
		for(Course course: courses) {
			if(course.getCourseCode().equals(courseCode))
				c = course;
		}
		return c;
	}
	
	public void clear() {
		courses.clear();
	}
}
