package com.jsoftwares.jdbcdemo;

import com.jsoftwares.jdbcdemo.dao.JdbcDaoImpl;
import com.jsoftwares.jdbcdemo.model.Circle;

public class JDBCDemo {

	public static void main(String[] args) {

		Circle circle = new JdbcDaoImpl().getCirlce(1);
		System.out.println(circle.getName());
	}

}
