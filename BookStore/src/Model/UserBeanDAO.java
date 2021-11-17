package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserBeanDAO {

	public synchronized UserBean doRetrieveByKey(String username, String password) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			UserBean ub = new UserBean(username, password);
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement("SELECT * FROM utente WHERE username = ? AND password = ?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			con.commit();
			if (rs.next()) {
				ub.setNome(rs.getString("nome"));
				ub.setCognome(rs.getString("cognome"));
				ub.setAdmin(rs.getInt("is_admin"));
				return ub;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DriverManagerConnectionPool.releaseConnection(con);
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;

	}

	public synchronized int doSave(UserBean ub) {
		String fullName = ub.getNome();
		String cognome = ub.getCognome();
		String email = ub.getEmail();
		String userName = ub.getUsr();
		String password = ub.getPsw();
		String card = ub.getCard();
		String address = ub.getAddress();
		String provincia=ub.getProvincia();
		String comune=ub.getComune();
		int res = 0;

		Connection con = null;
		PreparedStatement preparedStatement = null;

		try {
			try {
				con = DriverManagerConnectionPool.getConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String query = "insert into utente values (?,?,?,0,?,?,?,?,?,?)"; // Insert

			try {
				preparedStatement = con.prepareStatement(query);

				preparedStatement.setString(1, userName);
				preparedStatement.setString(2, password);
				preparedStatement.setString(3, address);
				preparedStatement.setString(4, card);
				preparedStatement.setString(5, fullName);
				preparedStatement.setString(6, cognome);
				preparedStatement.setString(7, email);
				preparedStatement.setString(8, provincia);
				preparedStatement.setString(9, comune);

				res = preparedStatement.executeUpdate();
				con.commit();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			} // Making use of prepared statements here to insert bunch of data

		}

		finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				DriverManagerConnectionPool.releaseConnection(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return res;
	}
	
	
	public synchronized int doUpdate(UserBean ub) {
		String fullName = ub.getNome();
		String cognome = ub.getCognome();
		String email = ub.getEmail();
		String userName = ub.getUsr();
		String password = ub.getPsw();
		String card = ub.getCard();
		String address = ub.getAddress();
		String provincia=ub.getProvincia();
		String comune=ub.getComune();
		int res = 0;

		Connection con = null;
		PreparedStatement preparedStatement = null;

		try {
			try {
				con = DriverManagerConnectionPool.getConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String query = "UPDATE book_store.utente SET password=?,address=?,is_admin=0,cred_card=?,nome=?,cognome=?,email=?,provincia=?,comune=? WHERE username=?";
        
        
		
    			try {
				preparedStatement = con.prepareStatement(query);

				preparedStatement.setString(1, password);
				preparedStatement.setString(2, address);
				preparedStatement.setString(3, card);
				preparedStatement.setString(4, fullName);
				preparedStatement.setString(5, cognome);
				preparedStatement.setString(6, email);
				preparedStatement.setString(7, provincia);
				preparedStatement.setString(8, comune);
				preparedStatement.setString(9, userName);


				res = preparedStatement.executeUpdate();
				con.commit();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			} // Making use of prepared statements here to insert bunch of data

		}

		finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				DriverManagerConnectionPool.releaseConnection(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return res;
	}
	

	public synchronized ArrayList<UserBean> doRetrieveAll() {
		Connection con = null;
		PreparedStatement ps = null;
		ArrayList<UserBean> utenti = new ArrayList<UserBean>();
		try {
			
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement("SELECT * FROM utente ");
			ResultSet rs = ps.executeQuery();
			con.commit();
			while (rs.next()) {
				UserBean ub = new UserBean();
				ub.setUsr(rs.getString("username"));
				ub.setNome(rs.getString("nome"));
				ub.setCognome(rs.getString("cognome"));
				utenti.add(ub);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				DriverManagerConnectionPool.releaseConnection(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return utenti;
	}
	
	public synchronized int doDelete(String username) {
		Connection con = null;
		PreparedStatement ps = null;
		int res=0;
		try {
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement("DELETE FROM utente WHERE username = ?");
			ps.setString(1, username);
			res=ps.executeUpdate();
			con.commit();

			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DriverManagerConnectionPool.releaseConnection(con);
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return res;

	}


}
