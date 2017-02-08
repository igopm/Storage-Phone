package com.sp.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sp.jdbc.model.Phone;

/**
 * @author Maschikevich Igor
 * @version 1.0
 */
public class PhoneDAO {
	private static String SQL_INSERT = "INSERT INTO phones (brand, model, date) VALUE (?, ?, ?); ";
	private static String SQL_UPDATE = "UPDATE phones set brand=?,model=?, date=? where id=?";
	private static String SQL_SELECT = "SELECT * FROM phones;";
	private static String SQL_DELETE = "delete from phones;";
	private static String SQL_SELECT_BY_ID = "SELECT * FROM phones where id = ?;";
	private static String SQL_DELETE_BY_ID = "delete from phones where id = ?;";
	private static final String FIELD_ID = "id";
	private static final String FIELD_BRAND = "brand";
	private static final String FIELD_MODEL = "model";
	private static final String FIELD_DATE = "date";
	private static PhoneDAO PHONE_DAO = null;

	private PhoneDAO() {

	}

	public static PhoneDAO getInstance() {
		if (PHONE_DAO == null) {
			PHONE_DAO = new PhoneDAO();
		}
		return PHONE_DAO;
	}

	public boolean delete(Phone item) {
		return delete(item.getId());
	}

	public boolean delete(long id) {
		Connection con = null;
		try {
			con = MySqlConnection.getConnection();
			PreparedStatement st = con.prepareStatement(SQL_DELETE_BY_ID);
			st.setLong(1, id);
			st.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			close(con);
		}
	}

	public boolean deleteAll() {
		Connection con = null;
		try {
			con = MySqlConnection.getConnection();
			PreparedStatement st = con.prepareStatement(SQL_DELETE);
			int n = st.executeUpdate();
			if (n == 0) {
				return false;
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			close(con);
		}
	}

	public List<Phone> selectAll() {
		Connection con = null;
		List<Phone> list = new ArrayList<Phone>();
		try {
			con = MySqlConnection.getConnection();
			Statement st = con.createStatement();
			ResultSet result = st.executeQuery(SQL_SELECT);
			while (result.next()) {
				list.add(extractPhone(result));
			}
		} catch (Exception e) {
			e.printStackTrace();
			return list;
		} finally {
			close(con);
		}
		return list;
	}

	public Phone select(int id) {
		Connection con = null;
		Phone item = null;
		try {
			con = MySqlConnection.getConnection();
			PreparedStatement st = con.prepareStatement(SQL_SELECT_BY_ID);
			st.setInt(1, id);
			ResultSet result = st.executeQuery();
			if (result.next()) {
				item = extractPhone(result);
			}
			return item;
		} catch (Exception e) {
			e.printStackTrace();
			return item;
		} finally {
			close(con);
		}
	}

	public boolean insert(Phone item) {
		return insert(item.getBrand(), item.getModel(), item.getDate());
	}

	public boolean insert(String name, String author, Date date) {
		Connection con = null;
		try {
			con = MySqlConnection.getConnection();
			PreparedStatement st = con.prepareStatement(SQL_INSERT);
			st.setString(1, name);
			st.setString(2, author);
			st.setLong(3, date.getTime());
			int n = st.executeUpdate();
			if (n == 0) {
				return false;
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			close(con);
		}
	}

	public void update(Phone item) {
		Connection con = null;
		try {
			con = MySqlConnection.getConnection();
			PreparedStatement preparedStatement = con
					.prepareStatement(SQL_UPDATE);
			preparedStatement.setString(1, item.getBrand());
			preparedStatement.setString(2, item.getModel());
			preparedStatement.setLong(3, item.getDate().getTime());
			preparedStatement.setLong(4, item.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con);
		}
	}

	private void close(Connection connection) {
		try {
			if (connection != null)
				connection.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	private Phone extractPhone(ResultSet rs) throws SQLException {
		Phone item = new Phone();
		item.setId(rs.getLong(FIELD_ID));
		item.setBrand(rs.getString(FIELD_BRAND));
		item.setModel(rs.getString(FIELD_MODEL));
		item.setDate(new Date(rs.getLong(FIELD_DATE)));
		return item;
	}
}
