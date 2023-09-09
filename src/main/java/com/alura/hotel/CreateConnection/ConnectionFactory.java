package com.alura.hotel.CreateConnection;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {

	private DataSource dataSource;
	
	public ConnectionFactory() {
	var pollDataSource = new ComboPooledDataSource();
    pollDataSource.setJdbcUrl("jdbc:mysql://localhost/hotel_alura?useTimeZone=true&serverTimeZone=UTC");
    pollDataSource.setUser("root");
    pollDataSource.setPassword("Vl%%ll*0j5TH9SNB3j");
    pollDataSource.setMaxPoolSize(10);
    this.dataSource = pollDataSource;
	}
	
    public Connection recoverConnection(){
        try {
            return this.dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
