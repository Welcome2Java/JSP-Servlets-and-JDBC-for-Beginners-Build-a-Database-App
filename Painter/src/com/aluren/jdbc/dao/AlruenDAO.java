package com.aluren.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.aluren.jdbc.Aluren;


public class AlruenDAO {
	private DataSource dataSource;

	public AlruenDAO(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public List<Aluren> getAluren() throws Exception {
		List<Aluren> alurenList = new ArrayList<>();

		Connection connection = null;
		Statement statement = null;
		ResultSet result = null;

		try {
			connection = dataSource.getConnection();

			String sql = "select * from aluren";
			statement = connection.createStatement();

			result = statement.executeQuery(sql);

			while (result.next()) {
				String name = result.getString("name");
				String type = result.getString("type");
				int quantity = Integer.valueOf(result.getString("quantity"));
				String cost = result.getString("cost");
				String set = result.getString("CardSet");

				Aluren aluren = new Aluren(name, type, quantity, cost, set);

				alurenList.add(aluren);
			}
			return alurenList;
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

	public void addCard(Aluren newCard) throws SQLException {
		Connection connection = null;
		PreparedStatement  statement = null;
		
		try {
			connection = dataSource.getConnection();
			String sql = "insert into aluren (name, type, quantity,cost,CardSet) values(?, ?, ?, ?, ?)"  ;
			statement = connection.prepareStatement(sql);
			
			
			statement.setString(1, newCard.getName());
			statement.setString(2, newCard.getType());
			statement.setLong(3, newCard.getQuantity());
			statement.setString(4, newCard.getCost());
			statement.setString(6, newCard.getCardSet());
			
			statement.execute();
			
		}  finally {
			//clean up JDBC
			close(connection, statement, null);
		}	
	}
}
