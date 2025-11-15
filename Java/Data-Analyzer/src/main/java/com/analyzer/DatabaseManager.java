package com.analyzer;

import java.sql.*;

public class DatabaseManager {
  private Connection connection;
  private String url;
  private String username;
  private String password;

  public DatabaseManager(String url, String username, String password) {
    this.url = url;
    this.username = username;
    this.password = password;
  }

  public boolean connect() {
    try {
      Class.forName("org.postgresql.Driver");
      connection = DriverManager.getConnection(url, username, password);
      return true;
    } catch (Exception e) {
      System.err.println("Connection failed: " + e.getMessage());
      return false;
    }
  }

  public ResultSet executeQuery(String query) throws SQLException {
    Statement stmt = connection.createStatement();
    return stmt.executeQuery(query);
  }

  public PreparedStatement prepareStatement(String sql) throws SQLException {
    return connection.prepareStatement(sql);
  }

  public Connection getConnection() {
    return connection;
  }

  public int executeUpdate(String query) throws SQLException {
    Statement stmt = connection.createStatement();
    return stmt.executeUpdate(query);
  }

  public void close() {
    try {
      if (connection != null && !connection.isClosed()) {
        connection.close();
      }
    } catch (SQLException e) {
      System.err.println("Error closing connection: " + e.getMessage());
    }
  }
}
