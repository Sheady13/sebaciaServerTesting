package database;

import java.sql.*;
import java.util.Properties;

public class databaseConnection
{
  // The JDBC Connector Class.
  private static final String dbClassName = "com.mysql.jdbc.Driver";
  private static final String CONNECTION ="jdbc:mysql://10.10.10.14:3306/sebacia";
  
  private Properties properties;
  private Connection connection;

  public databaseConnection() throws ClassNotFoundException
  {
    Class.forName(dbClassName);
    //set up connection information (this should be done more securly)
    properties = new Properties();
    properties.put("user", "sebacia");
    properties.put("password","sebacia");

  }

  public void openConnection() throws SQLException
  {
    connection = DriverManager.getConnection(CONNECTION,properties);
  }

  public void closeConnection() throws SQLException
  {
    connection.close();
  }

  public Connection getConnection() {
    return connection;
  }

}

