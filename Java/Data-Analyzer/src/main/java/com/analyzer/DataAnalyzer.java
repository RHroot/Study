package com.analyzer;

import java.sql.*;

public class DataAnalyzer {
  private DatabaseManager db;

  public DataAnalyzer(DatabaseManager db) {
    this.db = db;
  }

  public void showTableSchema(String tableName) {
    try {
      String query =
          "SELECT column_name, data_type, is_nullable "
              + "FROM information_schema.columns "
              + "WHERE table_name = ? "
              + "ORDER BY ordinal_position";

      PreparedStatement stmt = db.getConnection().prepareStatement(query);
      stmt.setString(1, tableName);
      ResultSet rs = stmt.executeQuery();

      System.out.println("Schema for table: " + tableName);
      System.out.println("Column Name\t\tData Type\t\tNullable");
      System.out.println("-------------------------------------------------------");

      while (rs.next()) {
        System.out.printf(
            "%20s\t%-20s\t%s%n",
            rs.getString("column_name"), rs.getString("data_type"), rs.getString("is_nullable"));
      }
    } catch (SQLException e) {
      System.err.println("Error getting schema: " + e.getMessage());
    }
  }

  public void analyzeNumericColumn(String tableName, String columnName) {
    try {
      String query =
          "SELECT MIN("
              + columnName
              + ") as min_value, "
              + "MAX("
              + columnName
              + ") as max_val, "
              + "AVG("
              + columnName
              + ") as avg_val, "
              + "COUNT("
              + columnName
              + ") as count_val, "
              + "STDDEV("
              + columnName
              + ") as stddev_val "
              + "FROM "
              + tableName;

      ResultSet rs = db.executeQuery(query);
      if (rs.next()) {
        System.out.println("Analysis for column: " + columnName);
        System.out.println("Min: " + rs.getDouble("min_val"));
        System.out.println("Max: " + rs.getDouble("max_val"));
        System.out.println("Average: " + rs.getDouble("avg_val"));
        System.out.println("Count: " + rs.getDouble("count_val"));
        System.out.println("Std Dev: " + rs.getDouble("stddev_val"));
      }
    } catch (SQLException e) {
      System.err.println("Error analyzing column: " + e.getMessage());
    }
  }

  public void showTablePreview(String tableName, int limit) {
    try {
      String query = "SELECT * FROM " + tableName + " LIMIT " + limit;
      ResultSet rs = db.executeQuery(query);
      ResultSetMetaData metaData = rs.getMetaData();
      int columnCount = metaData.getColumnCount();

      for (int i = 1; i <= columnCount; i++) {
        System.out.print(String.format("%-15s", metaData.getColumnName(i)));
      }
      System.out.println();

      for (int i = 1; i <= columnCount; i++) {
        System.out.print(String.format("%-15s", "---------------"));
      }
      System.out.println();

      while (rs.next()) {
        for (int i = 1; i <= columnCount; i++) {
          String value = rs.getString(i);
          if (value == null) value = "NULL";
          System.out.print(String.format("%-15s", value));
        }
        System.out.println();
      }
    } catch (SQLException e) {
      System.err.println("Error showing preview: " + e.getMessage());
    }
  }

  private Connection getConnection() throws SQLException {
    throw new SQLException("Method not implemented - need to add getter to DatabaseManager");
  }
}
