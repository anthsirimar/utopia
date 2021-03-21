package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public abstract class BaseDAO<T> {
	protected Connection connection = null;

	public BaseDAO(Connection connection) {
		this.connection = connection;
	}

	public Integer save(String sqlStatement, Object[] vals) throws ClassNotFoundException, SQLException {
		PreparedStatement statement = connection.prepareStatement(sqlStatement, Statement.RETURN_GENERATED_KEYS);

		int i = 1;
		for (Object val : vals) {
			statement.setObject(i, val);
			i++;
		}
		statement.executeUpdate();
		ResultSet rs = statement.executeQuery();
		while (rs.next()) {
			return rs.getInt(1);
		}

		return null;
	}

	public List<T> read(String sqlStatement, Object[] vals) throws ClassNotFoundException, SQLException {
		PreparedStatement statement = connection.prepareStatement(sqlStatement);

		int i = 1;
		for (Object val : vals) {
			statement.setObject(i, val);
			i++;
		}
		ResultSet rs = statement.executeQuery();

		return extractData(rs);
	}

	abstract public List<T> extractData(ResultSet rs) throws ClassNotFoundException, SQLException;

}
