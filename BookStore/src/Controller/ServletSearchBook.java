package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.BookBean;
import Model.BookBeanDAO;
import Model.UserBean;
import Model.UserBeanDAO;

/**
 * Servlet implementation class ServletUpdateUser
 */
@WebServlet("/ServletSearchBook")
public class ServletSearchBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletSearchBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String tit = request.getParameter("title");
		System.out.println("\n\\nsono nella servserchbook"+tit);
		BookBean lb=new BookBean();
		BookBeanDAO bbd=new BookBeanDAO();
		lb=bbd.doRetrieveByTitle(tit);
		//System.out.println("\n\\nsono nella servserchbook isbn del libro"+lb.getIsbn());

		

		
		
		if(lb!=null&&lb.getIsbn()!=null)   //On success, you can display a message to user on Home page
		{
			request.setAttribute("isbn", lb.getIsbn());
			request.getRequestDispatcher("newoutputbook.jsp").forward(request, response);
		}
		else   //On Failure, display a meaningful message to the User.
		{
			request.setAttribute("errMessage", "bookNotFound");
			request.getRequestDispatcher("newhome.jsp").forward(request, response);
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
