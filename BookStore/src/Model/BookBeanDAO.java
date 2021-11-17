package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookBeanDAO {

	public synchronized BookBean doRetrieveByTitle(String title) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			BookBean lb = new BookBean();
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement("SELECT * FROM book_store.libro WHERE title LIKE ?");
			ps.setString(1, "%"+title+"%");
			ResultSet rs = ps.executeQuery();
			con.commit();
			if (rs.next()) {

				lb.setIsbn(rs.getString("isbn"));
				lb.setTitle(rs.getString("title"));
				lb.setImage(rs.getString("image"));
				lb.setPrice((double) rs.getDouble("price"));
				lb.setDescription(rs.getString("description"));
				lb.setAuthor(rs.getString("author"));
				lb.setYear((int)rs.getInt("year"));
				lb.setPublisher(rs.getString("publisher"));
				lb.setCategory(rs.getString("category"));

				return lb;
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
	
	public synchronized ArrayList<BookBean> doRetrieveByCategory(String category) {
		Connection con = null;
		PreparedStatement ps = null;
		ArrayList<BookBean> libri=new ArrayList<>();

		try {
			BookBean lb = new BookBean();
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement("SELECT * FROM book_store.libro WHERE category=?");
			ps.setString(1, category);
			ResultSet rs = ps.executeQuery();
			con.commit();
			while (rs.next()) {
				BookBean lb1=new BookBean();
				lb1.setIsbn(rs.getString("isbn"));
				lb1.setTitle(rs.getString("title"));
				lb1.setImage(rs.getString("image"));
				lb1.setPrice((double) rs.getDouble("price"));
				lb1.setDescription(rs.getString("description"));
				lb1.setAuthor(rs.getString("author"));
				lb1.setYear((int)rs.getInt("year"));
				lb1.setPublisher(rs.getString("publisher"));
				lb1.setCategory(rs.getString("category"));


				libri.add(lb1);
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
		return libri;

	}
	
	public synchronized BookBean doRetrieveByKey(String isbn) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			BookBean lb = new BookBean();
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement("SELECT * FROM book_store.libro WHERE isbn = ?");
			ps.setString(1, isbn);
			ResultSet rs = ps.executeQuery();
			con.commit();
			if (rs.next()) {

				lb.setIsbn(rs.getString("isbn"));
				lb.setTitle(rs.getString("title"));
				lb.setImage(rs.getString("image"));
				lb.setPrice((double) rs.getDouble("price"));
				lb.setDescription(rs.getString("description"));
				lb.setAuthor(rs.getString("author"));
				lb.setYear((int)rs.getInt("year"));
				lb.setPublisher(rs.getString("publisher"));
				lb.setCategory(rs.getString("category"));


				return lb;
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


	public synchronized int doSave(BookBean lb) {
		String isbn = lb.getIsbn();
		String d = lb.getDescription();
		Double p = lb.getPrice();
		String imm = lb.getImage();
		String tit = lb.getTitle();
		int y=lb.getYear();
		String aut=lb.getAuthor();
		String pub=lb.getPublisher();
		String cat=lb.getCategory();
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
			String query = "insert into book_store.libro values (?,?,?,?,?,?,?,?,?)"; // Insert

			try {
				preparedStatement = con.prepareStatement(query);

				preparedStatement.setString(1, isbn);
				preparedStatement.setString(2, d);
				preparedStatement.setDouble(3, p);
				preparedStatement.setString(4, imm);
				preparedStatement.setString(5, tit);
				preparedStatement.setInt(6, y);
				preparedStatement.setString(7, aut);
				preparedStatement.setString(8, pub);
				preparedStatement.setString(9, cat);


				
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

	
	public synchronized ArrayList<BookBean> doRetrieveAll() {
		Connection con = null;
		PreparedStatement ps = null;
		ArrayList<BookBean> libri = new ArrayList<BookBean>();
		try {
			
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement("SELECT * FROM book_store.libro  ");
			ResultSet rs = ps.executeQuery();
			con.commit();
			while (rs.next()) {
				BookBean lb=new BookBean();
				lb.setIsbn(rs.getString("isbn"));
				lb.setTitle(rs.getString("title"));
				lb.setImage(rs.getString("image"));
				lb.setPrice((double) rs.getDouble("price"));
				lb.setDescription(rs.getString("description"));
				lb.setAuthor(rs.getString("author"));
				lb.setYear((int)rs.getInt("year"));
				lb.setPublisher(rs.getString("publisher"));
				lb.setCategory(rs.getString("category"));


				libri.add(lb);
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
		return libri;
	}
	
	
	public synchronized int doDelete(String isbn) {
		Connection con = null;
		PreparedStatement ps = null;
		int res=0;
		try {
			con = DriverManagerConnectionPool.getConnection();
			con.setAutoCommit(false);
			ps = con.prepareStatement("DELETE FROM book_store.libro  WHERE isbn = ?");
			ps.setString(1, isbn);
			res=ps.executeUpdate();
			con.commit();

			
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
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


	public synchronized int doUpdate(BookBean lb) {
		String isbn = lb.getIsbn();
		String d = lb.getDescription();
		Double p = lb.getPrice();
		String imm = lb.getImage();
		String tit = lb.getTitle();
		int y=lb.getYear();
		String aut=lb.getAuthor();
		String pub=lb.getPublisher();
		String cat=lb.getCategory();
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
			String query = "update book_store.libro set description=?,price=?,image=?,title=?,year=?,author=?,publisher=?,category=? where isbn=?"; // Insert

			try {
				preparedStatement = con.prepareStatement(query);

				preparedStatement.setString(1, d);
				preparedStatement.setDouble(2, p);
				preparedStatement.setString(3, imm);
				preparedStatement.setString(4, tit);
				preparedStatement.setInt(5, y);
				preparedStatement.setString(6, aut);
				preparedStatement.setString(7, pub);
				preparedStatement.setString(8, cat);
				preparedStatement.setString(9, isbn);


				
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


	
}
