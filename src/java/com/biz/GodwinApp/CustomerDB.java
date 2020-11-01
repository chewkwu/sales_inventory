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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Uchenna
 */
public class CustomerDB {
    
    
  private String customerPhone;
  private String customerName;
  private String address;
  
  public String getCustomerPhone()
  {
    return this.customerPhone;
  }
  
  public void setCustomerPhone(String customerPhone)
  {
    this.customerPhone = customerPhone;
  }
  
  public String getCustomerName()
  {
    return this.customerName;
  }
  
  public void setCustomerName(String customerName)
  {
    this.customerName = customerName;
  }
  
  public String getAddress()
  {
    return this.address;
  }
  
  public void setAddress(String address)
  {
    this.address = address;
  }
  
  public List<CustomerDB> viewAllCustomers()
    throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException
  {
    List<CustomerDB> cust = new ArrayList();
    Class.forName("com.mysql.jdbc.Driver").newInstance();
    Connection conn2 = DriverManager.getConnection("jdbc:mysql:///aso-oke", "root", "java@1986");
    String upd2 = "SELECT * FROM clients";
    PreparedStatement ps2 = conn2.prepareStatement(upd2);
    ResultSet rst = ps2.executeQuery();
    while (rst.next())
    {
      CustomerDB eru = new CustomerDB();
      eru.setCustomerPhone(rst.getString("CustomerPhone"));
      eru.setCustomerName(rst.getString("CustomerName"));
      eru.setAddress(rst.getString("Address"));
      cust.add(eru);
    }
    return cust;
  }
  
  public boolean updateName(String newbie, String phone)
    throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException
  {
    Class.forName("com.mysql.jdbc.Driver").newInstance();
    Connection conn2 = DriverManager.getConnection("jdbc:mysql:///aso-oke", "root", "java@1986");
    String upd1 = "UPDATE clients SET CustomerName = ? WHERE CustomerPhone = ?";
    PreparedStatement ps = conn2.prepareStatement(upd1);
    ps.setString(1, newbie);
    ps.setString(2, phone);
    try
    {
      ps.executeUpdate();
      ps.close();
      conn2.close();
    }
    catch (Exception e)
    {
      return false;
    }
    return true;
  }
  
  public boolean updateAddress(String add, String phone)
    throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException
  {
    Class.forName("com.mysql.jdbc.Driver").newInstance();
    Connection conn2 = DriverManager.getConnection("jdbc:mysql:///aso-oke", "root", "java@1986");
    String upd1 = "UPDATE clients SET Address = ? WHERE CustomerPhone = ?";
    PreparedStatement ps = conn2.prepareStatement(upd1);
    ps.setString(1, add);
    ps.setString(2, phone);
    try
    {
      ps.executeUpdate();
      ps.close();
      conn2.close();
    }
    catch (Exception e)
    {
      return false;
    }
    return true;
  }
  
  public boolean updatePhone(String newPhone, String phone)
    throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException
  {
    Class.forName("com.mysql.jdbc.Driver").newInstance();
    Connection conn2 = DriverManager.getConnection("jdbc:mysql:///aso-oke", "root", "java@1986");
    String upd1 = "UPDATE clients SET CustomerPhone = ? WHERE CustomerPhone = ?";
    PreparedStatement ps = conn2.prepareStatement(upd1);
    ps.setString(1, newPhone);
    ps.setString(2, phone);
    try
    {
      ps.executeUpdate();
      ps.close();
      conn2.close();
    }
    catch (Exception e)
    {
      return false;
    }
    return true;
  }
  
  public boolean registerCustomer(String phone, String name, String address)
  {
    try
    {
      Class.forName("com.mysql.jdbc.Driver").newInstance();
      Connection conn = DriverManager.getConnection("jdbc:mysql:///aso-oke", "root", "java@1986");
      String sql = "INSERT INTO clients  VALUES(?,?,?)";
      PreparedStatement pst = conn.prepareStatement(sql);
      pst.setString(1, phone);
      pst.setString(2, name);
      pst.setString(3, address);
      pst.executeUpdate();
      conn.close();
    }
    catch (Exception e)
    {
      return false;
    }
    return true;
  }
    
}
