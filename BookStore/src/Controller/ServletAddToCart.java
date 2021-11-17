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
import Model.OrderBeanDAO;

/**
 * Servlet implementation class ServletAddToCart
 */
@WebServlet("/ServletAddToCart")
public class ServletAddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static int instanceCounterKey=0;
	private int counterKey =0;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAddToCart() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	super.init();
    	initialKey();
    }
    
    
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String user=(String)request.getParameter("user");
		String isbn=(String)request.getParameter("isbn");
		String q=(String)request.getParameter("quantity");
		int quantity=1;
		if (q!=null&&!(q.equals(""))) {
			quantity=Integer.parseInt(q);
		}
		
		CartBean cart=(CartBean)request.getSession().getAttribute("cart");
		OrderBean ob=new OrderBean();
		OrderBean oldOrder=new OrderBean();

		ob.setUtente(user);
		ob.setLibro(isbn);
		//se l' ordine è presente nel carrello aggiorno la quantita
		if (ob.findOrder(cart)!=null) {
			oldOrder=ob.findOrder(cart);
			oldOrder.setQuantita(quantity);
			
			cart.update(oldOrder);
			
			System.out.println("numero ordine  "+oldOrder.getNumOrdine());
			System.out.println("numero isbn "+oldOrder.getLibro());
			System.out.println("numero quantita "+oldOrder.getQuantita());
			System.out.println("utente "+oldOrder.getUtente());


			
		}else{//altrimenti creo il nuovo ordine
			
			
		    increaseKey();
		    ob.setNumOrdine(counterKey);
		    ob.setQuantita(quantity);
		    cart.add(ob);
		     
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
	
	public synchronized void increaseKey(){
		instanceCounterKey++;
	    counterKey = instanceCounterKey;
	}
	
	public synchronized void initialKey(){
		OrderBeanDAO obd=new OrderBeanDAO();
		instanceCounterKey=obd.doRetrieveMaxOrder();
	    counterKey = instanceCounterKey;
	}

}
