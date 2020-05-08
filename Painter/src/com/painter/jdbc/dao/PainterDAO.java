package com.painter.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.painter.jdbc.Painter;

public class PainterDAO {

	private DataSource dataSource;

	public PainterDAO(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public List<Painter> getPainter() throws Exception {
		List<Painter> painterList = new ArrayList<>();

		Connection connection = null;
		Statement statement = null;
		ResultSet result = null;

		try {
			connection = dataSource.getConnection();

			String sql = "select * from painter";
			statement = connection.createStatement();

			result = statement.executeQuery(sql);

			while (result.next()) {
				String name = result.getString("name");
				String type = result.getString("type");
				int quantity = Integer.valueOf(result.getString("quantity"));
				String cost = result.getString("cost");
				String description = result.getString("description");
				String set = result.getString("CardSet");

				Painter painter = new Painter(name, type, quantity, cost, description, set);

				painterList.add(painter);
			}
			return painterList;
		} finally {
			// close JDBC objects
			close(connection, statement, result);
		}

	}

	private void close(Connection myConn, Statement myStat, ResultSet myRs) {
		try {
			if (myRs != null) {
				myRs.close(); // just puts back in connection pool. make it free for someone else to use.
			}
			if (myStat != null) {
				myStat.close();
			}
			if (myConn != null) {
				myConn.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void addCard(Painter newCard) throws SQLException {
		Connection connection = null;
		PreparedStatement  statement = null;
		
		try {
			connection = dataSource.getConnection();
			String sql = "insert into painter (name, type, quantity,cost,description,CardSet) values(?, ?, ?, ?, ?, ?)"  ;
			statement = connection.prepareStatement(sql);
			
			
			statement.setString(1, newCard.getName());
			statement.setString(2, newCard.getType());
			statement.setLong(3, newCard.getQuantity());
			statement.setString(4, newCard.getCost());
			statement.setString(5, newCard.getDesciption());
			statement.setString(6, newCard.getSet());
			
			statement.execute();
			
		}  finally {
			//clean up JDBC
			close(connection, statement, null);
		}	
	}

}
