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
				int id = Integer.valueOf(result.getString("id"));
				String name = result.getString("name");
				String type = result.getString("type");
				int quantity = Integer.valueOf(result.getString("quantity"));
				String cost = result.getString("cost");
				String set = result.getString("CardSet");

				Painter painter = new Painter(id, name, type, quantity, cost, set);

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
		PreparedStatement statement = null;

		try {
			connection = dataSource.getConnection();
			String sql = "insert into painter (name, type, quantity,cost,CardSet) values(?, ?, ?, ?, ?)";
			statement = connection.prepareStatement(sql);

			statement.setString(1, newCard.getName());
			statement.setString(2, newCard.getType());
			statement.setLong(3, newCard.getQuantity());
			statement.setString(4, newCard.getCost());
			statement.setString(5, newCard.getCardSet());
			

			statement.execute();

		} finally {
			// clean up JDBC
			close(connection, statement, null);
		}
	}

	public void updateCard(Painter newCard) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			// get db connection
			connection = dataSource.getConnection();

			// create SQL update statement
			String sql = "update painter " + "set name=?, type=?, quantity=?, cost=?, CardSet=? " + "where id=?";

			// prepare statement
			statement = connection.prepareStatement(sql);

			// set params
			statement.setString(1, newCard.getName());
			statement.setString(2, newCard.getType());
			statement.setLong(3, newCard.getQuantity());
			statement.setString(4, newCard.getCost());
			statement.setString(5, newCard.getCardSet());
			statement.setInt(6, newCard.getId());
			// execute SQL statement
			statement.execute();
		} finally {
			// clean up JDBC objects
			close(connection, statement, null);
		}

	}

	public Painter getPainter(String id) throws Exception {
		Painter thePainter = null;

		Connection connection = null;
		PreparedStatement mySstatement = null;
		ResultSet result = null;
		int painterID;

		try {
			// convert student id to int
			painterID = Integer.parseInt(id);

			// get connection to database
			connection = dataSource.getConnection();

			// create sql to get selected student
			String sql = "select * from painter where id=?";

			// create prepared statement
			mySstatement = connection.prepareStatement(sql);

			// set params
			mySstatement.setInt(1, painterID);

			// execute statement
			result = mySstatement.executeQuery();

			// retrieve data from result set row
			if (result.next()) {
				String name = result.getString("name");
				String type = result.getString("type");
				int quantity = Integer.valueOf(result.getString("quantity"));
				String cost = result.getString("cost");
				String set = result.getString("CardSet");

				// use the studentId during construction
				thePainter = new Painter(painterID, name, type, quantity, cost, set);
			} else {
				throw new Exception("Could not find student id: " + painterID);
			}

			return thePainter;
		} finally {
			// clean up JDBC objects
			close(connection, mySstatement, result);
		}
	}

	public void deleteCard(String painterID) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			// convert student id to int
			int painterId = Integer.parseInt(painterID);

			// get connection to database
			connection = dataSource.getConnection();

			// create sql to delete painter
			String sql = "delete from painter where id=?";

			// prepare statement
			statement = connection.prepareStatement(sql);

			// set params
			statement.setInt(1, painterId);

			// execute sql statement
			statement.execute();
		} finally {
			// clean up JDBC code
			close(connection, statement, null);
		}
	}

}
