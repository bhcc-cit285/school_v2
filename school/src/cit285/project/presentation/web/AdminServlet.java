package cit285.project.presentation.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cit285.project.config.SchoolSystemConfig;
import cit285.project.domain.Cart;
import cit285.project.domain.Course;
import cit285.project.services.AdminServicesAPI;
import cit285.project.services.StudentServicesAPI;

/**
 * Servlet implementation class PaymentsServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminServicesAPI adminServices;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init() throws ServletException {
    	try{
			//System.out.println("Configuring services...");
			SchoolSystemConfig.configureServices();
		}
		catch(Exception e){}
		//System.out.println("Getting payments services...");
		adminServices = SchoolSystemConfig.getAdminServices();
	}
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		HttpSession session = request.getSession();
		String source = request.getParameter("source");
		
		if (source.equals("courseadd")){
			
			getServletContext().getRequestDispatcher("/WEB-INF/jsp/addcoursepage.jsp").forward(request, response);
		}
		else if(source.equals("addcourse")) {
			Course course = new Course();
			
			course.setCourseId(Integer.parseInt(request.getParameter("courseid")));
			course.setCourseCode(request.getParameter("coursecode"));
			course.setCourseTitle(request.getParameter("coursetitle"));
			course.setCourseDescription(request.getParameter("coursedescription"));
			
			adminServices.registerCourse(course);
			
			getServletContext().getRequestDispatcher("/WEB-INF/jsp/adminpage.jsp").forward(request, response);
		}
		else if(source.equals("courseupdate")) {
			// TO DO
			
			getServletContext().getRequestDispatcher("/WEB-INF/jsp/updatecoursepage.jsp").forward(request, response);
		}
		else if(source.equals("coursedelete")) {
			// TO DO
			
			getServletContext().getRequestDispatcher("/WEB-INF/jsp/deletecoursepage.jsp").forward(request, response);
		}
		else if(source.equals("studentadd")) {
			// TO DO
			
			getServletContext().getRequestDispatcher("/WEB-INF/jsp/addstudentpage.jsp").forward(request, response);
		}
		else{
			
			session.setAttribute("Error","Unknown source!");
			getServletContext().getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
		}
	}
}
