	package Controller;
	
	import java.io.IOException;
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
	 * Servlet implementation class ServletRegister
	 */
	@WebServlet("/ServletAddBook")
	public class ServletAddBook extends HttpServlet {
		private static final long serialVersionUID = 1L;
	
		/**
		 * @see HttpServlet#HttpServlet()
		 */
		public ServletAddBook() {
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
			
			String regex= "^\\d*\\.\\d+|\\d+\\.\\d*$";
			String yeregex="[0-9]+";

			String p =(String)request.getParameter("price");
			String ye=(String)request.getParameter("year");
			
			String titolo = request.getParameter("title");
			String isbn = request.getParameter("isbn");
			String descr = request.getParameter("description");
			System.out.println("prezzo stringa "+p);
			Double prezzo=0.0;
			
			if (p.matches(regex)) {
				 prezzo = Double.parseDouble(request.getParameter("price"));

			}
			
			if (p.matches(regex)) {
				System.out.println("match ok");

			}
			System.out.println(prezzo);
			String path = request.getParameter("image");
			String aut = request.getParameter("author");
			String pub = request.getParameter("publisher");
			String cat=request.getParameter("category");
			int y=0;
			System.out.println("anno stringa "+ye);
			if (ye.matches(yeregex)) {
				y=Integer.parseInt(request.getParameter("year"));

			}
			
			if (ye.matches(yeregex)) {
				System.out.println("anno matcha");

			}
			

	
			BookBean lb = new BookBean();
			// Using Java Beans - An easiest way to play with group of related data
			lb.setDescription(descr);
			lb.setTitle(titolo);
			lb.setImage(path);
			lb.setIsbn(isbn);
			lb.setPrice(prezzo);
			lb.setAuthor(aut);
			lb.setPublisher(pub);
			lb.setYear(y);
			lb.setCategory(cat);
	
			BookBeanDAO bbd = new BookBeanDAO();
	
			// The core Logic of the Registration application is present here. We
			// are going to insert user data in to the database.
			int bookRegistered = bbd.doSave(lb);
	
			if(bookRegistered>=1)   //On success, you can display a message to user on Home page
			{
				request.getRequestDispatcher("newadminpanel.jsp").forward(request, response);
			}
			else   //On Failure, display a meaningful message to the User.
			{
				request.setAttribute("errMessage", bookRegistered);
				request.getRequestDispatcher("newaddbook.jsp").forward(request, response);
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
