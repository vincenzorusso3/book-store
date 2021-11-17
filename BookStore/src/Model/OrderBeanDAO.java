package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderBeanDAO {

	

	public synchronized int doSave(OrderBean ob) {
		int numOrdine=ob.getNumOrdine();
		String utente=ob.getUtente();
		String libro=ob.getLibro();
		int quantita=ob.getQuantita();
		int res = 0;

		Connection con = null;
		PreparedStatement preparedStatement = null;

		try {
			try {
				con = DriverManagerConnectionPool.getConnection();
				con.setAutoCommit(false);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String query = "insert into carrello values(?,?,?,?)"; // Insert

			try {
				preparedStatement = con.prepareStatement(query);

				preparedStatement.setInt(1, numOrdine);
				preparedStatement.setString(2, utente);
				preparedStatement.setString(3, libro);
				preparedStatement.setInt(4, quantita);
			
				res = preparedStatement.executeUpdate();
				con.commit();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				try {
					con.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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
	
	
	public synchronized ArrayList<OrderBean> doRetrieveByUser(String user) {
		Connection con = null;
		PreparedStatement ps = null;
		ArrayList<OrderBean> orders=new ArrayList<>();
		try {
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement("SELECT * FROM book_store.carrello where utente=?");
			ps.setString(1,user);
			ResultSet rs = ps.executeQuery();
			con.commit();
			while (rs.next()) {
				OrderBean ob=new OrderBean();
				ob.setNumOrdine(rs.getInt("order_id"));
				ob.setUtente(rs.getString("utente"));
				ob.setLibro(rs.getString("libro"));
				ob.setQuantita(rs.getInt("quantita"));
				orders.add(ob);
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
		return orders;

	}
	
	
	public synchronized ArrayList<OrderBean> doRetrieveByBook(String book) {
		Connection con = null;
		PreparedStatement ps = null;
		ArrayList<OrderBean> orders=new ArrayList<>();
		try {
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement("SELECT * FROM book_store.carrello where libro=?");
			ps.setString(1,book);
			ResultSet rs = ps.executeQuery();
			con.commit();
			while (rs.next()) {
				OrderBean ob=new OrderBean();
				ob.setNumOrdine(rs.getInt("order_id"));
				ob.setUtente(rs.getString("utente"));
				ob.setLibro(rs.getString("libro"));
				ob.setQuantita(rs.getInt("quantita"));
				orders.add(ob);
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
		return orders;

	}
	
	
	public synchronized int doDelete(int ordine) {
		Connection con = null;
		PreparedStatement ps = null;
		int res=0;
		try {
			con = DriverManagerConnectionPool.getConnection();
			con.setAutoCommit(false);
			ps = con.prepareStatement("DELETE FROM book_store.carrello where order_id=?");
			ps.setInt(1, ordine);
			res=ps.executeUpdate();
			con.commit();

			
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
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
	
	
	public synchronized int doUpdate(OrderBean ob) {
		int numOrdine=ob.getNumOrdine();
		String utente=ob.getUtente();
		String libro=ob.getLibro();
		int quantita=ob.getQuantita();
		int res = 0;
		
		System.out.println("\n\nsono in orderbean update\n\n");
		System.out.println(ob);
		
		Connection con = null;
		PreparedStatement preparedStatement = null;

		try {
			try {
				con = DriverManagerConnectionPool.getConnection();
				con.setAutoCommit(false);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String query = "UPDATE carrello SET utente=?, libro=?, quantita=? where order_id=?"; // Insert

			try {
				preparedStatement = con.prepareStatement(query);

				preparedStatement.setString(1, utente);
				preparedStatement.setString(2, libro);
				preparedStatement.setInt(3, quantita);
				preparedStatement.setInt(4, numOrdine);

				
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
					try {
						con.rollback();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
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
	
	
	public synchronized int doUpdateISBN(OrderBean ob,String newISBN) {
		int numOrdine=ob.getNumOrdine();
		String utente=ob.getUtente();
		String libro=newISBN;
		int quantita=ob.getQuantita();
		int res = 0;
		
		System.out.println("\n\nsono in orderbean update\n\n");
		System.out.println(ob);
		
		Connection con = null;
		PreparedStatement preparedStatement = null;

		try {
			try {
				con = DriverManagerConnectionPool.getConnection();
				con.setAutoCommit(false);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String query = "update carrello set libro=? where order_id=?"; // Insert

			try {
				preparedStatement = con.prepareStatement(query);

				preparedStatement.setString(1, libro);
			
				preparedStatement.setInt(2, numOrdine);

				
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
					try {
						con.rollback();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
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
	
	
	
	public synchronized int doRetrieveMaxOrder() {
		Connection con = null;
		PreparedStatement ps = null;
		int maxorder=0;
		try {
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement("SELECT max(order_id) FROM book_store.carrello;");
			ResultSet rs = ps.executeQuery();
			con.commit();
			if (rs.next()) {
				maxorder=rs.getInt(1);
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
		return maxorder;

	}
	

	
	
}
