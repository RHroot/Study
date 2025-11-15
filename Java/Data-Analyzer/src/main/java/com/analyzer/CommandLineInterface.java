package com.analyzer;

import java.util.Scanner;

public class CommandLineInterface {
  private DatabaseManager db;
  private DataAnalyzer analyzer;
  private Scanner scanner;

  public CommandLineInterface() {
    this.scanner = new Scanner(System.in);
  }

  public void run(String[] args) {
    System.out.println("Data Analysis CLI Tool");
    System.out.println("======================");

    System.out.print("Database URL (e.g., jdbc:postgresql://locahost:5432/mydb): ");
    String url = scanner.nextLine();

    System.out.print("Username: ");
    String username = scanner.nextLine();

    System.out.print("Password: ");
    String password = scanner.nextLine();

    db = new DatabaseManager(url, username, password);
    if (!db.connect()) {
      System.out.println("Failed to connect to database. Exiting.");
      return;
    }

    analyzer = new DataAnalyzer(db);

    while (true) {
      printMenu();
      System.out.print("Enter command: ");
      String command = scanner.nextLine().trim();

      if (command.equalsIgnoreCase("exit") || command.equalsIgnoreCase("quit")) {
        break;
      }

      processCommand(command);
    }

    db.close();
    System.out.println("Goodbye!");
  }

  private void printMenu() {
    System.out.println("\nAvailable commands:");
    System.out.println("  schema <table_name>         - Show table schema");
    System.out.println("  preview <table_name>        - Show table preview (first 10 rows)");
    System.out.println("  analyze <table_name> <col>  - Analyze numeric column");
    System.out.println("  query <sql>                 - Execute custom SQL query");
    System.out.println("  exit                        - Exit the program");
  }

  private void processCommand(String command) {
    String[] parts = command.split("\\s+", 3);
    if (parts.length == 0) return;

    String action = parts[0].toLowerCase();

    switch (action) {
      case "schema":
        if (parts.length > 1) {
          analyzer.showTableSchema(parts[1]);
        } else {
          System.out.println("Usage: schema <table_name>");
        }
        break;

      case "analyzer":
        if (parts.length > 1) {
          executeCustomQuery(parts[1]);
        } else {
          System.out.println("Usage: query <sql_query>");
        }
        break;

      default:
        System.out.println("Unknown command. Type 'help' for available command.");
    }
  }

  private void executeCustomQuery(String query) {
    try {
      var rs = db.executeQuery(query);
      var metaData = rs.getMetaData();
      int columnCount = metaData.getColumnCount();

      for (int i = 1; i <= columnCount; i++) {
        System.out.print(String.format("%-15s", metaData.getColumnName(i)));
      }
      System.out.println();
      System.out.println("".repeat(15 * columnCount));

      int rowCount = 0;
      while (rs.next()) {
        for (int i = 1; i <= columnCount; i++) {
          String value = rs.getString(i);
          if (value == null) value = "NULL";
          System.out.print(String.format("%-15s", value));
        }
        System.out.println();
        rowCount++;
      }
      System.out.println("\n" + rowCount + "rows returned.");
    } catch (Exception e) {
      System.err.println("Error executing query: " + e.getMessage());
    }
  }
}
