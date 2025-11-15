package com.analyzer;

import java.util.Scanner;

public class CommandLineInterface {
  private DatabaseManager db;
  private DataAnalyzer analyzer;
  private Scanner scanner;

  public CommandLineInterface() {
    this.scanner = new Scanner(System.in);
  }
}
