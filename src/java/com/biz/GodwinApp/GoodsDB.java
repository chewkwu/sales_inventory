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
public class GoodsDB {
    
    private String goodsName;
  private int stockQuantity;
  
  public boolean register(String name, int quantity)
    throws SQLException
  {
    try
    {
      Class.forName("com.mysql.jdbc.Driver").newInstance();
      Connection conn = DriverManager.getConnection("jdbc:mysql:///aso-oke", "root", "java@1986");
      String sql = "INSERT INTO goods  VALUES(?,?)";
      PreparedStatement pst = conn.prepareStatement(sql);
      pst.setString(1, name);
      pst.setInt(2, quantity);
      pst.executeUpdate();
      conn.close();
    }
    catch (Exception e)
    {
      return false;
    }
    return true;
  }
  
  public boolean updateStock(int stock, String goodsname)
    throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException
  {
    Class.forName("com.mysql.jdbc.Driver").newInstance();
    Connection conn2 = DriverManager.getConnection("jdbc:mysql:///aso-oke", "root", "java@1986");
    String upd1 = "UPDATE goods SET StockQuantity = ? WHERE GoodsName = ?";
    PreparedStatement ps = conn2.prepareStatement(upd1);
    ps.setInt(1, stock);
    ps.setString(2, goodsname);
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
  
  public boolean updateName(String newName, String name)
    throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException
  {
    Class.forName("com.mysql.jdbc.Driver").newInstance();
    Connection conn2 = DriverManager.getConnection("jdbc:mysql:///aso-oke", "root", "java@1986");
    String upd1 = "UPDATE goods SET GoodsName = ? WHERE GoodsName = ?";
    PreparedStatement ps = conn2.prepareStatement(upd1);
    ps.setString(1, newName);
    ps.setString(2, name);
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
  
  public String getGoodsName()
  {
    return this.goodsName;
  }
  
  public void setGoodsName(String goodsName)
  {
    this.goodsName = goodsName;
  }
  
  public int getStockQuantity()
  {
    return this.stockQuantity;
  }
  
  public void setStockQuantity(int stockQuantity)
  {
    this.stockQuantity = stockQuantity;
  }
  
  public List<GoodsDB> viewAll()
    throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException
  {
    List<GoodsDB> good = new ArrayList();
    Class.forName("com.mysql.jdbc.Driver").newInstance();
    Connection conn2 = DriverManager.getConnection("jdbc:mysql:///aso-oke", "root", "java@1986");
    String upd2 = "SELECT * FROM goods";
    PreparedStatement ps2 = conn2.prepareStatement(upd2);
    ResultSet rst = ps2.executeQuery();
    while (rst.next())
    {
      GoodsDB eru = new GoodsDB();
      eru.setGoodsName(rst.getString("GoodsName"));
      eru.setStockQuantity(rst.getInt("StockQuantity"));
      good.add(eru);
    }
    return good;
  }
  
  public List<GoodsDB> viewAvailGoods()
    throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException
  {
    List<GoodsDB> good = new ArrayList();
    Class.forName("com.mysql.jdbc.Driver").newInstance();
    Connection conn2 = DriverManager.getConnection("jdbc:mysql:///aso-oke", "root", "java@1986");
    String upd2 = "SELECT * FROM goods where StockQuantity > 0";
    PreparedStatement ps2 = conn2.prepareStatement(upd2);
    ResultSet rst = ps2.executeQuery();
    while (rst.next())
    {
      GoodsDB eru = new GoodsDB();
      eru.setGoodsName(rst.getString("GoodsName"));
      eru.setStockQuantity(rst.getInt("StockQuantity"));
      good.add(eru);
    }
    return good;
  }
    
}
