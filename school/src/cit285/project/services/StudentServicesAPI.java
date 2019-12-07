package cit285.project.services;

import java.util.ArrayList;

import cit285.project.domain.Cart;
import cit285.project.domain.Course;
import cit285.project.domain.Student;

public interface StudentServicesAPI {

	public Student getStudent(int studentId);
	
	public Course getCourse(int courseId);
	
	public ArrayList<Course> getCourses();
	
	public Cart createCart();
}
