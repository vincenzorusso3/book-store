package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.CartBean;
import Model.OrderBean;

/**
 * Servlet implementation class ServletAddToCart
 */
@WebServlet("/ServletRemoveFromCart")
public class ServletRemoveFromCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRemoveFromCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String user=(String)request.getParameter("user");
		String isbn=(String)request.getParameter("isbn");

		
		CartBean cart=(CartBean)request.getSession().getAttribute("cart");
		OrderBean ob=new OrderBean();

		ob.setUtente(user);
		ob.setLibro(isbn);
		//se l' ordine non è presente nel carrello non faccio niente
		if (ob.findOrder(cart)!=null) {
			OrderBean del= ob.findOrder(cart);
			cart.remove(del);
		}
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("newoutput.jsp");
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
