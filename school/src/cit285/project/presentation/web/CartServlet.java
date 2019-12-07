package cit285.project.presentation.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cit285.project.config.SchoolSystemConfig;
import cit285.project.domain.Cart;
import cit285.project.domain.Course;
import cit285.project.services.StudentServicesAPI;

/**
 * Servlet implementation class PaymentsServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentServicesAPI studentServices;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
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
		studentServices = SchoolSystemConfig.getStudentServices();
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
		Cart cart = (Cart)session.getAttribute("cart");
		
		if (source.equals("add")){
			int courseId = 0;
			
			try {
				courseId = Integer.parseInt(request.getParameter("courseid"));
				
			}catch(NumberFormatException nfe) {
				System.out.println("String not pursable to int... ");
			}
			
			Course course = studentServices.getCourse(courseId);
			// Add course to the cart
			cart.addCourse(course);
			
			// Add cart back to the session
			session.setAttribute("cart",cart);
			
			getServletContext().getRequestDispatcher("/WEB-INF/jsp/courseslist.jsp").forward(request, response);
		}
		else if(source.equals("remove")) {
			
			// remove the course from the cart
			//cart.removeCourse(course);
			
			// Add cart back to the session
			session.setAttribute("cart",cart);
			
			getServletContext().getRequestDispatcher("/WEB-INF/jsp/courseslist.jsp").forward(request, response);
		}
		else if(source.equals("clear")) {
			// remove the course from the cart
			cart.clear();
			
			// Add cart back to the session
			session.setAttribute("cart",cart);
			//session.setAttribute("student",student);
			//session.setAttribute("courses",courses);
			
			getServletContext().getRequestDispatcher("/WEB-INF/jsp/courseslist.jsp").forward(request, response);
		}
		else if(source.equals("showcart")) {
			Set<Course> coursescart = cart.getCourses();
			// Add cart back to the session
			session.setAttribute("coursescart",coursescart);
			//session.setAttribute("student",student);
			//session.setAttribute("courses",courses);
			
			getServletContext().getRequestDispatcher("/WEB-INF/jsp/showchartpage.jsp").forward(request, response);
		}
		else{
			session.setAttribute("cart",cart);
			session.setAttribute("Error","Unknown source!");
			getServletContext().getRequestDispatcher("/WEB-INF/jsp/courseslist.jsp").forward(request, response);
		}	
	}
}
