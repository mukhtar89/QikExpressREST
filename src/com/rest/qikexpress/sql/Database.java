package com.rest.qikexpress.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.google.appengine.api.utils.SystemProperty;

public class Database {

	public Connection getConnection() throws Exception {
		Connection connection = null;
		String connectionURL = null;
		try {
			/*
			 * if (SystemProperty.environment.value() ==
			 * SystemProperty.Environment.Value.Production) { // Load the class
			 * that provides the new "jdbc:google:mysql://" prefix.
			 * Class.forName("com.mysql.jdbc.GoogleDriver"); connectionURL =
			 * "jdbc:google:mysql://1-dot-qikexpress:qik/qik_schema?user=root";
			 * } else { // Local MySQL instance to use during development.
			 * Class.forName("com.mysql.jdbc.Driver"); connectionURL =
			 * "jdbc:mysql://104.154.146.18:3306/qik_schema?user=root&password=muk5086";
			 * }
			 */
			if (System.getProperty("com.google.appengine.runtime.version").startsWith("Google App Engine/")) {
				// Check the System properties to determine if we are running on
				// appengine or not
				// Google App Engine sets a few system properties that will
				// reliably be present on a remote
				// instance.
				connectionURL = System.getProperty("ae-cloudsql.cloudsql-database-url");
				// Load the class that provides the new
				// "jdbc:google:mysql://" prefix.
				Class.forName("com.mysql.jdbc.GoogleDriver");
			} else {
				// Set the url with the local MySQL database connection url when
				// running locally
				connectionURL = System.getProperty("ae-cloudsql.local-database-url");
			}
			connection = DriverManager.getConnection(connectionURL);
			return connection;
		} catch (SQLException e) {
			throw new SQLException(e.getMessage());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
}
