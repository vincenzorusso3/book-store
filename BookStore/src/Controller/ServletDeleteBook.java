package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.SendResult;

import Model.BookBeanDAO;
import Model.CartBean;
import Model.CartBeanDAO;
import Model.OrderBeanDAO;
import Model.UserBeanDAO;

/**
 * Servlet implementation class ServletDelete
 */
@WebServlet("/ServletDeleteBook")
public class ServletDeleteBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDeleteBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		String isbn = request.getParameter("book");
		CartBeanDAO cbd=new CartBeanDAO();
		CartBean cb=cbd.doRetrieveByBook(isbn);
		BookBeanDAO bbd=new BookBeanDAO();
		cbd.doDelete(cb);
		bbd.doDelete(isbn);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("newadminpanel.jsp");
		requestDispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
