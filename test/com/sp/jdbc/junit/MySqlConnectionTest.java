package com.sp.jdbc.junit;

import static org.junit.Assert.assertFalse;
import java.sql.SQLException;
import org.junit.Test;

import com.sp.jdbc.dao.MySqlConnection;


public class MySqlConnectionTest {
	@Test
	public void testGetConnection() throws SQLException {
		assertFalse(MySqlConnection.getConnection().isClosed());
	}
}
