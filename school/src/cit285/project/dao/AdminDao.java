package cit285.project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import cit285.project.domain.Course;
import cit285.project.domain.Student;

public class AdminDao {
	
	public void addCourse(Course course)
			throws SQLException, ClassNotFoundException {
		
		
		// Get Db connection
		Connection connection = getConnection();
		
		// Create statement
		Statement statement = connection.createStatement();
		
		// Create query
		String query = "insert into course (CourseID,CourseCode,CourseTitle,CourseDescription) " +
					   "values (?,?,?,?)";
		
		// Execute statement
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		
		preparedStatement.setInt(1, course.getCourseId());
		preparedStatement.setString(2,course.getCourseCode());
		preparedStatement.setString(3, course.getCourseTitle());
		preparedStatement.setString(4, course.getCourseDescription());
		
		preparedStatement.executeQuery();
	}
	
	public ArrayList<Student> getStudentsList()
			throws SQLException, ClassNotFoundException {
		
		ArrayList<Student> studentsList = new ArrayList<>();
		
		// Get Db connection
		Connection connection = getConnection();
		
		// Create statement
		Statement statement = connection.createStatement();
		
		// Execute statement
		ResultSet resultSet = statement.executeQuery("select * from student");
		
		// Iterate through the result and print
		while(resultSet.next()) {
			Student student = new Student();
			student.setId(resultSet.getInt(1));
			student.setFirstName(resultSet.getString(2));
			student.setFirstName(resultSet.getString(3));
			
			studentsList.add(student);
		}
		
		return studentsList;
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
