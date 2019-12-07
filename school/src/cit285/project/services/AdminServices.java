package cit285.project.services;

import java.sql.SQLException;

import cit285.project.dao.AdminDao;
import cit285.project.domain.Course;

public class AdminServices implements AdminServicesAPI {
	AdminDao adminDao;
	
	public AdminServices() {
		adminDao = new AdminDao();
	}
	
	// Get list of courses from the Dao
	public void registerCourse(Course course){
		
		try {
			adminDao.addCourse(course);
			
		}catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.toString());
		}
	}
}
