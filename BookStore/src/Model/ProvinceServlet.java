package Model;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProvinceServlet
 */
@WebServlet("/ProvinceServlet")
public class ProvinceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProvinceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String province=request.getParameter("provinces");
		String myvar = null;

		if (province.equals("salerno")) {
			myvar = 
					" <select name=\"comuni\" >"+
					"  <option value=\"salerno\">Salerno</option>"+
					"  <option value=\"bellizzi\">Bellizzi</option>"+
					"  <option value=\"pontecagnano\">Pontecagnano</option>"+
					"</select>";
						
		} else if (province.equals("napoli")) {
			 myvar = 
					" <select name=\"comuni\" >"+
					"  <option value=\"napoli\">Napoli</option>"+
					"  <option value=\"acerra\">Acerra</option>"+
					"  <option value=\"afragola\">Afragola</option>"+
					"</select>";
						
		} else{
			
			myvar = 
					" <select name=\"comuni\" >"+
					"  <option value=\"avellino\">Avellino</option>"+
					"  <option value=\"montoro\">Montoro</option>"+
					"  <option value=\"solofra\">Solofra</option>"+
					"</select>";
		}



		PrintWriter out=response.getWriter();
		out.println("Comuni: " + myvar);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
