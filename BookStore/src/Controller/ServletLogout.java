
package Controller;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import Model.CartBean;
import Model.CartBeanDAO;
import Model.UserBean;

/**
 * Servlet implementation class ServletLogout
 */
@WebServlet("/ServletLogout")
public class ServletLogout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLogout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 	
		Integer applicationCount;
		
		ServletContext application = getServletContext();
        applicationCount = (Integer)application.getAttribute("counter");
        if (applicationCount != null)
        		applicationCount++;
        	else
        		applicationCount = 1;
        application.setAttribute("counter", applicationCount);
        
		// per fare in modo che un cookie venga cancellato dal browser
		// bisogna ri-crearlo con valore "", dargli MaxAge pari a 0 e rinviarglielo.
			Cookie usr = new Cookie("usr", "");
	        usr.setMaxAge(0);
	        response.addCookie(usr);
	        
	        Cookie psw = new Cookie("psw", "");
	        psw.setMaxAge(0);
	        response.addCookie(psw);
	        
	        CartBean cart=(CartBean)request.getSession().getAttribute("cart");
	        UserBean currUser=(UserBean)request.getSession().getAttribute("userBean");
	        CartBeanDAO cartdao=new CartBeanDAO();
	        if (cart!=null && (currUser.isAdmin()==0)) {
	        	
	        	
	        	if (!(cart.getOrders().isEmpty())) {
	        		System.out.println(cart.toString());
	 		       
		        	cartdao.doUpdate(cart);
				}
	        

				

			}
	        
	        
	        request.getSession().invalidate();
	        
	        // reinvio anche il form di login
	        response.sendRedirect("newoutput.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
