package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.UserBean;
import Model.UserBeanDAO;

/**
 * Servlet implementation class ServletUpdateUser
 */
@WebServlet("/ServletUpdateUser")
public class ServletUpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletUpdateUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String old = (String)request.getSession(false).getAttribute("oldUser");
		System.out.println("\nvecchio utente\n"+old+"\n\n");
		UserBeanDAO ubd=new UserBeanDAO();
		ubd.doDelete(old);
		
		
		 String fullName = request.getParameter("nome");
		 String email = request.getParameter("email");
		 String userName = request.getParameter("username");
		 String password = request.getParameter("password");
		 String address = request.getParameter("address");
		 String card = request.getParameter("card");
		 String cognome = request.getParameter("cognome");


		 
		 UserBean UserBean = new UserBean();
		 //Using Java Beans - An easiest way to play with group of related data
		 UserBean.setUsr(userName);
		 UserBean.setPsw(password); 
		 UserBean.setAddress(address);
		 UserBean.setCard(card);
		 UserBean.setNome(fullName);
		 UserBean.setCognome(cognome);
		 UserBean.setEmail(email);

		 UserBean.setEmail(email);
		 UserBean.setUsr(userName);
		 
		 UserBeanDAO userBeanDAO = new UserBeanDAO();
		 
		 //The core Logic of the Registration application is present here. We are going to insert user data in to the database.
		 int userRegistered = userBeanDAO.doSave(UserBean);
		 
		 if(userRegistered>=1)   //On success, you can display a message to user on Home page
		 {
		 request.getRequestDispatcher("newlogin.jsp").forward(request, response);
		 }
		 else   //On Failure, display a meaningful message to the User.
		 {
		 request.setAttribute("errMessage", userRegistered);
		 request.getRequestDispatcher("newupdateuser.jsp").forward(request, response);
		 }
	
	
	
	}
	
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
