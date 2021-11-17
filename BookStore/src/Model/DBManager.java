package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBManager {

	public UserBean checkLogin(UserBean lb) throws Exception {

		UserBean risultato = null;
		
		if (lb != null) {
			try {
			Class.forName("com.mysql.jdbc.Driver");

			// 1. Effettuo connessione al database
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/form", "root", "manuel");

			// 2. Crea lo statement
			Statement st = conn.createStatement();

			// 3. esegui la query
			ResultSet res = st.executeQuery("SELECT * FROM account WHERE username = '" + lb.getUsr() + "' AND password = '" + lb.getPsw() + "'");

			// 4. Prendi il risultato
			if(res.next())
			{
				lb.setNome(res.getString("name"));
				lb.setCognome(res.getString("surname"));
				risultato = lb;
			}
			conn.close();
		} 
			catch(Exception e)
			{throw(e);}
		} 
		return risultato;
	}

}

