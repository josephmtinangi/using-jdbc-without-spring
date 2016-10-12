package com.jsoftwares.jdbcdemo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jsoftwares.jdbcdemo.model.Circle;

public class JdbcDaoImpl {

	public Circle getCirlce(int id) {

		Connection conn = null;
		String driver = "com.mysql.jdbc.Driver";
		Circle circle = null;

		try {
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost/firstdb?user=root&password=");
			PreparedStatement ps;
			ps = conn.prepareStatement("SELECT * FROM circle WHERE id = ?");
			ps.setInt(1, id);

			
			ResultSet rs;
			rs = ps.executeQuery();
			if (rs.next()) {
				circle = new Circle(id, rs.getString("name"));
			}
			rs.close();
			ps.close();

			return circle;
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return circle;

	}
}
