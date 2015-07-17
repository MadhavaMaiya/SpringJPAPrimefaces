/*
 * Created on Aug 22, 2014
 * @author Madhava
 */
package com.madhava.jdbc;

import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.apache.tomcat.jdbc.pool.ConnectionPool;
import org.apache.tomcat.jdbc.pool.JdbcInterceptor;
import org.apache.tomcat.jdbc.pool.PooledConnection;

/**
 * Checks if connection is closed and reconnects the same connection. Configure
 * this class in jdbcInterceptors property for TOMCAT-7 JDBC connection pool
 * configuration.
 * 
 * Class ConnectionReconnect
 * 
 * @author Madhava
 * @since Aug 22, 2014 - 6:09:02 PM
 * @version UserManagement 1.0
 */
public class ConnectionReconnect extends JdbcInterceptor {

	private static final Logger LOGGER = Logger
			.getLogger(ConnectionReconnect.class);

	@Override
	public void reset(ConnectionPool pool, PooledConnection pooledConnection) {

		try {
			if (pooledConnection.getConnection().isClosed()) {
				LOGGER.info("Closed connection in the pool is being reconnected");
				pooledConnection.reconnect();
			}
		} catch (SQLException e) {
			LOGGER.error("Error in JDBC Interceptor", e);
		}
	}

}
