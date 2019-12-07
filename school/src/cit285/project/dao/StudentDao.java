package cit285.project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import cit285.project.domain.Course;
import cit285.project.domain.Student;

public class StudentDao {
	
	public Student getStudent(int studentId)
			throws SQLException, ClassNotFoundException {
		
		Student student = new Student();
		
		// Get Db connection
		Connection connection = getConnection();
		
		// Create statement
		Statement statement = connection.createStatement();
		
		// Create query
		String query = "select * from student where StudentID = " + studentId;
		
		// Execute statement
		ResultSet resultSet = statement.executeQuery(query);
		
		// Iterate through the result and print
		if(resultSet.next()) {
			
			student.setId(resultSet.getInt(1));
			student.setFirstName(resultSet.getString(2));
			student.setFirstName(resultSet.getString(3));
		}
		else {
			// No student found for this studentID
			student = null;
		}
		
		// return the result
		return student;
	}
	
	// Get a course given given the course Id.
	public Course getCourse(int courseId)
			throws SQLException, ClassNotFoundException {
		
			Course course = new Course();
			
			// Get Db connection
			Connection connection = getConnection();
			
			// Create statement
			Statement statement = connection.createStatement();
			
			// Create query
			String query = "select * from course where CourseID = " + courseId;
			
			// Execute statement
			ResultSet resultSet = statement.executeQuery(query);
			
			// Iterate through the result and print
			if(resultSet.next()) {
				course.setCourseId(resultSet.getInt(1));
				course.setCourseCode(resultSet.getString(2));
				course.setCourseTitle(resultSet.getString(3));
				course.setCourseDescription(resultSet.getString(4));
			}
			else {
				// No student found for this studentID
				course = null;
			}
			
			// return the result
			return course;
	}
	
	// Get a list of courses
	public ArrayList<Course> getCoursesList()
			throws SQLException, ClassNotFoundException {
		
		ArrayList<Course> coursesList = new ArrayList<>();
		
		// Get Db connection
		Connection connection = getConnection();
		
		// Create statement
		Statement statement = connection.createStatement();
		
		// Execute statement
		ResultSet resultSet = statement.executeQuery("select * from course");
		
		// Iterate through the result and print
		while(resultSet.next()) {
			Course course = new Course();
			course.setCourseId(resultSet.getInt(1));
			course.setCourseCode(resultSet.getString(2));
			course.setCourseTitle(resultSet.getString(3));
			course.setCourseDescription(resultSet.getString(4));
			
			coursesList.add(course);
		}
		
		return coursesList;
	}
	
	private Connection getConnection() 
			throws SQLException, ClassNotFoundException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// Connect to the database
		Connection connection = DriverManager
				.getConnection("jdbc:mysql://localhost/schooldb","root","cmoreno");
		
		return connection;
	}
}
