package com.ss.utopia.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import com.ss.utopia.dao.AirplaneDAO;
import com.ss.utopia.dao.AirportDAO;
import com.ss.utopia.entity.Airplane;
import com.ss.utopia.entity.Airport;

public class Util {

	private final String driver = "com.mysql.cj.jdbc.Driver";
	private final String url = "jdbc:mysql://localhost:3306/utopia";
	private final String username = "root";
	private final String password = "doopliss";

//	public static void main(String[] args) {
//		try {
//			Connection c = new Util().getConnection();
//			Statement s = c.createStatement();
////			String sql = "select * from airport";
////			ResultSet rs = s.executeQuery(sql);
////			while(rs.next()) {
////				System.out.println(rs.getString("iata_id") + " --- " + rs.getString("city"));
////			}
//			List<Airplane> as = new AirplaneDAO(c).readAll();
//			for(Airplane a : as) {
//				System.out.println(a.getId() + " --- " + a.getTypeId());
//			}
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		Connection connection = DriverManager.getConnection(url, username, password);
		connection.setAutoCommit(Boolean.FALSE);
		return connection;
	}
}
