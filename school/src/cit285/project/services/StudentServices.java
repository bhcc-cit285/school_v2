package cit285.project.services;

import java.sql.SQLException;
import java.util.ArrayList;

import cit285.project.dao.StudentDao;
import cit285.project.domain.Cart;
import cit285.project.domain.Course;
import cit285.project.domain.Student;

public class StudentServices implements StudentServicesAPI{
	StudentDao studentDao;
	
	public StudentServices() {
		studentDao = new StudentDao();
	}
	
	// Get a student given student id
	public Student getStudent(int studentId){
		Student student = null;
		
		try {
			student = studentDao.getStudent(studentId);
			
		}catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.toString());
		}
		
		return student;
	}
	
	// Get course id given course id
	public Course getCourse(int courseId){
		Course course = null;
		
		try {
			course = studentDao.getCourse(courseId);
			
		}catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.toString());
		}
		
		return course;
	}
	
	// Get list of courses from the Dao
	public ArrayList<Course> getCourses(){
		ArrayList<Course> courses = null;
		
		try {
			courses = studentDao.getCoursesList();
			
		}catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.toString());
		}
		
		return courses;
	}
	
	// Create a new Cart
	public Cart createCart() {
		return new Cart();
	}
}
