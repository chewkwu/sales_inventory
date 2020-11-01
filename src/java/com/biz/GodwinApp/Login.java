/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biz.GodwinApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Uchenna
 */
public class Login {
    
    
  public ResultSet allAccess(String username)
    throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException
  {
    Class.forName("com.mysql.jdbc.Driver").newInstance();
    Connection conn = DriverManager.getConnection("jdbc:mysql:///aso-oke", "root", "java@1986");
    String sqlSelectQuery = "SELECT * FROM users WHERE Username = ?";
    PreparedStatement preparedStatement = conn.prepareStatement(sqlSelectQuery);
    preparedStatement.setString(1, username);
    return preparedStatement.executeQuery();
  }
    
}
