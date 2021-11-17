
package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import Model.*;



@WebServlet("/index.html")

public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// questo counter è visibile solo in questa servlet
	// e conta il numero di accessi totale da parte di chiunque accede a questa servlet
	// da quando viene deployed sul server
	private int servletCount;  

	public void  init() throws ServletException {
	      // inizializzazione 
	      servletCount = 0;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// aggiorno contatori e memorizzo i conteggi in cb   
		CounterBean cb = updateCounters(request);
		

		// recupero login e password e li memorizzo in userB se presenti
		UserBean userB = getUsrPsw(request);

		if (userB == null)     // no login e/o no password -> redirigo a login form 
			response.sendRedirect("newlogin.jsp");    // non ho bisogno di mandargli parametri. Il nome login.jsp si vedrà nel browser
		else {
			try{
				UserBeanDAO ubd=new UserBeanDAO ();
				UserBean ub = ubd.doRetrieveByKey (userB.getUsr (), userB.getPsw ());
				if (ub==null) {    // login e/o password sbagliati -> chiamo login form  con messaggio errore
									// il nome login.jsp non si vedrà nel browser
					request.setAttribute("denied", true);
					System.out.println("\n\n sono in servletlogin\n\n");

					System.out.println(userB.getPsw());
					System.out.println(userB.getUsr());

					RequestDispatcher requestDispatcher = request.getRequestDispatcher("newlogin.jsp");
					requestDispatcher.forward(request, response);
				}else {
					// l'utente è ammesso al sito: inserisco dati di login in cookies e do risposta
					
					Cookie usrcookie = new Cookie("usr", ub.getUsr());
					Cookie pswcookie = new Cookie("psw", ub.getPsw());
					response.addCookie(usrcookie);
					response.addCookie(pswcookie);
					
					HttpSession session=request.getSession();  
					session.setAttribute("userBean", ub );
					
					CartBean cart=new CartBean();
					CartBeanDAO cartdao=new CartBeanDAO();
					cart=cartdao.doRetrieveByUser(ub.getUsr());
					session.setAttribute("cart", cart);
					
					request.setAttribute("userBean", ub);  // l'output ha bisogno di queste informazioni
					request.setAttribute("countBean", cb);
					
					if (ub.isAdmin()==1) {
				
						RequestDispatcher requestDispatcher = request.getRequestDispatcher("newadminpanel.jsp");
						requestDispatcher.forward(request, response);
					
					}else{
						RequestDispatcher requestDispatcher = request.getRequestDispatcher("newoutput.jsp");
						requestDispatcher.forward(request, response);
					}
				}
			}
			catch(Exception e)
			{  
				e.printStackTrace();
			}
		}
	}

		
	private UserBean getUsrPsw(HttpServletRequest request) {
		
		UserBean ub = null;
		String usr = null, psw = null;

		Cookie[] c = request.getCookies();   // tramite cookie
		if (c!=null) { 
			for(int i=0;i<c.length;i++) {
				if (c[i].getName().equals("usr")) 
					usr = c[i].getValue();
				if (c[i].getName().equals("psw")) 
					psw = c[i].getValue();	
			}
		} 	
		if (usr == null || psw == null){		// se recupero tramite cookie fallisce, allora tramite parametri	
			String temp;                        
			temp = request.getParameter("usr");
			if (temp!= null) {
				usr = temp;
				temp = request.getParameter("psw");   
				if (temp!= null) {
					psw = temp;
				}
			}
		}
		
		if (usr != null && psw != null)    // se recupero ha avuto successo riempio bean
			 ub = new UserBean(usr, psw);
		
		return ub;
	}
	
		
	
	private CounterBean updateCounters(HttpServletRequest request) {

		servletCount++;     // aggiornamento livello di scoping -> servlet
		Integer sessionCount;   // livello di scoping -> session
		Integer applicationCount;  // livello di scoping -> application (servletContext)

		HttpSession session=request.getSession();      // lettura ed aggiornamento -> session
		sessionCount = (Integer)session.getAttribute("counter");
		if (sessionCount != null) 
			sessionCount++;
		else 
			sessionCount = 1;	
		session.setAttribute("counter", sessionCount);

		ServletContext application = getServletContext();   // lettura ed aggiornamento -> application
		applicationCount = (Integer)application.getAttribute("counter");
		if (applicationCount != null)
			applicationCount++;
		else
			applicationCount = 1;
		application.setAttribute("counter", applicationCount);
		
		CounterBean cb = new CounterBean(servletCount, sessionCount, applicationCount);
		
		return cb;
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		
	}

}
