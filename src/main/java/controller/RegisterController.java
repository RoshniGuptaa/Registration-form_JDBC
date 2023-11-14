package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.trainee;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;

import dao.traineeDao;

/**
 * Servlet implementation class RegisterController
 */
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	traineeDao traineeD=new traineeDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("/views/traineeRegister.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String FirstName=request.getParameter("firstName");
		String LastName=request.getParameter("lastName");
		String  username=request.getParameter("username");
		String password=request.getParameter("password");
		String address=request.getParameter("address");
		String con=request.getParameter("contact");
		int contact=Integer.parseInt(con);
		trainee t =new trainee();
		
		t.setFirstName(FirstName);
		t.setLastName(LastName);
		t.setUsername(username);
		t.setPassword(password);
		t.setAddress(address);
		t.setContact(contact);
		
		
		try {
			traineeD.registerTrainee(t);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("/views/traineeDetail.jsp");
		dispatcher.forward(request, response);
	}

}
