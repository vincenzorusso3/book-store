package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.UserBean;
import Model.UserBeanDAO;

/**
 * Servlet implementation class ServletRegister
 */
@WebServlet("/ServletSelfUserUpdate")
public class ServletSelfUserUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletSelfUserUpdate() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Copying all the input parameters in to local variables
		UserBean oldUser=(UserBean) request.getSession().getAttribute("userBean");
		UserBeanDAO userBeanDAO=new UserBeanDAO();
			
		String fullName = request.getParameter("nome");
		String email = request.getParameter("email");
		String userName = oldUser.getUsr();
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String card = request.getParameter("card");
		String cognome = request.getParameter("cognome");
		String prov=request.getParameter("provinces");
		String com=request.getParameter("comuni");
		
		System.out.println("\n\n sono in selfservlet\n");
		System.out.println(fullName);
		System.out.println(email);
		System.out.println(userName);
		System.out.println(password);
		System.out.println(address);
		System.out.println(card);
		System.out.println(cognome);
		System.out.println(prov);
		System.out.println(com);




		UserBean UserBean = new UserBean();
		// Using Java Beans - An easiest way to play with group of related data
		UserBean.setUsr(userName);
		UserBean.setPsw(password);
		UserBean.setAddress(address);
		UserBean.setCard(card);
		UserBean.setNome(fullName);
		UserBean.setCognome(cognome);
		UserBean.setEmail(email);
		UserBean.setProvincia(prov);
		UserBean.setComune(com);
		
		userBeanDAO.doUpdate(UserBean);


		// The core Logic of the Registration application is present here. We
		// are going to insert user data in to the database.
		int userRegistered = userBeanDAO.doUpdate(UserBean);

		if (userRegistered >= 1) // On success, you can display a message to
			// user on Home page
		{
			request.getSession().setAttribute("userBean", UserBean);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("newoutput.jsp");
			requestDispatcher.forward(request, response);
		
			
		} else // On Failure, display a meaningful message to the User.
		{
			request.setAttribute("errMessage", userRegistered);
			request.getRequestDispatcher("newselfupdateuser.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
